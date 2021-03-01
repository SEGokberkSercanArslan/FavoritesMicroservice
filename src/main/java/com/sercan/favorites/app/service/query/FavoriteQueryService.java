package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.entity.Favorite;

import java.util.List;

public interface FavoriteQueryService {
    List<Favorite> findAllByApplicationName(String applicationName);
    Favorite findFavoriteById(Long id);
    void saveEntity(Favorite entity);
}
