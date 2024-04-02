import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Writer {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\asus\\Documents\\Groceries.txt";
        String fileToWrite = "C:\\Users\\asus\\Documents\\GroceriesFormatted.txt";

        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileToWrite);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String [] array = new String[4];
        String line;
        String id;
        String itemName;
        String quantity;
        double price;
        double totalPrice = 0.0;

        writer.write("****************************************************");
        writer.newLine();
        writer.write("ID#" + "\t\t" + "Item" + "\t\t\t" + "Quantity" + "\t\t" + "Price (€)." );
        writer.newLine();

        while ((line = reader.readLine()) != null) {
                array = line.split(",");
                id = array[0];
                itemName = array[1];
                quantity = array[2];
                price = Double.parseDouble(array[3]);
                totalPrice += price;

                if (itemName.length() < 5 && quantity.length() < 4 ){
                   line=id + "\t\t" + itemName + "\t\t\t" + quantity + "\t\t\t" + price + ".";
                }else if (itemName.length() >= 5 && quantity.length() < 4){
                   line=id + "\t\t" + itemName + "\t\t" + quantity + "\t\t\t" + price + ".";
                }else {line=id + "\t\t" + itemName + "\t\t" + quantity + "\t\t" + price + ".";
            }

            System.out.println(line);
            writer.write(line);
            writer.newLine();

        } 
        writer.write("****************************************************");
        writer.newLine();
        writer.write("The grocery shopping total is: €" + Math.round(totalPrice));
        writer.newLine();
        writer.write("****************************************************");

        writer.flush();
        writer.close();
        reader.close();
    }
}