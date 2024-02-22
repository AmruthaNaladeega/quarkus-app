package repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import app.model.Film;
import app.model.Film$;

import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class FilmRepository {
    @Inject
    JPAStreamer jpaStreamer;
    @PersistenceContext
    private EntityManager em;

    public Optional<Film> getFilmName(Integer filmId) {
        return jpaStreamer.stream(Film.class)
                .filter(film -> film.getFilmId().equals(filmId))
                .findFirst();
    }


    public FilmDetails getFilmDetails(Integer filmId) {
        Film film = em.find(Film.class, filmId);

        if (film == null) {
            return null;
        }

        FilmDetails details = new FilmDetails();
        details.setFilmId(film.getFilmId());
        details.setTitle(film.getTitle());
        details.setActors(film.getActors().stream()
                .map(actor -> new ActorDetails(actor.getFirstName(), actor.getLastName()))
                .collect(Collectors.toList()));
        return details;
    }
}
