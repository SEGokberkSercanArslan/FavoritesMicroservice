package com.sercan.favorites.app.service.command;

import com.sercan.favorites.app.base.response.BaseApiResponse;
import com.sercan.favorites.app.models.dto.FavoriteDTO;
import com.sercan.favorites.app.models.dto.FavoriteDurationLogDTO;
import com.sercan.favorites.app.models.dto.FavoriteHistoryDTO;
import com.sercan.favorites.app.models.entity.Favorite;
import com.sercan.favorites.app.models.entity.FavoriteHistory;
import com.sercan.favorites.app.models.request.FavoriteCreationRequest;
import com.sercan.favorites.app.models.response.FavoritesResponse;
import com.sercan.favorites.app.service.query.FavoriteHistoryQueryService;
import com.sercan.favorites.app.service.query.FavoriteQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteCommandServiceImpl created on 1.03.2021, licencing LGPL
 */
@Service
public class FavoriteCommandServiceImpl implements FavoriteCommandService{

    private final FavoriteQueryService favoriteQueryService;
    private final FavoriteHistoryQueryService favoriteHistoryQueryService;

    @Autowired
    public FavoriteCommandServiceImpl(FavoriteQueryService favoriteQueryService, FavoriteHistoryQueryService favoriteHistoryQueryService) {
        this.favoriteQueryService = favoriteQueryService;
        this.favoriteHistoryQueryService = favoriteHistoryQueryService;
    }

    @Override
    public Boolean hasFavoriteList(String applicationName){
        return favoriteQueryService.findAllByApplicationName(applicationName).size() != 0;
    }

    @Override
    public FavoritesResponse getFavorites(LocalDate date){
        FavoritesResponse response = new FavoritesResponse();
        List<FavoriteDTO> favoriteDTOS = favoriteQueryService.findAllByRecordDateOrderByTotalDurationDesc(date).stream().map(Favorite::toDTO).collect(Collectors.toList());
        if (favoriteDTOS.size() != 0){
            response.setFavoriteDTOS(favoriteDTOS);
        } else {
            List<FavoriteHistoryDTO> favoriteHistoryDTOS = favoriteHistoryQueryService.findAllByRecordDateOrderByTotalDurationDesc(date).stream().map(FavoriteHistory::toDTO).collect(Collectors.toList());
            if (favoriteHistoryDTOS.size() != 0){
                response.setFavoriteHistoryDTOS(favoriteHistoryDTOS);
            }
        }
        return response;
    }

    @Override
    public BaseApiResponse durationLog(FavoriteDurationLogDTO dto) {
        Favorite entity = favoriteQueryService.findFavoriteByApplicationName(dto.getApplicationName());
        if (!dto.getRecordDate().isAfter(entity.getRecordDate()) && !dto.getRecordDate().isBefore(entity.getRecordDate())){
            entity.setTotalDuration(entity.getTotalDuration() + dto.getTotalDuration());
            favoriteQueryService.saveEntity(entity);
            return new BaseApiResponse(System.currentTimeMillis(), "Usage duration logged");
        } else {
            FavoriteHistory favoriteHistory = new FavoriteHistory();
            favoriteHistory.setFavoriteID(entity.getId());
            favoriteHistory.setTotalDuration(entity.getTotalDuration());
            favoriteHistory.setRecordDate(entity.getRecordDate());
            favoriteHistory.setApplicationName(entity.getApplicationName());
            favoriteHistoryQueryService.saveEntity(favoriteHistory);
            entity.setTotalDuration(dto.getTotalDuration());
            entity.setRecordDate(dto.getRecordDate());
            favoriteQueryService.saveEntity(entity);
            return new BaseApiResponse(System.currentTimeMillis(),"New record created due to date changes");
        }
    }

    @Override
    public BaseApiResponse createFavoriteApp(FavoriteCreationRequest request) {
        if (!hasFavoriteList(request.getFavoriteDTO().getApplicationName())){
            favoriteQueryService.saveEntity(request.getFavoriteDTO().toEntity());
            return new BaseApiResponse(System.currentTimeMillis(), "Operation Done");
        } else {
            return new BaseApiResponse(System.currentTimeMillis(),"Already Exists");
        }
    }
}
