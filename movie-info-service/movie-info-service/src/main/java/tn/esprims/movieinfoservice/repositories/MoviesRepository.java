package tn.esprims.movieinfoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprims.movieinfoservice.models.Movie;


public interface MoviesRepository extends JpaRepository<Movie, Integer> {
    Movie findByName(String movieName);

    Movie findById(@Param("id") int Id);
}
