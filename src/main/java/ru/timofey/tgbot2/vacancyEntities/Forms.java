package ru.timofey.tgbot2.vacancyEntities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forms {
    @SerializedName("items")
    private List<HeadHunterForm> items;

    public List<HeadHunterForm> getFormList() {
        return items;
    }

    public void setFormList(List<HeadHunterForm> formList) {
        this.items = formList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HeadHunterForm hhf :
                items) {
            sb.append("id: " + hhf.getId() + "\n" +
                    "name: " + hhf.getName() + "\n" +
                    "Schedule: " + hhf.getSchedule().toString() + "\n" +
                    hhf.getAlternate_url() + "\n" + "\n");

        }
        return sb.toString();
    }
}
