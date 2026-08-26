import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {


        // 1. ReadScores, clean it up
        ArrayList<Integer> scores = readScores("scores.txt");

        int high =  Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int n : scores) {
            if (n > high) high = n;
            if (n < low) low = n;
        }
        int errors = 0;


        // 2. Calculate the average
        double average = calculateAverage(scores);
        
        // 3: write and print report
        writeReport(scores, average, high, low, "report.txt");
    } 


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Returns a list of valid scores read from the file
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>(); // my array here


        System.out.println("Reading the scores");



        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.trim(); // trim the line
                        if (line.isEmpty()) {
                           continue;  // skip blank lines; continue means go to the start of the loop
                    }

                    // Wrap in try-catch when reading untrusted data:
                    try {
                        int n = Integer.parseInt(line);
                        scores.add(n);
  
                        } catch (NumberFormatException e) {
                            System.out.println("Skipping invalid value: " + line);
                        }
                        }
                } catch (IOException e) {
                    System.out.println("Could not read file: " + e.getMessage());
                }


        System.out.println("Scores:");
        System.out.println(scores);


        return scores;
    }


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Returns the average of a list of scores, or 0.0 if the list is empty
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()){
        System.out.println("No entries in the file.");
         return 0.0;   // return 0.0 if it's empty --> that should probably be more of an error though, rather than 0.0...!
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        // Return average
        System.out.println("Calculated Average: " + total / scores.size());
        return total / scores.size();
    }


 // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Writes and prints the report
 // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low, 
                                   String outputFile) {
       
        // Declare my people
        int countA=0; int countB=0; int countC=0; int countD=0; int countF=0; 

        // loop it
        for (int score: scores){
            if (score>=90) countA++;
            else if (score >= 80 && score<90) countB++;
            else if (score >= 70 && score<80) countC++;
            else if (score >= 60 && score<70) countD++;
            else if (score <60) countF++;
            else {System.out.println("you wanted an Else statement but you should never get here");}
        }

        // Print the report
        System.out.println("*** GRADE ANALYSIS REPORT***");
        System.out.println("Scores processed: " + scores.size());
        System.out.println("Average Score   : " + avg );

        System.out.println("Grade Distribution :");
        System.out.println("  A-" + countA + ", B-" + countB +", C-" + countC +", D-" +countD +", Failed-" + countF);
        System.out.println("----------------------------------------------------------------------------------");


        System.out.println(String.format("%-26s %5d", "Correct Entries Processed:", scores.size()));
        System.out.println(String.format("%-26s %5d", "Highest Grade:", high));
        System.out.println(String.format("%-26s %5d", "Lowest Grade:", low));

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
        writer.println("*** GRADE ANALYSIS REPORT ***");
        writer.println("Scores processed: " + scores.size());
        writer.write(String.format("Average Score   : %.2f%n", avg));
        writer.println("Grade Distribution :");
        writer.println("  A-" + countA + ", B-" + countB + ", C-" + countC + ", D-" + countD + ", Failed-" + countF);
        writer.println("----------------------------------------------------------------------------------");
        writer.write(String.format("%-26s %5d%n", "Correct Entries Processed:", scores.size()));
        writer.write(String.format("%-26s %5d%n", "Highest Grade:", high));
        writer.write(String.format("%-26s %5d%n", "Lowest Grade:", low));
        
        System.out.println("\nSuccessfully written to " + outputFile);
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}

    }