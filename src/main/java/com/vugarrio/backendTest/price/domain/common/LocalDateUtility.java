package com.vugarrio.backendTest.price.domain.common;

import com.vugarrio.backendTest.price.domain.exception.DateWrongFormatException;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
public class LocalDateUtility {

    public static final String DATETIME_LOCAL_TEXT_PATTERN = "yyyy-MM-dd-HH.mm.ss";

    private LocalDateUtility() {
        throw new IllegalStateException("ZoneDateConstant class");
    }

    public static void validateDateString(final String date) {
        try {
            DateTimeFormatter.ofPattern(DATETIME_LOCAL_TEXT_PATTERN).parse(date);
        } catch (DateTimeParseException e) {
            throw new DateWrongFormatException(date);
        }
    }
}
