package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.action.Act;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AddForm extends JFrame {
    private final Font FONT = new Font("Verdana", Font.BOLD, 14);
    private int width = 320;
    private int height = 250;
    private String titleAdd = "Добавить задачу";
    private String titleTask = "Название задачи: ";
    private String titleTextTask = "Текст задачи: ";
    private String titleDateTask = "Время на задачу: ";
    private String titleContactTask = "Номер телефона: ";

    private JPanel panelBottom;

    private JLabel labelTitle;
    private JLabel labelText;
    private JLabel labelDate;
    private JLabel labelContact;

    private JTextField textFieldNameTask;
    private JTextField textFieldContactTask;
    private JTextArea textAreaTextTask;
    private JSpinner spinnerDateTask;

    private Task task;

    public AddForm() {
        setTitle(titleAdd);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        labelTitle = getJLabel(titleTask);
        labelText = getJLabel(titleTextTask);
        labelDate = getJLabel(titleDateTask);
        labelContact = getJLabel(titleContactTask);

        textFieldNameTask = getJTextField(10);
        textAreaTextTask = getJTextArea(56);
        spinnerDateTask = getSpinnerDateModel();
        textFieldContactTask = getJTextField(11);

        panelBottom = getPanelBottomButton();

        Dimension sizeLabelTitle = new Dimension(150, 15);
        Dimension sizeLabelText = new Dimension(150, 15);
        Dimension sizeLabelDate = new Dimension(150, 15);
        Dimension sizeLabelContact = new Dimension(150, 15);

        Dimension sizeTextFieldNameTask = new Dimension(150, 25);
        Dimension sizeTextAreaTextTask = new Dimension(150, 70);
        Dimension sizeSpinnerDateTask = new Dimension(150, 25);
        Dimension sizeTextFieldContactTask = new Dimension(150, 25);

        Dimension sizePanelBottom = new Dimension(300, 30);

        labelTitle.setBounds(5, 8, sizeLabelTitle.width, sizeLabelTitle.height);
        textFieldNameTask.setBounds(160, 5, sizeTextFieldNameTask.width, sizeTextFieldNameTask.height);
        add(labelTitle);
        add(textFieldNameTask);
        labelText.setBounds(20, 60, sizeLabelText.width, sizeLabelText.height);
        textAreaTextTask.setBounds(160, 35, sizeTextAreaTextTask.width, sizeTextAreaTextTask.height);
        add(labelText);
        add(textAreaTextTask);
        labelDate.setBounds(5, 115, sizeLabelDate.width, sizeLabelDate.height);
        spinnerDateTask.setBounds(160, 112, sizeSpinnerDateTask.width, sizeSpinnerDateTask.height);
        add(labelDate);
        add(spinnerDateTask);
        labelContact.setBounds(5, 145, sizeLabelContact.width, sizeLabelContact.height);
        textFieldContactTask.setBounds(160, 142, sizeTextFieldContactTask.width, sizeTextFieldContactTask.height);
        add(labelContact);
        add(textFieldContactTask);
        panelBottom.setBounds(5, 178, sizePanelBottom.width, sizePanelBottom.height);
        add(panelBottom);
    }

    private JLabel getJLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(FONT);
        return label;
    }

    private JTextField getJTextField(int limit) {
        JTextField textField = new JTextField();
        textField.setFont(FONT);
        textField.setPreferredSize(new Dimension(100, 25));
        textField.setDocument(new SymbolLimit(limit));
        return textField;
    }

    private JTextArea getJTextArea(int limit) {
        JTextArea textArea = new JTextArea();
        textArea.setFont(FONT);
        textArea.setPreferredSize(new Dimension(170, 53));
        textArea.setDocument(new SymbolLimit(limit));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(BorderFactory.createEtchedBorder());
        return textArea;
    }

    private  JSpinner getSpinnerDateModel() {
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(dateModel);
        spinner.setValue(new Date());
        spinner.setFont(FONT);
        return spinner;
    }

    private JPanel getPanelBottomButton() {
        JButton buttonAdd = new JButton("Добавить");
        buttonAdd.addActionListener(new AddActionListener());
        JButton buttonСancel = new JButton("Отмена");
        buttonСancel.addActionListener(new CancelActionListener());
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(buttonAdd);
        panel.add(buttonСancel);
        return panel;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    private class AddActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Task tempTask = new Task();
            if (textFieldNameTask.getText().trim().length() > 0) {
                tempTask.setTitle(textFieldNameTask.getText());
                tempTask.setDescription(textAreaTextTask.getText());
                tempTask.setDate((Date) spinnerDateTask.getValue());
                tempTask.setContacts(textFieldContactTask.getText());
//                System.out.println(tempTask.toString());
                setTask(tempTask);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Название задачи не может быть пустым!");
            }
        }
    }

    private class CancelActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}