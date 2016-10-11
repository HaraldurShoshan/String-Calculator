package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

	private static String splitter = ",|\\n";
	

	public static int add(String text){
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		
		if(!text.equals("")){
			String[] myNumbers  = splitNumbers(text);
			addToArray(myNumbers, negativeNumbers);
		}
		

		if(negativeNumbers.size() > 0){
			String negNumbers = createNegativeString(negativeNumbers);

			throw new IllegalArgumentException("Negatives not allowed: " + negNumbers);
		}
	
		if(text.equals("")){
			return 0;
		}else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}else{
			return toInt(text);
		}

	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){

		return numbers.split(splitter);
	}

	private static void addToArray(String[] numbers, ArrayList<Integer> negativeNumbers){
		for(String number : numbers){
			int x = toInt(number);			
			if(x < 0){
				negativeNumbers.add(x);
			}
			
		}
	}

	private static String createNegativeString(ArrayList<Integer> negativeNumbers){
		String finalString = "";
		int count = 0;

		for(Integer num : negativeNumbers){
			String x = Integer.toString(num);

			if(count == 0){
				finalString = x;
				count++;
			}else{
				finalString = finalString + "," + x;
			}
		}

		return finalString;
	}

	private static int sum(String[] numbers){
		int sumTotal = 0;
		for(String number : numbers){
			sumTotal += toInt(number);
		}

		return sumTotal;
	}
}