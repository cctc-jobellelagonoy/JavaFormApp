package com.sample.JavaFormApp;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.function.Consumer;

public class PersonForm extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JDatePickerImpl birthDatePicker;
    private JTextField emailField;
    private JComboBox<String> sexComboBox;

    public PersonForm(Consumer<Person> onSubmit) {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Birth Date:"));
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        birthDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        add(birthDatePicker);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Sex:"));
        sexComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        add(sexComboBox);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(e -> {
            if (isFormValid()) {
                SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
                String birthDate = sdf.format(birthDatePicker.getModel().getValue());

                Person person = new Person(
                        firstNameField.getText(),
                        lastNameField.getText(),
                        birthDate,
                        emailField.getText(),
                        (String) sexComboBox.getSelectedItem()
                );
                onSubmit.accept(person);

                // Clear form fields
                firstNameField.setText("");
                lastNameField.setText("");
                birthDatePicker.getModel().setValue(null);
                emailField.setText("");
                sexComboBox.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Please fill in all required fields.",
                        "Form Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private boolean isFormValid() {
        return !firstNameField.getText().trim().isEmpty() &&
                !lastNameField.getText().trim().isEmpty() &&
                birthDatePicker.getModel().getValue() != null &&
                !emailField.getText().trim().isEmpty() &&
                sexComboBox.getSelectedItem() != null;
    }
}
