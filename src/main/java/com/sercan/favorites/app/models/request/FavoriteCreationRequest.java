package com.sercan.favorites.app.models.request;

import com.sercan.favorites.app.dto.FavoriteDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteCreationRequest created on 1.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FavoriteCreationRequest")
public class FavoriteCreationRequest {

    @ApiModelProperty(name = "favoriteDTO")
    private FavoriteDTO favoriteDTO;

}
