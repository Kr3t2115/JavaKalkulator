package com.example.demo;

import javafx.event.ActionEvent;

public class Obliczanie {
    private final ActionEvent event;

    public Obliczanie(ActionEvent event) {
        this.event = event;
    }
    void metoda(){
        System.out.println(event);
    }
}
