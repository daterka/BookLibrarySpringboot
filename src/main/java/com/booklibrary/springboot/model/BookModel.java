package com.booklibrary.springboot.model;

public class BookModel {
    private int id;
    private String title;
    private String author;
    private String releasedDate;
    private String genre;

    public BookModel(int id, String title, String author, String releasedDate, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releasedDate = releasedDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releasedDate='" + releasedDate + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
