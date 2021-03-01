package com.sercan.favorites.app.entity;

import com.sercan.favorites.app.base.dto.BaseDTO;
import com.sercan.favorites.app.dto.FavoriteDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan A.K.A GoldenArchitech
 * Favorite created on 1.03.2021, licencing LGPL
 */
@Table(name = "favorite", schema = "favorite")
@Entity
@Data
@ApiModel(value = "Favorite")
public class Favorite implements BaseDTO<FavoriteDTO> {

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "id" ,required = true)
    private Long id;

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
    public FavoriteDTO toDTO() {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setRecordDate(recordDate);
        dto.setApplicationName(applicationName);
        dto.setTotalDuration(totalDuration);
        return dto;
    }
}
