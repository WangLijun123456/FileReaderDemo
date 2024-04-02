 import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {

    public static void main(String[] args) throws Exception{
        
        String filePath = "C:\\Users\\asus\\Documents\\Groceries.txt";
       
        String [] array = new String[4];
        String id;
        String itemName;
        String quantity;
        double price;
        String separator = ",";
        double total = 0;

        FileReader fileReader = new FileReader(filePath);
        
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
            
        while ((line = reader.readLine()) != null) {
             
            array = line.split(separator);

            price = Double.parseDouble(array[3]);

            total += price;

            System.out.println(line);

        }
            
        System.out.println("\n" + "Total price of groceries: " + Math.round(total));
        
        reader.close();
        } 

    }

