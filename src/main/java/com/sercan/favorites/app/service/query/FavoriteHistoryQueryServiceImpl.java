package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.models.entity.FavoriteHistory;
import com.sercan.favorites.app.repositories.FavoriteHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteHistoryQueryServiceImpl created on 1.03.2021, licencing LGPL
 */
@Service
public class FavoriteHistoryQueryServiceImpl implements FavoriteHistoryQueryService{

    private final FavoriteHistoryRepository favoriteHistoryRepository;

    @Autowired
    public FavoriteHistoryQueryServiceImpl(FavoriteHistoryRepository favoriteHistoryRepository) {
        this.favoriteHistoryRepository = favoriteHistoryRepository;
    }

    @Override
    public FavoriteHistory saveEntity(FavoriteHistory entity) {
        return favoriteHistoryRepository.save(entity);
    }

    @Override
    public List<FavoriteHistory> findAllByRecordDateOrderByTotalDurationDesc(LocalDate date) {
        return favoriteHistoryRepository.findAllByRecordDateOrderByTotalDurationDesc(date);
    }
}
