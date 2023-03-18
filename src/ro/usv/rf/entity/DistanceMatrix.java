package ro.usv.rf.entity;

import java.util.Arrays;

import static ro.usv.rf.utils.DistanceUtils.*;

public class DistanceMatrix {

    private static double[][] matDist;
    private double[][] matDist1;

//    public DistanceMatrix(double[][] x) {
//        int n = x.length;
//        int p = x[0].length;
//        matDist = new double[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++)
//                {
//                    matDist[i][j] = matDist[j][i] = distEuclid(x[i], x[j]);
//                }
//
//        }
//    }

    public DistanceMatrix(double[][] x) {
        int n = x.length;
        matDist = new double[n][];
        for (int i = 0; i < n; i++) {
            matDist[i] = new double[i+1];
            for (int j = 0; j <= i; j++) {
                matDist[i][j] = distEuclid(x[i], x[j]);
            }
        }
    }

    public static double d(int i, int j) {
        if (i == j) {
            return 0;
        } else if (i < j) {
            return matDist[j][i];
        } else {
            return matDist[i][j];
        }
    }

    public DistanceMatrix(double[][] x, String metric) {
        int n = x.length;
        matDist = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matDist[i][j] = 0;
                } else {
                    switch (metric) {
                        case "euclidean":
                            matDist[i][j] = distEuclid(x[i], x[j]);
                            break;
                        case "manhattan":
                            matDist[i][j] = distManhattan(x[i], x[j]);
                            break;
                        case "chebyshev":
                            matDist[i][j] = distChebyshev(x[i], x[j]);
                            break;
                        case "city-block":
                            matDist[i][j] = distCityBlock(x[i], x[j]);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid metric specified: " + metric);
                    }
                }
            }
        }
    }

    public double[][] getMatDist() {
        return matDist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int n = matDist.length;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matDist[i].length; j++) {
                sb.append(String.format("%.2f", matDist[i][j])).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static double[][] neighbors(int i) {
        int n = matDist.length;

        double[] dist = new double[n];
        double[] frecventa = new double[n];
        for (int j = 0; j < n; j++) {
            dist[j] = matDist[i][j];
        }
        Arrays.sort(dist);

        double[][] result = new double[2][n];
        result[0][0] = i;
        result[1][0] = 0.0;
        for (int j = 1; j < n; j++) {
            int index = -1;
            for (int k = 0; k < n; k++) {
                if (matDist[i][k] == dist[j] && frecventa[k]==0) {
                    {
                        index = k;
                        frecventa[index]=1;
                    }
                    break;
                }
            }
            result[0][j] = index;
            result[1][j] = dist[j];
        }

        return result;
    }


}
