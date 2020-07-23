package Models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tim7v
 */
public class Order
{

    private ArrayList<ArrayList<Pizza>> order;
    private User user;
    
    public Order()
    {
        order = new ArrayList<>();
        this.user = new User();
    }
    
    //Add pizza to order
    public void addToOrder(Pizza pizza)
    {
        if (checkClones(pizza))
        {
            order.add(new ArrayList<>(Arrays.asList(pizza)));
        }
    }
    
    //Check if pizza is equal to pizza in array
    private boolean checkClones(Pizza pizza)
    {
        for (int i = 0; i < order.size(); i++)
        {
            if (order.get(i).get(0).getOrderString().equals(pizza.getOrderString()))
            {
                order.get(i).add(pizza);    
                return false;
            }
        }
        return true;
    }
    
    //Set user
    public void setUser(User user) 
    {
        this.user = user;
    }
    
    //Get user
    public User getUser() 
    {
        return user;
    }
    
    //Get cost of pizzas
    public String getTotalCost() {
        double totalCost = 0;
        for (ArrayList<Pizza> arrayList : order)
        {
            totalCost += arrayList.get(0).getSize().getCost() + arrayList.get(0).getCrust().getCost();
            for (PizzaTopping pizza : arrayList.get(0).getToppings())
            {
                totalCost += pizza.getCost();
            }
            totalCost *=  arrayList.size();
        }
        return String.format("€ %.2f", totalCost);
    }
    
    //Get order
    public ArrayList<ArrayList<String>> getOrder() {
        ArrayList<ArrayList<String>> pizzas = new ArrayList<>();
        
        for (ArrayList<Pizza> arrayList : order)
        {
            String options = " - (" + arrayList.get(0).getSize().getName() + "," + arrayList.get(0).getCrust().getName() + ",";
            double cost = arrayList.get(0).getSize().getCost() + arrayList.get(0).getCrust().getCost();
            for (PizzaTopping pizza : arrayList.get(0).getToppings())
            {
                options += pizza.getName() + ",";
                cost += pizza.getCost();
            }
            options = options.substring(0, options.length() -1) + ")";
            pizzas.add(new ArrayList<>(Arrays.asList(arrayList.size() + "X Pizza",String.format("€ %.2f" , cost * arrayList.size()),options)));
        }
        return pizzas;
    }
    
    //Set oder array empty
    public void EmptyOrder() {
        order = new ArrayList<>();
    }
}
