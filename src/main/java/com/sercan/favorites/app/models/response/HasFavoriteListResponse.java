package com.sercan.favorites.app.models.response;

import com.sercan.favorites.app.dto.HasFavoriteDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * IsFavoriteListResponse created on 1.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value ="IsFavoriteListResponse")
public class HasFavoriteListResponse {

    @ApiModelProperty(value = "hasFavoriteDTO")
    private HasFavoriteDTO hasFavoriteDTO;
}
