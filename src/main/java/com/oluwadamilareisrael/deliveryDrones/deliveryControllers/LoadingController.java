package com.oluwadamilareisrael.deliveryDrones.deliveryControllers;

import com.oluwadamilareisrael.deliveryDrones.loading.Loading;
import com.oluwadamilareisrael.deliveryDrones.loading.LoadingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/V1/loading")
public class LoadingController {
    private LoadingService loadingService;

    public LoadingController(LoadingService loadingService){this.loadingService = loadingService;}

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void loadMedication(@RequestBody Loading loading){
        loadingService.loadMedication(loading);
    }
}
