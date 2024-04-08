package com.day01p01;

public class Main {
    public static Book createBooks(String title, double price) {
        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        return book;
    }
 
    public static void showBooks(Book book) {
        System.out.println("Book Title: " + book.getTitle() + " and Price: " + book.getPrice());
    }
 
    public static void main(String[] args) {
        Book book = createBooks("Java Programming", 350.00);
        showBooks(book);
    }
}