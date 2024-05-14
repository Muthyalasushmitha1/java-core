package com.day03p03;



import java.time.LocalDate;
import java.util.*;

// Book class representing details of a book
class Book implements Comparable<Book> {
    private int bookId;
    private String title;
    private double price;
    private String author;
    private LocalDate publicationDate;

    // Constructor
    public Book(int bookId, String title, double price, String author, String publicationDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publicationDate = LocalDate.parse(publicationDate, java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));
    }

    // Getter methods
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    // Implementing toString method
    @Override
    public String toString() {
        return bookId + " " + title + " " + price + " " + author + " " + publicationDate;
    }

    // Implementing equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return this.bookId == other.bookId;
    }

    // Implementing hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    // Implementing compareTo method for natural ordering based on bookId
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.bookId, other.bookId);
    }
}


