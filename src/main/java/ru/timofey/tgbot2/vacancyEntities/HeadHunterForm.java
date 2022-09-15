package ru.timofey.tgbot2.vacancyEntities;

public class HeadHunterForm {
    private Schedule schedule;
    private Experience experience;
    private Address address;
    private int id;
    private String alternate_url;
    private Salary salary;
    private String name;
    private Area area;
    private Specializations specializations;

    public HeadHunterForm(){
    }

    public HeadHunterForm(Schedule schedule, Experience experience,
                          Address address, int id, String alternate_url,
                          Salary salary, Area area,
                          Specializations specializations,String name) {

        this.name = name;
        this.schedule = schedule;
        this.experience = experience;
        this.address = address;
        this.id = id;
        this.alternate_url = alternate_url;
        this.salary = salary;
        this.area = area;
        this.specializations = specializations;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlternate_url() {
        return alternate_url;
    }

    public void setAlternate_url(String alternate_url) {
        this.alternate_url = alternate_url;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Specializations getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Specializations specializations) {
        this.specializations = specializations;
    }
}
