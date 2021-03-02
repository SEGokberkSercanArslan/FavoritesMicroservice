package com.sercan.favorites.app.models.dto;

import com.sercan.favorites.app.base.entity.BaseEntity;
import com.sercan.favorites.app.models.entity.FavoriteHistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
* @author : Gökberk Sercan Arslan
* FavoriteHistoryDTO created on 1.03.2021, licencing LGPL
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "FavoriteHistoryDTO")
public class FavoriteHistoryDTO implements BaseEntity<FavoriteHistory> {

    @NotNull
    @ApiModelProperty(name = "favoriteId")
    private Long favoriteId;

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
    public FavoriteHistory toEntity() {
        FavoriteHistory entity = new FavoriteHistory();
        entity.setFavoriteID(favoriteId);
        entity.setApplicationName(applicationName);
        entity.setRecordDate(recordDate);
        entity.setTotalDuration(totalDuration);
        return entity;
    }
}
