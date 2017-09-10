package lt.somka.geocoding;

import java.net.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

import javax.xml.xpath.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class GeocodeProcessor {

    private static final String GEOCODE_REQUEST_PREFIX = "http://maps.google.com/maps/api/geocode/xml";
    private String geocodeRequest;
    private static final String XPATH_EXPRESSION = "//text()";

    public String _xpath = null;
    public Document _xml = null;

    public List<Double> getCoordinates(String geocodeRequest) throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String resultXml, urlString = null;

        ByteBuffer resultBytes = null;

        if (geocodeRequest != "") {
            this.geocodeRequest = geocodeRequest;
        }

        urlString = GEOCODE_REQUEST_PREFIX + "?address=" + URLEncoder.encode(geocodeRequest, "UTF-8") + "&sensor=false";

        URL url = new URL(urlString);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        Document geocoderResultDocument = null;
        try {
            // open the connection and get results as InputSource.
            conn.connect();
            InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());

            // read result and parse into XML Document
            geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);
        } finally {
            conn.disconnect();
        }

        NodeList nodes = process(geocoderResultDocument, XPATH_EXPRESSION);

        List<Double> coordinates = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            String nodeString = nodes.item(i).getTextContent();
            try {
                double value = Double.parseDouble(nodeString);
                coordinates.add(value);
            } catch (NumberFormatException ex) {
            }
        }
        return coordinates;
    }


    private void GeocodeProcessor() {
    }

    public static NodeList process(Document xml, String xPathString) throws IOException {

        NodeList result = null;

        XPathFactory factory = XPathFactory.newInstance();

        XPath xpath = factory.newXPath();

        try {
            result = (NodeList) xpath.evaluate(xPathString, xml, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            // Deal with it
        }
        return result;
    }
}