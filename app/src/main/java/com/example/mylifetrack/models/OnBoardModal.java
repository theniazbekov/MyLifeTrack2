package com.example.mylifetrack.models;

public class OnBoardModal {
    private int animation;
    private String text;
    private String buttonText;

    public OnBoardModal(int animation, String text, String buttonText) {
        this.animation = animation;
        this.text = text;
        this.buttonText = buttonText;
    }

    public int getAnimation() {
        return animation;
    }

    public String getText() {
        return text;
    }

    public String getButtonText() {
        return buttonText;
    }
}


