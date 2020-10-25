package sk.stefanlevoca.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "film_director",
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Film> films = new HashSet<>();

    public Director() {
    }

    public void addFilm(Film film) {
        films.add(film);
        film.getDirectors().add(this);
    }

    public void removeFilm(Film film) {
        films.remove(film);
        film.getDirectors().remove(this);
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Long getId() {
        return id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(id, director.id) &&
                Objects.equals(name, director.name) &&
                Objects.equals(films, director.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, films);
    }

    @Override
    public String toString() {
        return "Director {" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", films= " + films.toString() +
                '}';
    }
}

