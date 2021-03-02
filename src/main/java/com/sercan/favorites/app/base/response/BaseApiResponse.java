package com.sercan.favorites.app.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Gökberk Sercan Arslan
 * BaseApiResponse created on 1.03.2021, licencing LGPL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BaseApiResponse")
public class BaseApiResponse {

    @ApiModelProperty(name = "timeStamp")
    private Long timeStamp;

    @ApiModelProperty(name = "message")
    private String message;
}
