package is.ru.stringcalculator;

public class Calculator {

	private static String splitter = ",|\\n";

	public static int add(String text){
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

	private static int sum(String[] numbers){
		int sumTotal = 0;
		for(String number : numbers){
			sumTotal += toInt(number);
		}

		return sumTotal;
	}
}