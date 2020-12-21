package com.gino.breizhvideo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Village {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String Post_Code;

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

        public String getPost_Code() {
            return Post_Code;
        }
        public void setPost_Code(String Post_Code) {
            this.Post_Code= Post_Code;
        }

}
