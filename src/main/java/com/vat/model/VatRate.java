package com.vat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Model class for VAT rates coming from json
 */
public class VatRate {

    private String name;
    private String code;
    private String countryCode;
    private List<Period> periods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("periods")
    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "VatRate{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", periods=" + periods +
                '}';
    }

}
