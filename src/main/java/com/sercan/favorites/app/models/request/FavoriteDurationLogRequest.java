package com.sercan.favorites.app.models.request;

import com.sercan.favorites.app.models.dto.FavoriteDurationLogDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteDurationLogRequest created on 2.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FavoriteDurationLogRequest")
public class FavoriteDurationLogRequest {

    @ApiModelProperty(value = "favoriteDurationLogDTO")
    private FavoriteDurationLogDTO favoriteDurationLogDTO;
}
