import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GamePanel extends JPanel implements ComponentListener, ActionListener, KeyListener, MouseListener {
    public static int width;
    public static int height;

    private Timer timer;
    private Deck deck;
    private Table table;
    private Player player;


    public GamePanel() throws IOException {
        super();
        setPreferredSize(new Dimension(1600, 900));
        addComponentListener(this);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocus();

        width = getPreferredSize().width;
        height = getPreferredSize().height;

        deck = new Deck();
        table = new Table();
        player = new Player();
    }

    @Override
    // instance
    public void addNotify() {
        super.addNotify();

        timer = new Timer(0, this);
        timer.start();

        for (int i = 0; i < 4; i++)
            table.addThreeCards(deck.pickThreeCards());
    }

    @Override
    // executing loop
    public void actionPerformed(ActionEvent e) {
        table.update(deck);

        repaint();

        if (!table.isSetAvailable() && deck.getCardsInDeck() <= 0) {
            JOptionPane.showMessageDialog(null, "No set is available and no cards left in deck." + System.lineSeparator() +
                    "Number of sets: " + player.getNumberOfSets() + System.lineSeparator() +
                    "Cards left on table: " + table.getNumberOfCardsOnTable() + System.lineSeparator() + System.lineSeparator() +
                    "The game will be automatically reset.", "Finish", JOptionPane.INFORMATION_MESSAGE);
            deck.resetDeck(table, player);
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Sets
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Courier New", 1, 17));
        graphics2D.drawString("Sets: " + player.getNumberOfSets(), width - 250, 50);
        graphics2D.drawString("Cards selected: " + player.getNumberOfSelectedCards(), width - 250, 70);
        graphics2D.drawString("Cards on Table: " + table.getNumberOfCardsOnTable(), width - 250, 90);
        graphics2D.drawString("Cards in Deck: " + deck.getCardsInDeck(), width - 250, 130);
        graphics2D.drawString("Hotkeys:", width - 250, 260);
        graphics2D.drawString("Add more cards: +", width - 250, 290);
        graphics2D.drawString("Find a set: F", width - 250, 310);
        graphics2D.drawString("Reset game: R", width - 250, 330);

        table.paintTable(graphics2D);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ADD)
            if (!table.isTableFull() && deck.getCardsInDeck() > 0)
                table.addThreeCards(deck.pickThreeCards());

        if (e.getKeyCode() == KeyEvent.VK_R && JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the game?", "Reset game", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            deck.resetDeck(table, player);
        if (e.getKeyCode() == KeyEvent.VK_W) table.playerOnMove = player;
        if (e.getKeyCode() == KeyEvent.VK_F) table.searchForSet();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        table.addPlayerSelectedCard(e, player);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
