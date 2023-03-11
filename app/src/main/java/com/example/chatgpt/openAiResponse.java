package com.example.chatgpt;

import android.util.Log;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;

import java.util.List;

public class openAiResponse {
    String myKey = "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";
    OpenAiService service = new OpenAiService(myKey);

    public String getResponse(String prompt){
        Log.i("known", prompt);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .temperature(0.0)
                .topP(1.0)
                .maxTokens(200)
                .frequencyPenalty(0.0)
                .presencePenalty(0.0)
                .build();
       List<CompletionChoice> x = service.createCompletion(completionRequest).getChoices();
       Log.i("xxx", x.toString());
       return x.get(0).getText().replace(prompt, "");
    }
}
