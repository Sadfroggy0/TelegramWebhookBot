package ru.timofey.tgbot2.vacancyEntities;

import com.google.gson.Gson;

public class VacanciesFromJson {
    public static Forms getVacancies(String json) {
        Gson gson = new Gson();
        Forms froms = gson.fromJson(json, Forms.class);
        return froms;
    }
}
