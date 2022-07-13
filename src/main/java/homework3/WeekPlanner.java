package homework3;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        fillWithTasks(schedule);
        weekPlanner(schedule);
    }

    /**
     * This method describes all the main work and logic of the planner
     */
    public static void weekPlanner(String[][] schedule) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("Please, input the day of the week: ");
            input = sc.nextLine();
            String[] words = input.split(" "); // split all input words in array

            // check if user prints 'exit'
            // or 'change/reschedule [day of the week]
            if (input.trim().equalsIgnoreCase("exit")) {
                break;
            } else if (words[0].equalsIgnoreCase("change") ||
                    words[0].equalsIgnoreCase("reschedule")) {
                reschedule(words, schedule);
            } else {
                calendarView(words, schedule);
            }
        }
    }

    /**
     * Shows the current tasks of the day, depending on the day entered by the user
     */
    public static void calendarView(String[] words, String[][] schedule) {
        // NOTE: this program not accept accidentally entered space BEFORE the day of the week
        // but accept accidentally entered space AFTER the day of the week.
        // with using trim() we can allow both of them, but we needed only AFTER(as I understood the task reqs)

        String text = "";
        for (int i = 0; i < words.length; i++) {
            // concat all input words
            // here it's preferred to use StringBuilder instead of String
            text += words[i];
        }

        switch (text.toLowerCase()) {
            case "sunday":
                System.out.println("Your tasks for Sunday: " + schedule[0][1] + ".");
                break;
            case "monday":
                System.out.println("Your tasks for Monday: " + schedule[1][1] + ".");
                break;
            case "tuesday":
                System.out.println("Your tasks for Tuesday: " + schedule[2][1] + ".");
                break;
            case "wednesday":
                System.out.println("Your tasks for Wednesday: " + schedule[3][1] + ".");
                break;
            case "thursday":
                System.out.println("Your tasks for Thursday: " + schedule[4][1] + ".");
                break;
            case "friday":
                System.out.println("Your tasks for Friday: " + schedule[5][1] + ".");
                break;
            case "saturday":
                System.out.println("Your tasks for Saturday: " + schedule[6][1] + ".");
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
                break;
        }
    }

    /**
     * Main logic for change/reschedule for a given day of the week tasks
     */
    public static void reschedule(String[] words, String[][] schedule) {
        Scanner sc = new Scanner(System.in);
        String text = "";
        boolean isEqual;

        for (int i = 1; i < words.length; i++) {
            // concat all input words except 'change/reschedule'
            // here it's preferred to use StringBuilder instead of String
            text += words[i];
        }
        // this loop is for check input with all weekdays
        for (int i = 0; i < schedule.length; i++) {
            isEqual = text.equalsIgnoreCase(schedule[i][0]);
            if (isEqual) {
                System.out.println("Please, input new tasks for " + schedule[i][0] + ": ");
                schedule[i][1] = sc.nextLine();
                return; // here it's prefer to use return instead of break
            }
        }
        // prints if user enters a non-valid weekday
        System.out.println("Sorry, I don't understand you, please try again.");
    }

    /**
     * Fill the array (it would be better if it was a database :) )
     */
    public static void fillWithTasks(String[][] schedule) {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do homework";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "practice with java";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "meeting with friends";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "go to courses; practice with java";
        schedule[5][0] = "Friday";
        schedule[5][1] = "watch a film";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do homework";
    }
}
