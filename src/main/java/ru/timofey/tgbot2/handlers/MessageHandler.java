package ru.timofey.tgbot2.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.timofey.tgbot2.keyboard.Keyboard;

@Component
public class MessageHandler {

    @Autowired
    Keyboard keyboard;

    public BotApiMethod<?>handleMessage(Message message){
        String chatId= message.getChatId().toString();
        String inputText = message.getText();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        if (inputText.equals("/start"))
        {

            sendMessage.setReplyMarkup(keyboard.getMenuKeyboard());
            sendMessage.setText("Start command has been executed");

            return sendMessage;
        }
        else if(inputText.equals("Vacancies")){

        }

        sendMessage.setText(inputText);
        return sendMessage;

    }

}
