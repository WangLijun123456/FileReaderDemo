import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        
        String filePath = "C:\\Users\\asus\\Documents\\Groceries.txt";
        String[] id = new String[100];
        String[] itemName = new String[100];
        String[] quantity = new String[100];
        double[] price = new double[100];

        int itemCount = 0;
        double totalPrice = 0.0;

        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");

                id[itemCount] = tokens[0];
                itemName[itemCount] = tokens[1];
                quantity[itemCount] = tokens[2];
                price[itemCount] = Double.parseDouble(tokens[3]);

                System.out.println(line);

                // Increment item count and calculate total price

                itemCount++;
                totalPrice += price[itemCount - 1];
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}
