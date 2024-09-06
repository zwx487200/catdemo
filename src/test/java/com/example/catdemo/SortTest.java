package com.example.catdemo;

import lombok.Data;

@Data
public class SortTest {
    public String name;
    public String description;
    public String lastMrData;
    public String mrData;

    public SortTest(String name, String description, String lastMrData, String mrData) {
        this.name = name;
        this.description = description;
        this.lastMrData = lastMrData;
        this.mrData = mrData;
    }
}
