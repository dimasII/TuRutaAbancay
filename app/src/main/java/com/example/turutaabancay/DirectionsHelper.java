package com.example.turutaabancay;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class DirectionsHelper {
    private static final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json";
    private static final List<Polyline> polylines = new ArrayList<>();

    public static void  clearRoutes() {
        for (Polyline polyline : polylines) {
            polyline.remove();
        }
        polylines.clear();
    }
    public static void drawRouteWithWaypoints(GoogleMap map, LatLng origin, LatLng destination,
                                              List<LatLng> waypoints, String apiKey, int color) {
        if (map == null || origin == null || destination == null || apiKey == null) return;

        String url = DIRECTIONS_URL + "?origin=" + origin.latitude + "," + origin.longitude +
                "&destination=" + destination.latitude + "," + destination.longitude +
                "&mode=driving&key=" + apiKey;

        if (waypoints != null && !waypoints.isEmpty()) {
            url += "&waypoints=";
            for (int i = 0; i < waypoints.size(); i++) {
                LatLng p = waypoints.get(i);
                url += p.latitude + "," + p.longitude;
                if (i < waypoints.size() - 1) url += "|";
            }
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) return;

                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

                if (!jsonObject.get("status").getAsString().equals("OK")) return;

                JsonArray routes = jsonObject.getAsJsonArray("routes");
                if (routes.size() > 0) {
                    JsonObject overviewPolyline = routes.get(0).getAsJsonObject()
                            .getAsJsonObject("overview_polyline");
                    String encodedPoints = overviewPolyline.get("points").getAsString();

                    List<LatLng> points = decodePoly(encodedPoints);

                    new Handler(Looper.getMainLooper()).post(() -> {
                        List<PatternItem> pattern = Arrays.asList(new Dash(30), new Gap(20));

                        Polyline polyline = map.addPolyline(new PolylineOptions()
                                .addAll(points)
                                .width(10)
                                .color(color)
                                .pattern(pattern));
                        polylines.add(polyline);
                    });
                }
            }
        });
    }
    private static List<LatLng> decodePoly(String encoded) {
        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng(((double) lat / 1E5), ((double) lng / 1E5));
            poly.add(p);
        }
        return poly;
    }
}