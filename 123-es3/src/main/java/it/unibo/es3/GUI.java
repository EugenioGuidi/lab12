package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> cells = new HashMap<>();
    private final Logics logics;
    
    public GUI(int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        JButton nextButton = new JButton(">");
        this.getContentPane().add(nextButton, BorderLayout.SOUTH);
        
        nextButton.addActionListener(b -> {
            logics.hit();
            Set<Pair<Integer, Integer>> setTotal = logics.getSet();
            for(Pair<Integer, Integer> pair : setTotal) {
                for(Map.Entry<JButton, Pair<Integer, Integer>> entry : cells.entrySet()) {
                    if(entry.getValue().equals(pair)) {
                        entry.getKey().setText("*");
                    }
                }
            }
            if(logics.toQuit()) {
                System.exit(0);
            }
        });
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton("");
                this.cells.put(jb, new Pair<Integer,Integer>(i, j));
                panel.add(jb);
            }
        }

        Set<Pair<Integer, Integer>> setTotal = logics.getSet();
        for(Pair<Integer, Integer> pair : setTotal) {
            for(Map.Entry<JButton, Pair<Integer, Integer>> entry : cells.entrySet()) {
                if(entry.getValue().equals(pair)) {
                    entry.getKey().setText("*");
                }
            }
        }

        this.setVisible(true);
    }
    
}