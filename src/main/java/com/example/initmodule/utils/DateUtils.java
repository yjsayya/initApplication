package com.example.initmodule.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    @Getter
    @AllArgsConstructor
    public enum DateTimeFormat {

        YYYYMMDDHHMISS("yyyymmddhhmiss", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
        ,YYYYMMDD("yyyymmdd", DateTimeFormatter.ofPattern("yyyyMMdd"))
        ,HHMISS("hhmiss", DateTimeFormatter.ofPattern("HHmmss"))
        ,DEFAULT("default", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        ;

        private final String code;
        private final DateTimeFormatter formatter;

        public static DateTimeFormat fromCode(String code) {
            for (DateTimeFormat format : values()) {
                if (format.code.equalsIgnoreCase(code))
                    return format;
            }
            throw new IllegalArgumentException("Invalid code: " + code);
        }

    }

    public static String getCurrentDate(String code) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormat format = DateTimeFormat.fromCode(code);

        return currentDateTime.format(format.getFormatter());
    }

}