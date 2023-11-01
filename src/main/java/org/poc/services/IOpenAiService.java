package org.poc.services;

import com.theokanning.openai.completion.chat.ChatMessage;
import java.util.List;

// Defines the contract for OpenAI service interactions
public interface IOpenAiService {

    // Retrieves a chat completion based on predefined system and user messages
    String getChatCompletion();

    // Retrieves a chat completion for a simple user-defined message
    String getSimpleChatCompletion(String message);

    // Retrieves a chat completion based on a list of ChatMessage objects
    String getChatCompletion(List<ChatMessage> chatMessageList);
}
