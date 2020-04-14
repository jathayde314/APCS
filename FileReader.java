import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/joshuaathayde/Documents/Prefix Sum HW Assignment/prefixsum/p7.txt");
        Scanner scan = new Scanner(file); //Creates Scanner
        String fileContent = ""; //Empty string used for concatenation
        DecimalFormat df = new DecimalFormat("#.000"); //Rounds to 3 decimal places


        int n = scan.nextInt(); //Finds n
        //Creates Array
        int[] givenArray = new int[n];
        for (int index = 0; index < n; index++){
            givenArray[index] = scan.nextInt();
        }

        int q = scan.nextInt(); //Finds q
        for (int index = 0; index < q; index++){
            int l = scan.nextInt();
            int r = scan.nextInt();
            String roundedDouble = df.format(averageSubArray(givenArray, l, r)); //Averages and rounds number
            fileContent += roundedDouble + "\n"; //Concatenates to string with new line
        }

        //File writing
        FileWriter fileWriter = new FileWriter("/Users/joshuaathayde/Documents/Prefix Sum HW Assignment/output2.txt");
        fileWriter.write(fileContent, 0, fileContent.length());
        fileWriter.flush();
        fileWriter.close();

    }

    //Averages by summing and dividing
    static double averageSubArray(int[] givenArray, int l, int r){
        double retval = 0;
        for (int index = l - 1; index < r; index++){
            retval += givenArray[index];
        }
        retval = retval / (r - l + 1);
        return retval;
    }
}
