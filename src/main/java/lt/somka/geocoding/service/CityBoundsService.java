package lt.somka.geocoding.service;

import lt.somka.geocoding.service.repositories.CityBoundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityBoundsService {
    private CityBoundsRepository cityBoundsRepository;

    @Autowired
    public CityBoundsService(CityBoundsRepository cityBoundsRepository) {
        this.cityBoundsRepository = cityBoundsRepository;
    }

}
