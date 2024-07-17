import java.util.ArrayList; // import ArrayList class
import java.util.Scanner; // import Scanner class

/**
 *
 * @author Daniel Sandy sandyds@mail.uc.edu
 */

public class ListMaker // class ListMaker
{
    static Scanner in = new Scanner(System.in); // store Scanner in in
    static ArrayList<String> list = new ArrayList<>(); // store ArrayList in list
    static String listItem = ""; // list item to manipulate
    static int listNum = 0; // index number of list item

    public static void main(String[] args) // main()
    {
        //Scanner in = new Scanner(System.in); // store Scanner in in
        final String Menu = "Choose action --> Add[A]  Delete[D]  Insert[I]  Print[P]  Quit[Q]"; // variable to store the Menu
        boolean done = false; // set done to false
        String cmd = ""; // variable to store user's menu choice

        System.out.println("\n*** Welcome to Daniel Sandy's List Creator! ***"); // Welcome message

        do // loop until user is done
        {
            System.out.println(""); // insert blank line for visual effects
            displayList(); // display the list
            cmd = SafeInput.getRegExString(in, Menu, "[AaDdIiPpQq]"); // prompt & input a menu choice from the user
            cmd = cmd.toUpperCase(); // ensure user choice is uppercase
            switch (cmd) // process depending on user's choice
            {
                case "A": // if user chooses A
                    add(); // run add method
                    break; // end case A
                case "D": // if user chooses D
                    delete(); // run delete method
                    break; // end case D
                case "I": // if user chooses I
                    insert(); // run insert method
                    break; // end case I
                case "P": // if user chooses P
                    print(); // run print method
                    break; // end case P
                case "Q": // if user chooses Q
                    print();
                    System.exit(0); // end program
                    break; // end case Q
            } // end switch for cases
            done = SafeInput.getYNConfirm(in, "Are you done?"); // prompt & input if user is done
        }while (!done); // loop while user is not done
        System.out.println("\nThe List is Finalized"); // output that the list is complete
        print(); // print list one last time
    } // return main()

    private static void displayList() // method to display the list
    {
        System.out.println("*************************************************"); // display top border
        if (list.size() != 0) // if list is not empty
        {
            for (int i = 0; i < list.size(); i++) // loop through list indices
            {
                String fixedNum = (i + 1) + "."; // stor index + 1 in variable fixedNum
                System.out.printf("%-5s%-35s\n", fixedNum, list.get(i)); // print index & list item
            } // end for loop
        }
        else // if list is empty
        {
            System.out.println("***            The List is Empty!             ***"); // output that the list is empty
        } // end if else
        System.out.println("*************************************************"); // print bottom border
    } // end displayList()

    private static void add() // method to add items to list
    {
        listItem = SafeInput.getNonZeroLenString(in, "Enter what you want to add at the end of the list"); // prompt to add something to the list of non-zero length
        list.add(listItem); // add item to the list
    } // end add()

    private static void delete() // method to delete items from list
    {
        if (list.size() != 0) // if list is not empty
        {
            listNum = SafeInput.getRangedInt(in, "Enter the number of the item you want to delete", 1, list.size()); // prompt & input the list number to delete
            list.remove(listNum - 1); // delete the list item
        }
        else // if list is empty
        {
            System.out.println("There is nothing to delete!"); // output that there are no items to delete
        } // end if else
    } // end delete()

    private static void insert() // method to insert items onto the list
    {
        listItem = SafeInput.getNonZeroLenString(in, "Enter an item to insert"); // prompt & input the item to insert
        listNum = SafeInput.getRangedInt(in, "Enter the number where you want to insert the item", 1, list.size() + 1); // prompt & input location to insert item
        list.add(listNum - 1, listItem); // add item where specified
    } // end insert()

    private static void print() // method to print the list
    {
        System.out.println(""); // insert blank line for visual effect
        System.out.println("*************************************************"); // output top border
        for (int i = 0; i < list.size(); i++) // loop through list item indices
        {
            String fixedNum = "#" + (i + 1) + "."; // add a # before each number & a period after them
            System.out.printf("%-5s%-5s%-35s\n", fixedNum, "-->", list.get(i)); // output list number & item with an arrow between them
        } // end for loop
        System.out.println("*************************************************"); // output bottom border
    } // end print()
} // end class