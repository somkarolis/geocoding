package lt.somka.geocoding.service.repositories;

import lt.somka.geocoding.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<City, Integer> {
}
