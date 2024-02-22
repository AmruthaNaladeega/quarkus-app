import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.model.Film;
import repository.FilmDetails;
import repository.FilmRepository;
import java.util.*;

@Path("/")
public class FilmResource {

    private final FilmRepository filmRepository;

    public FilmResource(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GET
    @Path("/helloWorld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello World";
    }

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilmName(Integer filmId){
        Optional<Film> film = filmRepository.getFilmName(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film was found!";
    }


    @GET
    @Path("/filmDetails/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDetails getFilm(@PathParam("filmId") Integer filmId) {
        try {
            return filmRepository.getFilmDetails(filmId);
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
            // Returning null is just a placeholder, you may handle errors differently
            return null;
        }
    }

}
