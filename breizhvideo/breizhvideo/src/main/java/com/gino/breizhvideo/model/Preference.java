package com.gino.breizhvideo.model;

import javax.persistence.*;
import java.util.Date;

    @Entity
public class Preference {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private long id;
        private int vote;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public int getVote() {
            return vote;
        }
        public void setVote(int vote) {
            this.vote = vote;
        }

    }



