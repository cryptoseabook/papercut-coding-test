package com.papercut.services;

import com.papercut.domains.GenericPrintSetting;
import com.papercut.domains.PrintJob;
import com.papercut.domains.PrintPriceSetup;
import com.papercut.domains.PrintSize;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrintService {

    private PrintPriceSetup printPriceSetup = new PrintPriceSetup();

    public PrintService() {
        printPriceSetup.init();
    }

    /**
     * Internal method to calculate the price based on size, pages, color and doublesided parameters
     * @param printSize
     * @param totalPages
     * @param isColorPrint
     * @param isDoubleSided
     * @return
     */
    private BigDecimal calcCost(PrintSize printSize, int totalPages, boolean isColorPrint, boolean isDoubleSided) {
        GenericPrintSetting genericPrintSetting = new GenericPrintSetting(printSize, isColorPrint, isDoubleSided);
        BigDecimal price = printPriceSetup.getPriceSetting(genericPrintSetting);

        BigDecimal result = BigDecimal.valueOf(totalPages).multiply(price);

        System.out.println(result);

        return result;
    }

    /**
     * Calculate price for one printJob, using BigDecimal to avoid buffer over flow and lose precision issues in Double.
     * @param printJob
     * @return
     */
    public BigDecimal calcCost(PrintJob printJob) {
        System.out.println("Start to calculate cost for printJob: " + printJob.toString());

        PrintSize printSize = printJob.getPaperSize();
        int totalPages = printJob.getTotalPages();
        boolean isColorPrint = printJob.isColorPrint();
        boolean isDoubleSided = printJob.isDoubleSided();

        return calcCost(printSize, totalPages, isColorPrint, isDoubleSided);
    }

    /**
     * Calculate total Cost, using BigDecimal to avoid buffer over flow and lose precision issues in Double.
     * @param printJobs
     * @return
     */
    public BigDecimal calcTotalCost(List<PrintJob> printJobs) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (PrintJob printJob : printJobs) {
            total = total.add(calcCost(printJob));
        }

        return total;
    }

    /**
     * Get all the print jobs from specified csv file.
     * @param pathToCsv
     * @return
     */
    public List<PrintJob> getAllPrintJobs(String pathToCsv) {
        List<PrintJob> printJobs = new ArrayList<>();
        BufferedReader csvReader = null;
        try {
            InputStream in = getClass().getResourceAsStream(pathToCsv);
            csvReader = new BufferedReader(new InputStreamReader(in));
            String row;
            while ((row = csvReader.readLine()) != null) {

                if (row.contains("Color Pages")) {  // skip header
                    continue;
                }

                String[] data = row.split(",");
                String totalPages = data[0].trim();
                String colorPages = data[1].trim();
                String doubleSided = data[2].trim();

                int colorPagesNo = Integer.valueOf(colorPages);
                int blackWhitePagesNo = Integer.valueOf(totalPages) - colorPagesNo;
                boolean isDoubleSided = Boolean.valueOf(doubleSided);

                /* break down the one csv line into two separate print jobs */
                PrintJob printJob1 = new PrintJob(PrintSize.A4, true, isDoubleSided, colorPagesNo);
                PrintJob printJob2 = new PrintJob(PrintSize.A4, false, isDoubleSided, blackWhitePagesNo);

                printJobs.add(printJob1);
                printJobs.add(printJob2);

            }
        } catch(IOException ioException) {
            throw new IllegalArgumentException("Cant find the print jobs: " + pathToCsv);
        } catch(Exception ex) {
            throw new IllegalArgumentException("Print jobs csv configuration seems corrupted: " + pathToCsv);
        } finally {
            if (csvReader != null) {
                try {csvReader.close(); } catch (IOException e) { }
            }
        }

        return printJobs;
    }
}