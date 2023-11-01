package org.poc.services;

// Class to hold configuration constants
public class OpenAIConfig {

    // API key for OpenAI Service
    public static final String API_KEY = "YOUR_OPENAI_API_KEY_HERE";

    // Timeout for OpenAI API calls in milliseconds
    public static final long API_TIME_OUT = 1000;

    // OpenAI API model to be used
    public static final String API_MODEL = "gpt-3.5-turbo";

    // Temperature setting for API requests
    public static final double TEMPERATURE = 0.8;

    // System message for initiating chat tasks
    public static final String SYSTEM_TASK_MESSAGE = "...";

    // User message for chat tasks
    public static final String USER_MESSAGE = "...";
}

