package com.project;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new GenerateData(), 0, 30000);
    }
}
