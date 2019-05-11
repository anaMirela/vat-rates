package com.vat.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vat.model.VatRate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that will provide a list of vat rates
 */
public class VatRateService {

    public List<VatRate> getVatRatesFromUrl(String url) throws IOException {
        List<VatRate> vatRates = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ObjectNode node = new ObjectMapper().readValue(new URL(url), ObjectNode.class);
        if (node.has("rates")) {
            for (JsonNode rateNode : node.get("rates")) {
                VatRate vatRate = mapper.treeToValue(rateNode, VatRate.class);
                vatRates.add(vatRate);
            }
        }
        return vatRates;
    }

}

