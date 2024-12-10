package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*size, 70*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        JButton nextMove = new JButton(">");
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, nextMove);

        ActionListener al = (e) -> {
            final int[][] matrix = logics.hit();
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 1) {
                        Pair<Integer, Integer> pair = new Pair<>(i, j);
                        for(Map.Entry<JButton, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
                            if(entry.getValue().equals(pair)) {
                                JButton button = entry.getKey();
                                button.setText("*");
                            }
                        }
                    }
                }
            }
            if (logics.toQuit()) {
                System.exit(0);
            }
        };

        nextMove.addActionListener(al);
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                this.buttons.put(jb, new Pair<>(i, j));
                panel.add(jb);
                jb.setEnabled(false);
            }
        }
        this.setVisible(true);
        final int[][] matrix = logics.getMatrix();
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 1) {
                        Pair<Integer, Integer> pair = new Pair<>(i, j);
                        for(Map.Entry<JButton, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
                            if(entry.getValue().equals(pair)) {
                                JButton button = entry.getKey();
                                button.setText("*");
                            }
                        }
                    }
                }
            }
    };
}