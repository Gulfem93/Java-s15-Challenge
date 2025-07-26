package com.library.main;
package book;
import com.library.model.*;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Book books = new Book();
    private static final Map<String, Author> authors = new HashMap<>();
    private static final Map<String, Reader> readers = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("📚 Kütüphane Otomasyon Sistemine Hoş Geldiniz!");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("Seçiminizi giriniz: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> searchBook();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> listBooksByCategory();
                case 6 -> listBooksByAuthor();
                case 7 -> borrowBook();
                case 8 -> returnBook();
                case 9 -> listAllBooks();
                case 0 -> {
                    running = false;
                    System.out.println("👋 Sistemden çıkılıyor...");
                }
                default -> System.out.println("❌ Geçersiz seçim, tekrar deneyiniz.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                \n========= MENU =========
                1. Yeni Kitap Ekle
                2. Kitap Ara (ID / Başlık / Yazar)
                3. Kitap Bilgisi Güncelle
                4. Kitap Sil
                5. Kategoriye Göre Kitapları Listele
                6. Yazara Göre Kitapları Listele
                7. Kitap Ödünç Al
                8. Kitap İade Et
                9. Tüm Kitapları Listele
                0. Çıkış
                =======================
                """);
    }

    private static void addBook() {
        String id = getInput("Kitap ID: ");
        String title = getInput("Kitap Adı: ");
        String edition = getInput("Baskı Bilgisi: ");
        String authorName = getInput("Yazar Adı: ");

        BookCategory category = selectCategory();

        Author author = authors.computeIfAbsent(authorName, Author::new);
        Book book = new Book(id, title, author, edition, category);
        books.put(id, book);

        System.out.println("✅ Kitap başarıyla eklendi.");
    }

    private static void searchBook() {
        String key = getInput("Aranacak Kitap ID, Başlık veya Yazar Adı: ");
        books.values().stream()
                .filter(book -> book.getId().equalsIgnoreCase(key)
                        || book.getTitle().equalsIgnoreCase(key)
                        || book.getAuthor().getName().equalsIgnoreCase(key))
                .forEach(Book::display);
    }

    private static void updateBook() {
        String id = getInput("Güncellenecek Kitap ID: ");
        Book book = books.get(id);
        if (book == null) {
            System.out.println("❌ Kitap bulunamadı.");
            return;
        }

        String newTitle = getInput("Yeni Başlık: ");
        String newEdition = getInput("Yeni Baskı: ");
        BookCategory newCategory = selectCategory();

        book.updateDetails(newTitle, newEdition, newCategory);
        System.out.println("🔁 Kitap bilgileri güncellendi.");
    }

    private static void deleteBook() {
        String id = getInput("Silinecek Kitap ID: ");
        if (books.remove(id) != null) {
            System.out.println("🗑️ Kitap silindi.");
        } else {
            System.out.println("❌ Kitap bulunamadı.");
        }
    }

    private static void listBooksByCategory() {
        BookCategory category = selectCategory();
        books.values().stream()
                .filter(book -> book.getCategory() == category)
                .forEach(Book::display);
    }

    private static void listBooksByAuthor() {
        String authorName = getInput("Yazar adı: ");
        Author author = authors.get(authorName);
        if (author == null) {
            System.out.println("❌ Yazar bulunamadı.");
            return;
        }
        author.getBooks().forEach(Book::display);
    }

    private static void borrowBook() {
        String readerName = getInput("Okuyucu adı: ");
        Reader reader = readers.computeIfAbsent(readerName, Reader::new);

        String bookId = getInput("Ödünç alınacak kitap ID: ");
        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("❌ Kitap bulunamadı.");
            return;
        }

        if (reader.borrowBook(book)) {
            System.out.println("📦 Kitap başarıyla ödünç alındı.");
            System.out.println("🧾 Fatura kesildi (örnek işlem).");
        }
    }

    private static void returnBook() {
        String readerName = getInput("Okuyucu adı: ");
        Reader reader = readers.get(readerName);
        if (reader == null) {
            System.out.println("❌ Okuyucu bulunamadı.");
            return;
        }

        String bookId = getInput("İade edilecek kitap ID: ");
        Book book = books.get(bookId);

        if (book == null || !reader.getBorrowedBooks().contains(book)) {
            System.out.println("❌ Bu kitap sizde görünmüyor.");
            return;
        }

        if (reader.returnBook(book)) {
            System.out.println("✅ Kitap başarıyla iade edildi.");
            System.out.println("💰 İade faturası oluşturuldu (örnek işlem).");
        }
    }

    private static void listAllBooks() {
        books.values().forEach(Book::display);
    }

    // 🔧 Yardımcı metodlar
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static BookCategory selectCategory() {
        System.out.println("Kategori seçiniz:");
        for (BookCategory category : BookCategory.values()) {
            System.out.println("- " + category);
        }
        String cat = getInput("Kategori: ").toUpperCase();
        try {
            return BookCategory.valueOf(cat);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Geçersiz kategori, STUDYBOOK varsayılan olarak seçildi.");
            return BookCategory.STUDYBOOK;
        }
    }
}
