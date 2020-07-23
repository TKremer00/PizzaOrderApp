package Views;

import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import Models.PizzaCurst;

/**
 *
 * @author tim7v
 */
public class CurstUI extends GridPane 
{
    //private List<PizzaCurst> curst;
    private ToggleGroup group;
    
    private final Text lblcategory;

    public CurstUI()
    {
        group = new ToggleGroup();
        GridPane p = this;
        List<PizzaCurst> curst = Arrays.asList(PizzaCurst.values());
        
        p.setPadding(new Insets(10,10,10,10));
        p.setHgap(10);
        p.setVgap(10);
        
        lblcategory = new Text("Curst");
        p.add(lblcategory, 0, 0);
        
        for (int i = 0; i < curst.size(); i++)
        {
            RadioButton rb = new RadioButton(curst.get(i).name() + " " + String.format("€ %.2f", curst.get(i).getCost()));
            if(i == 0) {
                rb.setSelected(true);
            }
            rb.setToggleGroup(group);
            rb.setUserData(curst.get(i).getName());
            p.add(rb, 0, 1 + i);
        }
    }
    
    public String getCurst() {
        return (String) group.getSelectedToggle().getUserData();
    }
}
