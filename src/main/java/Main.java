import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Enter file name => ");
        String name = reader.readLine();
        name += ".csv";
        ArrayList<Route> routes = RouteParser.readCSVFile(name);

        if(routes.size() == 0){
            throw new Exception("No elements found");
        }

        System.out.print("Enter the number of the route => ");
        try {
            Integer routeNumber = Integer.parseInt(reader.readLine());
            Route searchedRoute = RouteController.getRoute(routes, routeNumber);
            if(searchedRoute == null){
                System.out.println("Route not found");
            }else{
                RouteController.printRoutes(new ArrayList<Route>(List.of(searchedRoute)));
            }
        }catch (Exception e){
            System.out.println("Incorrect route number: " + e.getMessage());
        }
//        ArrayList<Route> routes = new ArrayList<Route>();
//        routes.add(new Route(111, "Lviv", "Hamburg"));
//        routes.add(new Route(112, "Ternopil", "Lviv"));
//        routes.add(new Route(113, "Sumy", "Lviv"));

        System.out.println("All Routes: ");
        RouteController.printRoutes(routes);
        RouteController.editRouteInfo(routes, 113, "Rivne", "Lviv");

        System.out.println("Edited Routes: ");
        RouteController.printRoutes(routes);
        RouteController.addRoute(routes, 114, "Lutsk", "Lviv");
        
        System.out.println("Added routes: ");
        RouteController.printRoutes(routes);
        RouteParser.generateCSVFile(routes, "routes");

    }
}
