package pl.coderslab.workshop_1.zadanie_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main (String[] args){

        Scanner scn = new Scanner(System.in);
        Random random = new Random();
        int[] randomTab = new int[6];
        int[] userTab = new int[6];

        for (int i = 0; i < randomTab.length; i++) {
            do {
                int num = random.nextInt(49) + 1;
                if(checkTabForNumber(randomTab, num)){
                    randomTab[i] = num;
                }
            } while (randomTab[i] == 0);
        }

        Arrays.sort(randomTab);
        System.out.println("Wytypuj 6 liczb od 1 do 49.");

        for(int i = 0; i <userTab.length; ) {
            try {
                System.out.println("Podaj liczbę:");
                String line = scn.nextLine();
                int userNum = Integer.parseInt(line);
                if (userNum < 1 || userNum > 49) {
                    System.out.println("Podaj liczbę od 1 do 49.");
                } else {
                    if (checkTabForNumber(userTab, userNum)) {
                        userTab[i] = userNum;
                        i++;
                    } else {
                        System.out.println("Ta liczba zostałą już wcześniej wytypowana.");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("To nie jest liczba.");
            }
        }

        Arrays.sort(userTab);
        System.out.println("Wylosowane liczby to: " + Arrays.toString(randomTab));
        System.out.println("Wybrane przez użytkownika liczby to: " + Arrays.toString(userTab));

        switch (compareTabs(randomTab,userTab)){
            case 3:
                System.out.println("Trafiłeś trójkę!");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę!");
                break;
            case 6:
                System.out.println("Trafiłeś szóstkę!");
                break;
            default:
                System.out.println("Spróbuj jeszcze raz.");
        }
    }

    static boolean checkTabForNumber(int[] tab, int number){
        for(int i = 0; i <tab.length; i++ ){
            if(tab[i] == number) {
                return false;
            }
        }
        return true;
    }

    static int compareTabs(int[] tab1, int[] tab2){
        int count = 0;
        for(int i = 0; i <tab1.length; i++){
            for(int j = 0; j <tab2.length; j++){
                if(tab1[i] == tab2[j]){
                    count++;
                }
            }
        }
        return count;
    }
}