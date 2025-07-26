package entities.person;

import entities.book.Book;
import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {

    private String books;
    //Kitap limiti
    private static final int maxBookLimit = 5;
    private Set<Book> borrowedBooks;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new HashSet<>();
    }

    public String getBooks() {
        return books;
    }

    public void purchaseBook() {

    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= maxBookLimit) {
            System.out.println("Borrow limit reached (5 books).");
            return false;
        }
        if (book.getStatus()) {
            System.out.println("Book already issued.");
            return false;
        }
        borrowedBooks.add(book);
        book.changeOwner(this);
        return true;
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.changeOwner(null);
            return true;
        }
        return false;
    }

    public void showBook() {

    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a reader: " + getName());
    }

}
