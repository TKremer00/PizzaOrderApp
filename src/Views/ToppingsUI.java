package Views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import Models.PizzaTopping;

/**
 *
 * @author tim7v
 */
public class ToppingsUI extends GridPane{

    private List<PizzaTopping> topping;
    private ArrayList<String> selectedTopping;
    private final Text lblTitle;

    public ToppingsUI()
    {
        GridPane p = this;
        p.setPadding(new Insets(10,10,10,10));
        p.setHgap(10);
        p.setVgap(10);
        
        topping = Arrays.asList(PizzaTopping.values());
        selectedTopping = new ArrayList<>();
        
        lblTitle = new Text("Toppings");
        p.add(lblTitle,0,0);
        for (int i = 0; i < topping.size(); i++)
        {
            CheckBox cb = new CheckBox(topping.get(i).getName() + " " +  String.format("€ %.2f", topping.get(i).getCost()) );
            cb.setUserData(topping.get(i).getName());
            
            cb.setOnAction(event -> {
                if(cb.isSelected()) {
                    selectedTopping.add((String)cb.getUserData());
                }else {
                    selectedTopping.remove((String) cb.getUserData());
                }
            });
            p.add(cb, 0, i + 1);
        }
    }
    
    public ArrayList<String> getToppings() {
        return selectedTopping;
    }
    
}
