package Models;

/**
 *
 * @author tim7v
 */
public enum PizzaSize {

    Small("Small",1.00),Medium("Medium",1.25),Large("Large",1.50);
    
    private String size;
    private double cost;

    private PizzaSize(String size,double cost)
    {
        this.size = size;
        this.cost = cost;
    }

    public String getName()
    {
        return size;
    }

    public double getCost()
    {
        return cost;
    }
    
}
