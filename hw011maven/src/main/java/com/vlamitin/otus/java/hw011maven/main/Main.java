package com.vlamitin.otus.java.hw011maven.main;

import org.apache.commons.lang3.time.DateFormatUtils;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String formattedCurrentDate = DateFormatUtils.formatUTC(new Date(), "DD.MM.YYYY HH:mm:ss");
        System.out.format("Hello! It is already %s. Maybe it is time to study Java?", formattedCurrentDate);
        System.exit(0);
    }
}
