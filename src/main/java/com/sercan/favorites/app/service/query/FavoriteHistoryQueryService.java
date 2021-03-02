package com.sercan.favorites.app.service.query;

import com.sercan.favorites.app.entity.FavoriteHistory;

import java.time.LocalDate;
import java.util.List;

public interface FavoriteHistoryQueryService {
    FavoriteHistory saveEntity(FavoriteHistory entity);
    List<FavoriteHistory> findAllByRecordDateOrderByTotalDurationDesc(LocalDate date);
}
