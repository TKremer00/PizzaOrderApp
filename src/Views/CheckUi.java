package Views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import pizzabestellenapp.OrderController;

/**
 *
 * @author tim7v
 */
public class CheckUi {

    private final Button saveCheck,btnExit; 
    private final Image check;
    
    public CheckUi(GridPane p, OrderController oc)
    {
        check = new Image(oc.getFile().toURI().toString());
        saveCheck = new Button("Save check");
        btnExit = new Button("Exit");
        p.setHgap(10);
        saveCheck.setOnAction((event) ->
        {
            JFileChooser chooser = new JFileChooser(); 
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Save image");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            
            if (chooser.showOpenDialog(new JPanel()) == JFileChooser.APPROVE_OPTION) { 
                oc.MoveCheck(chooser.getSelectedFile().getAbsolutePath() + "\\Check.png");
            }
        });
        
        btnExit.setOnAction((event) ->
        {
            oc.deleteCheck();
           ((Node)(event.getSource())).getScene().getWindow().hide();
        });
        
        p.add(new ImageView(check), 0, 0,5,1);
        p.add(saveCheck, 0,1,1,1);
        p.add(btnExit, 1, 1);
    }
}
