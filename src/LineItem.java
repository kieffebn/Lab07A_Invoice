/**
 Describes a quantity of an article to purchase and its  price.
 */
public class LineItem
{
    public Integer quantity;
    public Product theProduct;
    /**
     Computes the total cost of this line item.
     @return the total price
     */
    public double getTotalPrice()
    {
        return theProduct.getPrice() * quantity;
    }
    /**
     Formats this item.
     @return a formatted string of this line item
     */
    public String format()
    {
        return (theProduct.description + "\t \t" + quantity.toString() + "\t" + "$" + theProduct.getPrice().toString() + " " + "$" + getTotalPrice());
    }
}
