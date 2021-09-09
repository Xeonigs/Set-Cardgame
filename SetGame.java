import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * @author Dave
 */
public class SetGame extends JFrame {

    public SetGame() throws IOException {
        super("Set - Cardgame");
        setLayout(new BorderLayout());
        add(new GamePanel(), BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]) throws IOException {
        new SetGame();
    }
}
