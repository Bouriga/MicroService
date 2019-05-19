package tn.esprims.ratingsdataservice.resource;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprims.ratingsdataservice.models.Rating;
import tn.esprims.ratingsdataservice.models.RatingList;
import tn.esprims.ratingsdataservice.repositories.RatingRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ratings")
@Api(value="UserResources", consumes="application/json", produces="application/json",protocols="http", description="Operations Related to Ratings")
public class RatingResource {

    @Autowired
    RatingRepository ratingRepository;

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getRatings" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get Rating"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @GetMapping("/all")
    public List<Rating> getAll(){
        return ratingRepository.findAll();
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "addRating" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add Rating"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @PostMapping("/add")
    public List<Rating> persist(@RequestBody final Rating rating){
        ratingRepository.save(rating);
        return ratingRepository.findAll();
    }


    //Les deux microservices
    @RequestMapping("/api/all")
    public RatingList getRatings( ){
        RatingList ratingList = new RatingList();
        ratingList.setRatingList(ratingRepository.findAll());
        return ratingList;
    }

    @RequestMapping("/api/{userName}")
    public RatingList getUserRatings(@PathVariable("userName") String userName){
        RatingList ratingList = new RatingList();
        ratingList.setRatingList(ratingRepository.findByUserName(userName));
        return ratingList;
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getRatingById" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get Rating by ID"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @GetMapping("ratingById/{id}")
    public Rating getRatingById(@PathVariable("id") int id){
        return ratingRepository.findById(id);
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "deleteRating" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Rating"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @DeleteMapping("/delete/{id}")
    public List<Rating> deleteRating(@PathVariable("id") int id){
        Rating rating = ratingRepository.findById(id);
        ratingRepository.delete(rating);
        return ratingRepository.findAll();
    }

    @ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "updateRating" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update Rating"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @PutMapping("/update/{id}")
    public List<Rating> updateRating(@ModelAttribute Rating rating){

        ratingRepository.save(rating);
        return ratingRepository.findAll();
    }
}
