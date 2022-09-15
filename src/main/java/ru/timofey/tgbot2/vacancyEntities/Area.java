package ru.timofey.tgbot2.vacancyEntities;

public class Area {
    private String Url;
    private int id;
    private String name;
    public Area(){}

    public Area(String url, int id, String name) {
        Url = url;
        this.id = id;
        this.name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
