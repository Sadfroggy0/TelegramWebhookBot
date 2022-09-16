package ru.timofey.tgbot2.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.timofey.tgbot2.keyboard.Keyboard;
import ru.timofey.tgbot2.vacancyEntities.Forms;
import ru.timofey.tgbot2.vacancyEntities.VacanciesFromJson;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
            StringBuilder jsonString = new StringBuilder();

            URL url = null;
            try {
                url = new URL("https://api.hh.ru/vacancies");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.setRequestProperty("User-Agent", "HH-User-Agent");

            try (InputStream is = connection.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                String c;
                while ((c = reader.readLine()) != null) {
                    jsonString.append(c);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
            Forms list = VacanciesFromJson.getVacancies(jsonString.toString());
            sendMessage.setText(list.toString());

            return sendMessage;
        }
        else {
            sendMessage.setText(inputText);
            return sendMessage;
        }

    }

}
