public class Route {
    private Integer routeNumber;
    private String startPoint;
    private String endPoint;

    public Route(Integer routeNumber, String startPoint, String endPoint) {
        this.routeNumber = routeNumber;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
