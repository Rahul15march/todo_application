package com.project.todo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.todo.summaryService.SummaryService;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SummarizeController {

    @Autowired
    private SummaryService summaryService;

    @PostMapping("/summarize")
    public ResponseEntity<?> summarizeTodos() {
        String summary = summaryService.generateSummary();
        if (summary == null) {
            return ResponseEntity.badRequest().body("No todos to summarize.");
        }

        boolean success = summaryService.sendToSlack("Summary of todos: " + summary);
        return ResponseEntity.ok(Map.of("message", success ? "Posted to Slack!" : "Slack failed"));
    }
}

