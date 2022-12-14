package ru.timofey.tgbot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.timofey.tgbot2.Bot;
import ru.timofey.tgbot2.handlers.CallbackQueryHandler;
import ru.timofey.tgbot2.handlers.MessageHandler;


@Configuration
public class SpringConfiguration {

    private TelegramConfig telegramConfig;

    public SpringConfiguration(TelegramConfig telegramConfig) {
        this.telegramConfig = telegramConfig;
    }


    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebHookPath()).build();

    }

    @Bean
    public Bot webHookBotBean(SetWebhook setWebhook, MessageHandler messageHandler, CallbackQueryHandler callbackQueryHandler) {
        Bot bot = new Bot(messageHandler, callbackQueryHandler, setWebhook);
        bot.setBotPath(telegramConfig.getWebHookPath());
        bot.setBotToken(telegramConfig.getBotToken());
        bot.setBotName(telegramConfig.getBotName());
        return bot;
    }

}
