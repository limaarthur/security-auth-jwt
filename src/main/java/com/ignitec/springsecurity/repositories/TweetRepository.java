package com.ignitec.springsecurity.repositories;

import com.ignitec.springsecurity.entities.Tweet;
import com.ignitec.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
