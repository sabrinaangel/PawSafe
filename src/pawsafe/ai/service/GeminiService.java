///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package pawsafe.ai.service;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
///**
// *
// * @author asus
// */
//public class GeminiService {
//    // 🔴 Masukkan API Key milikmu di sini
//    private static final String API_KEY = ""; 
//    
//    // Model Gemini 2.5 Flash yang tersedia
//private static final String ENDPOINT = "" + API_KEY;    
//    public static String getApiKey() {
//        return API_KEY;
//    }
//
//    public static String kirimPesan(String pesanUser) {
//        try {
//            String jsonPayload = String.format("{\"contents\":[{\"parts\":[{\"text\":\"%s\"}]}]}", 
//                     "Kamu adalah asisten penyelamat hewan PawSafe. Jawab dengan singkat: " + pesanUser);
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(ENDPOINT))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            
//            if (response.statusCode() == 200) {
//            return parseResponsGemini(response.body());
//                } else {
//                System.out.println("DEBUG - Error Body: " + response.body());
//                return "Error (Status " + response.statusCode() + "): " + response.body();
//                }
//                    } catch (Exception e) {
//                        return "Error Jaringan: " + e.getMessage();
//                    }
//                }
//
//    private static String parseResponsGemini(String jsonResponse) {
//        try {
//            String target = "\"text\": \"";
//            int startIndex = jsonResponse.indexOf(target);
//            
//            if (startIndex != -1) {
//                startIndex += target.length();
//                int endIndex = jsonResponse.indexOf("\"", startIndex);
//                if(endIndex == -1) {
//                    endIndex = jsonResponse.lastIndexOf("\"");
//                }
//                String hasil = jsonResponse.substring(startIndex, endIndex);
//                return hasil.replace("\\n", "\n").replace("\\\"", "\"");
//            }
//            return "AI merespons, tapi format teks tidak terbaca. (Cek log respons asli di konsol)";
//        } catch (Exception e) {
//            return "Gagal membaca jawaban AI: " + e.getMessage();
//        }
//    }
//}    


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