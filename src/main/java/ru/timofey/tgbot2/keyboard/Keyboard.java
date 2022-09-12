package ru.timofey.tgbot2.keyboard;

import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class Keyboard {

    public ReplyKeyboardMarkup getMenuKeyboard(){
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(ButtonsEnum.Vacancies.toString()));

        keyboardRowList.add(row1);
        keyboard.setKeyboard(keyboardRowList);
        keyboard.setSelective(true);
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);

        return keyboard;

    }
}
