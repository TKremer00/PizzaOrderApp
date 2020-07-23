package pizzabestellenapp;

import Models.Order;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 *
 * @author tim7v
 */
public class OrderController
{

    private Order order;
    private final String DEFAULT_PATH = "check.png";
    private File file;
    
    public OrderController(Order order)
    {
        this.order = order;
    }
    
    //Make the check file
    public void makeCheck()
    {
        BufferedImage image = new BufferedImage(500, 750, BufferedImage.TYPE_INT_RGB);

        Graphics2D gd2d = image.createGraphics();

        DrawGrapics(gd2d).dispose();
        file = new File(DEFAULT_PATH);
        try
        {
            ImageIO.write(image, "png", file);
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    // Move check to selected path
    public void MoveCheck(String path)
    {
        System.out.println("MOVE TO : " + path);
        try
        {
            Path temp = Files.move(Paths.get(DEFAULT_PATH), Paths.get(path));
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    //Draw the content of the check
    public Graphics2D DrawGrapics(Graphics2D gd2d)
    {
        //Draw background   
        gd2d.setColor(Color.WHITE);
        gd2d.fillRect(0, 0, 500, 750);
        gd2d.setColor(Color.BLACK);

        //Draw border
        gd2d.drawRect(1, 1, 498, 650);
        gd2d.drawRect(1, 650, 498, 98);

        //Draw title
        gd2d.setFont(new Font("Verdana", Font.BOLD, 32));
        gd2d.drawString("Tim's Pizza", 160, 30);
        gd2d.drawLine(10, 40, 490, 40);

        //Draw amount pizzas.
        gd2d.setFont(new Font("Verdana", Font.BOLD, 16));

        for (int i = 0; i < order.getOrder().size(); i++)
        {
            gd2d.setColor(Color.BLACK);
            gd2d.setFont(new Font("Verdana", Font.BOLD, 16));
            gd2d.drawString(order.getOrder().get(i).get(0), 10, 70 + (i * 40));
            gd2d.drawString(order.getOrder().get(i).get(1), 400, 70 + (i * 40));
            gd2d.setFont(new Font("Verdana", Font.BOLD, 13));
            gd2d.drawString(order.getOrder().get(i).get(2), 20, 90 + (i * 40));
        }

        //Draw total price
        gd2d.setFont(new Font("Verdana", Font.BOLD, 16));
        gd2d.drawString("+", 370, 615);
        gd2d.drawLine(380, 615, 490, 615);
        gd2d.drawString(order.getTotalCost(), 400, 635);

        //User data on the check.
        gd2d.setFont(new Font("Verdana", Font.BOLD, 13));
        gd2d.drawString(order.getUser().getName(), 10, 680);
        gd2d.drawString(order.getUser().getAddress(), 10, 700);
        gd2d.drawString(order.getUser().getPhoneNumber(), 10, 720);

        return gd2d;
    }
    
    public File getFile()
    {
        if (file.exists())
        {
            return file;
        }
        return null;
    }

    public void deleteCheck()
    {
        File file = new File(DEFAULT_PATH);
        file.delete();
    }

}
