package com.tamaproject.weather;

public class CurrentConditions {
    private String condition;
    private String main;
    private int tempF;

    public CurrentConditions(String condition, String main, int tempF) {
        this.condition = condition;
        this.main = main;
        this.tempF = tempF;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getMain() {
        return this.main;
    }

    public int getTempF() {
        return this.tempF;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setTempF(int tempF) {
        this.tempF = tempF;
    }

    public String toString() {
        return "CurrentConditions [condition=" + this.condition + ", main=" + this.main + ", tempF=" + this.tempF + "]";
    }
}
