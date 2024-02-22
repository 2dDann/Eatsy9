package com.example.eatsy9;

public class HelpItem {
    private String title;
    private String extraInfo;

    public HelpItem(String title, String extraInfo) {
        this.title = title;
        this.extraInfo = extraInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getExtraInfo() {
        return extraInfo;
    }
}

