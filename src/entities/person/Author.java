package entities.person;

import entities.book.Book;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    //Kitap ekleme
    public void newBook(Book book) {
        books.add(book);
    }

    public String showBook() {
        return "Author books = " + books;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author: " + getName());
    }


    
}
