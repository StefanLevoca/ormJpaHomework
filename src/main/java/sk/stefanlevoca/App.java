package sk.stefanlevoca;

/**
 * Hello world!
 */

import sk.stefanlevoca.model.Director;
import sk.stefanlevoca.model.Film;
import sk.stefanlevoca.model.FilmDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sk.stefanlevoca.ormJpaHomework");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            createFilmPlusDetail(entityManager);
            createDirector(entityManager);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void deleteFilm(EntityManager entityManager) {
        Film film = entityManager.find(Film.class, 1L);
        Set<Director> directors = film.getDirectors();
        for (Director d : directors) {
            d.removeFilm(film);
        }
        entityManager.remove(film);
    }

    private static void deleteFilmDetail(EntityManager entityManager) {
        FilmDetail filmDetail = entityManager.find(FilmDetail.class, 1L);
        filmDetail.getFilm().removeFilmDetail();
        entityManager.remove(filmDetail);
    }

    private static void deleteDirector(EntityManager entityManager) {
        Director director = entityManager.find(Director.class, 1L);
        entityManager.remove(director);
    }

    private static void createFilmDetail(EntityManager entityManager) {
        Film film = entityManager.find(Film.class, 1L);
        FilmDetail filmDetail = new FilmDetail();
        filmDetail.setGenre("Comedy");
        filmDetail.setStoryLine("Unordinaly people gather to...");
        filmDetail.setFilm(film);
        film.setFilmDetail(filmDetail);
        entityManager.persist(film);
    }

    private static void createFilmPlusDetail(EntityManager entityManager) {
        Film film = new Film();
        film.setName("X-men");

        FilmDetail filmDetail = new FilmDetail();
        filmDetail.setGenre("Comedy");
        filmDetail.setStoryLine("Unordinaly people gather to...");
        filmDetail.setFilm(film);
        film.setFilmDetail(filmDetail);

        entityManager.persist(film);
        entityManager.persist(filmDetail);
    }

    private static void createDirector(EntityManager entityManager) {

        Director director = new Director();
        director.setName("Jaro reziser 2");
        entityManager.persist(director);
    }

    private static void loadFilmDirectorAndJoinThem(EntityManager entityManager) {

        Film film = entityManager.find(Film.class, 1L);
        Director director = entityManager.find(Director.class, 1L);
        director.addFilm(film);

        entityManager.persist(director);
    }

    private static void addDirector(EntityManager entityManager) {
        Film film = entityManager.find(Film.class, 1L);

        Director director = new Director();
        director.setName("Jaro reziser 4");
        director.addFilm(film);

        Director director2 = new Director();
        director2.setName("Jaro reziser 5");
        director2.addFilm(film);

        entityManager.persist(director);
        entityManager.persist(director2);
    }

    private static void newFilmPlusDirector(EntityManager entityManager) {
        Director director = new Director();
        director.setName("Spielberg");
        Film film = new Film();
        film.setName("PAn Prstenov");
        director.addFilm(film);
        entityManager.persist(film);
    }
}