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
	        String url = API_URL + "?secret=" + API_KEY + "&email=" + email;
	        System.out.println(url);
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .GET()
	                .build();

	        try {
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            
	            // Kiểm tra mã trạng thái của phản hồi
	            int statusCode = response.statusCode();
	            if (statusCode != 200) {
	                System.out.println("Error: API returned status code " + statusCode);
	                return false;
	            }

	            // Phân tích JSON để lấy trạng thái xác nhận
	            ObjectMapper mapper = new ObjectMapper();
	            JsonNode rootNode = mapper.readTree(response.body());
	            String status = rootNode.path("status").asText();

	            // Kiểm tra trạng thái xác nhận
	            return "ok".equalsIgnoreCase(status);

	        } catch (IOException | InterruptedException e) {
	            System.out.println("Error sending request: " + e.getMessage());
	            e.printStackTrace();
	        }

	        return false;
	    }
}
