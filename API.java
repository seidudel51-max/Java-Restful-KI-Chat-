package RESTFULKICHAT;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

	private static final String API_KEY = "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";
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";

    public static String frageKi(String userText) {
        try {
            // User-Text für JSON absichern
            userText = userText.replace("\"", "\\\"");

            HttpClient client = HttpClient.newHttpClient();

            String jsonBody = """
            {
              "model": "llama-3.3-70b-versatile",
              "messages": [
                {"role": "user", "content": "%s"}
              ]
            }
            """.formatted(userText);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

            HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() != 200) {
                System.out.println("Error: " + response.statusCode());
                return "Fehler bei der KI-Anfrage";
            }

            // Nur die KI-Antwort zurückgeben
            return extrahiereAntwort(response.body());

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
            return "Fehler bei der KI-Anfrage";
        }
    }

    // Minimaler JSON-Parser
    private static String extrahiereAntwort(String json) {
        int startIndex = json.indexOf("\"content\":\"") + 11;
        int endIndex = json.indexOf("\"", startIndex);

        if (startIndex < 11 || endIndex < 0) {
            return "Keine Antwort erhalten";
        }

        String antwort = json.substring(startIndex, endIndex)
                .replace("\\n", "\n")
                .replace("\\\"", "\"");

        return antwort;
    }
}