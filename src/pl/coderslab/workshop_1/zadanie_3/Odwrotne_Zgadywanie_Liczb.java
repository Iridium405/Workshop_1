package pl.coderslab.workshop_1.zadanie_3;

import java.util.Scanner;

public class Odwrotne_Zgadywanie_Liczb {

    public static void main (String[] args) {
        int min = 0;
        int max = 1000;
        int count = 0;
        Scanner scn = new Scanner(System.in);

        System.out.println("Pomysl liczbę od 1 do 1000, a ja zgadnę jaka to liczba w max. 10 próbach.");
        boolean isFound = false;

        while(!isFound){
            int guess = (max - min)/2 + min;
            if(count > 10){
                System.out.println("Oszukujesz!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Zgaduję: " + guess);
            count++;
            System.out.println("1. mniej \n2. więcej \n3. trafiłeś");

            String answer = scn. nextLine();
            if(answer.toLowerCase().equals("mniej") || answer.equals("1")) {
                max = guess;
            } else if (answer.toLowerCase().equals("więcej") || answer.equals("2")) {
                min = guess;
            } else if (answer.toLowerCase().equals("trafiłeś") || answer.equals("3")) {
                System.out.println("Wygrałem! [" + count +" prób]" );
                isFound = true;
            } else {
                System.out.println("Wybierz odpowiedź z listy!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}