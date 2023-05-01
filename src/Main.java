import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in); //initialize the input memo
    private static ArrayList<String> lines = new ArrayList<>(); //initialize the arraylist of memos
    private static boolean savedSaver = false; //initialize that this variable has not been saved

    public static void main(String[] args) {
        String menuPrompt = " A - Add \n D - Delete \n P - Print \n Q - Quit \n";
        String cmd = "";

        while (true) {
            showList();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch (cmd) {
                case "A":
                    add();
                    savedSaver = true;
                    break;
                case "D":
                    delete();
                    savedSaver = true;
                    break;
                case "P":
                    showList();
                    break;
                case "Q":
                    if (!savedSaver || SafeInput.getYNConfirm(in, "Are you sure you would like to quit?")) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }
//shows the list in its current state
    public static void showList() {
        System.out.println("-----------------------------------------");
        if (lines.size() == 0) {
            System.out.println("\nThe list is empty right now\n");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + lines.get(i));
            }
        }
        System.out.println("-----------------------------------------");
    }
//adds a line to the list
    public static void add() {
        String lineItem = SafeInput.getNonZeroLengthString(in, "Enter the memo line");
        lines.add(lineItem);
    }
//deletes a line from the list
    private static void delete() {
        System.out.println("-----------------------------");
        if (lines.size() == 0) {
            System.out.println("\nThere is nothing to delete right now\n");
            System.out.println("--------------------------");
            return;
        }

        int target = SafeInput.getRangeint(in, "Enter the number of the line you would like to delete", 1, lines.size());

        lines.remove(target - 1);
    }
}