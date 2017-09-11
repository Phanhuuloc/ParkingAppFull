package com.sungwoo.aps.controllers.main;

import com.sungwoo.aps.models.Gps;

import java.util.Arrays;
import java.util.List;

public class DummyRoute {

    public static List<Gps> buildRouteA2() {
        Gps gps1 = new Gps(10.80236064, 106.64041266);
        Gps gps2 = new Gps(10.802108698819, 106.640415675);
        Gps gps3 = new Gps(10.802108698819, 106.640120801);
        Gps gps4 = new Gps(10.802108698819, 106.640118286);
        Gps gps5 = new Gps(10.80208795070461, 106.640120801);

        return Arrays.asList(gps1, gps2, gps3, gps4, gps5);
    }

    public static List<Gps> buildRouteD2() {
        Gps gps1 = new Gps(10.80201121, 106.64041969);
        Gps gps2 = new Gps(10.80201121, 106.64017193);
        Gps gps3 = new Gps(10.80166475, 106.64017293);
        Gps gps4 = new Gps(10.80166870, 106.64024770);
        Gps gps5 = new Gps(10.8017281518, 106.640247367);

        return Arrays.asList(gps1, gps2, gps3, gps4, gps5);
    }
}
