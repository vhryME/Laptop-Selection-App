package com.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static String seacrhQuery;

    public static List<Laptop> getProducts() throws IOException {
        seacrhQuery = "noutbuki";

        List<Laptop> products = new ArrayList<>();
        StringBuffer temp = null;

        Document document = document= Jsoup.connect("https://5element.by/catalog/1383-" + seacrhQuery).get();

        Elements productsHTML = document.getElementsByAttributeValue("class", "spec-product js-product-item");

        for (Element productHTML : productsHTML) {

            String data = productHTML.text();

            //Temporary vars for getting data to parsing that in objects
            StringBuffer name = new StringBuffer();
            StringBuffer code = new StringBuffer();
            StringBuffer os = new StringBuffer();
            StringBuffer screen = new StringBuffer();
            StringBuffer processor = new StringBuffer();
            StringBuffer gCard = new StringBuffer();
            StringBuffer ram = new StringBuffer();
            StringBuffer hard = new StringBuffer();

            StringBuffer cost = new StringBuffer();
            StringBuffer delivery = new StringBuffer();

            //System.out.println(data);

            String[] strArray = data.split(" ");

            //Getting name
            for (int i = 0; i < 7; i++) {
                if(!strArray[i].equalsIgnoreCase("Код:") && !strArray[i].equalsIgnoreCase("Ноутбук") && !strArray[i].equalsIgnoreCase("Видео"))
                    name.append(strArray[i] + " ");
            }

            //Getting code
            for (int i = 7; i < 9; i++) {
                if(!strArray[i].equals("Код:"))
                    code.append(strArray[i] + " ");
            }

            //Getting os
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("Не")) {
                    strArray[i] = "Не установлена";
                    os.append(strArray[i]);
                }

                if((strArray[i].equalsIgnoreCase("Mac"))) {
                    strArray[i] = "Mac OS";
                    os.append(strArray[i]);
                }

                if(strArray[i].equalsIgnoreCase("Windows") || strArray[i].equalsIgnoreCase("Linux") || strArray[i].equalsIgnoreCase("Dos"))
                    os.append(strArray[i]);
            }

            //Getting screen
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("экрана")) {
                    strArray[i] = strArray[i++];
                    screen.append(strArray[i]);
                }
            }

            //Getting processor
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("процессора")) {
                    strArray[i] = strArray[i++];
                    processor.append(strArray[i]);
                }
            }

            //Getting graphic Card
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("видеокарты")) {
                    strArray[i] = strArray[i++];
                    gCard.append(strArray[i]);
                }
            }

            //Getting RAM
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("памяти")) {
                    strArray[i] = strArray[i++];
                    ram.append(strArray[i] + " ГБ");
                }
            }

            //Getting hard disk
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("диска")) {
                    strArray[i] = strArray[i++];
                    hard.append(strArray[i]);
                }
            }

            //Getting costs and cos of deloivery
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i].equalsIgnoreCase("SSD") || strArray[i].equalsIgnoreCase("HDD") || strArray[i].equalsIgnoreCase("HDD+SSD")) {
                    strArray[i] = strArray[i+2];
                    cost.append(strArray[i]);
                }

                if(strArray[i].equalsIgnoreCase("Бонусы:")) {
                    strArray[i] = strArray[i++];
                    delivery.append(strArray[i]);
                }
            }

            Laptop product = new Laptop(name, code, os, screen, processor, gCard, ram, hard, cost, delivery);
            System.out.println(product.toString());
            products.add(product);
        }

        return products;
    }
}
