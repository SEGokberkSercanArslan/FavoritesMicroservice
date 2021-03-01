package com.sercan.favorites.app.entity;

import com.sercan.favorites.app.base.dto.BaseDTO;
import com.sercan.favorites.app.dto.FavoriteHistoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * FavoriteHistory created on 1.03.2021, licencing LGPL
 */
@Table(name = "favorites_history", schema = "favorite")
@Entity
@Data
@ApiModel(value = "FavoriteHistory")
public class FavoriteHistory implements BaseDTO<FavoriteHistoryDTO> {

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "id", required = true)
    private Long id;

    @NotNull
    @Column(name = "favorite_id")
    @ApiModelProperty(name = "favoriteID", required = true)
    private Long favoriteID;

    @NotNull
    @Column(name = "application_name")
    @ApiModelProperty(name = "applicationName", required = true)
    private String applicationName;

    @NotNull
    @Column(name = "record_date")
    @ApiModelProperty(name = "recordDate", required = true)
    private LocalDate recordDate;

    @NotNull
    @Column(name = "total_duration")
    @ApiModelProperty(name = "totalDuration", required = true)
    private Integer totalDuration;

    @Override
    public FavoriteHistoryDTO toDTO() {
        FavoriteHistoryDTO dto = new FavoriteHistoryDTO();
        dto.setFavoriteId(favoriteID);
        dto.setApplicationName(applicationName);
        dto.setRecordDate(recordDate);
        dto.setTotalDuration(totalDuration);
        return dto;
    }
}
