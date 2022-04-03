import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteControllerTest {

    @Test
    @DisplayName("Adding routes to the list")
    void addRoutePositive() {
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,1, "Start Test", "End Test");
        assertEquals(1, routes.size());
    }

    @Test
    @DisplayName("Adding routes to the list with the bad route number")
    void addRouteBadRouteNumber(){
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,-2, "Start Test", "End Test");
        assertEquals(0, routes.size());
    }

    @Test
    @DisplayName("Adding routes to the list with the bad start point")
    void addRouteBadStartPoint(){
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,1, "", "End Test");
        assertEquals(0, routes.size());
    }

    @Test
    @DisplayName("Adding routes to the list with the bad end point")
    void addRouteBadEndPoint(){
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,1, "Start Test", null);
        assertEquals(0, routes.size());
    }

    @Test
    @DisplayName("Editing routes in the list")
    void editRouteTest() {
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,1, "Start Test", "End Test");
        assertEquals(1, routes.size());
        RouteController.editRouteInfo(routes, 1, "Edited Start", "Edited End");
        Route searchedRoute = RouteController.getRoute(routes, 1);
        assertEquals("Edited Start", searchedRoute.getStartPoint());
        assertEquals("Edited End", searchedRoute.getEndPoint());
    }

    @Test
    @DisplayName("Printing routes in the list")
    void printRouteTest() {
        ArrayList<Route> routes = new ArrayList<>();
        RouteController.addRoute(routes,1, "Start Test", "End Test");
        assertEquals(1, routes.size());
        RouteController.printRoutes(routes);
    }


}
