import java.util.Scanner;

public class RectanglePlotter {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        printIdentification();
        restart();
    }

    private static void printIdentification() {
        System.out.println("Assignment 4: rectangle plotter  Author:Nikita Lobanov");
        System.out.println("Course/Section - CPSC1150-6");
        System.out.println("St.# - 100392186");
    }

    private static void restart()// the method that allows the user to restart the program at the end if they
                                 // would like to
    {
        char yes = 'y';

        while (yes == 'y') {
            mainMethod();
            System.out.println("Do you want to try again? ");
            yes = keyboard.next().toLowerCase().charAt(0);
        }
        System.out.print("end of program ");
    }

    private static void mainMethod() // initializes all the variables making sure that everything is within the
                                     // boundaries
    {
        int x;
        int y;
        int width;
        int height;

        System.out.println("What x coordinate will the rectangle start from? (min 1 max 40) ");
        x = xTest();

        System.out.println("What y coordinate will the rectangle start from? (min 1 max 20) ");
        y = yTest();

        System.out.println("What width will the rectangle be? (min 1 max " + (40 - x) + ") ");
        width = widthTest(x);

        System.out.println("What height will the rectangle be? (min 1 max " + y + ") ");
        height = heightTest(y);

        test(x, y, width, height);
    }

    private static int heightTest(int y) // test to make sure the height inputted is valid
    {
        int height = keyboard.nextInt();
        while (height > y || height < 1) {
            System.out
                    .println("the inputted value is invalid, please enter a value that fits the boundaries (min 1 max "
                            + y + ")");
            height = keyboard.nextInt();
        }
        return height;
    }

    private static int widthTest(int x) // test to make sure the width inputted is valid
    {
        int width = keyboard.nextInt();
        while (width > (40 - x) || width < 1) {
            System.out
                    .println("the inputted value is invalid, please enter a value that fits the boundaries (min 1 max "
                            + (40 - x) + ") ");
            width = keyboard.nextInt();
        }
        return width;
    }

    private static int xTest() // test to make sure the x value inputted is valid
    {
        int x = keyboard.nextInt();
        while (x > 40 || x < 1) {
            System.out.println(
                    "The inputted value is invalid, please enter a value that fits the boundaries (min 1 max 40)");
            x = keyboard.nextInt();
        }
        return x;
    }

    private static int yTest()// test to make sure the y value inputted is valid
    {
        int y = keyboard.nextInt();
        while (y > 20 || y < 1) {
            System.out.println(
                    "the inputted value is invalid, please enter a value that fits the boundaries (min 1 max 20)");
            y = keyboard.nextInt();
        }
        return y;
    }

    private static void test(int x, int y, int width, int height)// puts together the methods that draw everything
    {
        int line = 20;
        symbol();
        newLine();

        lineLoop(line, height, x, width, y);

        horizontal();
        bottomRow();
    }

    private static void lineLoop(int line, int height, int x, int width, int y)
    // draws the middle portion of the graph aswell as the rectangle
    {
        while (line > 0) {
            if (line == 20 || line == 15 || line == 10 || line == 5) // lines where the graph has a + instead of a |
            {
                if (line == 5)
                    System.out.print(" " + line + " ");
                else
                    System.out.print(line + " ");
                plus();
                if (y == line) {
                    if (height > 0) {
                        rectangleSpace(x);
                        rectangleLine(width);
                        y--;
                        height--;
                    }
                }
                newLine();
            } else {
                vertical();
                if (y == line) {
                    if (height > 0) {
                        rectangleSpace(x);
                        rectangleLine(width);
                        y--;
                        height--;
                    }
                }
                newLine();
            }
            line--;

        }
    }

    private static void rectangleSpace(int x) {
        while (x > 1) {
            System.out.print(" ");
            x--;
        }
    }

    private static void rectangleLine(int width) {
        while (width > 0) {
            System.out.print("*");
            width--;
        }
    }

    private static void newLine() {
        System.out.println();
    }

    private static void symbol() {
        System.out.print("   ^");

    }

    private static void plus() {
        System.out.print("+");
    }

    private static void vertical() {
        System.out.print("   |");
    }

    private static void horizontal() {
        System.out.println(" 0 +====+====+====+====+====+====+====+====+>");
    }

    private static void bottomRow() {
        System.out.println("   0    5   10   15   20   25   30   35   40");
    }
}
