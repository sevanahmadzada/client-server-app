package utility;

import java.util.Scanner;

public class InputUtil {
    public static String askString(String title){
        System.out.println(title);
        Scanner sc = new Scanner(System.in);
        String word =sc.nextLine();
        return word;
    }
}
