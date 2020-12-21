package com.gino.breizhvideo.model;

import javax.persistence.*;

    @Entity
public class Actor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private long id;
        private String firstName;
        private String lastName;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }


        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
