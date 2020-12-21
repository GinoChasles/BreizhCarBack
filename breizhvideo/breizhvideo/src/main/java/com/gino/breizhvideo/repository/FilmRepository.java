package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
}