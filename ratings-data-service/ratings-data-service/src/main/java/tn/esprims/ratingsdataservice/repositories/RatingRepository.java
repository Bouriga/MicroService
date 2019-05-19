package tn.esprims.ratingsdataservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tn.esprims.ratingsdataservice.models.Rating;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByUserName(String userName);

    Rating findById(@Param("id") int Id);
}
