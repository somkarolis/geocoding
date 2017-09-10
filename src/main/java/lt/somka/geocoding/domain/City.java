package lt.somka.geocoding.domain;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "LOCATION_LAT")
    private double lat;

    @Column(name = "LOCATION_LNG")
    private double lng;

    public City(String city, String country, double lat, double lng) {
        this.city = city;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
    }

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
