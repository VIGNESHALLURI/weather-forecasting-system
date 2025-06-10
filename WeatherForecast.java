import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        String apiKey = "b1e9591dfacd1b9b9955ee3d93feb6a4"; // Replace with your OpenWeatherMap API key
        String apiUrl = String.format(
            "https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", 
            city, apiKey
        );

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response.toString());

            System.out.println("\n🌍 Forecast for " + json.getJSONObject("city").getString("name") + ", " + json.getJSONObject("city").getString("country"));
            System.out.println("=======================================================");

            JSONArray list = json.getJSONArray("list");
            for (int i = 0; i < 8; i++) { // next 24 hours (3-hour interval)
                JSONObject forecast = list.getJSONObject(i);
                String dateTime = forecast.getString("dt_txt");
                double temp = forecast.getJSONObject("main").getDouble("temp");
                String weather = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.printf("%s | 🌡 %.1f°C | %s%n", dateTime, temp, weather);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}


class User {

    // User default id, with user profile image and their
    // bio.
    userID uid;
    string ImageURI;
    string bio;
}