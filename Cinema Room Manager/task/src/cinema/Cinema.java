package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        System.out.println("Total income:\n$" + calculateIncome(rows, seatsPerRow));

    }

    private static int calculateIncome(int rows, int seatsPerRow) {
        int totalSeats = rows * seatsPerRow;

        if (totalSeats <= 60) {
            return totalSeats * 10;
        }

        int frontRows = rows / 2;

        return frontRows * seatsPerRow * 10 + (rows - frontRows) * seatsPerRow * 8;
    }
}