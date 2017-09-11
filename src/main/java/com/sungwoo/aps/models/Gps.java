package com.sungwoo.aps.models;

/**
 * @author phloc
 */
public class Gps {
    private double lat;
    private double lon;

    public Gps() {
    }

    public Gps(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gps gps = (Gps) o;

        if (Double.compare(gps.lat, lat) != 0) return false;
        return Double.compare(gps.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Gps{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
