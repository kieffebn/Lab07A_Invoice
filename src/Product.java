/**
 Describes a product with a description and a price.
 */
public class Product
{
    public String description;
    public String price;

    /**
     Gets the product description.
     @return the description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     Gets the product price.
     @return the unit price
     */
    public Double getPrice()
    {
        return Double.valueOf(price);
    }
}
