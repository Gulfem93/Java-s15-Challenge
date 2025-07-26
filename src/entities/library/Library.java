package entities.library;

import entities.book.Book;
import entities.person.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {

    private Map<String, Book> books = new HashMap<>();
    private List<Reader> readers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Map<String, Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        //Sadece okuma
        return Collections.unmodifiableList(this.readers);
    }

    //long bookID, String name, String author, double price, String status, int edition, LocalDate dateOfPurchase
    public Book newBook(Scanner scanner) {
        // Kitap ID
        System.out.print("Kitap ID: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // nextLong() sonrası yeni satırı tüket

        // Kitap adı
        System.out.print("Kitap Adı: ");
        String title = scanner.nextLine();

        // Yazar adı
        System.out.print("Yazar Adı: ");
        String authorName = scanner.nextLine();

        // Kitap ücreti
        System.out.print("Kitap Ücreti: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // nextDouble() sonrası yeni satırı tüket

        // Kitap durumu
        System.out.print("Kitap Durumu (AVAILABLE/BORROWED/RESERVED): ");
        String status = scanner.nextLine().toUpperCase();

        // Baskı sayısı
        System.out.print("Baskı Sayısı: ");
        int edition = scanner.nextInt();
        scanner.nextLine(); // nextInt() sonrası yeni satırı tüket

        // Satın alma tarihi
        System.out.print("Satın Alma Tarihi (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        LocalDate purchaseDate = LocalDate.parse(date);

        // Yeni kitap oluştur ve döndür
        return new Book(id, title, authorName, price, status, edition, purchaseDate);
    }

    public void lendBook() {

    }

    public void takeBackBook() {

    }

    public void showBack() {

    }

}
