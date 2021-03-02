package com.sercan.favorites.app.models.dto;

import com.sercan.favorites.app.base.entity.BaseEntity;
import com.sercan.favorites.app.models.entity.Favorite;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteDTO created on 1.03.2021, licencing LGPL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "FavoriteDTO")
public class FavoriteDTO implements BaseEntity<Favorite> {

    @NotNull
    @ApiModelProperty(name = "applicationName")
    private String applicationName;

    @NotNull
    @ApiModelProperty(name = "recordDate")
    private LocalDate recordDate;

    @NotNull
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
