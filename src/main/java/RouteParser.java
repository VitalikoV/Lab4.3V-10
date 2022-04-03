import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RouteParser {

    public static ArrayList<Route> readCSVFile(String fileName){
        ArrayList<Route> routes = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Route route = createRoute(attributes);
                routes.add(route);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("The file was not found.");
            ioe.printStackTrace();
        }

        return routes;
    }

    public static Route createRoute(String[] metadata){
        Integer routeNumber = Integer.parseInt(metadata[0]);
        String startPoint = metadata[1];
        String endPoint = metadata[2];
        return new Route(routeNumber, startPoint, endPoint);

    }

    public static void generateCSVFile(ArrayList<Route> routes, String fileName) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".csv"), "UTF-8"));

        for(Route route : routes){
            StringBuffer data = new StringBuffer();
            data.append(route.getRouteNumber()).append(",").append(route.getStartPoint()).append(",").append(route.getEndPoint());
            bw.write(data.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
