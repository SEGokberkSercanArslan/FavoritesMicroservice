package com.sercan.favorites.app.controller;

import com.sercan.favorites.app.base.response.BaseApiResponse;
import com.sercan.favorites.app.dto.HasFavoriteDTO;
import com.sercan.favorites.app.models.request.FavoriteCreationRequest;
import com.sercan.favorites.app.models.response.HasFavoriteListResponse;
import com.sercan.favorites.app.service.command.FavoriteCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Gökberk Sercan Arslan
 * FavoriteUIApiController created on 1.03.2021, licencing LGPL
 */

@RestController
@RequestMapping(name = "favorite/api/ui")
@Api(value = "favoriteUI-api")
public class FavoriteUIApiController {

    private final FavoriteCommandService favoriteCommandService;

    @Autowired
    public FavoriteUIApiController(FavoriteCommandService favoriteCommandService) {
        this.favoriteCommandService = favoriteCommandService;
    }

    @PostMapping(value = "/createFavoriteApp")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "creates new favorite app entity", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseApiResponse createFavoriteApp(@RequestBody FavoriteCreationRequest request) {
        return this.favoriteCommandService.createFavoriteApp(request);
    }

    @GetMapping(value = "/getFavorites")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "The api brigs first 4 favorite applications today", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void getFavorites() {

    }

    @GetMapping(value = "hasFavoriteList/{APP_NAME}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HasFavoriteListResponse hasFavoriteList(@PathVariable String APP_NAME) {
        HasFavoriteDTO hasFavoriteDTO = new HasFavoriteDTO(APP_NAME,this.favoriteCommandService.hasFavoriteList(APP_NAME));
        return new HasFavoriteListResponse(hasFavoriteDTO);
    }
}
