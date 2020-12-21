package com.gino.breizhvideo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Show {

    @OneToMany
    private List<Preference> preferences;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
        private long id;
        private Date date;

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }

    }

