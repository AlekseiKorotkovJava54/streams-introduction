package telran.streams;

import static telran.streams.StreamIntroductionMethods.*;

record MinMaxQuantity(int min, int max, int nRandomNumbers) {
}

public class SportLoto {

	public static void main(String[] args) {
		try {
			if (args.length<3) {
				throw new Exception("Enter the data: min, max, and the number of random numbers in integer format");
			}
			MinMaxQuantity minMaxQuantity = getMinMaxQuantity(args);
			displayShuffle(randomNnumsFromMinToMax(minMaxQuantity));
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static MinMaxQuantity getMinMaxQuantity(String[] args) throws Exception {
				int min = getMin(args);
				int max = getMax(args);
				int nRandomNumbers = getNRandomNumbers(args);
				return new MinMaxQuantity(min,max,nRandomNumbers);
	}
	
	private static int getMin(String[] args) throws Exception {
		try {
			int res = Integer.parseInt(args[0]);
			if (res < 1) {
				throw new Exception("The minimum value must be greater than 0");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("The data must be in the form of an integer");
		}
	}
	
	private static int getMax(String[] args) throws Exception {
		try {
			int res = Integer.parseInt(args[1]);
			if (res < 1) {
				throw new Exception("The max value must be greater than 0");
			}
			if (Integer.parseInt(args[1]) - Integer.parseInt(args[0])<=0) {
				throw new Exception("The maximum number cannot be less than or equal to the minimum number");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("The data must be in the form of an integer");
		}
	}

	private static int getNRandomNumbers(String[] args) throws Exception {
		try {
			int res = Integer.parseInt(args[2]);
			if (res < 1) {
				throw new Exception("The number of random numbers requested must be greater than 0");
			}
			if(res > Integer.parseInt(args[1]) - Integer.parseInt(args[0])+1) {
				throw new Exception("The number of random numbers requested exceeds the number of numbers in the range from min to max");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("The data must be in the form of an integer");
		} 
	}

	
}