package com.gygproductions.blog.services;

import com.gygproductions.blog.models.Ad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class AdService {
    private List<Ad> ads;

    public AdService(){
        this.ads = new ArrayList<>();
        createAds();
    }

    public List<Ad> getAllAds(){
        return ads;
    }

    public Ad getAd (long id){
        return ads.get(((int) id) -1);
    }

    public void createAds() {
        ads.add(new Ad("Test Title 1", "This is a test post description 1."));
        ads.add(new Ad("Test Title 2", "This is a test post description 2."));
        ads.add(new Ad("Test Title 3", "This is a test post description 3."));
    }

    public void save(Ad ad){
        this.ads.add(ad);
    }
}
