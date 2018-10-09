package by.mbicycle.test.one;

import java.util.*;

/**
 *  Main
 * @author Stas Nesteruk
 */
public class Calculate {

    private Calculate() {}
    //Main method
    public static double calculating(String string){
        String[] numbers = string.split("[/*+-]");
        String[] operators = string.split("\\d+\\.?(\\d+)?");
        String output = getExpression(string, numbers, operators);
        return getResult(output);
    }

    //Return expressin(Reverse Polish notation) from calculating
    private static String getExpression(String string,String[] numbers, String[] operators){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i].trim();
        }
        List<String> listOperators = new ArrayList<>();
        for(int i = 0; i < operators.length; i++){
            operators[i] = operators[i].trim();
        }
        for(String str : operators){
            if(!str.equals("")){
                listOperators.add(str);
            }
        }
        Deque<String> operatorsStack = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            stringBuilder.append(numbers[i]);
            stringBuilder.append(" ");
            if(i < listOperators.size()){
                if(!operatorsStack.isEmpty() && (getPriority(listOperators.get(i)) <= getPriority(operatorsStack.peek()))){
                    stringBuilder.append(operatorsStack.pop());
                    stringBuilder.append(" ");
                }
                operatorsStack.push(listOperators.get(i));
            }
        }
        while (!operatorsStack.isEmpty()){
            stringBuilder.append(operatorsStack.pop());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    //Returns the operation priority
    private static byte getPriority(String s){
        switch (s){
            case "+": return 1;
            case "-": return 2;
            case "*": return 3;
            case "/": return 4;
            default: return 0;
        }
    }

    //Calculating and returns result
    private static double getResult(String string){
        double result = 0;
        Deque<Double> dequeResult = new ArrayDeque<>();
        String[] values = string.split(" ");
        for (int i = 0; i < values.length; i++){
            if(values[i].matches("\\d+\\.?(\\d+)?")){
                dequeResult.push(Double.parseDouble(values[i]));
            }
            else{
                double first = dequeResult.pop();
                double second = dequeResult.pop();
                switch (values[i]){
                    case "+":
                        result = second + first;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "/":
                        result = second / first;
                        break;
                    default: return 0;
                }
                dequeResult.push(result);
            }
        }
        return dequeResult.peek();
    }
}
