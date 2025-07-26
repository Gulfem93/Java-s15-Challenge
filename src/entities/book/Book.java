package entities.book;

import entities.library.BookCategory;
import entities.person.Author;
import entities.person.Reader;
import java.time.LocalDate;

public class Book {

    private String bookID;
    private Author author;
    private String name;
    private String price;
    private boolean status = false;
    private String edition;
    private LocalDate dateOfPurchase;
    private BookCategory category;

    //id, title, author, edition, category
    public Book(String bookID, String name, Author author, String edition, BookCategory category) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.category = category;
    }

    // Secondary constructor with additional fields
    public Book(String bookID, String name, Author author, String price, String edition,
            BookCategory category, LocalDate dateOfPurchase) {
        this(bookID, name, author, edition, category);
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getBookID() {
        return bookID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }

    public String getEdition() {
        return edition;
    }

    public void getTitle() {

    }

    public void changeOwner(Reader newOwner) {
        this.currentHolder = reader;
        this.isIssued = (reader != null);
    }

    public void getOwner() {

    }

    public void display() {
        System.out.println(name + " by " + author);
    }

    public void updateStatus(String newName, String newEdition, BookCategory newCategory) {
        this.name = newName;
        this.edition = newEdition;
        this.category = newCategory;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

}
