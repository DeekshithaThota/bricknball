import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Main {
    public static void main(String[] args) {
        Game_imp gi= new Game_imp();
        game g = new game();
        g.add(gi);

    }
}
class game extends JFrame{
    game(){
        setTitle("Brick n Ball");
        setVisible(true);
        //setLayout(new FlowLayout());
        setBounds(10,10,700,600);
        setResizable(false);
        setDefaultCloseOperation(3);
        


    }


}