package tn.esprims.moviecatalogservice.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprims.moviecatalogservice.models.User;
import tn.esprims.moviecatalogservice.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
@Api(value = "UserResourceAPI", produces = MediaType.APPLICATION_JSON_VALUE, description = "User Resource")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/all")
    public List<User> getMovies()
    {
        List<User> list = userRepository.findAll();
        return list;
    }

    @RequestMapping("/find/{userId}")
    public Optional<User> findUser(@PathVariable("userId") Integer userId)
    {
        return userRepository.findById(userId);
    }

    @ApiOperation("Add User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Added User"),
            @ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
            @ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
            @ApiResponse(code = 404, message = "The resource  not found")
    })
    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return userRepository.findAll();
    }

}
