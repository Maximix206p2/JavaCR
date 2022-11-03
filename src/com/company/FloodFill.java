package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FloodFill {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = new JFrame("Flood fill");
        jFrame.setSize(500, 300);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setContentPane(new DrawPane());
        jFrame.repaint();
        jFrame.setVisible(true);
    }
}

class DrawPane extends JPanel {
    BufferedImage bufferedImage = null;
    int color;

    DrawPane() throws IOException {
        File file = new File("src/com/company/image.jpg");//сферический конь
        //File file = new File("C:/Users/гк/Pictures/image.bmp");
        bufferedImage = ImageIO.read(file);
        addMouseListener(new MouseAdapter() { //Кнопка нажата
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX(); //Координата x
                int y = e.getY(); //Координата y
                color = bufferedImage.getRGB(x, y);
                //bufferedImage.setRGB(x, y, new Color(255,0,0).getRGB());
                floodFill(x,y);
                System.out.printf("x = %d, y = %d, color=%d%n", x, y, color); //Отслеживание координат нажатия и цвета
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    void floodFill(int x, int y){
        int colorCurr = bufferedImage.getRGB(x,y);
        if (color!=colorCurr) return;
        bufferedImage.setRGB(x,y,new Color(255,0,0).getRGB());
        floodFill(x-1,y);
        floodFill(x+1,y);
        floodFill(x,y+1);
        floodFill(x,y-1);
    }
}
