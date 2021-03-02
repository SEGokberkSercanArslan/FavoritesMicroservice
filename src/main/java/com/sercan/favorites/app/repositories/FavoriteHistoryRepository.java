package com.sercan.favorites.app.repositories;

import com.sercan.favorites.app.models.entity.FavoriteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FavoriteHistoryRepository extends JpaRepository<FavoriteHistory,Long> {
    List<FavoriteHistory> findAllByRecordDateOrderByTotalDurationDesc(LocalDate recordDate);
}
