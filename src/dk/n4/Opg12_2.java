/* OPGAVE 12.2

Lille program, der beder brugeren om at finde summen af to tilfældige tal. Hvis svaret er forkert, gives nyt forsøg.
Da "Math.random" altid vil generere 0, hvis jeg caster den til "int", så deklarerer jeg number1 og number2 til at være
"double" og caster senere disse variabler til at være "int". På den måde får brugeren ikke to kommatal, der skal udregnes.
Hvis brugeren indtaster alt andet end heltal, så bliver det catched, og en fejlbesked udskrives i konsollen. */

package dk.n4;

import java.util.InputMismatchException; //Importerer klassen InputMismatchException
import java.util.Scanner; //Importerer Scanner-klassen

public class Opg12_2 {

    public static void main(String[] args) { //Main method køres

        //Variabler deklareres og initialiseres
        double number1 = Math.random() * 100 + 1;
        double number2 = Math.random()* 100 + 1;
        int result;

        //Try-block afvikles
        try {
            System.out.print("Læg de to tal sammen: ");
            System.out.print((int)number1 + " + " + (int)number2 + " = ");
            Scanner input = new Scanner(System.in); //Nyt scanner-objekt laves
            result = input.nextInt(); //Scanner-objekt initialiseres til at være "result"

            //While-løkke kører, så længe brugeren indtaster forkert løsning
            while (result != (int)number1 + (int)number2) {
                System.out.print("Forkert, prøv igen. ");
                System.out.print((int)number1 + " + " + (int)number2 + " = ");
                result = input.nextInt();
            }
            System.out.println("Korrekt!"); //Printes, hvis brugeren taster korrekt løsning
        }

        //Hvis brugeren benytter sig af bogstaver eller andet, som ikke er integer, så bliver det catched
        catch (InputMismatchException ex) {
            System.out.println("Dit svar skal bestå af et helt tal."); //Fejlbesked printes
        }
        
    }

}
