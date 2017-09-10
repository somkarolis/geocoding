package lt.somka.geocoding.controller;

import lt.somka.geocoding.service.CityService;
import org.springframework.stereotype.Controller;


@Controller
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


}
