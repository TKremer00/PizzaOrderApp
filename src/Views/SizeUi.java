package Views;

import java.util.List;
import java.util.Arrays;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import Models.PizzaSize;

/**
 *
 * @author tim7v
 */
public class SizeUi extends GridPane {

    //private List<PizzaSize> size;
    private ToggleGroup group;
    
    private final Text lblcategory;

    public SizeUi()
    {
        GridPane p = this;

        // Style
        p.setPadding(new Insets(10,10,10,10));
        p.setHgap(10);
        p.setVgap(10);
        
        
        group = new ToggleGroup();
        
        List<PizzaSize> size = Arrays.asList(PizzaSize.values());
        
        lblcategory = new Text("Size");
        
        p.add(lblcategory, 0,0);
        for (int i = 0; i < size.size(); i++)
        {
            RadioButton rb = new RadioButton(size.get(i).name() + " " +  String.format("€ %.2f", size.get(i).getCost()));
            if(i == 0) {
                rb.setSelected(true);
            }
            rb.setToggleGroup(group);
            rb.setUserData(size.get(i).getName());
            p.add(rb, 0, 1 + i);
        }
    }
    
    public String getSize() {
        return (String) group.getSelectedToggle().getUserData();
    }
    
}
