package com.company;

import com.company.NumSquare;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GamePanel extends JPanel {
    int columns;
    int rows;
    NumSquare[][] numbers;
    public GamePanel(int xSize,int ySize){
        init(xSize,ySize);
        this.setBackground(new Color(0x6A6155));
    }
    void init(int xSize,int ySize){
        removeAll();
        columns = xSize;
        rows = ySize;
        setLayout(new GridLayout(rows, columns));
        numbers = new NumSquare[columns][rows];
        for (int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                numbers[col][row] = new NumSquare(0);
                add(numbers[col][row]);
            }
        }
    }

    public int getValue(int columns, int rows) {
        NumSquare num = numbers[columns][rows];
        return num.getValue();
    }

    public void setValue(int columns, int rows,int value) {
        NumSquare num = numbers[columns][rows];
        num.setValue(value);
    }
}

