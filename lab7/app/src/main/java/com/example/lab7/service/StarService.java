package com.example.lab7.service;

import com.example.lab7.beans.Star;
import com.example.lab7.dao.IDao;
import java.util.ArrayList;
import java.util.List;

/**
 * Couche service pour la gestion des stars (Pattern Singleton).
 */
public class StarService implements IDao<Star> {

    private List<Star> stars;
    private static StarService instance;

    private StarService() {
        stars = new ArrayList<>();
        seed();
    }

    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    private void seed() {
        stars.add(new Star(
            "Kate Bosworth",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Kate_Bosworth_2012.jpg/220px-Kate_Bosworth_2012.jpg",
            3.5f
        ));
        stars.add(new Star(
            "George Clooney",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/George_Clooney_2016.jpg/220px-George_Clooney_2016.jpg",
            3.0f
        ));
        stars.add(new Star(
            "Michelle Rodriguez",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Michelle_Rodriguez_2013.jpg/220px-Michelle_Rodriguez_2013.jpg",
            5.0f
        ));
        stars.add(new Star(
            "Scarlett Johansson",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Scarlett_Johansson_2010.jpg/220px-Scarlett_Johansson_2010.jpg",
            4.5f
        ));
        stars.add(new Star(
            "Leonardo DiCaprio",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Leonardo_Dicaprio_Cannes_2019.jpg/220px-Leonardo_Dicaprio_Cannes_2019.jpg",
            4.8f
        ));
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for (Star s : stars) {
            if (s.getId() == o.getId()) {
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setStar(o.getStar());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
        for (Star s : stars) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }
}