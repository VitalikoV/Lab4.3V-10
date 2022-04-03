import java.util.ArrayList;
import java.util.Objects;

public class RouteController {

        public static ArrayList<Route> addRoute(ArrayList<Route> routes, Integer routeNumber,
                                                  String startPoint, String endPoint) {

            if(startPoint == null || startPoint.equals("")){
                System.out.println("Start Point is not correct");
                return routes;
            }

            if(endPoint == null || endPoint.equals("")){
                System.out.println("End Point is not correct");
                return routes;
            }

            boolean routeAlreadyExists = false;

            for(Route route : routes){
                if (Objects.equals(route.getRouteNumber(), routeNumber)) {
                    routeAlreadyExists = true;
                    break;
                }
            }

            if(routeNumber <= 0 || routeAlreadyExists){
                System.out.println("Route number is not correct or already exists");
                return routes;
            }

            routes.add(new Route(routeNumber, startPoint, endPoint));
            return routes;
        }

        public static Route getRoute(ArrayList<Route> routes, Integer routeNumber){
            for(Route route : routes){
                if(route.getRouteNumber().equals(routeNumber)){
                    return route;
                }
            }
            return null;
        }

        public static ArrayList<Route> editRouteInfo(ArrayList<Route> routes, Integer routeNumberToEdit,
                                                       String startPoint, String endPoint){
            for(Route route : routes){
                if(Objects.equals(route.getRouteNumber(), routeNumberToEdit)){
                    route.setStartPoint(startPoint);
                    route.setEndPoint(endPoint);
                }
            }

            return routes;
        }

        public static void printRoutes(ArrayList<Route> routes){

            for(Route route : routes){
                System.out.println("");
                System.out.println("ROUTE NUMBER: " + route.getRouteNumber());
                System.out.println("Start Point: " +  route.getStartPoint());
                System.out.println("End Point: " +  route.getEndPoint());

            }
            System.out.println("");

        }
}
