package repository;

import java.util.List;

public class FilmDetails {
    private Integer filmId;
    private String title;
    private List<ActorDetails> actors;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ActorDetails> getActors() {
        return actors;
    }

    public void setActors(List<ActorDetails> actors) {
        this.actors = actors;
    }
}

