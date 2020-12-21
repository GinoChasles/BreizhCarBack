package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}