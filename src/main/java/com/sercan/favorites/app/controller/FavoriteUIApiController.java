package com.sercan.favorites.app.controller;

import com.sercan.favorites.app.base.response.BaseApiResponse;
import com.sercan.favorites.app.models.dto.FavoriteDurationLogDTO;
import com.sercan.favorites.app.models.dto.HasFavoriteDTO;
import com.sercan.favorites.app.models.request.FavoriteCreationRequest;
import com.sercan.favorites.app.models.request.FavoritesInformationRequest;
import com.sercan.favorites.app.models.response.FavoritesResponse;
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
    @ApiOperation(value = "createFavoriteApp", notes = "creates new favorite app entity", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseApiResponse createFavoriteApp(@RequestBody FavoriteCreationRequest request) {
        return favoriteCommandService.createFavoriteApp(request);
    }

    @PostMapping(value = "/getFavorites")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getFavorites", notes = "The api brigs first 4 favorite applications today", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FavoritesResponse getFavorites(@RequestBody FavoritesInformationRequest request){
        return favoriteCommandService.getFavorites(request.getRecordDate());
    }

    @GetMapping(value = "/hasFavoriteList/{APP_NAME}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "hasFavoriteList", notes = "Returns check result if the application exists in favorites list", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HasFavoriteListResponse hasFavoriteList(@PathVariable String APP_NAME) {
        HasFavoriteDTO hasFavoriteDTO = new HasFavoriteDTO(APP_NAME,favoriteCommandService.hasFavoriteList(APP_NAME));
        return new HasFavoriteListResponse(hasFavoriteDTO);
    }

    @PutMapping(value = "/durationLog")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "durationLog", notes = "Logs duration of total app usage", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseApiResponse durationLog(@RequestBody FavoriteDurationLogDTO logDTO){
        return favoriteCommandService.durationLog(logDTO);
    }

}
