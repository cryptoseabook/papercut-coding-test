package com.papercut.domains;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PrintPriceSetup {

    private Map<GenericPrintSetting, BigDecimal> pricingStrategy = new HashMap<>();

    /**
     * Initialize all the price setup
     * This probably could be extracted to a property files for more flexible configuration, but for the sake of simplicity we will leave like this for now.
     *
     */
    public void init() {
        GenericPrintSetting printJobA4NonColorSingleSided = new GenericPrintSetting(PrintSize.A4, false, false);
        GenericPrintSetting printJobA4ColorSingleSided = new GenericPrintSetting(PrintSize.A4, true, false);
        GenericPrintSetting printJobA4NonColorDoubleSided = new GenericPrintSetting(PrintSize.A4, false, true);
        GenericPrintSetting printJobA4ColorDoubleSided = new GenericPrintSetting(PrintSize.A4, true, true);

        pricingStrategy.put(printJobA4NonColorSingleSided, BigDecimal.valueOf(0.15));
        pricingStrategy.put(printJobA4ColorSingleSided, BigDecimal.valueOf(0.25));
        pricingStrategy.put(printJobA4NonColorDoubleSided, BigDecimal.valueOf(0.1));
        pricingStrategy.put(printJobA4ColorDoubleSided, BigDecimal.valueOf(0.2));
    }

    public BigDecimal getPriceSetting(GenericPrintSetting printSetting) {
        return pricingStrategy.get(printSetting);
    }

}
