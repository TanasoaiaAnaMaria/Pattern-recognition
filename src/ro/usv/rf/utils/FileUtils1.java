package ro.usv.rf.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileUtils1 {
    private static final String inputFileValuesSeparator = "[ \t]";
    private static final String outputFileValuesSeparator = ",";

    public static String readTextFile (String fileName) {
        StringBuffer content = new StringBuffer();

        try (Stream<String> fileStream =
                     Files.lines(Paths.get(fileName))) {

            fileStream.forEach(line ->
                    content.append(line).append("\n") );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static String[][] readStringMatrixFromFileStream (String fileName) {
        try (Stream<String> fstream = Files.lines(Paths.get(fileName)) )
        {
            return
                    fstream
                            .map(line -> line.split("\\s+"))
                            .toArray(String[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double[][] readMatrixFromFileStream(String fileName)
    {
        double[][] matrix=null;
        StringBuffer content = new StringBuffer();
        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {

            matrix = fileStream.map(line -> Arrays.stream(line.split(inputFileValuesSeparator))
                                                    .mapToDouble(Double::parseDouble)
                                                    .toArray()
                    ).toArray(double[][]::new);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static void writePatternSetToFile ( String fileName,
                                               double[][] patternMatrix,
                                               String fieldSeparator )
    {

        StringBuilder stringBuilder = new StringBuilder();

        for (double[] row : patternMatrix) {
            for (int i = 0; i < row.length; i++) {
                stringBuilder.append(row[i]);
                if (i < row.length - 1) {
                    stringBuilder.append(fieldSeparator);
                }
            }
            stringBuilder.append("\n");
        }



        try {
            Files.write ( Paths.get(fileName),
                    stringBuilder.toString().getBytes());
        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
