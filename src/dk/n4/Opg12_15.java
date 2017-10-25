/* OPGAVE 12.15

Opgavebeskrivelsen lyder:
Write a program to create a file named Exercise12_15.txt if it does not exist. Write 120 integers created randomly into
the file using text I/O. Integers are separated by spaces in the file. Read the data back from the file and display the
data in increasing order. */

package dk.n4;

import java.util.Scanner; //Importerer klaassen "Scanner"

public class Opg12_15 {

    public static void main(String[] args) throws Exception { //Main eksekveres

        //SEKTION 1: Vi initialiserer et objekt (kaldet "file") i File-klassen til at en .txt-fil

        java.io.File file = new java.io.File("Exercise12_15.txt");

        //Hvis det initialiserede objekt allerede eksisterer, så lukkes systemet, og resten af koden eksekveres ikke!
        if (file.exists()) {
            System.out.println("Filen eksisterer allerede!");
            System.exit(0);
        }

        //SEKTION 2: Vi åbner filen, skriver til filen, og lukker filen igen

        try ( //Auto-closer filen, når vi er færdige med at indsætte data i den
              // Laver nyt PrintWriter objekt og initialiserer det til at være vores file-objekt
              java.io.PrintWriter output = new java.io.PrintWriter(file) //Nu kan vi skrive til filen
        ) {
            // Skriver 120 tilfældige int-værdier i filen vha. Math.random
            double randomNo;
            for (int i = 0; i < 120; i++) {
                randomNo = Math.random() * 150;
                output.print((int) randomNo + " "); //Caster "randomNo" til integer og laver space bagefter
            }
        } //Vi er færdige med at skrive til filen

        //SEKTION 3: Vi åbner filen igen, og læser filens indhold

        // Laver nyt scanner-objekt og initialiserer det med vores file-objekt
        Scanner input = new Scanner(file); //Nu kan vi læse fra filen

        // Læser data fra fil vha. while-loop
        while (input.hasNext()) {
            int value = input.nextInt();
            System.out.print(value + " "); //Printer data i konsollen
        }

        input.close(); //Vi lukker filen igen, efter vi har indlæst

    }

}
