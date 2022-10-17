package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in Date: ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date: ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to Update the reservation: ");
            System.out.print("Check-in Date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date: ");
            checkOut = sdf.parse(sc.next());


            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid Date Format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }


        sc.close();

    }
}

