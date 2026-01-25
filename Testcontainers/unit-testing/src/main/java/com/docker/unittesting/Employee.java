package com.docker.unittesting;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

// Definimos la estructura de datos.
// @Redishash indica que esto se guardara en redis en el futuro
@RedisHash("Employee")
public record Employee(
        @Id Long id,
        String name,
        String position) {

    // Los records crean automaticamente getters, equals(), hashCode() y toString().
}