/*
 * Carson Rohan
 * 
 * Advent of Code 2019
 * 
 * Dec 1, 2019
 * 
 * Fuel Counter-Upper is a class that will take in a text file full of masses and will calculate the
 * fuel required for Santa's sleigh.
 */

import java.io.*;

public class FuelCounterUpper {

	public static void main(String[]args) throws Exception {
		
		File file = new File("/Users/crohan/eclipse-workspace/AdventOfCode2019/src/"
				+ "FuelCounterUpper.txt"); 

		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st; 
		int totalFuel = 0;
		
		while ((st = br.readLine()) != null) {
			
			Integer num = Integer.valueOf(st);
			
			totalFuel += recursiveCalcFuel(num);
			
		}
			
		
		System.out.println(totalFuel);
		
		
		br.close();
		
	}
	
	/** 
	 * This method will recursively calculate all the additional fuel needed for each amount of
	 * fuel we add.
	 * 
	 * @param mass the mass of the fuel
	 * @return the total additional fuel
	 */
	public static int recursiveCalcFuel(int mass) {
		
		int totalFuel = 0;
		
		int fuel = calcFuel(mass);
		
		while(fuel > 0) {
			
			totalFuel += fuel;
			fuel = calcFuel(fuel);
			
		}
		return totalFuel;
	}
	
	/**
	 * This method calculates the fuel needed based on mass.
	 * 
	 * @param mass the mass of the modules
	 * @return the fuel required to carry a module
	 */
	public static int calcFuel(int mass) {
		
		return Math.floorDiv(mass, 3) - 2;
		
	}
	
}
