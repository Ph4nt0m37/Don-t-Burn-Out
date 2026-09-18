package project1;
import java.util.Scanner;

public class InputHandler
{
    public static Scanner scanner;

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
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
}
