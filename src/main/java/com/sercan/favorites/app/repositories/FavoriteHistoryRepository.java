package com.sercan.favorites.app.repositories;

import com.sercan.favorites.app.entity.FavoriteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteHistoryRepository extends JpaRepository<FavoriteHistory,Long> {
    FavoriteHistory findFavoriteHistoryById(Long id);
}
