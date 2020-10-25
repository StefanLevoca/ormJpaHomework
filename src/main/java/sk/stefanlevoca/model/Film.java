package sk.stefanlevoca.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private FilmDetail filmDetail;

    @ManyToMany(mappedBy = "films", cascade = CascadeType.PERSIST)
    private Set<Director> directors = new HashSet<>();

    public Film() {
    }

    public void removeFilmDetail() {
        this.filmDetail = null;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Long getId() {
        return id;
    }

    public FilmDetail getFilmDetail() {
        return filmDetail;
    }

    public void setFilmDetail(FilmDetail filmDetail) {
        this.filmDetail = filmDetail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film {" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", filmDetail=" + filmDetail +
                ", diretors= " + directors.toString() +
                '}';
    }
}