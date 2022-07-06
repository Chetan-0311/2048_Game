package com.company;

import javax.swing.*;
import java.awt.*;

public class NumSquare extends JComponent {
    static final int scale = 107 ;
    static final int border = scale/20;
    static final int fontSize = (int)(scale * 0.4);
    static final Font font = new Font("Consolas", Font.PLAIN, fontSize);
    private int value;

    public NumSquare(int value){
        this.value = value;
        setFont(font);
        setPreferredSize(new Dimension(scale,scale));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void paintComponent(Graphics g){
        ((Graphics2D)g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();


        Color color;
        if (value == 0) {
            color = new Color(255, 254, 254);
        }
        else if(value == 2 ){
         color= new Color(0xF6D9AE);
        }
        else if(value == 4 ){
            color= new Color(0xD8A864);
        }
        else if(value == 8 ){
            color= new Color(0xFDA648);
        }
        else if(value == 16 ){
            color= new Color(0xFF8C40);
        }else if(value == 32 ){
            color= new Color(0xFA6604);
        }
        else if(value == 64 ){
            color= new Color(0xFB1D1D);
        }
        else if(value == 128 ){
            color= new Color(0xFFFF07);
        }
        else if(value == 256 ){
            color= new Color(0xFF9600);
        }
        else if(value ==  512){
            color= new Color(0xE2FB00);
        }
        else if(value == 1024 ){
            color= new Color(0x14CAF4);
        }
        else {
            color = new Color(0);
        }
        g.setColor(color);
        g.fillRoundRect(0,0,100,100,scale/10,scale/10);
        if(value==0){
            g.setColor(Color.white);
        }
        else {
            g.setColor(Color.black);
        }
        FontMetrics metrics = getFontMetrics(font);;
        String txt = Integer.toString(value);
        g.drawString(txt,
                (getWidth() - metrics.stringWidth(txt)) / 2,
                getHeight() / 2 + metrics.getAscent() / 3);
    }
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x645848));
        panel.add(new NumSquare(16));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
