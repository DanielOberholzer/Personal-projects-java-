import java.util.regex.*;
import java.util.Scanner;

public class FromValidator {

    public static void main(String[] args) {
        Pattern name = Pattern.compile("^[A-Za-z ]+$");
        Pattern email = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[\\w]{3}");
        Pattern phoneNum = Pattern.compile("^\\d{10}$");
        Pattern password = Pattern.compile("^(?=.*[A-Za-z ])(?=.*\\d)[\\w]{6,}$");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your full name (Letters and spaces only): ");
           String iName = scanner.nextLine();
            if (name.matcher(iName).matches()) {
                break;
            } else {
                System.out.println("Invalid name. Please use letters and spaces only.");
            }
        }
        while (true) {
            System.out.println("Enter your email (Must use a valid email): ");
            String iEmail = scanner.nextLine();
            if (email.matcher(iEmail).matches()) {
                break;
            } else {
                System.out.println("Invalid email. Please use a valid email address.");
            }
        }
        while (true) {
            System.out.println("Enter your phone number (10 digits. and only numbers): ");
            String iPhoneNum = scanner.nextLine();
            if (phoneNum.matcher(iPhoneNum).matches()) {
                break;
            } else {
                System.out.println("Invalid phone number. Please use 10 numbers.");
            }
        }
        while (true) {
            System.out.println("Enter your password (6 characters, with at least 1 number and 1 letter): ");
            String iPassword = scanner.nextLine();
            if (password.matcher(iPassword).matches()) {
                break;
            } else {
                System.out.println("Invalid password, try again");
            }
        }



    }
}