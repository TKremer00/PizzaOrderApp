package Models;

/**
 *
 * @author tim7v
 */
public enum PizzaCurst {
    
    Thin("Thin",1.00), Thick("Thick",1.25);
    
    private String thickness;
    private double cost;

    PizzaCurst(String size,double cost) {
        this.thickness = size;
        this.cost = cost;
    }

    public String getName()
    {
        return thickness;
    }

    public double getCost()
    {
        return cost;
    }
}
