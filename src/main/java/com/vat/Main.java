package com.vat;

import com.vat.model.Period;
import com.vat.model.VatRate;
import com.vat.service.VatRateService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    private static final String JSON_VAT_URL = "http://jsonvat.com/";

    public static void main(String[] args) throws IOException {
        VatRateService rateService = new VatRateService();
        List<VatRate> vatRates = rateService.getVatRatesFromUrl(JSON_VAT_URL);
        List<VatRate> sortedVatRates = vatRates.stream()
                .sorted(buildVatRateComparator()).collect(Collectors.toList());
        printResults(sortedVatRates);
    }

    private static Comparator<VatRate> buildVatRateComparator() {
        Comparator<VatRate> comparator = (VatRate v1, VatRate v2) -> {
            Optional<Period> p1 = v1.getPeriods().stream()
                    .min(Comparator.comparing(p -> p.getEffectiveFrom()));
            Optional<Period> p2 = v2.getPeriods().stream()
                    .min(Comparator.comparing(p -> p.getEffectiveFrom()));

            if (p1.isPresent() && p2.isPresent())
                return p1.get().getRates().getStandard()
                        .compareTo(p2.get().getRates().getStandard());
            else if (p1.isPresent())
                return 1;
            else if(p2.isPresent())
                return (-1);
            return 0;
        };
        return comparator;
    }

    private static void printResults(List<VatRate> sortedVatRates) {
        if (sortedVatRates.size() > 3) {
            System.out.println("EU countries with lowest VAT: "
                    + sortedVatRates.get(0).getCountryCode() + ", "
                    + sortedVatRates.get(1).getCountryCode() + ", "
                    + sortedVatRates.get(2).getCountryCode());
            System.out.println("EU countries with highest VAT: "
                    + sortedVatRates.get(sortedVatRates.size() - 1).getCountryCode() + ", "
                    + sortedVatRates.get(sortedVatRates.size() - 2).getCountryCode() + ", "
                    + sortedVatRates.get(sortedVatRates.size() - 3).getCountryCode());
        } else {
            System.out.println("Less than 3 countries provided as input.");
        }
    }
}
