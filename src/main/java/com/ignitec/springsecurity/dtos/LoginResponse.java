package com.ignitec.springsecurity.dtos;

public record LoginResponse(String accessToken, Long expiresIn) {
}
