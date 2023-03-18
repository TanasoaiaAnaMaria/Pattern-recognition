package ro.usv.rf.utils;

public class DataUtils {

        public static void printMatrix(double[][] x){
            for(double[] lin: x){

                for(double xcrt: lin)
                    System.out.print(String.format("%.2f", xcrt)+"\t");
                System.out.println();
            }
        }

    public static void printMatrix(String[][] x){
        for(String[] lin: x){

            for(String xcrt: lin)
                System.out.print(xcrt+"\t");
            System.out.println();
        }
    }

        public static double[][] normalizeLearningSet(
                double[][] patternSet)
        {
            double[][] normalizedPatternSet = new double[patternSet.length][];
// TODO .. enter your code here
            return normalizedPatternSet;
        }

}
