package lt.somka.geocoding.domain;

import javax.persistence.*;

@Entity
@Table(name = "bounds")
public class CityBounds {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "CITY_ID")
    private Integer cityID;

    @Column(name = "NORTH_LAT")
    private double northLAT;

    @Column(name = "SOUTH_LAT")
    private double southLAT;

    @Column(name = "EAST_LNG")
    private double eastLNG;

    @Column(name = "WEST_LNG")
    private double westLNG;

    public CityBounds(Integer cityID, double northLAT, double southLAT, double eastLNG, double westLNG) {
        this.cityID = cityID;
        this.northLAT = northLAT;
        this.southLAT = southLAT;
        this.eastLNG = eastLNG;
        this.westLNG = westLNG;
    }

    public CityBounds() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getCityID() {
        return cityID;
    }

    public double getNorthLAT() {
        return northLAT;
    }

    public double getSouthLAT() {
        return southLAT;
    }

    public double getEastLNG() {
        return eastLNG;
    }

    public double getWestLNG() {
        return westLNG;
    }
}
