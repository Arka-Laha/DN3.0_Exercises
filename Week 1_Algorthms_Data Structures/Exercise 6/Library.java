import java.util.*;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Method to remove a book
    public void removeBook(String attribute, String value) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            switch (attribute.toLowerCase()) {
                case "id":
                    if (book.getBookId() == Integer.parseInt(value)) {
                        iterator.remove();
                    }
                    break;
                case "title":
                    if (book.getTitle().equalsIgnoreCase(value)) {
                        iterator.remove();
                    }
                    break;
                case "author":
                    if (book.getAuthor().equalsIgnoreCase(value)) {
                        iterator.remove();
                    }
                    break;
                default:
                    System.out.println("Invalid attribute.");
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        for (Book book : books) {
            book.displayBook();
        }
    }
}
