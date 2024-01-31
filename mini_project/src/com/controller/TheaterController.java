package com.controller;

import com.model.Theater;

public class TheaterController {
    Theater[] theater1 = new Theater[50];
    Theater[] theater2 = new Theater[30];
    Theater[] theater3 = new Theater[40];

    public void seatsList() {
        for (int i = 0; i < theater1.length; i++) {
            theater1[i] = new Theater(1, i + 1);
        }
        for (int i = 0; i < theater1.length; i++) {
            theater2[i] = new Theater(1, i + 1);
        }
        for (int i = 0; i < theater1.length; i++) {
            theater3[i] = new Theater(1, i + 1);
        }

        System.out.println("좌석 선택 : " + theater1[0] + " ~ " + theater1[theater1.length]);
        System.out.println("좌석 선택 : " + theater2[0] + " ~ " + theater1[theater1.length]);
        System.out.println("좌석 선택 : " + theater3[0] + " ~ " + theater1[theater1.length]);
    }

    public Object SelectSeat() {
        return 0;
    }
}
