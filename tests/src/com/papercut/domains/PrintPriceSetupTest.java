package com.papercut.domains;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PrintPriceSetupTest {

    private PrintPriceSetup printPriceSetup = new PrintPriceSetup();

    @Before
    public void init() {
        printPriceSetup.init();
    }

    @Test
    public void getPriceSetting() {
        GenericPrintSetting printJobA4NonColorSingleSided = new GenericPrintSetting(PrintSize.A4, false, false);
        GenericPrintSetting printJobA4ColorSingleSided = new GenericPrintSetting(PrintSize.A4, true, false);
        GenericPrintSetting printJobA4NonColorDoubleSided = new GenericPrintSetting(PrintSize.A4, false, true);
        GenericPrintSetting printJobA4ColorDoubleSided = new GenericPrintSetting(PrintSize.A4, true, true);


        BigDecimal priceSetting1 = printPriceSetup.getPriceSetting(printJobA4NonColorSingleSided);
        BigDecimal priceSetting2 = printPriceSetup.getPriceSetting(printJobA4ColorSingleSided);
        BigDecimal priceSetting3 = printPriceSetup.getPriceSetting(printJobA4NonColorDoubleSided);
        BigDecimal priceSetting4 = printPriceSetup.getPriceSetting(printJobA4ColorDoubleSided);

        Assert.assertEquals(BigDecimal.valueOf(0.15), priceSetting1);
        Assert.assertEquals(BigDecimal.valueOf(0.25), priceSetting2);
        Assert.assertEquals(BigDecimal.valueOf(0.1), priceSetting3);
        Assert.assertEquals(BigDecimal.valueOf(0.2), priceSetting4);
    }
}
