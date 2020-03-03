package com.papercut;

import com.papercut.domains.PrintJob;
import com.papercut.services.PrintService;

import java.math.BigDecimal;
import java.util.List;

public class PrintServiceExecutor {

    public static void main(String[] args) {

        PrintService printService = new PrintService();

        List<PrintJob> allPrintJobs = printService.getAllPrintJobs("../sample.csv");
        BigDecimal result = printService.calcTotalCost(allPrintJobs);

        System.out.println("============================================================");
        System.out.println("Total cost:" + result.doubleValue());
        System.out.println("============================================================");
    }
}
