package drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameDrop extends JFrame {
    private static GameDrop Game_Drop;
    private static long LastFrameTime;
    private static Image backgrounr;
    private static Image GameOver;
    private static Image Drop;
    private static float DropLeft = 200;
    private static float DropTop = -100;
    private static float DropV= 200;
    private static int score;

    public static void main(String[] args) throws IOException {
        backgrounr = ImageIO.read(GameDrop.class.getResourceAsStream("background.png"));
        GameOver = ImageIO.read(GameDrop.class.getResourceAsStream("game_over.png"));
        Drop = ImageIO.read(GameDrop.class.getResourceAsStream("drop.png"));
        Game_Drop = new GameDrop();
        Game_Drop.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Game_Drop.setLocation(200,100);
        Game_Drop.setSize(906,478);
        Game_Drop.setResizable(false);
        LastFrameTime = System.nanoTime();
        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_right = DropLeft + Drop.getWidth(null);
                float drop_bottom = DropTop + Drop.getHeight(null);
                boolean is_drop = x >= DropLeft && x <= drop_right && y >= DropTop && y <= drop_bottom;
                if (is_drop) {
                    DropTop = -100;
                    DropLeft = (int) (Math.random() * (game_field.getWidth() - Drop.getWidth(null)));
                    DropV = DropV + 20;
                    score ++;
                    Game_Drop.setTitle("Score: " + score);


                }
            }
        });
        Game_Drop.add(game_field);
        Game_Drop.setVisible(true);
    }

    private static void onRepaint(Graphics g){
        long CurrentTime = System.nanoTime();
        float DeltaTame = (CurrentTime - LastFrameTime) * 0.000000001f;
        LastFrameTime = CurrentTime;
        DropTop = DropTop + DropV * DeltaTame;
        g.drawImage(backgrounr,0,0,null);
        g.drawImage(Drop,(int)DropLeft,(int)DropTop,null);
        if (DropTop > Game_Drop.getHeight ()) g.drawImage(GameOver,280,120,null);
    }

    private static class GameField extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
