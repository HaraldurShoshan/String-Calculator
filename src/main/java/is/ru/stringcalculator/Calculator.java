package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

    private static int MAX_VALUE = 1001;

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
        }else if(text.startsWith("//") || text.contains(",") || text.contains("\n")){
            return sum(splitNumbers(text));
        }else{
            return toInt(text);
        }
    }

    private static int toInt(String number){
        return Integer.parseInt(number);
    }

    private static String[] splitNumbers(String numbers){
        String splitter = ",|\\n";

        if(numbers.startsWith("//")){
            numbers = numbers.replace("\n", "]");

            String delim = "";
            Matcher m = Pattern.compile("\\//(.*?)\\]").matcher(numbers);
            while(m.find()) {
                delim = m.group(1);
            }

            String result = numbers.substring(numbers.lastIndexOf("]") + 1);
            splitter = splitter + "|" + delim;

            return result.split(splitter);
        }else{
            return numbers.split(splitter);
        }
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

        for(Integer num : negativeNumbers){
            String x = Integer.toString(num);

            if(finalString.equals("")){
                finalString = x;
            }else{
                finalString = finalString + "," + x;
            }
        }
        return finalString;
    }

    private static int sum(String[] numbers){
        int sumTotal = 0;
        for(String number : numbers){
            if(toInt(number) < MAX_VALUE){
                sumTotal += toInt(number);
            }
        }
        return sumTotal;
    }
}
