package ro.usv.rf.utils;

import ro.usv.rf.Pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticsUtils {
	
	protected static double calculateFeatureAverage(double[] feature)
	{
		double average = 0.0;
		for (int i=0; i<feature.length; i++)
		{
			average += feature[i];
		}
		average = average/feature.length;
		return average;
	}
	
	protected static Map<Pattern, Integer> getPatternsMapFromInitialSet(double[][] patternSet) {
		Map<Pattern, Integer> patternMap = new HashMap<Pattern, Integer>();
		// enter code here

		for (int i = 0; i < patternSet.length; i++) {
			Pattern pattern = new Pattern(patternSet[i]);

			if (patternMap.containsKey(pattern)) {
				patternMap.put(pattern, patternMap.get(pattern) + 1);
			} else {
				patternMap.put(pattern, 1);
			}
		}

		return patternMap;
	}

	public static double[] calculateWeightedAverages(Map<Pattern, Integer> patternsMap, int numberOfFeatures) {
		double[]  weightedAverages = new double[numberOfFeatures];

		for(Map.Entry<Pattern,Integer> entry: patternsMap.entrySet())
		{
			int weight =  entry.getValue();
			double [] pattern= entry.getKey().getPatternValues();
			for(int i =0;i<pattern.length;i++)
			{
				weightedAverages[i]+=pattern[i]*weight;
			}

		}

		int totalWeights= patternsMap.values().stream().mapToInt(x->x).sum();
		for(int i=0;i<numberOfFeatures;i++)
		{
			weightedAverages[i]=weightedAverages[i]/totalWeights;
		}

		return weightedAverages;
	}


	public static double[][] calculateFrequency(Map<Pattern, Integer> patternsMap, int numberOfFeatures,int numberOfPatterns) {
		double[][] frequncy = new double[numberOfFeatures][numberOfPatterns];


		for (Map.Entry<Pattern, Integer> entry : patternsMap.entrySet()) {
			int weight = entry.getValue();
			for (int i = 0; i < numberOfFeatures; i++){
				for (int j = 0; j < numberOfPatterns; j++)
				{ frequncy[i][j] =weight;
					//System.out.println(weight+" "+frequncy[i][j]+" ");
				}
			}}

		for (int i = 0; i < numberOfFeatures; i++){
			for (int j = 0; j < numberOfPatterns; j++)
				System.out.println(frequncy[i][j]+" ");


		}
		return frequncy;
	}


}
