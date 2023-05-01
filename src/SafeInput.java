
import java.util.Scanner;

public class SafeInput
{
    public static int getRangeint(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int retValue = 0;
        String trash = "";

        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine();
                if (retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("You must enter a value in range: " + trash);

            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a value int not: " + trash);
            }
        } while (!done);

        return retValue;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String value = "";
        boolean retValue = false;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "(y or n): ");
            value = pipe.nextLine();

            if (value.equalsIgnoreCase("y")) {
                retValue = true;
                done = true;
            } else if (value.equalsIgnoreCase("n")) {
                retValue = false;
                done = true;
            } else {
                System.out.println("You must enter a Y or N.");
            }
        } while (!done);
        return retValue;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retValue = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " " + regEx + ": ");
            retValue = pipe.nextLine();

            if (retValue.matches(regEx)) {
                done = true;
            } else
                System.out.println("You must enter an output that matches the pattern: " + regEx);

        } while (!done);

        return retValue;

    }

    public static String getNonZeroLengthString(Scanner pipe, String prompt) {
        String retValue = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            retValue = pipe.nextLine();

            if (retValue.length() > 0)
                done = true;
            else
                System.out.println("You must some characters!");


        } while (!done);

        return retValue;
    }

}//end class