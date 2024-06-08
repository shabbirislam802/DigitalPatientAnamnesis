/*package at.ac.fhwn.group6.DigitaleRADAnamnese.controller.web;
import at.ac.fhwn.group6.DigitaleRADAnamnese.services.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/message")
    public String getChatResponse(@RequestBody Map<String, String> request) {
        String prompt = request.get("message");
        return openAIService.getChatGPTResponse(prompt);
    }
}

*/