package com.gygproductions.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Ad> ads;

    public Categories(String name, long id, List<Ad> ads) {
        this.name = name;
        this.id = id;
        this.ads = ads;
    }

    public Categories(String name,List<Ad> ads) {
        this.name = name;
        this.ads = ads;
    }

    public Categories() {
    }

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

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
