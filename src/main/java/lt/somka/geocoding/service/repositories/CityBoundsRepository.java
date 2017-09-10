package lt.somka.geocoding.service.repositories;

import lt.somka.geocoding.domain.CityBounds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityBoundsRepository extends JpaRepository<CityBounds, Integer> {
}
