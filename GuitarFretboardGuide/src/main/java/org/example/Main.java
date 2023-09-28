package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame();

        myFrame.repaint();
        myFrame.revalidate();
        //myFrame.pack();

    }
}

