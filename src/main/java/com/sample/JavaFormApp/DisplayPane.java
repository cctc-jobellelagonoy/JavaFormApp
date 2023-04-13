package com.sample.JavaFormApp;
import javax.swing.*;

public class DisplayPane extends JScrollPane {
    private JTextArea outputArea;

    public DisplayPane() {
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        setViewportView(outputArea);
    }

    public void addPerson(Person person) {
        outputArea.append(person.toString());
    }
    
}

