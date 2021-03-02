package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.models.entity.Favorite;

import java.time.LocalDate;
import java.util.List;

public interface FavoriteQueryService {
    List<Favorite> findAllByApplicationName(String applicationName);
    void saveEntity(Favorite entity);
    List<Favorite> findAllByRecordDateOrderByTotalDurationDesc(LocalDate date);
    Favorite findFavoriteByApplicationName(String applicationName);
}
