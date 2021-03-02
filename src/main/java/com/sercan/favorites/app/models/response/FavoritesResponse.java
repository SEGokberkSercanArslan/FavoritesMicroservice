package com.sercan.favorites.app.models.response;

import com.sercan.favorites.app.dto.FavoriteDTO;
import com.sercan.favorites.app.dto.FavoriteHistoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoritesResponse created on 2.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FavoritesResponse")
public class FavoritesResponse {

    @ApiModelProperty(value = "favoriteDTOS")
    private List<FavoriteDTO> favoriteDTOS;

    @ApiModelProperty(value = "favoriteHistoryDTOS")
    private List<FavoriteHistoryDTO> favoriteHistoryDTOS;
}
