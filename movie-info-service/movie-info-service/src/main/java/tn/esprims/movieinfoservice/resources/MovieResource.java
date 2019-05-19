package tn.esprims.movieinfoservice.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprims.movieinfoservice.models.Movie;
import tn.esprims.movieinfoservice.models.MovieList;
import tn.esprims.movieinfoservice.repositories.MoviesRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/movies")
@Api(value="UserResources", consumes="application/json", produces="application/json",protocols="http", description="Operations Related to Movie")
public class MovieResource {
    @Autowired
    MoviesRepository moviesRepository;

    @RequestMapping("/api/{movieName}")
    public Movie getMovieInfo(@PathVariable("movieName") String movieName){
        return moviesRepository.findByName(movieName);
    }
    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getMovieById" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get Movie by ID"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @GetMapping("movieById/{id}")
    public Movie getMovieById(@PathVariable("id") int id){
        return moviesRepository.findById(id);
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getMovies" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get Movies"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @GetMapping("/api/all")
    public MovieList getMovies(){
        MovieList movieList = new MovieList();
        movieList.setMovieList(moviesRepository.findAll());
        return movieList;
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "addMovie" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add Movie"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @PostMapping("/add")
    public List<Movie> persist(@RequestBody final Movie movie){
        moviesRepository.save(movie);
        return moviesRepository.findAll();
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "deleteMovie" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Movie"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @DeleteMapping("/delete/{id}")
    public List<Movie> deleteMovie(@PathVariable("id") int id){
        Movie movie = moviesRepository.findById(id);
        moviesRepository.delete(movie);
        return moviesRepository.findAll();
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "updateMovie" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update Movie"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @PutMapping("/update/{id}")
    public List<Movie> updateMovie(@ModelAttribute Movie movie){

        moviesRepository.save(movie);
        return moviesRepository.findAll();
    }

}
