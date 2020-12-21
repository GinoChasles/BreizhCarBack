package com.gino.breizhvideo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film {

  @ManyToMany
    private List<Actor> actors;
    @ManyToMany
    private List<Category> categories;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer length;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title= title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description= description;
    }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLength() { return length; }
    public void setLength(Integer length) {
        this.length = length;
    }

}
