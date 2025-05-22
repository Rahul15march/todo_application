package com.project.todo.summaryService;



import com.project.todo.model.Todo;
import com.project.todo.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryService {

    @Autowired
    private TodoRepository todoRepo;

    @Value("${slack.webhook.url}")
    private String slackWebhookUrl;

    public String generateSummary() {
        List<Todo> todos = todoRepo.findAll();
        if (todos.isEmpty()) return null;
        return todos.stream()
                .map(Todo::getText)
                .collect(Collectors.joining(", "));
    }

    public boolean sendToSlack(String message) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(slackWebhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"text\":\"" + message + "\"}"))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

