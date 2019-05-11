package com.vat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Model class for period
 */
public class Period {

    private Date effectiveFrom;
    private Rates rates;

    @JsonProperty("effective_from")
    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    @JsonProperty("rates")


    @Override
    public String toString() {
        return "Period{" +
                "effectiveFrom=" + effectiveFrom +
                ", rates=" + rates +
                '}';
    }
}
