package com.ignitec.springsecurity.controllers;

import com.ignitec.springsecurity.dtos.CreateTweetDto;
import com.ignitec.springsecurity.entities.Tweet;
import com.ignitec.springsecurity.repositories.TweetRepository;
import com.ignitec.springsecurity.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TweetController {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public TweetController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/tweets")
    public ResponseEntity<Void> createTweet(@RequestBody CreateTweetDto createTweetDto, JwtAuthenticationToken jwtAuthenticationToken) {
        var user = userRepository.findById(UUID.fromString(jwtAuthenticationToken.getName()));
        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(createTweetDto.content());
        tweetRepository.save(tweet);
        return ResponseEntity.ok().build();

    }
}


