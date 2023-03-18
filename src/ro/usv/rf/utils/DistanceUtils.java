package ro.usv.rf.utils;

import ro.usv.rf.exceptions.DimensiuniDiferite;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class DistanceUtils {
    public static double distEuclid(double[] x, double[] y){
        int p = x.length;
        if(p != y.length) throw new DimensiuniDiferite(p, y.length);
        double dist = 0.;
        for(int j=0; j<p; j++){
            dist += (x[j] - y[j]) * (x[j] - y[j]);
        }
        return sqrt( dist );
    }
    
    public static double distManhattan(double[] x, double[] y){
        int p = x.length;
        if(p != y.length) throw new DimensiuniDiferite(p, y.length);
        double dist = 0.;
        for(int j=0; j<p; j++){
            dist += abs(x[j] - y[j]) ;
        }
        return dist;
    }

    public static double distCityBlock(double[] x, double[] y) {
        int p = x.length;
        if (p != y.length) throw new DimensiuniDiferite(p, y.length);
        double dist = 0.;
        for (int j = 0; j < p; j++) {
            dist += abs(x[j] - y[j]);
        }
        return dist;
    }

    public static double distChebyshev(double[] x, double[] y) {
        int p = x.length;
        if (p != y.length) throw new DimensiuniDiferite(p, y.length);
        double dist = 0.;
        for (int j = 0; j < p; j++) {
            double diff = abs(x[j] - y[j]);
            if (diff > dist) {
                dist = diff;
            }
        }
        return dist;
    }


}
