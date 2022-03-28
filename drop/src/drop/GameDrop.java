package drop;

import javax.swing.*;
import java.awt.*;

public class GameDrop extends JFrame {
    private static GameDrop Game_Drop;


    public static void main(String[] args) {
        Game_Drop = new GameDrop();
        Game_Drop.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Game_Drop.setLocation(200,100);
        Game_Drop.setSize(906,478);
        Game_Drop.setResizable(false);
        GameField game_field = new GameField();
        Game_Drop.add(game_field);
        Game_Drop.setVisible(true);

    }
    private static void onRepaint(Graphics g){
       g.fillOval(10,10,200,100);
       g.drawLine(10,5,100,220);



    }
    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);

        }
    }
}
