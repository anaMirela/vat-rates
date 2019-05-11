package com.vat.model;

/**
 * Model for rates only with necessary keys from JSON
 */
public class Rates {

    private Double standard;

    public Double getStandard() {
        return standard;
    }

    public void setStandard(Double standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "standard='" + standard + '\'' +
                '}';
    }
}
