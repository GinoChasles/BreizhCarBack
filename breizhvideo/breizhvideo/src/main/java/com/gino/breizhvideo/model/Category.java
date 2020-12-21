package com.gino.breizhvideo.model;

import javax.persistence.*;

    @Entity
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private long id;
        private String name;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

