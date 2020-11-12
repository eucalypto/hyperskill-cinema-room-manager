package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cinema {

    Scanner scanner = new Scanner(System.in);
    private int rows;
    private int seatsPerRow;
    private List<Integer> rowPrices;

    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        cinema.setUp();
        cinema.calculateRowPrices();

        System.out.println(cinema);

        cinema.getTicketPrice();


    }

    private static int calculateIncome(int rows, int seatsPerRow) {
        int totalSeats = rows * seatsPerRow;

        if (totalSeats <= 60) {
            return totalSeats * 10;
        }

        int frontRows = rows / 2;

        return frontRows * seatsPerRow * 10 + (rows - frontRows) * seatsPerRow * 8;
    }

    private void calculateRowPrices() {
        rowPrices = new ArrayList<>();

        int totalSeats = rows * seatsPerRow;

        if (totalSeats <= 60) {
            for (int i = 0; i < rows; i++) {
                rowPrices.add(10);
            }
        } else {
            int frontRows = rows / 2;
            for (int i = 0; i < frontRows; i++) {
                rowPrices.add(10);
            }
            for (int i = 0; i < rows - frontRows; i++) {
                rowPrices.add(8);
            }
        }
    }

    private void getTicketPrice() {
        System.out.println("Enter a row number:");
        int selectedRow = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int selectedSeat = scanner.nextInt();

        System.out.println("Ticket price: $" + getTicketPrice(selectedRow));
    }

    private int getTicketPrice(int selectedRow) {
        return rowPrices.get(selectedRow - 1);
    }

    private void setUp() {

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();


        // first 2 lines
        builder.append("Cinema:\n");
        builder.append(" ");
        for (int i = 1; i <= seatsPerRow; i++) {
            builder.append(" ").append(i);
        }
        builder.append("\n");

        // other lines
        for (int row = 1; row <= rows; row++) {
            builder.append(row);
            builder.append(" S".repeat(seatsPerRow));
            builder.append("\n");
        }

        return builder.toString();
    }
}