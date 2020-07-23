package Views;

import Models.Order;
import Models.Pizza;
import Models.User;
import pizzabestellenapp.OrderController;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author tim7v
 */
public class Gui
{

    //Variables
    private final Text lblTitle;
    private final Text lblName, lblPhone, lblAddress;

    private final TextField txtName, txtPhone, txtAddress;

    private final SizeUi size;
    private final CurstUI curst;
    private final ToppingsUI topping;
    private User user;
    private OrderController oc;
    private Order order;

    private final Button btnAddToOrder, btnOrder, btnCancel;
    private Text price;

    public Gui(GridPane p)
    {
        //Objects
        lblTitle = new Text("Order your Pizza now!");

        lblName = new Text("Name");
        lblPhone = new Text("Phone");
        lblAddress = new Text("Address");

        txtName = new TextField();
        txtPhone = new TextField();
        txtAddress = new TextField();

        size = new SizeUi();

        curst = new CurstUI();

        topping = new ToppingsUI();
        btnAddToOrder = new Button("Add to card");
        btnOrder = new Button("Order");
        btnCancel = new Button("Cancel");
        price = new Text("€ 0,00");

        order = new Order();
        

        //Event handelers
        btnAddToOrder.setOnAction(event ->
        {
            Pizza pizza = new Pizza(size.getSize(), curst.getCurst(), topping.getToppings());
            order.addToOrder(pizza);
            price.setText(order.getTotalCost());
        });

        btnOrder.setOnAction(event ->
        {
            user = new User(txtName.getText(), txtAddress.getText(), txtPhone.getText());
            order.setUser(user);
            oc = new OrderController(order);
            oc.makeCheck();
            
            StackPane stackPane = new StackPane(new Text("Generating Check.."));
            Scene popupScene = new Scene(stackPane, 75, 75);
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(popupScene);
            popupStage.setResizable(false); // prevents resize and removes minimize and maximize buttons
            popupStage.show();

            PauseTransition wait = new PauseTransition(Duration.seconds(3));
            
            GridPane secondaryLayout = new GridPane();
            
            Scene secondScene = new Scene(secondaryLayout, 750, 800);
            //New window (Stage)
            Stage newWindow = new Stage();
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.setTitle("Check");
            newWindow.setScene(secondScene);
            
            //Wait until popup is gone
            wait.setOnFinished((e) -> {
                popupStage.close();
                new CheckUi(secondaryLayout,oc);
                newWindow.show();
                order.EmptyOrder();
                price.setText("€ 0,00");
            });
            wait.play();
        });
        
        btnCancel.setOnAction((event) ->
        {
            order.EmptyOrder();
            oc.deleteCheck();
            price.setText("€ 0,00");
        });
        
        //Styling
        p.setPadding(new Insets(10,10,10,10));
        p.setHgap(10);
        p.setVgap(10);

        //Alignments
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        GridPane.setHalignment(lblName, HPos.CENTER);
        GridPane.setHalignment(lblPhone, HPos.CENTER);
        GridPane.setHalignment(lblAddress, HPos.CENTER);
        GridPane.setHalignment(price, HPos.CENTER);

        //Add to Pane
        p.add(lblTitle, 0, 0, 3, 1);

        p.add(lblName, 0, 1);
        p.add(txtName, 1, 1, 2, 1);

        p.add(lblPhone, 0, 2);
        p.add(txtPhone, 1, 2, 2, 1);

        p.add(lblAddress, 0, 3);
        p.add(txtAddress, 1, 3, 2, 1);

        p.add(size, 0, 4);

        p.add(curst, 1, 4);

        p.add(topping, 2, 4);

        p.add(btnAddToOrder, 1, 5);
        p.add(price, 1, 5,3,1);
        p.add(btnOrder, 1, 6);
        p.add(btnCancel, 2, 6);
        
    }

}
