package ru.timofey.tgbot2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TelegramConfig {

    //https://api.telegram.org/bot1371627210:AAFrSd-euAi05t3TN-Exc-BvC2hLzNQfcWI/setWebhook?url=https://f941-85-143-106-69.eu.ngrok.io
    @Value("${telegrambot.name}")
    private  String botName;
    @Value("${telegrambot.token}")
    private  String token;
    @Value("${telegrambot.webHookPath}")
    private String webHookPath;


    public String getBotName() {
        return botName;
    }

    public String getBotToken() {
        return token;
    }

    public String getWebHookPath() {
        return webHookPath;
    }
}
