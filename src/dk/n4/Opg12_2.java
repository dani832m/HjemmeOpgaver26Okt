/* OPGAVE 12.2
Lille program, der beder brugeren om at finde summen af to tilfældige tal. Hvis svaret er forkert, gives nyt forsøg.
Da "Math.random" altid vil generere 0, hvis jeg caster den til "int", så deklarerer jeg number1 og number2 til at være
"double" og caster senere disse variabler til at være "int". På den måde får brugeren ikke to kommatal, der skal udregnes.
Hvis brugeren indtaster alt andet end heltal, så bliver det catched, og en fejlbesked udskrives i konsollen. */

package dk.n4; //Package

import java.util.InputMismatchException; //Importerer klassen "InputMismatchException"
import java.util.Scanner; //Importerer klassen "Scanner"

public class Opg12_2 { //Angiver access modifier og klassens navn
//Læs mere om modifiers her: https://www.tutorialspoint.com/java/java_access_modifiers.htm

    public static void main(String[] args) { //Main method køres

        //Variabler deklareres og initialiseres
        double number1 = Math.random() * 100 + 1;
        double number2 = Math.random()* 100 + 1;
        int result;

        //Try-block afvikles
        try {
            System.out.print("Læg de to tal sammen: "); //Tekst udskrives i konsollen
            System.out.print((int)number1 + " + " + (int)number2 + " = "); //Udskiver de to variabler
            Scanner input = new Scanner(System.in); //Nyt scanner-objekt laves
            result = input.nextInt(); //Scanner-objekt initialiseres til at være "result"

            //While-løkke kører, så længe brugeren indtaster forkert løsning
            while (result != (int)number1 + (int)number2) {
                System.out.print("Forkert, prøv igen. "); //Udskriver tekst i konsollen
                System.out.print((int)number1 + " + " + (int)number2 + " = "); //Udskriver de to variabler
                result = input.nextInt(); //Scanner-objekt initialiseres til at være "result"
            }
            System.out.println("Korrekt!"); //Printes, hvis brugeren taster korrekt løsning
        } //Afslutter try-block

        //Hvis brugeren benytter sig af bogstaver eller andet, som ikke er integer, så bliver det catched
        catch (InputMismatchException ex) { //Catch i kategorien "InputMismatchException"
            System.out.println("Dit svar skal bestå af et helt tal."); //Fejlbesked printes
        } //Catch-block afsluttes
        
    } //Main afsluttes

} //Klassen afsluttes
