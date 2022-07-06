package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {
    static JPanel panelMain;
    static GamePanel panelGame;
    static JPanel panelButtons;
    JButton right,left,up,down;
    static GameCode game;

    public GameFrame() {
        panelButtons = new JPanel();
        panelButtons.setBackground(new Color(112, 70, 225));
        panelButtons.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        left = new JButton("Slide Left");
        left.setFocusable(false);
        constraints.gridx = 0;constraints.gridy = 200;
        panelButtons.add(left, constraints);

        right = new JButton("Slide Right");
        right.setFocusable(false);
        constraints.gridx = 200; constraints.gridy =200;
        panelButtons.add(right, constraints);

        up = new JButton("Slide Up");
        up.setFocusable(false);
        constraints.gridx = 50; constraints.gridy = 0;
        panelButtons.add(up, constraints);

        down = new JButton("Slide Down");
        down.setFocusable(false);
        constraints.gridx = 50; constraints.gridy = 400;
        panelButtons.add(down, constraints);

        game = new GameCode(4,4);

        Dimension dem = new Dimension(600, 600);
        panelGame = new GamePanel(game.COLUMNS, game.ROWS);



        panelMain = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelMain, BoxLayout.Y_AXIS);
        panelMain.setLayout(boxLayout);
        panelMain.add(panelGame);
        panelMain.setBackground(Color.black);
        panelMain.add(panelButtons);

        game.addNew2();
        game.addNew2();
        updateNumSquares();

        left.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        game.slideLeft();
                        game.addNew2();
                        updateNumSquares();
                    }
                }
        );
        right.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        game.slideRight();
                        game.addNew2();
                        updateNumSquares();
                    }
                }
        );
        up.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        game.slideUp();
                        game.addNew2();
                        updateNumSquares();
                    }
                }
        );
        down.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        game.slideDown();
                        game.addNew2();
                        updateNumSquares();
                    }
                }
        );
        panelGame.repaint();

        addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_UP){
                            game.slideUp();
                            game.addNew2();
                            updateNumSquares();
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                            game.slideDown();
                            game.addNew2();
                            updateNumSquares();
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                            game.slideLeft();
                            game.addNew2();
                            updateNumSquares();
                        }
                        else{
                            game.slideRight();
                            game.addNew2();
                            updateNumSquares();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
    }

    public void updateNumSquares(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                panelGame.setValue(i,j,game.getCellValue(i,j));
            }
        }
        panelGame.repaint();
        if(!game.canPlay()){
            gameOver();
        }
    }

    void gameOver(){
        String[] options = {"New Game","Exit"};
        int result = JOptionPane.showOptionDialog(
                this,
                "Game over.\nYour score was " + game.getScore(),
                "Game Over!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        if(result == JOptionPane.YES_OPTION){
            newGame();
        }
        else{
            System.exit(0);
        }
    }
    void newGame(){
        game = new GameCode(4,4);
        game.addNew2();
        game.addNew2();
        updateNumSquares();
        pack();
    }

    public static void run() {

        GameFrame frame = new GameFrame();
        frame.add(panelMain);
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
