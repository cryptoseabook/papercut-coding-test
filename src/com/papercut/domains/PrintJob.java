package com.papercut.domains;

public class PrintJob extends GenericPrintSetting {
    private int totalPages;

    public PrintJob(PrintSize paperSize, boolean isColorPrint, boolean isDoubleSided, int totalPages) {
        super(paperSize, isColorPrint, isDoubleSided);
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "totalPages=" + totalPages + ", " +
                super.toString() +
                '}';
    }
}
