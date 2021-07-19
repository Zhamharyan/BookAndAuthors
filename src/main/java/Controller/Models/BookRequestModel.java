package Controller.Models;

import Service.Models.Author;

public class BookRequestModel {
    private String title;
    private Genre genre;
    private Author author;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthorId() {
        return author;
    }

    public void setAuthor(Author authorId) {
        this.author = authorId;
    }
}
