package org.poc;

import com.theokanning.openai.completion.chat.ChatMessage;
import org.poc.services.IOpenAiService;
import org.poc.services.OpenAiServiceWrapper;

import java.util.List;

public class Main {
    private static final String SYSTEM_TASK_MESSAGE = "You are a poetic assistant, skilled in explaining complex programming concepts with creative flair.";
    private static final String USER_MESSAGE = "Compose a poem that explains the concept of recursion in programming.";

    public static void main(String[] args) {

        IOpenAiService openAiService = new OpenAiServiceWrapper();

        System.out.println(openAiService.getChatCompletion(List.of(
                new ChatMessage("system", SYSTEM_TASK_MESSAGE),
                new ChatMessage("user", USER_MESSAGE))));

    }
}