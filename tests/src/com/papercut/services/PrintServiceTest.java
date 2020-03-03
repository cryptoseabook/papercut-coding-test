package com.papercut.services;


import com.papercut.domains.PrintJob;
import com.papercut.domains.PrintSize;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class PrintServiceTest {

    private PrintService printService = new PrintService();


    @Test
    public void calcCost() {
        PrintJob printJob1 = new PrintJob(PrintSize.A4, false, false, 10);
        BigDecimal result1 = printService.calcCost(printJob1);

        Assert.assertEquals(1.5, result1.doubleValue(), 0);

        PrintJob printJob2 = new PrintJob(PrintSize.A4, false, true, 100);
        BigDecimal result2 = printService.calcCost(printJob2);

        Assert.assertEquals(10, result2.doubleValue(), 0);

        PrintJob printJob3 = new PrintJob(PrintSize.A4, true, false, 10);
        BigDecimal result3 = printService.calcCost(printJob3);

        Assert.assertEquals(2.5, result3.doubleValue(), 0);

        PrintJob printJob4 = new PrintJob(PrintSize.A4, true, true, 100);
        BigDecimal result4 = printService.calcCost(printJob4);

        Assert.assertEquals(20, result4.doubleValue(), 0);
    }

    @Test
    public void calcTotalCost() {
        PrintJob printJob1 = new PrintJob(PrintSize.A4, false, false, 10);
        PrintJob printJob2 = new PrintJob(PrintSize.A4, false, true, 100);
        PrintJob printJob3 = new PrintJob(PrintSize.A4, true, false, 10);
        PrintJob printJob4 = new PrintJob(PrintSize.A4, true, true, 100);


        List<PrintJob> printJobs = Arrays.asList(printJob1, printJob2, printJob3, printJob4);

        BigDecimal totalCost = printService.calcTotalCost(printJobs);

        Assert.assertEquals(34, totalCost.doubleValue(), 0);

    }

    @Test
    public void getAllPrintJobs() {
        String path = "../test_sample.csv";
        List<PrintJob> allPrintJobs = printService.getAllPrintJobs(path);
        Assert.assertEquals(8, allPrintJobs.size());
    }

    @Test
    public void getTotalCost4PrintJobs() {
        String path = "../test_sample.csv";
        List<PrintJob> allPrintJobs = printService.getAllPrintJobs(path);
        Assert.assertEquals(8, allPrintJobs.size());

        BigDecimal totalCost = printService.calcTotalCost(allPrintJobs);

        Assert.assertEquals(64.1, totalCost.doubleValue(), 0);
    }



    @Test(expected = IllegalArgumentException.class)
    public void getAllPrintJobsDataIssueException() {
        String path = "../test_sample2.csv";
        List<PrintJob> allPrintJobs = printService.getAllPrintJobs(path);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllPrintJobsFileNotFoundException() {
        String path = "../test_sample23.csv";
        List<PrintJob> allPrintJobs = printService.getAllPrintJobs(path);
    }
}
