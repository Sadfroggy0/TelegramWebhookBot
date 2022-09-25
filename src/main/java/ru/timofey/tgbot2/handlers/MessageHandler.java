package ru.timofey.tgbot2.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.timofey.tgbot2.httpConnection.HttpHeadHunterRequest;
import ru.timofey.tgbot2.keyboard.Keyboard;
import ru.timofey.tgbot2.vacancyEntities.Forms;
import ru.timofey.tgbot2.vacancyEntities.VacanciesFromJson;



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

        //test method just to see how it works.
        // TODO: 16.09.2022 make HTTP REQUEST Entity + make some methods for it to use simple interfaces here.
        else if(inputText.equals("Vacancies")){

            HttpHeadHunterRequest request = new HttpHeadHunterRequest("https://api.hh.ru/vacancies") ;
            Forms list = VacanciesFromJson.getVacancies(request.getJsonString().toString());
            sendMessage.setText(list.toString());
            return sendMessage;
        }
        else if(inputText!=null && inputText.length()>1) {

            String[] searchPool = inputText.split(" ");
            StringBuilder sb = new StringBuilder("https://api.hh.ru/vacancies?text=");
           for (int i = 0; i <searchPool.length; i++){

               if(i==0) sb.append(searchPool[i]);
               else if (i==searchPool.length-1) sb.append("+"+searchPool[i]);
               else sb.append("+"+searchPool[i]);
           }
           HttpHeadHunterRequest request = new HttpHeadHunterRequest(sb.toString());
            Forms list = VacanciesFromJson.getVacancies(request.getJsonString().toString());
            sendMessage.setText(list.toString());
            return sendMessage;
        }
        else {
            sendMessage.setText(inputText.toString());
            return sendMessage;
        }

    }

}
