package com.chenjian.java;

/**
 * Created by chenjian on 2021/3/30 23:53
 */
public class Father {


    private String name;

    private int years;

    private boolean man;

    public Father(){

    }

    public Father(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
