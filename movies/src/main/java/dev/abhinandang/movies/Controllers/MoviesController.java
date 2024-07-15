package dev.abhinandang.movies.Controllers;

import dev.abhinandang.movies.Movies;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    @Autowired
    private dev.abhinandang.movies.MovieService movieService;
    @GetMapping
    private ResponseEntity<List<Movies>> getAllMovies(){
        //System.out.print("Output");
        return new ResponseEntity<List<Movies>>(movieService.allMovies(),HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    /* The following method is used to retrieve movies by using imdb id. For this mongo repository has no inbuilt class so that
    we are creating one in the service class.
     */
    private ResponseEntity<Optional<Movies>> getOneMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(movieService.findMovieByImdbId(imdbId),HttpStatus.OK);
    }

   /*@GetMapping("/{id}")
    private ResponseEntity<Optional<Movies>> getOneMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movies>>(movieService.findMovieByImdbId(id),HttpStatus.OK);
    }
    This is the method where we retrieve the data using the object id. For retrieving using object id the mongo repository
    has inbuilt method
    */
}
