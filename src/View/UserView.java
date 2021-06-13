package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends Frame{

    public UserView(String title) {
        super(title);
    }

    /**
     *  edit profile
     *  search for books --> dialog(add to shopping cart)
     *  view && checkout shopping cart --> dialog.
     */
    protected JPanel findABookPanel, editProfilePanel, shoppingCartPanel;

    private void init(){
        editProfilePanel = new JPanel();
        findABookPanel = new JPanel();
        shoppingCartPanel = new JPanel();
    }

    protected BookTableModel tableModel;
    protected CustomJTable customJTable;

    public void viewFindABookPanel(){
        BoxLayout boxLayout = new BoxLayout(findABookPanel,BoxLayout.Y_AXIS);
        findABookPanel.setLayout(boxLayout);
        JTextField textField = new JTextField();
        textField.setSize(20,20);
        String[] items = {"ISBN","title","category","author","publisher"};
        JComboBox comboBox = new JComboBox(items);
        JLabel searchByLabel= new JLabel("search by");
        JButton searchButton = new JButton("search");
        findABookPanel.add(getPairLayouts(searchByLabel,comboBox));
        findABookPanel.add(getPairLayouts(textField,searchButton));
        tableModel = new BookTableModel();
        customJTable = new CustomJTable(findABookPanel, tableModel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textField.getText();
                if(comboBox.getActionCommand().equals(items[0])){

                }else if(comboBox.getActionCommand().equals(items[1])){

                }else if(comboBox.getActionCommand().equals(items[2])){

                }else if(comboBox.getActionCommand().equals(items[3])){

                }else if(comboBox.getActionCommand().equals(items[4])){

                }
            }
        });
    }


    public void viewEditProfilePanel(){
        editProfilePanel.setLayout(new BoxLayout(editProfilePanel,BoxLayout.Y_AXIS));
        String firstName = "islam";
        String lastName = "yousry";
        String email = "is";
        String phoneNumber = "04";
        String shippingAddress = "dfs";
        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last Name");
        JLabel emailLabel = new JLabel("Email");
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        JLabel shippingAddressLabel = new JLabel("Shipping Address");

        JTextField firstNameTextField = new JTextField(firstName);
        firstNameTextField.setEnabled(false);
        JTextField lastNameTextField = new JTextField(lastName);
        lastNameTextField.setEnabled(false);
        JTextField emailTextField = new JTextField(email);
        emailTextField.setEnabled(false);
        JTextField phoneNumberTextField = new JTextField(phoneNumber);
        phoneNumberTextField.setEnabled(false);
        JTextField shippingAddressTextField = new JTextField(shippingAddress);
        shippingAddressTextField.setEnabled(false);
        editProfilePanel.add(getPairLayouts(firstNameLabel,firstNameTextField));
        editProfilePanel.add(getPairLayouts(lastNameLabel,lastNameTextField));
        editProfilePanel.add(getPairLayouts(emailLabel,emailTextField));
        editProfilePanel.add(getPairLayouts(phoneNumberLabel,phoneNumberTextField));
        editProfilePanel.add(shippingAddressLabel,shippingAddressTextField);

        JButton saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        JButton editButton = new JButton("edit");
        editProfilePanel.add(getPairLayouts(editButton,saveButton));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editButton.setEnabled(true);
                saveButton.setEnabled(false);
                firstNameTextField.setEnabled(false);
                lastNameTextField.setEnabled(false);
                emailTextField.setEnabled(false);
                phoneNumberTextField.setEnabled(false);
                shippingAddressTextField.setEnabled(false);
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editButton.setEnabled(false);
                saveButton.setEnabled(true);
                firstNameTextField.setEnabled(true);
                lastNameTextField.setEnabled(true);
                emailTextField.setEnabled(true);
                phoneNumberTextField.setEnabled(true);
                shippingAddressTextField.setEnabled(true);
            }
        });
    }

    public void viewShoppingCartPanel(){
        shoppingCartPanel.setLayout(new BoxLayout(shoppingCartPanel,BoxLayout.Y_AXIS));
        ShoppingCartTableModel tableModel = new ShoppingCartTableModel();
        customJTable = new CustomJTable(shoppingCartPanel, tableModel);
        JButton deleteBookButton = new JButton("delete Book");
        JButton checkOutButton = new JButton("check out");
        shoppingCartPanel.add(getPairLayouts(deleteBookButton,checkOutButton));
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tableModel.deleteBook(customJTable.getTable().getSelectedRow());
            }
        });
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog dialog = new JDialog();


            }
        });
    }

    public void view(){
        init();
        JTabbedPane tabbedPane = new JTabbedPane();
        setMainPanel(tabbedPane);
        tabbedPane.setBorder(BorderFactory.createLineBorder(Color.black));
        tabbedPane.addTab("find a book",findABookPanel);
        tabbedPane.addTab("profile",editProfilePanel);
        tabbedPane.addTab("shopping cart",shoppingCartPanel);
       viewFindABookPanel();
       viewEditProfilePanel();
       viewShoppingCartPanel();
       getFrame().add(getMainPanel());
       getFrame().pack();
    }

}
