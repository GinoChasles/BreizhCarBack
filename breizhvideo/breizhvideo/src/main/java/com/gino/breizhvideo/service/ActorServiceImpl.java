package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Actor;
import com.gino.breizhvideo.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
public class ActorServiceImpl implements ActorService{
        @Autowired
        private ActorRepository repository;

        @Override
        public Optional<Actor> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<Actor> findAll() {
           return repository.findAll();
        }

        @Override
        public Actor insert(Actor actor) {
            return repository.save(actor);
        }

        @Override
        public Actor update(Long id, Actor actor) {
            Optional<Actor> optionalActor = this.findById(id);

            if(optionalActor.isPresent()){
                Actor actorToUpdate = optionalActor.get();
                actorToUpdate.setFirstName(actor.getFirstName());
                if (actor.getLastName() != null){
                    actorToUpdate.setLastName(actor.getLastName());}
                return repository.save(actorToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Long id) {
            Optional<Actor> actor = this.findById(id);
            if (actor.isPresent()){
                repository.delete(actor.get());
            }

        }
    }

