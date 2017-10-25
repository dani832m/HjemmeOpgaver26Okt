/* OPGAVE 12.14

Program, der kan udregne gennemsnit og samlet score baseret på indholdet i en .txt-fil, som brugeren selv angiver,
hvor er placeret. */

package dk.n4;

import java.io.File; //Importerer File-klassen fra "java.io"
import java.util.Scanner; //Importerer Scanner-klassen fra "java.util"

public class Opg12_14 {

    public static void main(String[] args) throws Exception { //Bemærk: throws Exception

        // Laver et nyt objekt i Scanner-klassen med navnet "input"
        Scanner input = new Scanner(System.in);

        // Giver brugeren mulighed for at indtaste en sti til score-filen
        System.out.print("Indtast navnet på filen: ");
        //Laver et nyt objekt i File-klassen med navnet "file"
        File file = new File(input.nextLine()); //Fortæller at "file" skal baseres på bruger-input

        // Tjekker om objektet eksisterer, hvis ikke lukkes systemet
        if (!file.exists()) {
            System.out.println("Filen '" + file + "' eksisterer ikke.");
            System.exit(1);
        }

        int count = 0; //Deklarerer og initialiserer variabel "count" - bruges ved resultaterne
        double samlet = 0; //Deklarerer og initialiserer variabel "samlet" - bruges ved resultaterne

        try ( //Try der automatisk lukker filen efter brug
                //Laver objekt i Scanner-klassen og initialiserer den til at være brugerens fil
                Scanner inputFile = new Scanner(file);
        ) {
            while (inputFile.hasNext()) { //Kører while-loop baseret på indhold af brugerens fil
                samlet += inputFile.nextInt();
                count++;
            }
        } //Lukker filen igen

        // Viser resultater
        System.out.println("Filnavnet: " + file.getName());
        System.out.println("Samlet score: " + samlet);
        System.out.println("Gennemsnitlig score: " + (samlet / count));

    }

}