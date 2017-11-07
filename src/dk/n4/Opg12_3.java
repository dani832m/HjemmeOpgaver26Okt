/* OPGAVE 12.3
Program der automatisk tildeler et array 100 værdier, lader brugeren indtaste en index-værdi og printer tallet, der
er stored på valgte index. Hvis indtastning ikke lever op til arrayets index length, får brugeren en fejlbesked */

package dk.n4; //Package

import java.util.Arrays; //Importerer klassen "Arrays" (til debugging)
import java.util.Scanner; //Importerer klassen "Scanner"

public class Opg12_3 { //Angiver access modifier og klassens navn
//Læs mere om access modifiers her: https://www.tutorialspoint.com/java/java_access_modifiers.htm

    public static void main(String[] args) { //Main-metode eksekveres

        double ran = Math.random() * 100; //Anvender "double" fordi "Math.random" som "int" altid vil give 0
        int[] array = new int[100]; //Nyt array, der kan indeholde 100 int-værdier

        for(int i = 0; i < array.length; i++) { //For-loop der kører, hvis variablen "i" er mindre end index-længde
            array[i] = (int)ran; //Caster "ran" til "int" for ikke at få kommatal, og initialiserer værdien i arrays index
            ran = Math.random() * 100; //Tildeler variablen "ran" en ny tilfældig værdi, og loopet køres igen
        }

        //System.out.println(Arrays.toString(array)); //Printer mit arrays indhold (til debugging)

        Scanner input = new Scanner (System.in); //Laver nyt scanner-objekt
        System.out.println("Indtast et index, du vil se værdien på: ");

        try { //Try-block
            int index = input.nextInt(); //Deklarerer "index" og initialiseres til at være brugerinput
            System.out.println("Array[" + index + "] = " + array[index]); //Printer valgte index og værdi af dette
        }
        //To exceptions integreres i catch-blokke
        catch (IndexOutOfBoundsException ex) { //Hvis valgte index ikke er mellem 1-100 bliver det catched
            System.out.println("Out of Bounds."); //Og besked printes
        }
        catch (Exception ex) {
            System.out.println("Ugyldig indtastning!"); //Printes hvis der ikke anvendes legal input (integers)
        }

    } //Main afsluttes

} //Klassen afsluttes
