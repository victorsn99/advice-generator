package com.api.advice.advicesGenerator.provider.slip;

public class Advice {

    private Long id;

    private String advice;

    public Advice(String advice) {
        this.advice = advice;
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
}
