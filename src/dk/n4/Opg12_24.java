/* OPGAVE 12.24
Opgavebeskrivelsen lyder:
Create a data file with 1000 lines. Each line in the file consists of a faculty member's first name, last name, rank,
and salary. The faculty member's first name and last name for the ith line are FirstNamei and LastNamei. The rank is
randomly generated as assistant, associate, and full. The salary is randomly generated as a number with two digits after
the decimal point. The salary for an assistant professor should be in the range from 50,000 to 80,000 for associate
professor from 60,000 til 110,000, and for full professor from 75,000 to 130,000. Save the file in Salary.txt
Sample data:    FirstName1 LastName1 Assistant 60055.95
                FirstName2 LastName2 Associate 81112.45
                ...
                FirstName1000 LastName1000 Full 92255.21 */

package dk.n4; //Package

//Importerer nødvendige klasser
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Opg12_24 { //Angiver access modifier og klassens navn
//Læs mere om access modifiers her: https://www.tutorialspoint.com/java/java_access_modifiers.htm

    //Metode til senere brug
    public static String randomRankAndSalary() {
        String[] rankArray = new String[3]; //Laver et array med plads til 3 værdier
        rankArray[0] = "Assistant";
        rankArray[1] = "Associate";
        rankArray[2] = "Full";

        //Deklarerer og initialiserer variabel "rndRank" med random værdi baseret på indhold i "rankArray"
        int rndRank = new Random().nextInt(rankArray.length); //Tildeler random værdi fra "rankArray"

        double salary; //Deklarerer variabel "salary"

        //If-else statement baseret på, hvilken automatisk rank, der blev valgt i "rndRank"
        if (rndRank == 0) { //Hvis det er assistant
            salary = 50000 + (Math.random() * 30001); //Tilfældig salary for assistant
        }
        else if (rndRank == 1) { //Hvis det er associate
            salary = 60000 + (Math.random() * 50001); //Tilfældig salary for associate
        }
        else salary = 75000 + (Math.random() * 55001); //Tilfældig salary for full

        return rankArray[rndRank] + " " + salary; //Returnerer rank og salary
    }

    public static void main(String[] args) throws FileNotFoundException { //Main-metode eksekveres

        File file = new File("Salary.txt"); //Nyt file-objekt oprettes og initialiseres

        //Hvis det initialiserede objekt allerede eksisterer, så lukkes systemet, og resten af koden eksekveres ikke!
        if (file.exists()) {
            System.out.println("Filen eksisterer allerede!");
            System.exit(0);
        }

        //Try lukker automatisk filen efter brug
        try ( PrintWriter output = new PrintWriter(file) ) { //Nyt PrintWriter-objekt oprettes. Initialiseres til "file"

            for(int i = 0; i < 1000; i++) { //For-loop der kører præcis 1000 gange
                //Skriver FirstName i, LastName i, rank og salary til filen
                output.println("FirstName" + i + " " + "Lastname" + i + " " + randomRankAndSalary()); //Kalder metode
            }

        } //Try-block slutter

    } //Main method slutter

} //Klassen slutter
