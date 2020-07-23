package Models;

/**
 *
 * @author tim7v
 */
public enum PizzaTopping{
    
    Pepperoni("Pepperoni",1.00),Mushrooms("Mushrooms",1.25),Anchovy("Anchovy",1.50);
    
    private final String toppings;
    private final double cost;
    
    private PizzaTopping(String toppings,double cost) {
        this.toppings = toppings;
        this.cost = cost;
    }

    public String getName()
    {
        return toppings;
    }

    public double getCost()
    {
        return cost;
    }
}
