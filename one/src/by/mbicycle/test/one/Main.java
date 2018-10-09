package by.mbicycle.test.one;

import java.util.Scanner;
/**
 *  Main
 * @author Stas Nesteruk
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        Double result;
        result = Calculate.calculating(expression);
        System.out.printf("%.2f",result);
    }
}
