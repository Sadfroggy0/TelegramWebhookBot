package ru.timofey.tgbot2.httpConnection;

import org.springframework.beans.factory.annotation.Value;

public enum RequestType {
    BASIC("https://api.hh.ru/vacancies?text=");

    private  String urlStarter;

    RequestType(String s) {
        this.urlStarter = s;
    }

    public String getUrlStarter() {
        return urlStarter;
    }
}
