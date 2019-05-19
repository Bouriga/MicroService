package tn.esprims.moviecatalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprims.moviecatalogservice.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String userName);
    }
