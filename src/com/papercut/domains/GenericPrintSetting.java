package com.papercut.domains;

public class GenericPrintSetting {
    private PrintSize paperSize;
    private boolean isColorPrint;
    private boolean isDoubleSided;

    public GenericPrintSetting(PrintSize paperSize, boolean isColorPrint, boolean isDoubleSided) {
        this.paperSize = paperSize;
        this.isColorPrint = isColorPrint;
        this.isDoubleSided = isDoubleSided;
    }

    public PrintSize getPaperSize() {
        return paperSize;
    }

    public boolean isColorPrint() {
        return isColorPrint;
    }

    public boolean isDoubleSided() {
        return isDoubleSided;
    }

    /**
     * Using equals and hashcode to make sure only one price configuration existing in the hash map
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericPrintSetting printSetting = (GenericPrintSetting) o;

        if (isColorPrint != printSetting.isColorPrint) return false;
        if (isDoubleSided != printSetting.isDoubleSided) return false;
        return paperSize == printSetting.paperSize;
    }

    /**
     * Using equals and hashcode to make sure only one price configuration existing in the hash map
     * @return
     */
    @Override
    public int hashCode() {
        int result = paperSize.hashCode();
        result = 31 * result + (isColorPrint ? 1 : 0);
        result = 31 * result + (isDoubleSided ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenericPrintSetting{" +
                "paperSize=" + paperSize +
                ", isColorPrint=" + isColorPrint +
                ", isDoubleSided=" + isDoubleSided +
                '}';
    }
}
