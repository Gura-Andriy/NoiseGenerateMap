package com.gura.other;

import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        initUI();
    }

    private void initUI() {
        var frame = new Noise();
        //add(frame);

        setSize(350, 250);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
