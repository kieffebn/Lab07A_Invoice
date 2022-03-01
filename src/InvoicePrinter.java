import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class InvoicePrinter {
    public static void main (String[] args) {
        Boolean moreEntries = true;
        Scanner input = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();
        Address samsAddress = new Address();
        String cont;
        Double amtDue = 0.00;

        samsAddress.name = "Sam's Small Appliances";
        samsAddress.street = "100 Main Street";
        samsAddress.city = "Anytown";
        samsAddress.state = "CA";

        System.out.println("Enter a line item below.");
        while (moreEntries == true) {
            Product tempProd = new Product();
            LineItem tempLi = new LineItem();
            tempProd.description = SafeInput.getNonZeroLenString(input, "Enter Product Name");
            recs.add(tempProd.description);
            tempProd.price = SafeInput.getNonZeroLenString(input, "Enter the cost of ONE of these items");
            recs.add(tempProd.price);
            tempLi.theProduct = tempProd;
            tempLi.quantity = SafeInput.getInt(input, "Enter the product quantity");
            recs.add(String.valueOf(tempLi.quantity));
            Invoice.items.add(tempLi);
            cont = SafeInput.getNonZeroLenString(input, "More entries? Y/N");
            if (Objects.equals(cont, "Y")) {
                moreEntries = true;
            } else {
                moreEntries = false;
            }
            recs.clear();
        }

        System.out.println("INVOICE");
        System.out.println(samsAddress.format());
        System.out.println("========================================" + "\n" +
                "Item" + "\t \t \t" + "Qty" + "\t" + "Price" + " " + "Total");
        for (int i = 0; i < Invoice.items.size(); i++) {
            amtDue = amtDue + Double.valueOf(Invoice.items.get(i).getTotalPrice());
            System.out.println(Invoice.items.get(i).format());
            }
        System.out.println("========================================" + "\n" +
                    "Amount Due: " + String.format("%.2f",amtDue)
                );


    }
}
