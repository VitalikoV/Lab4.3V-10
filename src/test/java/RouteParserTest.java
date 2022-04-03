import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteParserTest {

    @Test
    @DisplayName("Generating csv file from the list of routes")
    void generateCSVTest() throws IOException {
        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(new Route(111, "Lviv", "Hamburg"));
        routes.add(new Route(112, "Ternopil", "Lviv"));
        routes.add(new Route(113, "Sumy", "Lviv"));

        RouteParser.generateCSVFile(routes, "routesTest");

        ArrayList<Route> retrievedRoutesFromFile = RouteParser.readCSVFile("routesTest.csv");
        assertEquals(3, retrievedRoutesFromFile.size());

    }
}
