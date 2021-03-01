package com.sercan.favorites.app.service.command;

import com.sercan.favorites.app.base.response.BaseApiResponse;
import com.sercan.favorites.app.models.request.FavoriteCreationRequest;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteCommandService created on 1.03.2021, licencing LGPL
 */
public interface FavoriteCommandService {
    BaseApiResponse createFavoriteApp(FavoriteCreationRequest request);
    Boolean hasFavoriteList(String applicationName);

}
