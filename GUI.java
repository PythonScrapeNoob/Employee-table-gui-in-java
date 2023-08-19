import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI{


    //Have a welcome page
    //Have a list of employees
    //click on them which brings to a page which displays their info


     public static void main(String[] args){
         
            JFrame frame = new JFrame("EMployee Management software");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SwingUtilities.invokeLater(() ->{
            String[] columnNames = {"First Name", "Salary", "Last Name", "ID"};

            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; 
                }

            };

            JTable table = new JTable(tableModel);

            JScrollPane scrollPane = new JScrollPane(table);

            JTextField firstNameField = new JTextField(10);
            JTextField salaryField = new JTextField(10);
            JTextField lastNameField = new JTextField(10);
            JTextField idField = new JTextField(10);

            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("First Name:"));
            inputPanel.add(firstNameField);
            inputPanel.add(new JLabel("Salary:"));
            inputPanel.add(salaryField);
            inputPanel.add(new JLabel("Last Name:"));
            inputPanel.add(lastNameField);
            inputPanel.add(new JLabel("ID:"));
            inputPanel.add(idField);

            JButton addButton = new JButton("Add");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String firstName = firstNameField.getText();
                    String salary = salaryField.getText();
                    String lastName = lastNameField.getText();
                    String id = idField.getText();

                    tableModel.addRow(new String[]{firstName, salary, lastName, id});

                    firstNameField.setText("");
                    salaryField.setText("");
                    lastNameField.setText("");
                    idField.setText("");
                }
            });
            inputPanel.add(addButton);

            frame.setLayout(new BorderLayout());

            frame.add(inputPanel, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}