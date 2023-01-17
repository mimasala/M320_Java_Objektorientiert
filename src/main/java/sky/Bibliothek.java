package sky;

public class Bibliothek {
    public Author[] getAllAuthors() {
        Author[] authors = new Author[2];
        Author author1 = new Author();
        author1.name = "Author1";
        authors[0] = author1;
        Author author2 = new Author();
        author2.name = "Author2";
        authors[1] = author2;
        return authors;
    }
}
