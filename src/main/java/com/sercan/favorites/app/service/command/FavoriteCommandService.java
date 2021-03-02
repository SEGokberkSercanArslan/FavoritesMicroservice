package com.sercan.favorites.app.service.command;

import com.sercan.favorites.app.base.response.BaseApiResponse;
import com.sercan.favorites.app.dto.FavoriteDurationLogDTO;
import com.sercan.favorites.app.entity.Favorite;
import com.sercan.favorites.app.models.request.FavoriteCreationRequest;

import java.util.List;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteCommandService created on 1.03.2021, licencing LGPL
 */
public interface FavoriteCommandService {
    BaseApiResponse createFavoriteApp(FavoriteCreationRequest request);
    Boolean hasFavoriteList(String applicationName);
    List<Favorite> getFavorites();
    BaseApiResponse durationLog(FavoriteDurationLogDTO dto);

}
