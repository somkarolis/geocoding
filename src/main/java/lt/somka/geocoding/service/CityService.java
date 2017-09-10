package lt.somka.geocoding.service;

import lt.somka.geocoding.service.repositories.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CityService {
    private CitiesRepository citiesRepository;

    @Autowired
    public CityService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

}
