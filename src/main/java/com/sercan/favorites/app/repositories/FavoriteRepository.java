package com.sercan.favorites.app.repositories;

import com.sercan.favorites.app.models.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    Favorite findFavoriteByApplicationName(String applicationName);
    List<Favorite> findAllByApplicationName(String app_name);
    List<Favorite> findAllByRecordDateOrderByTotalDurationDesc(LocalDate date);
}
