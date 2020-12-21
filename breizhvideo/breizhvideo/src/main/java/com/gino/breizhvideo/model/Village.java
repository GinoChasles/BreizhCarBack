package com.gino.breizhvideo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Village {



    @OneToMany
    private List<Show> shows;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, nullable = false)
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
