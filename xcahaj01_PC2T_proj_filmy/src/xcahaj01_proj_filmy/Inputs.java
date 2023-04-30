package xcahaj01_proj_filmy;

import java.util.Scanner;

public class Inputs {

    public static int pouzeCislo(int a, int b) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if(number >= a && number <= b){
                    validInput = true;
                }else{
                    System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+":");
                }
            }
            else {
                System.out.println("Zadejte celé číslo v rozsahu "+ a+"-"+b+" :");
                sc.next();
            }
        }
        return number;
    }
}