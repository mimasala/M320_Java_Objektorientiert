package sky;

public class PrinterUtil {
    public void printAllAuthors(Author[] allAuthors) {
        for (Author author : allAuthors) {
            System.out.println(author.name);
        }
    }
}
