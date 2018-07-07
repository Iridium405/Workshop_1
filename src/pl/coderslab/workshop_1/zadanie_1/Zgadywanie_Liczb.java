package pl.coderslab.workshop_1.zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class Zgadywanie_Liczb {

    public static void main (String[] args){
        Random random = new Random();
        Scanner scn = new Scanner(System.in);

        int x = random.nextInt(100)+1;
        int count = 0;
        boolean numberFound = false;

        do {
            try {
                System.out.println("Zgadnij liczbę:");
                String line = scn.nextLine();
                int number = Integer.parseInt(line);
                if (number > x) {
                    count++;
                    System.out.println("Mniej!");
                } else if (number == x) {
                    count++;
                    System.out.println("Odgadłeś liczbę w " + count + " ruchach.");
                    numberFound = true;
                } else if (number < x) {
                    count++;
                    System.out.println("Więcej!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("To nie jest liczba.");
            }

        } while (!numberFound);
    }
}
