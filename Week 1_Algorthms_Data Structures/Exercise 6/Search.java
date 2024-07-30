import java.util.*;

class Search {  
    // Method to perform search based on attribute
    public Book search(Library library, String attribute, String value, boolean isBinarySearch) {
        if (isBinarySearch) {
            // Perform binary search
            List<Book> books = library.getBooks();
            switch (attribute.toLowerCase()) {
                case "id":
                    return binarySearchById(books, Integer.parseInt(value));
                case "title":
                    return binarySearchByTitle(books, value);
                case "author":
                    return binarySearchByAuthor(books, value);
                default:
                    System.out.println("Invalid attribute.");
                    return null;
            }
        } else {
            // Perform linear search
            List<Book> books = library.getBooks();
            switch (attribute.toLowerCase()) {
                case "id":
                    return linearSearchById(books, Integer.parseInt(value));
                case "title":
                    return linearSearchByTitle(books, value);
                case "author":
                    return linearSearchByAuthor(books, value);
                default:
                    System.out.println("Invalid attribute.");
                    return null;
            }
        }
    }

    // Linear Search methods
    private Book linearSearchById(List<Book> books, int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private Book linearSearchByAuthor(List<Book> books, String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search methods
    private Book binarySearchById(List<Book> books, int bookId) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getBookId(), b2.getBookId());
            }
        });
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (books.get(mid).getBookId() == bookId) {
                return books.get(mid);
            } else if (books.get(mid).getBookId() < bookId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private Book binarySearchByTitle(List<Book> books, String title) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (books.get(mid).getTitle().equalsIgnoreCase(title)) {
                return books.get(mid);
            } else if (books.get(mid).getTitle().compareToIgnoreCase(title) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private Book binarySearchByAuthor(List<Book> books, String author) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
            }
        });
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (books.get(mid).getAuthor().equalsIgnoreCase(author)) {
                return books.get(mid);
            } else if (books.get(mid).getAuthor().compareToIgnoreCase(author) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}