package lt.somka.geocoding.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    private Map<String, String> cities;
    BufferedReader br;

    public Map<String, String> readCSV() throws FileNotFoundException, IOException {
        cities = new HashMap<String, String>();
        br = new BufferedReader(new FileReader("C:/Users/somka/Documents/Java/geocoding/500_europe_cities_test.csv"));
        String line = br.readLine();

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(";");
            String city = fields[0];
            String country = fields[1];
            cities.put(city, country);
        }
        br.close();
        return cities;
    }

    public void print(Map cities) {
        cities.forEach((city, country) -> System.out.println(city + ", " + country));
    }
}
