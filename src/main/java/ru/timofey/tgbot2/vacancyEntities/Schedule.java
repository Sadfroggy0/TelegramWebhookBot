package ru.timofey.tgbot2.vacancyEntities;

public class Schedule {
    private String id;
    private String name;
    public Schedule(){}

    public Schedule(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}