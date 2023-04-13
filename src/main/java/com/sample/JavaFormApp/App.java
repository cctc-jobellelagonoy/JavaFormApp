package com.sample.JavaFormApp;

import javax.swing.*;
import java.awt.*;

public class App {
    private JFrame frame;
    private PersonForm personForm;
    private DisplayPane displayPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App app = new App();
                app.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public App() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        personForm = new PersonForm(this::addPerson);
        frame.getContentPane().add(personForm, BorderLayout.NORTH);

        displayPane = new DisplayPane();
        frame.getContentPane().add(displayPane, BorderLayout.CENTER);
    }

    private void addPerson(Person person) {
        displayPane.addPerson(person);
    }
}
