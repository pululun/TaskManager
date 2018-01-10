package es.esy.kapcapx.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteForm extends JFrame{
    private final Font FONT = new Font("Verdana", Font.BOLD, 14);
    private int width = 320;
    private int height = 150;
    private String titleDelete = "Удалить задачу";
    private String titleMessage = "Введите название задачи";
    private String errorMessageNoName = "Не введено название задачи";
    private JLabel jlabelMessage;
    private JTextField jTextFieldDelete;
    private JPanel jPanelBottom;
    private String titleTask;

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public DeleteForm() {
        setTitle(titleDelete);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        jlabelMessage = getJLabel(titleMessage);
        jTextFieldDelete = getJTextField(10);
        jPanelBottom = getPanelBottomButton();

        Dimension sizeJlabelMessage = new Dimension(300, 15);
        Dimension sizeJtextFieldDelete = new Dimension(150, 25);
        Dimension sizeJpanelBottom = new Dimension(300, 30);

        jlabelMessage.setBounds(50, 5, sizeJlabelMessage.width, sizeJlabelMessage.height);
        add(jlabelMessage);
        jTextFieldDelete.setBounds(80, 35, sizeJtextFieldDelete.width, sizeJtextFieldDelete.height);
        add(jTextFieldDelete);
        jPanelBottom.setBounds(10, 75, sizeJpanelBottom.width, sizeJpanelBottom.height);
        add(jPanelBottom);
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

    private JPanel getPanelBottomButton() {
        JButton buttonAdd = new JButton("Удалить");
        buttonAdd.addActionListener(new AddActionListener());
        JButton buttonСancel = new JButton("Отмена");
        buttonСancel.addActionListener(new CancelActionListener());
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(buttonAdd);
        panel.add(buttonСancel);
        return panel;
    }

    public String getTitleTask() {
        return titleTask;
    }

    private class AddActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if (jTextFieldDelete.getText().trim().length() > 0) {
                setTitleTask(jTextFieldDelete.getText());
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, errorMessageNoName);
            }
        }
    }

    private class CancelActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
