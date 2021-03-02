package com.sercan.favorites.app.models.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteDurationLogDTO created on 2.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FavoriteDurationLogDTO")
public class FavoriteDurationLogDTO {

    @NotNull
    @ApiModelProperty(value = "totalDuration")
    private Integer totalDuration;

    @NotNull
    @ApiModelProperty(value = "applicationName")
    private String applicationName;

    @NotNull
    @ApiModelProperty(value = "recordDate")
    private LocalDate recordDate;
}
