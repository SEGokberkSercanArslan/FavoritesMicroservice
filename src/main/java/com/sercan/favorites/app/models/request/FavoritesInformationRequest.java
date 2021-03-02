package com.sercan.favorites.app.models.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan
 * FavoritesInformationRequest created on 2.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(value = "FavoritesInformationRequest")
public class FavoritesInformationRequest {

    @ApiModelProperty(value = "recordDate")
    private LocalDate recordDate;
}

