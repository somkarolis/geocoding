package lt.somka.geocoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class GeocodingApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GeocodingApplication.class);
    }

    public static void  main(String[] args) throws FileNotFoundException, IOException{
        //API key AIzaSyD_ISeB9fz5kC9cHayPy7MYSe8nwkpiy5c

        SpringApplication.run(GeocodingApplication.class, args);

        GeocodeProcessor geocodeProcessor = new GeocodeProcessor();
        try {
            List<Double> coordinates = geocodeProcessor.getCoordinates("Vilnius+Lithuania");
            for (Double coordinate : coordinates) {
                System.out.println(coordinate);
            }
        } catch (Exception e) {
            //live with that
        }

    }
}
