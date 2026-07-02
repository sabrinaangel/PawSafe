///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */    

package pawsafe.ai.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiService {
    private static final String API_KEY = "ISI_API_KEY_DISINI";
    private static final String ENDPOINT = "https://api.groq.com/openai/v1/chat/completions";

    public static String kirimPesan(String pesanUser) {
        try {
            String jsonPayload = String.format(
                "{\"model\":\"llama-3.3-70b-versatile\",\"messages\":[{\"role\":\"system\",\"content\":\"Kamu adalah asisten penyelamat hewan PawSafe. Jawab singkat dan praktis dalam Bahasa Indonesia.\"},{\"role\":\"user\",\"content\":\"%s\"}]}",
                pesanUser.replace("\"", "'").replace("\n", " ")
            );

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ENDPOINT))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return parseRespons(response.body());
            } else {
                System.out.println("DEBUG Error: " + response.body());
                return "Error (Status " + response.statusCode() + ")";
            }
        } catch (Exception e) {
            return "Error Jaringan: " + e.getMessage();
        }
    }

    private static String parseRespons(String json) {
        try {
            String target = "\"content\":\"";
            int start = json.indexOf(target);
            if (start != -1) {
                start += target.length();
                int end = json.indexOf("\"", start);
                return json.substring(start, end)
                           .replace("\\n", "\n")
                           .replace("\\\"", "\"");
            }
            return "AI merespons tapi format tidak terbaca.";
        } catch (Exception e) {
            return "Gagal membaca jawaban AI: " + e.getMessage();
        }
    }

    public static String getApiKey() {
        return API_KEY;
    }
}