package com.sercan.favorites.app.dto;

import com.sercan.favorites.app.base.entity.BaseEntity;
import com.sercan.favorites.app.entity.Favorite;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteDTO created on 1.03.2021, licencing LGPL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "FavoriteDTO")
public class FavoriteDTO implements BaseEntity<Favorite> {

    @ApiModelProperty(name = "applicationName")
    private String applicationName;

    @ApiModelProperty(name = "recordDate")
    private LocalDate recordDate;

    @ApiModelProperty(name = "totalDuration")
    private Integer totalDuration;

    @Override
    public Favorite toEntity() {
        Favorite entity = new Favorite();
        entity.setApplicationName(applicationName);
        entity.setRecordDate(recordDate);
        entity.setTotalDuration(totalDuration);
        return entity;
    }
}
