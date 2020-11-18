package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cinema {

    Scanner scanner = new Scanner(System.in);

    private int rows;
    private final List<Row> seatRows = new ArrayList<>(rows);
    private int seatsPerRow;

    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        cinema.setUp();

        cinema.printCinema();

    }

    private int getRowPrice(int rowNumber) {
        boolean isLargeRoom = (rows * seatsPerRow) > 60;

        if (isLargeRoom) {
            int largestFrontRowNumber = rows / 2;
            return (rowNumber <= largestFrontRowNumber) ? 10 : 8;
        } else {
            return 10;
        }
    }


    private void setUp() {

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            seatRows.add(newRow(seatsPerRow, i + 1));
        }

    }

    private Row newRow(int seatsPerRow, int rowNumber) {
        var row = new Row();
        var price = getRowPrice(rowNumber);
        row.price = price;
        for (int i = 1; i <= seatsPerRow; i++) {
            row.add(new Seat(rowNumber, i, price));
        }
        return row;
    }

    public void printCinema() {
        StringBuilder builder = new StringBuilder();

        // first 2 lines
        builder.append("Cinema:\n");
        builder.append(" ");
        for (int i = 1; i <= seatsPerRow; i++) {
            builder.append(" ").append(i);
        }
        builder.append("\n");

        // other lines
        seatRows.forEach(row -> {
            builder.append(row.rowNumber);
            row.forEach(seat -> builder.append(" ").append(seat.getOccupancyString()));
            builder.append("\n");
        });

        System.out.println(builder.toString());
    }
}

class Seat {
    int rowNumber;
    int seatNumber;
    int price;
    boolean isBooked = false;

    Seat(int rowNumber, int seatNumber, int price) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
    }


    public String getOccupancyString() {
        return isBooked ? "B" : "S";
    }
}

class Row extends ArrayList<Seat> {
    int rowNumber;
    int price;
}