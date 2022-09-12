package ru.timofey.tgbot2;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.timofey.tgbot2.handlers.CallbackQueryHandler;
import ru.timofey.tgbot2.handlers.MessageHandler;

public class Bot extends SpringWebhookBot {
    private String botPath;
    private String botToken;
    private String botName;

    MessageHandler messageHandler;
    CallbackQueryHandler callbackQueryHandler;


    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public CallbackQueryHandler getCallbackQueryHandler() {
        return callbackQueryHandler;
    }

    public void setCallbackQueryHandler(CallbackQueryHandler callbackQueryHandler) {
        this.callbackQueryHandler = callbackQueryHandler;
    }


    public Bot(MessageHandler messageHandler,CallbackQueryHandler callbackQueryHandler, SetWebhook setWebhook) {
        super(setWebhook);
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
    }


    public Bot(MessageHandler messageHandler,CallbackQueryHandler callbackQueryHandler,DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();

            return callbackQueryHandler.processCallback(callbackQuery);
        } else {

            Message message = update.getMessage();
            if(message.hasText() & message!=null)
                return messageHandler.handleMessage(message);
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setBotPath(String botPath) {
        this.botPath = botPath;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }
}
