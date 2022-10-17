package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in Date: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out Date: ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-Out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to Update the reservation: ");
            System.out.print("Check-in Date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date: ");
            checkOut = sdf.parse(sc.next());


            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Reservation: " + error);


            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }


        sc.close();

    }
}