package org.poc.services;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

// Class OpenAiServiceWrapper implements the IOpenAiService interface
public class OpenAiServiceWrapper implements IOpenAiService {

    // Instance of OpenAiService for API calls
    OpenAiService service = null;

    // Constructor: Initializes OpenAiService with API key and timeout from Config
    public OpenAiServiceWrapper() {
        service = new OpenAiService(OpenAIConfig.API_KEY, Duration.ofSeconds(OpenAIConfig.API_TIME_OUT));
    }

    // Overridden method to get chat completion based on predefined system and user messages
    @Override
    public String getChatCompletion() {
        ChatCompletionRequest request = buildRequest(List.of(
                new ChatMessage("system", OpenAIConfig.SYSTEM_TASK_MESSAGE),
                new ChatMessage("user", OpenAIConfig.USER_MESSAGE)));
        return service.createChatCompletion(request).toString();
    }

    // Overridden method to get chat completion based on a single user message
    @Override
    public String getSimpleChatCompletion(String message) {
        ChatCompletionRequest request = buildRequest(List.of(
                new ChatMessage("system", OpenAIConfig.SYSTEM_TASK_MESSAGE),
                new ChatMessage("user", message)));
        return service.createChatCompletion(request).toString();
    }

    // Overridden method to get chat completion based on a list of ChatMessage objects
    @Override
    public String getChatCompletion(List<ChatMessage> chatMessageList) {
        ChatCompletionRequest request = buildRequest(chatMessageList);
        return service.createChatCompletion(request).toString();
    }

    // Private helper method to build a ChatCompletionRequest
    private ChatCompletionRequest buildRequest(List<ChatMessage> chatMessageList) {
        return ChatCompletionRequest.builder()
                .model(OpenAIConfig.API_MODEL)
                .temperature(OpenAIConfig.TEMPERATURE)
                .messages(chatMessageList)
                .build();
    }
}
