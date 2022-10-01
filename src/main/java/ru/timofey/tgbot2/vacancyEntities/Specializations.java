package ru.timofey.tgbot2.vacancyEntities;

public class Specializations {
    private int profarea_id;
    private String profarea_name;
    private int id;
    private String name;

    public Specializations() {
    }

    public Specializations(int profarea_id, String profarea_name, int id, String name) {
        this.profarea_id = profarea_id;
        this.profarea_name = profarea_name;
        this.id = id;
        this.name = name;
    }

    public int getProfarea_id() {
        return profarea_id;
    }

    public void setProfarea_id(int profarea_id) {
        this.profarea_id = profarea_id;
    }

    public String getProfarea_name() {
        return profarea_name;
    }

    public void setProfarea_name(String profarea_name) {
        this.profarea_name = profarea_name;
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

    @Override
    public String toString() {
        return "Specializations{" +
                "profarea_name='" + profarea_name + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
