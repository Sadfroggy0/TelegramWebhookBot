package ru.timofey.tgbot2.vacancyEntities;

public class Salary {
    private int to;
    private int from;
    private String currency;
    private boolean gross;

    public Salary() {
    }

    public Salary(int to, int from, String currency, boolean gross) {
        this.to = to;
        this.from = from;
        this.currency = currency;
        this.gross = gross;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isGross() {
        return gross;
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "to=" + to +
                ", from=" + from +
                ", currency='" + currency + '\'' +
                '}';
    }
}
