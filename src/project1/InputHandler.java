package project1;
import java.util.*;

public class InputHandler
{
    public static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static String getUserInput(String prompt, String[] validAnswers, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String resp = scanner.nextLine();
            for (String validAnswer:validAnswers) {
                if (validAnswer.equalsIgnoreCase(resp)) return resp;
            }
            System.out.println(errorMessage);
        }
    }
    
//    public static <T extends Number> getUserInput(String prompt, T acceptableType, String errorMessage) {
//        System.out.print(prompt);
//        if ()
//    }
    
    public static int getUserIntInput(String prompt, int minVal, int maxVal, String 
        errorMessage) {
        while (true) {
            System.out.print(prompt);
            String resp = scanner.nextLine();
            try {
                int respNumVal = Integer.parseInt(resp);
                if (respNumVal >= minVal && respNumVal <= maxVal) return respNumVal;
                System.out.println(errorMessage);
            }catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
    
    public static boolean getUserBoolInput(String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String resp = scanner.nextLine();
            for (String validYesAnswer:new String[]{"Yes","Y"}) {
                if (validYesAnswer.equalsIgnoreCase(resp)) return true;
            }
            for (String validYesAnswer:new String[]{"No","N"}) {
                if (validYesAnswer.equalsIgnoreCase(resp)) return false;
            }
            System.out.println(errorMessage);
        }
    }
}
