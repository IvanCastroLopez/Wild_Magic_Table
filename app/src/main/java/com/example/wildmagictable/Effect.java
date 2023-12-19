package com.example.wildmagictable;

public class Effect {

    private int id;
    private String spanishEffect;
    private String englishEffect;

    public Effect(int id, String englishEffect, String spanishEffect) {
        this.id = id;
        this.spanishEffect = spanishEffect;
        this.englishEffect = englishEffect;
    }

    public int getId() {
        return id;
    }

    public String getSpanishEffect() {
        return spanishEffect;
    }

    public String getEnglishEffect() {
        return englishEffect;
    }
}
