package com.api.advice.advicesGenerator.provider.query;

import java.util.List;

public class StatsQuerySlip {

    private String total_results;

    private String query;

    private List<SlipWithDate> slips;

    public StatsQuerySlip() {
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SlipWithDate> getSlips() {
        return slips;
    }

    public void setSlips(List<SlipWithDate> slips) {
        this.slips = slips;
    }
}
