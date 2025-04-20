package com.dto;

public class Module {
    private String name;
    private String url;

    // constructor, getters
    public Module(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
