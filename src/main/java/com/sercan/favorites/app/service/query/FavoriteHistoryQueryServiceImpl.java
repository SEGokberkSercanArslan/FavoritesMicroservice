package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.repositories.FavoriteHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteHistoryQueryServiceImpl created on 1.03.2021, licencing LGPL
 */
@Service
public class FavoriteHistoryQueryServiceImpl implements FavoriteHistoryQueryService{

    private final FavoriteHistoryRepository favoriteHistoryRepository;

    @Autowired
    public FavoriteHistoryQueryServiceImpl(FavoriteHistoryRepository favoriteHistoryRepository) {
        this.favoriteHistoryRepository = favoriteHistoryRepository;
    }
}
