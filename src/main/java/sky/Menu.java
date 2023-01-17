package sky;

public class Menu {
    Bibliothek bibliothek = new Bibliothek();
    PrinterUtil printerUtil = new PrinterUtil();
    ScannerUtil scannerUtil = new ScannerUtil();
    public void printAllAuthorAttributes(){
        printerUtil.printAllAuthors(bibliothek.getAllAuthors());
        int integer = scannerUtil.scanInt();
        System.out.println(bibliothek.getAllAuthors()[integer]);
    }
}
