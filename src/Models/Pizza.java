package Models;

import java.util.ArrayList;

/**
 *
 * @author tim7v
 */
public class Pizza {
    
    private final PizzaSize size;
    private final PizzaCurst crust;
    private  ArrayList<PizzaTopping> toppings; 
    private double price = 0;

    public Pizza(String size, String crust, ArrayList<String> toppings)
    {
        this.size = PizzaSize.valueOf(size);
        this.crust = PizzaCurst.valueOf(crust);
        this.toppings = new ArrayList<>();
        toppings.forEach((topping) ->
        {
            this.toppings.add(PizzaTopping.valueOf(topping));
        });
    }
    
    //GETTERS 
    public Double getPrice() {
        price += size.getCost();
        price += crust.getCost();
        toppings.forEach((topping) ->
        {
            price += topping.getCost();
        });
        return price;
    }
    
    public String getOrderString() {
        String temp = size.getName() + " " + crust.getName() + " ";
        temp += toppings.stream().map((topping) -> topping.getName() + " ").reduce(temp, String::concat);
        return temp;
    }

    public PizzaSize getSize()
    {
        return size;
    }

    public PizzaCurst getCrust()
    {
        return crust;
    }

    public ArrayList<PizzaTopping> getToppings()
    {
        return toppings;
    }
}
