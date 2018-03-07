package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class TaskRenderer extends JPanel implements ListCellRenderer<Task> {
    private int width = 480;
    private int height = 130;
    private JLabel lTitle = new JLabel();
    private JLabel lDescription = new JLabel();
    private JLabel lDate = new JLabel();
    private JLabel lContacts = new JLabel();

    public TaskRenderer() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        add(lTitle);
        add(lDescription);
        add(lDate);
        add(lContacts);
        Insets insets = this.getInsets();
        Dimension sizeTitle = new Dimension(160, 15);
        Dimension sizeDescription = new Dimension(480, 15);
        Dimension sizeDate = new Dimension(235, 15);
        Dimension sizeContacts = new Dimension(160, 15);
        lTitle.setBounds(2 + insets.left, 2 + insets.top, sizeTitle.width, sizeTitle.height);
        lDescription.setBounds(12 + insets.left, 50 + insets.top, sizeDescription.width, sizeDescription.height);
        lDate.setBounds(240 + insets.left, 2 + insets.top, sizeDate.width, sizeDate.height);
        lContacts.setBounds(330 + insets.left, 110 + insets.top, sizeContacts.width, sizeContacts.height);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Task> list, Task task, int index, boolean isSelected, boolean cellHasFocus) {
        lTitle.setText(task.getTitle());
        lDescription.setText(task.getDescription());
        lDate.setText(task.getDate().toString());
        lContacts.setText(task.getContacts());
        this.setOpaque(true);
        if (task.getChecked()) {
            lDate.setForeground(Color.RED);
            lTitle.setForeground(Color.RED);
        } else {
            lDate.setForeground(Color.BLACK);
            lTitle.setForeground(Color.BLACK);
        }
        if (isSelected) {
            this.setBackground(list.getSelectionBackground());
        } else {
            this.setBackground(list.getBackground());
        }
        return this;
    }
}
