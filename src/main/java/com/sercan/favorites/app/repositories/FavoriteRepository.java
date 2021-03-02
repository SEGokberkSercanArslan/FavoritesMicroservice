package com.sercan.favorites.app.repositories;

import com.sercan.favorites.app.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    Favorite findFavoriteById(Long id);
    List<Favorite> findAllByApplicationName(String app_name);
    List<Favorite> findAllByOrderByTotalDurationDesc();
}
