/*
Kieran Heiberg
12/20/19
Frac Calc Final
*/
 
import java.util.Scanner;
public class FracCalcFinal {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Welcome to Frac Calc");
      System.out.print("Enter your calculation: ");
      String calculation = scan.nextLine(); //for first calculation
      while (!calculation.toLowerCase().equals("quit")) { //if quit is entered then program will end  
         if (calculation.toLowerCase().equals("test")) { 
            System.out.println(runTests(calculation)); //runs tests
         }
         else {
            System.out.println(produceAnswer(calculation)); //calculates
         }
         System.out.print("\nEnter your calculation: ");
         calculation = scan.nextLine(); //for following calculations
      }
      System.out.println("Goodbye, Thanks for using Frac Calc");            
   }
 
   public static String produceAnswer(String calculation) { //parses input 
      String[] splitInput = calculation.split(" "); //splits string at space key
      String firstOperand = splitInput[0]; //splits string at first instance of space
      String operator = splitInput[1];
      String secondOperand = splitInput[2]; //splits at third instance of string
      String[] firstFractionParsed = parseFraction(firstOperand); //parses first fraction 
      String[] secondFractionParsed = parseFraction(secondOperand); //parses second fraction
      //following variables split array returned from parseFraction method
      int wholeNumber1 = Integer.parseInt(firstFractionParsed[0]); 
      int numerator1 = Integer.parseInt(firstFractionParsed[1]);
      int denominator1 = Integer.parseInt(firstFractionParsed[2]);
      int wholeNumber2 = Integer.parseInt(secondFractionParsed[0]);
      int numerator2 = Integer.parseInt(secondFractionParsed[1]);
      int denominator2 = Integer.parseInt(secondFractionParsed[2]);
      //initializes variables
      int wholeNumberFinal = 0;
      int numeratorFinal = 0;
      int denominatorFinal = 0;
      int newNumerator1 = 0;
      int newNumerator2 = 0;
      String output = "";
      numerator1 = toImproperFraction(wholeNumber1, numerator1, denominator1);
      numerator2 = toImproperFraction(wholeNumber2, numerator2, denominator2);
      //changes numerator depending on sign of the whole number       
      denominatorFinal = commonDenominator(denominator1, denominator2, operator); 
      newNumerator1 = (denominatorFinal/denominator1) * numerator1;
      newNumerator2 = (denominatorFinal/denominator2) * numerator2;
      if (operator.equals("+") || operator.equals("-")) {
         numeratorFinal = addAndSubtract(newNumerator1, newNumerator2, operator);
      }
      if (operator.equals("*") || operator.equals("/")) {
         int[] result = multiplyOrDivide(numerator1, numerator2, denominator1, denominator2, operator);
         numeratorFinal = result[0];
         denominatorFinal = result[1];
      }
      if (numerator1 == 0 || numerator2 == 0) { //if equation is only whole number
         numerator1 = wholeNumber1; 
         numerator2 = wholeNumber2;
         denominator1 = 1;
         denominator2 = 1;
         wholeNumber1 = 0;
         wholeNumber2 = 0;
      }
      int[] fractionFinal = reduceFraction(numeratorFinal, denominatorFinal, wholeNumberFinal);
      numeratorFinal = fractionFinal[0];
      denominatorFinal = fractionFinal[1];
      wholeNumberFinal = fractionFinal[2];
      //multiplies numerator by same amount as denominator   
      // if it is valid operator 
      if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
         if (numeratorFinal == 0) {
            output = wholeNumberFinal + "";
         }
         else if (wholeNumberFinal == 0) {
            output = numeratorFinal + "/" + denominatorFinal;
         }
         else {
            output = wholeNumberFinal + "_" + numeratorFinal + "/" + denominatorFinal;
         }
      }
      //if non-valid operator
      else {
         output = "ERROR: Input is in an invalid format.";
      }
      return output; // returns final result
   }
   
   public static int[] reduceFraction(int numerator, int denominator, int wholeNumber) {
      if (numerator > denominator) {
         wholeNumber = numerator/denominator;
         numerator %= denominator;
      }
      if (numerator % 2 == 0 && denominator % 2 == 0) {
         while (numerator % 2 == 0) {
            numerator /= 2;
            denominator /= 2;
         }
      }
      int[] fraction = {numerator, denominator, wholeNumber};
      return fraction;
   }

   public static int[] multiplyOrDivide(int numerator1, int numerator2, int denominator1, int denominator2, String operator) {
      int numeratorFinal = 0;
      int denominatorFinal = 0;
      if (operator.equals("/")) { //multiplies diagonally across the problem
         numeratorFinal = numerator1 * denominator2;
         denominatorFinal = denominator1 * numerator2;
         if (denominatorFinal < 0) { //if denominator is negative makes its positive and numerator ngeative
            denominatorFinal *= -1;
            numeratorFinal *= -1;
         }
      }
      if (operator.equals("*")) { //multiplies numerators together and denominators together
         numeratorFinal = numerator1 * numerator2;
         denominatorFinal = denominator1 * denominator2;
      }
      int[] fraction = {numeratorFinal, denominatorFinal};
      return fraction;
   }
      
   public static int toImproperFraction(int wholeNumber, int numerator, int denominator) {
      if (wholeNumber < 0 ) { 
         numerator = (wholeNumber * denominator) - numerator;           
      }
      else {
         numerator = (wholeNumber * denominator) + numerator;
      }
      return numerator;
   }    
   
   public static int commonDenominator (int denominator1, int denominator2, String operator) {
      int denominatorFinal = 0;
      if (operator.equals("+") || operator.equals("-")) { // if operator is + or -
         //if denominators are the same then keeps current denominator
         if (denominator1 == denominator2) {
            denominatorFinal = denominator1;
         }
         //otherwise multiplies them together to find common factor
         else {
            denominatorFinal = denominator1 * denominator2;
         }
      }
      return denominatorFinal;
   }
   
   public static int addAndSubtract(int newNumerator1, int newNumerator2, String operator) {
      int numeratorFinal = 0;
      if (operator.equals("+")) { //adds numerators 
         numeratorFinal = newNumerator1 + newNumerator2;
      }
      if (operator.equals("-")) { //subtarcts numerators
         numeratorFinal = newNumerator1 - newNumerator2;
      }
      return numeratorFinal;
   }  
   
   public static String[] parseFraction (String fractionParse) {
      String wholeNumber = ""; //intializes variables
      String fraction = "";
      String numerator = "";
      String denominator = "";
      if (fractionParse.contains("_")) { //if the fraction is mixed
         String[] splitFraction = fractionParse.split("_");
         wholeNumber = splitFraction[0]; 
         fraction = splitFraction[1]; 
      }
      else { //if not then it just takes input value
         wholeNumber = fractionParse;
      }
      if (fractionParse.contains("/")) { //if input is fraction
         String[] splitFraction = fractionParse.split("/");
         numerator = splitFraction[0];
         denominator = splitFraction[1];
         if (numerator.contains("_")) { //if it is mixed then splits it agian
            String[] splitNumerator = numerator.split("_");
            numerator = splitNumerator[1];
         }
      }
      else { // if it is just a whole number
         numerator = "0";
         denominator = "1";
      }
      if (wholeNumber.contains("/")) { //if it is solely fraction
         wholeNumber = "0";
      }
      String[] values = {wholeNumber, numerator, denominator};
      return values;
   }
 
   public static String runTests (String calculation) { //runs tests
      String[] input = {"6 + 7", "-2_1/2 + 1/3", "1_1/3 + 2_3/4", "1/9 + 8/6", 
                        "5 - 8", "9/3 - 1/4", "-1_1/5 - 2/8", "1_1/2 - 1_1/2", 
                        "-3/4 * -4/5", "1_1/3 * 6_1/2", "1_1/2 * 1/9", "5 * 6",
                         "8 / 4", "2_3/4 / 1_2/5", "4/9 / 2/3", "1_1/5 / 1/6"}; //test problems
      String[] expected = {"13/1", "-13/6", "49/12", "78/54", 
                           "-3/1", "33/12", "-58/40", "0/2", 
                           "12/20", "52/6", "3/18", "30/1", 
                           "8/4", "55/28", "12/18", "36/5"}; //expected answer to test problems
      int passNumber = 0;
      for (int i = 0; i < input.length; i++) {
         if (testTests(input[i], expected[i])) { //runs as many times as there are tests
            passNumber++; //increases as each test is correct
         }
      }
      return "\nTests: " + passNumber + " of " + input.length + " test cases PASSED"; //returns string telling number of tests correct   
   }
 
   public static boolean testTests (String input, String expected) { //tests the tests
      String output = produceAnswer(input); //send each test to produce answer method to be parsed
      boolean pass = output.equals(expected); //assign boolean value of test to pass
      if (pass) { //if pass is true
         System.out.println("test passed");
      }
      else { //if pass is false
         System.out.println("test failed");
         System.out.println("   input: " + input); //returns diagnostics about problem
         System.out.println("   expected: " + expected);
         System.out.println("   output: " + output);
      }
      return pass;
   } 
 
}
