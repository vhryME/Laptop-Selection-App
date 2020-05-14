package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Laptop {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private StringBuffer name;
    private StringBuffer code;
    private StringBuffer os;
    private StringBuffer screen;
    private StringBuffer processor;
    private StringBuffer gCard;
    private StringBuffer ram;
    private StringBuffer hard;

    private StringBuffer cost;
    private StringBuffer delivery;


    public Laptop() {  }

    public Laptop(StringBuffer name, StringBuffer code, StringBuffer os, StringBuffer screen, StringBuffer processor, StringBuffer gCard, StringBuffer ram, StringBuffer hard, StringBuffer cost, StringBuffer delivery) {
        this.name = name;
        this.code = code;
        this.os = os;
        this.screen = screen;
        this.processor = processor;
        this.gCard = gCard;
        this.ram = ram;
        this.hard = hard;

        this.cost = cost;
        this.delivery = delivery;
    }


    public StringBuffer getName() { return name; }
    public void setName(StringBuffer name) { this.name = name; }

    public StringBuffer getCode() { return code; }
    public void setCode(StringBuffer code) { this.code = code; }

    public StringBuffer getOs() { return os; }
    public void setOs(StringBuffer os) { this.os = os; }

    public StringBuffer getScreen() { return screen; }
    public void setScreen(StringBuffer screen) { this.screen = screen; }

    public StringBuffer getProcessor() { return processor; }
    public void setProcessor(StringBuffer processor) { this.processor = processor; }

    public StringBuffer getgCard() { return gCard; }
    public void setgCard(StringBuffer gCard) { this.gCard = gCard; }

    public StringBuffer getRam() { return ram; }
    public void setRam(StringBuffer ram) { this.ram = ram; }

    public StringBuffer getHard() { return hard; }
    public void setHard(StringBuffer hard) { this.hard = hard; }

    public StringBuffer getCost() { return cost; }
    public void setCost(StringBuffer cost) { this.cost = cost; }

    public StringBuffer getDelivery() { return delivery; }
    public void setDelivery(StringBuffer delivery) { this.delivery = delivery; }


    public static String[] getAllproperties(Laptop laptop) {
        return new String[]{
                laptop.getName().toString(), laptop.getCode().toString(), laptop.getOs().toString(),
                laptop.getScreen().toString(), laptop.getProcessor().toString(), laptop.getgCard().toString(), laptop.getRam().toString(),
                laptop.getHard().toString(), laptop.getCost().toString(), laptop.getDelivery().toString()};
    }


    @Override
    public String toString() {
        return name + "\nКод:" + code + "\nОС:" + os + "\nЭкран:" + screen + "\nПроцессор:" + processor + "\nТип Видеокарты:" + gCard + "\nТип Жесткого диска:" + hard + "\nЦена + доставка:" + cost + " + " + delivery + "\n\n";
    }
}
