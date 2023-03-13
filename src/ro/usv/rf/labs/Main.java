package ro.usv.rf.labs;

import java.lang.reflect.Array;
import java.util.Arrays;

import static ro.usv.rf.utils.DataUtils.printMatrix;
import static ro.usv.rf.utils.FileUtils1.*;

public class Main {
    public static void main(String[] args) {

        //1
//        System.out.println("Hello world!");
//        System.out.println(Arrays.deepToString(readStringMatrixFromFileStream("in.txt")));


        //2
//        String[][] matSir = readStringMatrixFromFileStream("in.txt");
//        System.out.println(Arrays.deepToString(matSir));
//
//        printMatrix(matSir);


        //3
        double[][] X = readMatrixFromFileStream("in.txt");
        printMatrix(X);

        writePatternSetToFile("out.txt", X, ", ");


    }
}