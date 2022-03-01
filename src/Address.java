/**
 Describes a mailing address.
 */
public class Address
{
    public String name;
    public String street;
    public String city;
    public String state;
    /**
     Formats the address.
     @return the address as a string with three lines
     */
    public String format()
    {
        return (name + "\n"
            + street + "\n" +
                city + ", " + state
        );
    }
}
