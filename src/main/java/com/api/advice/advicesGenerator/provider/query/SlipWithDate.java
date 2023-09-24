package com.api.advice.advicesGenerator.provider.query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SlipWithDate {

    private Long id;

    private String advice;

    private LocalDate date;

    public SlipWithDate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getDateFormatted() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
