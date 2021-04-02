package ru.job4j.html;

import java.time.LocalDateTime;

public class Post {
    private String autor;
    private String description;
    private LocalDateTime date;

    public Post(String autor, String description, LocalDateTime date) {
        this.autor = autor;
        this.description = description;
        this.date = date;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
