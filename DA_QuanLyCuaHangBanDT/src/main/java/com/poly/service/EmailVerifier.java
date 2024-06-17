package com.poly.service;

import java.io.Console;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailVerifier {
	 private static final String API_KEY = "HEzzdkhVn2gX1RYyDlooY"; // Thay thế bằng API key thực tế của bạn
	    private static final String API_URL = "https://api.emaillistverify.com/api/verifyEmail";

	    public static boolean verifyEmail(String email) {
	        HttpClient client = HttpClient.newHttpClient();
	        String url = "https://api.emaillistverify.com/api/verifyEmail?secret=HEzzdkhVn2gX1RYyDlooY&email=" + email;
	        System.out.println(url);
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .GET()
	                .build();

	        try {
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            String responseBody = response.body();
	            System.out.println("Response body: " + responseBody);
	            // Assuming the API returns plain text 'ok' for valid email
	            return "ok".equalsIgnoreCase(responseBody.trim());
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }
}
