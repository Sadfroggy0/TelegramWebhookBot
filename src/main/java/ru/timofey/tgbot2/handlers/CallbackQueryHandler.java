package ru.timofey.tgbot2.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.timofey.tgbot2.keyboard.ButtonsEnum;

@Component
public class CallbackQueryHandler {
    public BotApiMethod<?>processCallback(CallbackQuery callbackQuery){
        String chatId = callbackQuery.getMessage().getChatId().toString();
        String data = callbackQuery.getData();

        return null;
    }
}
