package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFrame extends JFrame implements ActionListener {

    //Screen Variables

    private final int SCREEN_HEIGHT = 400;
    private final int SCREEN_WIDTH = 600;
    private final Color BG_COLOR = new Color(200, 200, 200);
    private final Color TITLE_COLOR = new Color(80, 50, 200);
    private final Font TITLE_FONT = new Font("MV Boli", Font.BOLD, 30);
    Graphics g;  //does not work because g is null

    //Fretboard Variables

    final int FIRST_STRING_LEFT_CORNER_X = 75;
    final int FIRST_STRING_LEFT_CORNER_Y = 200;
    final int STRING_SPACING = 15;
    final int FRET_SPACING = 36;
    final int HALF_FRET_SPACING = FRET_SPACING / 2;
    final int FIRST_FRET_X = FIRST_STRING_LEFT_CORNER_X + HALF_FRET_SPACING;

    final int NUM_OF_FRETS = 12;
    final int NUM_OF_STRING = 6;

    final BasicStroke FRET_THICKNESS = new BasicStroke(4);
    final BasicStroke STRING_THICKNESS = new BasicStroke(2);

    //Note Placement Variables

    final String[] NOTE_NAMES = {"A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab"};

    //Note Indexes for Buttons and Names

    final int A_INDEX = 0;
    final int A_SHARP_INDEX = 1;
    final int B_INDEX = 2;
    final int C_INDEX = 3;
    final int C_SHARP_INDEX = 4;
    final int D_INDEX = 5;
    final int D_SHARP_INDEX = 6;
    final int E_INDEX = 7;
    final int F_INDEX = 8;
    final int F_SHARP_INDEX = 9;
    final int G_INDEX = 10;
    final int G_SHARP_INDEX = 11;
    final int CLEAR_INDEX = 12;
    final int SHOW_ALL_INDEX = 13;

    //Note size variables

    final int NOTE_RADIUS = 5;
    //final int HALF_NOTE_RAD = NOTE_RADIUS / 2;

    //Note Locations in {fret, string} notation with the 0 string corresponding to the high E string and 0 fret referring to open string.

    final int[][] A_LOCATIONS = {{0, 4}, {2, 2}, {5, 5}, {5, 0}, {7, 3}, {10, 1}, {12, 4}};
    final int[][] A_SHARP_LOCATIONS = {{1, 4}, {3, 2}, {6, 5}, {6, 0}, {8, 3}, {11, 1}};
    final int[][] B_LOCATIONS = {{0, 1}, {2, 4}, {4, 2}, {7, 0}, {7, 5}, {9, 3}, {12, 1}};
    final int[][] C_LOCATIONS = {{1, 1}, {3, 4}, {5, 2}, {8, 0}, {8, 5}, {10, 3}};
    final int[][] C_SHARP_LOCATIONS = {{2, 1}, {4, 4}, {6, 2}, {9, 0}, {9, 5}, {11, 3}};
    final int[][] D_LOCATIONS = {{0, 3}, {3, 1}, {5, 4}, {7, 2}, {10, 0}, {10, 5}, {12, 3}};
    final int[][] D_SHARP_LOCATIONS = {{1, 3}, {4, 1}, {6, 4}, {8, 2}, {11, 0}, {11, 5}};
    final int[][] E_LOCATIONS = {{0, 0}, {0, 5}, {2, 3}, {5, 1}, {7, 4}, {9, 2}, {12, 0}, {12, 5}};
    final int[][] F_LOCATIONS = {{1, 0}, {1, 5}, {3, 3}, {6, 1}, {8, 4}, {10, 2}};
    final int[][] F_SHARP_LOCATIONS = {{2, 0}, {2, 5}, {4, 3}, {7, 1}, {9, 4}, {11, 2}};
    final int[][] G_LOCATIONS = {{0, 2}, {3, 0}, {3, 5}, {5, 3}, {8, 1}, {10, 4}, {12, 2}};
    final int[][] G_SHARP_LOCATIONS = {{1, 2}, {4, 0}, {4, 5}, {6, 3}, {9, 1}, {11, 4}};

    final int [][][] ALL_NOTE_LOCATIONS = {A_LOCATIONS, A_SHARP_LOCATIONS, B_LOCATIONS, C_LOCATIONS, C_SHARP_LOCATIONS,
    D_LOCATIONS,D_SHARP_LOCATIONS, E_LOCATIONS, F_LOCATIONS, F_SHARP_LOCATIONS, G_LOCATIONS, G_SHARP_LOCATIONS};



    //Note display colors

    final Color A_COLOR = Color.red;
    final Color A_SHARP_COLOR = Color.ORANGE;
    final Color B_COLOR = Color.gray;
    final Color C_COLOR = Color.green;
    final Color C_SHARP_COLOR = new Color(0, 160, 0);
    final Color D_COLOR = Color.BLUE;
    final Color D_SHARP_COLOR = new Color(0, 0, 120);
    final Color E_COLOR = Color.CYAN;
    final Color F_COLOR = new Color(153, 0, 255);
    final Color F_SHARP_COLOR = new Color(110, 0, 100);
    final Color G_COLOR = new Color(255, 153, 153);
    final Color G_SHARP_COLOR = Color.MAGENTA;

    final Color[] BUTTON_COLORS = {A_COLOR, A_SHARP_COLOR, B_COLOR, C_COLOR, C_SHARP_COLOR, D_COLOR,
            D_SHARP_COLOR, E_COLOR, F_COLOR, F_SHARP_COLOR, G_COLOR, G_SHARP_COLOR};

    //Create buttons to show notes

    //JButton clickToShowA = new JButton();

    //Button control to show the notes
    List<JButton> noteButtons = new ArrayList<>();

    //booleans to control the buttons

    boolean showANotes = true;
    boolean showASharpNotes = true;
    boolean showBNotes = true;
    boolean showCNotes = true;
    boolean showCSharpNotes = true;
    boolean showDNotes = true;
    boolean showDSharpNotes = true;
    boolean showENotes = true;
    boolean showFNotes = true;
    boolean showFSharpNotes = true;
    boolean showGNotes = true;
    boolean showGSharpNotes = true;

    //boolean [] showNotesControl = {showANotes, showASharpNotes, showBNotes, showCNotes, showCSharpNotes, showDNotes, showDSharpNotes, showENotes, showFNotes, showFSharpNotes, showGNotes, showGSharpNotes};
    boolean [] showNotesControl = {true, true, true, true, true, true, true, true, true, true, true, true};
    MyFrame() {

        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT); //sets x and y dimension
        this.setTitle("Guitar Fretboard Guide");//sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of app
        this.setResizable(false); //prevents frame from resizing
        this.setVisible(true);  //Make frame visible
        this.setLayout(new FlowLayout());

        ImageIcon image = new ImageIcon("Guitar Icon.png"); //Create image icon
        this.setIconImage(image.getImage()); //set icon image

        this.getContentPane().setBackground(BG_COLOR); //change background color

        //Add the title to the JFrame

        JLabel title = new JLabel(); //Create a label

        title.setText("GUITAR FRETBOARD GUIDE"); // Set text of label
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(TITLE_COLOR); //set text color
        title.setFont(TITLE_FONT); //set font of text
        //title.setBounds(0,0,50, 50);
        this.add(title);

        //Add Fret Labels

//        JLabel fret0 = new JLabel(); //Create a label
//
//        fret0.setText("0"); // Set text of label
//        //fret0.setVerticalAlignment(JLabel.TOP);
//        //fret0.setHorizontalAlignment(JLabel.CENTER);
//        fret0.setForeground(TITLE_COLOR); //set text color
//        fret0.setFont(TITLE_FONT); //set font of text
//        fret0.setLocation(300, 300);
//        this.add(fret0);

        //JPanel for Buttons

        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBounds(50, 300, 80, 60);
        buttonPanel.setPreferredSize(new Dimension(500, 70));
        buttonPanel.setBackground(BG_COLOR);

        //Create and Add Note buttons to panel

        for (int i = 0; i < BUTTON_COLORS.length; i++) {
            JButton button = new JButton();
            button.addActionListener(this);
            button.setForeground(Color.white);
            button.setText(NOTE_NAMES[i]);
            button.setFocusable(false);
            button.setBackground(BUTTON_COLORS[i]);
            buttonPanel.add(button);
            noteButtons.add(button);
        }

        this.add(buttonPanel);

        //Add Clear and Show All Buttons

        JButton clearButton = new JButton();
        clearButton.addActionListener(this);
        clearButton.setForeground(Color.white);
        clearButton.setText("Clear");
        clearButton.setFocusable(false);
        clearButton.setBackground(Color.BLACK);
        buttonPanel.add(clearButton);
        noteButtons.add(clearButton);
        this.add(buttonPanel);

        JButton showAllButton = new JButton();
        showAllButton.addActionListener(this);
        showAllButton.setForeground(Color.white);
        showAllButton.setText("Show All");
        showAllButton.setFocusable(false);
        showAllButton.setBackground(Color.darkGray);
        buttonPanel.add(showAllButton);
        noteButtons.add(showAllButton);
        this.add(buttonPanel);

//        clickToShowA.setBounds(300, 300, 10, 10);
//        clickToShowA.addActionListener(this);
//        clickToShowA.setText(NOTE_NAMES[0]);
//        clickToShowA.setFocusable(false);
//        clickToShowA.setBackground(A_COLOR);
//        this.add(clickToShowA);
//        buttonPanel.add(clickToShowA);
//
//        this.add(buttonPanel);

    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);  //set color of strings and frets

        for (int row = 0; row < NUM_OF_STRING; row++) {

            //Draw guitar strings
            g2.setStroke(STRING_THICKNESS);
            g2.drawLine(FIRST_STRING_LEFT_CORNER_X,
                    FIRST_STRING_LEFT_CORNER_Y + row * STRING_SPACING,
                    FIRST_STRING_LEFT_CORNER_X + FRET_SPACING * NUM_OF_FRETS + HALF_FRET_SPACING,
                    FIRST_STRING_LEFT_CORNER_Y + row * STRING_SPACING);
        }

        for (int col = 0; col <= NUM_OF_FRETS; col++) {

            //Draw frets
            g2.setStroke(FRET_THICKNESS);
            g2.drawLine(FIRST_FRET_X + col * FRET_SPACING,
                    FIRST_STRING_LEFT_CORNER_Y,
                    FIRST_FRET_X + col * FRET_SPACING,
                    FIRST_STRING_LEFT_CORNER_Y + STRING_SPACING * (NUM_OF_STRING - 1));
        }

        //Draw the fret labels (doesn't work)

//        g2.setColor(Color.black);
//        g2.setFont(new Font("MV Boli", Font.PLAIN, 10));
//        g2.drawString("0", 200, 200);

        //Draw the notes

        //Loop to draw all the notes based on the show conditions

        for (int i = 0; i < NOTE_NAMES.length;i++) {
            if (showNotesControl[i]) {
                addNotesToFretboard(ALL_NOTE_LOCATIONS[i], g, NOTE_NAMES[i], BUTTON_COLORS[i]);
            }
            else {
                addNotesToFretboard(ALL_NOTE_LOCATIONS[i], g, NOTE_NAMES[i], Color.white);
            }
        }
    }

    public List<NoteMarker> addNotesToFretboard(int[][] locations, Graphics g, String noteNames, Color color) {
        List<NoteMarker> noteMarkers = new ArrayList<>();
        for (int[] loc : locations) {
            NoteMarker note = new NoteMarker(NOTE_RADIUS,
                    loc[0] * FRET_SPACING + FIRST_STRING_LEFT_CORNER_X,
                    loc[1] * STRING_SPACING + FIRST_STRING_LEFT_CORNER_Y, noteNames, color);
            note.draw(g);
            noteMarkers.add(note);  //Attempt to change the color using an ArrayList of NoteMarkers
        }
        return noteMarkers;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < showNotesControl.length; i ++) {

            if (e.getSource() == noteButtons.get(i)) {
                showNotesControl[i] = !showNotesControl[i];
                //System.out.println(showNotesControl[i]);
                repaint();
            }
        }

        if (e.getSource() == noteButtons.get(CLEAR_INDEX)) {
            showNotesControl = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false};
            repaint();
        }
        else if (e.getSource() == noteButtons.get(SHOW_ALL_INDEX)) {
            showNotesControl = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true};
            repaint();
        }

    }
}
