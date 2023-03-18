package ro.usv.rf.labs;

import ro.usv.rf.entity.DistanceMatrix;

import java.lang.reflect.Array;
import java.util.Arrays;

import static ro.usv.rf.utils.DataUtils.printMatrix;
import static ro.usv.rf.utils.DistanceUtils.distCityBlock;
import static ro.usv.rf.utils.FileUtils.*;
import static ro.usv.rf.entity.DistanceMatrix.*;

public class Main {
    public static void main(String[] args) {
/////////////////////// LAB 1 //////////////////////////////
        //1
//        System.out.println("Hello world!");
//        System.out.println(Arrays.deepToString(readStringMatrixFromFileStream("in.txt")));


        //2
//        String[][] matSir = readStringMatrixFromFileStream("in.txt");
//        System.out.println(Arrays.deepToString(matSir));
//
//        printMatrix(matSir);


        //3
//        double[][] X = readLearningSetFromFile("in.txt");
//        printMatrix(X);
//
//        writeLearningSetToFile("out.txt", X);


/////////////////// LAB 3 //////////////////////////////
        ///a)
        double[][] X = readLearningSetFromFile("in.txt");
//        printMatrix(X);

        writeLearningSetToFile("out.txt", X);

        ///d)
        DistanceMatrix mDist = new DistanceMatrix(X);
        System.out.println(mDist);

        ///e)
        double[][] vecini = DistanceMatrix.neighbors(0);
        printMatrix(vecini);

        //tema ex 1
        System.out.println();
        DistanceMatrix mDistAlegere = new DistanceMatrix(X,"chebyshev");
        System.out.println(mDist);

        //tema ex 2
//        DistanceMatrix mDist = new DistanceMatrix(X);
//        System.out.println(mDist);
//
//        System.out.printf("Value is: %,.2f", DistanceMatrix.d(1,2));

    }
}