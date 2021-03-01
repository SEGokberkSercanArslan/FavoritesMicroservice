package com.sercan.favorites.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * IsFavoriteDTO created on 1.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "IsFavoriteDTO", description = "")
public class HasFavoriteDTO {

    @ApiModelProperty(name = "applicationName")
    private String applicationName;

    @ApiModelProperty(name = "hasList")
    private Boolean hasList;
}
