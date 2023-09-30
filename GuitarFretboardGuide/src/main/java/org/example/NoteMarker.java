package org.example;

import java.awt.*;

public class NoteMarker {

    private int radius;
    private int xPos;
    private int yPos;
    private String noteName;
    private Color noteColor;
    private Font noteFont = new Font("MV Boli", Font.PLAIN, 10);
    private Color noteNameColor = Color.white;

    public NoteMarker(int radius, int xPos, int yPos, String noteName, Color noteColor) {
        this.radius = radius;
        this.xPos = xPos;
        this.yPos = yPos;
        this.noteName = noteName;
        this.noteColor = noteColor;
    }

    public int getRadius() {
        return radius;
    }

    public void draw (Graphics g) {
        //Draw NoteMarker
        g.setColor(noteColor);
        g.fillOval(xPos - radius, yPos -radius, 2 * radius, 2* radius);

        //Draw NoteMarker label (doesn't work.  Results in visual glitch)
        g.setFont(noteFont);
        g.setColor(noteNameColor);
        //g.drawString(noteName, xPos, yPos);

    }

    public void disappear() {
        //Method to remove the NoteMarkers from the fretboard by turning them white
        noteColor = Color.white;
    }

    public void setNoteColor(Color noteColor) {
        this.noteColor = noteColor;
    }
}
