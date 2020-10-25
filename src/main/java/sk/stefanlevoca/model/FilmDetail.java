package sk.stefanlevoca.model;

import javax.persistence.*;

@Entity
public class FilmDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storyLine;
    private String genre;

    @OneToOne
    private Film film;

    public FilmDetail() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "FilmDetail {" +
                "id= " + id +
                "storyline= " + storyLine +
                "genre= " + genre +
                "film= " + film +
                '}';
    }
}