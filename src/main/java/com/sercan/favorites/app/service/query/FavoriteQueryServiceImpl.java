package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.entity.Favorite;
import com.sercan.favorites.app.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteQueryServiceImpl created on 1.03.2021, licencing LGPL
 */
@Service
public class FavoriteQueryServiceImpl implements FavoriteQueryService{

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteQueryServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<Favorite> findAllByApplicationName(String applicationName) {
        return favoriteRepository.findAllByApplicationName(applicationName);
    }

    @Override
    public Favorite findFavoriteById(Long id) {
        return favoriteRepository.findFavoriteById(id);
    }

    @Override
    public void saveEntity(Favorite entity) {
        favoriteRepository.save(entity);
    }

    @Override
    public List<Favorite> findAllByOrderByTotalDurationDesc() {
        return favoriteRepository.findAllByOrderByTotalDurationDesc();
    }

    @Override
    public Favorite findFavoriteByApplicationName(String applicationName) {
        return favoriteRepository.findFavoriteByApplicationName(applicationName);
    }

}
