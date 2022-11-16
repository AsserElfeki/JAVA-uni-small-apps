
package pl.polsl.lab.asser.moustafa.view;

import lombok.Data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * GUI class.
 * contains all elements in the window and pop-up windows
 * @author asser.elfeki
 */
@Data
public class AppWindow extends JPanel implements ActionListener {

    private MyTableModel model;

    //main window
    private JFrame mainFrame;

    //contents of the window
    private JMenuBar mainMenu;
    private JSplitPane mainPane;

    //contents of the menuBar
    private JMenu fileMenu;
    private JMenu helpMenu;

    //contents of help menu
    private JMenuItem manual;

    //contents of the fileMenu
    private JMenuItem about;
    private JMenuItem quit;

    //contents of the SpltPane
    private JPanel leftPanel;
    private JPanel rightPanel;

    //content of left panel
    private JLabel modes;
    private ButtonGroup modesOfConvertion;
    private JRadioButton arToRn;
    private JRadioButton rnToAr;
    private JLabel inputLabel;
    private JTextField input;
    private JLabel outputLabel;
    private JTextArea output;
    private JButton convertBtn;

    //contents of the right panel
    private JTable historyTable;
    private JButton clearHistory;
    private JScrollPane tableContainer;

    /**
     * non-parametric constructor
     */
    public AppWindow() {
        init();
    }

    private void init() {

        Dimension minimumPanelSize = new Dimension(450, 500);
        Dimension menuSize = new Dimension(1000, 50);
        Dimension windowSize = new Dimension(1000, 1000);
        Dimension menuItemSize = new Dimension(100, 50);
        Dimension buttonSize = new Dimension(150, 50);
        Dimension radioButtonSize = new Dimension(250, 30);
        Dimension labelSize = new Dimension(200, 50);
        Dimension textFieldSize = new Dimension(400, 50);
        int buttonFontSize = 20;

        //right panel
        String[] columnNames = {"Input", "Output"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        rightPanel = new JPanel();
        historyTable = new JTable(model);
        clearHistory = new JButton("clear history");

        historyTable.setBackground(Color.white);
        historyTable.setForeground(Color.black);
        historyTable.setSelectionBackground(Color.red);
        historyTable.setGridColor(Color.gray);
        historyTable.setSelectionForeground(Color.white);
        historyTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
        historyTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        historyTable.setRowHeight(30);
        historyTable.setAutoCreateRowSorter(true);
        historyTable.setCellSelectionEnabled(true);
        tableContainer = new JScrollPane(historyTable);
        tableContainer.add(historyTable);

        tableContainer.setViewportView(historyTable);
        clearHistory.setLocation(180, 700);
        clearHistory.setSize(buttonSize);
        tableContainer.setBounds(10, 100, 470, 500);

        rightPanel.setMinimumSize(minimumPanelSize);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.gray);
        rightPanel.setBounds(505, 50, 495, 900);
        rightPanel.add(tableContainer);
        rightPanel.add(clearHistory);

        //left panel
        leftPanel = new JPanel();
        modes = new JLabel("Modes:");
        arToRn = new JRadioButton("Arabic to Roman");
        rnToAr = new JRadioButton("Roman to Arabic");
        inputLabel = new JLabel("input:");
        input = new JTextField("");
        outputLabel = new JLabel("Converted number:");
        output = new JTextArea("");
        convertBtn = new JButton("Convert");
        modesOfConvertion = new ButtonGroup();

        modes.setFont(new Font(null, Font.BOLD, 28));
        modes.setForeground(new Color(0x228877));
        modes.setLocation(20, 50);
        modes.setSize(labelSize);

        arToRn.setFont(new Font(null, Font.ITALIC, buttonFontSize));
        arToRn.setForeground(new Color(0xffffff));
        arToRn.setLocation(100, 100);
        arToRn.setSize(radioButtonSize);
        arToRn.setSelected(true);

        rnToAr.setFont(new Font(null, Font.ITALIC, buttonFontSize));
        rnToAr.setForeground(new Color(0xffffff));
        rnToAr.setLocation(100, 130);
        rnToAr.setSize(radioButtonSize);

        modesOfConvertion.add(arToRn);
        modesOfConvertion.add(rnToAr);

        input.setLocation(50, 300);
        input.setSize(textFieldSize);
        input.setForeground(Color.gray);

        inputLabel.setLocation(50, 250);
        inputLabel.setSize(labelSize);
        inputLabel.setForeground(Color.black);

        output.setLocation(50, 400);
        output.setSize(textFieldSize);
        output.setEditable(false);

        outputLabel.setLocation(50, 350);
        outputLabel.setSize(labelSize);
        outputLabel.setForeground(Color.black);

        convertBtn.setLocation(170, 500);
        convertBtn.setSize(buttonSize);
        convertBtn.setFont(new Font(null, Font.BOLD, buttonFontSize));

        leftPanel.setMinimumSize(minimumPanelSize);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.gray);
        leftPanel.setBounds(0, 50, 495, 900);
        leftPanel.add(modes);
        leftPanel.add(arToRn);
        leftPanel.add(rnToAr);
        leftPanel.add(input);
        leftPanel.add(inputLabel);
        leftPanel.add(output);
        leftPanel.add(outputLabel);
        leftPanel.add(convertBtn);

        //MenuBar
        mainMenu = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        about = new JMenuItem("about");
        quit = new JMenuItem("quit");
        manual = new JMenuItem("how to use?");

        fileMenu.setSize(menuItemSize);
        helpMenu.setSize(menuItemSize);
        quit.setSize(menuItemSize);

        fileMenu.add(about);
        fileMenu.add(quit);
        helpMenu.add(manual);
        mainMenu.setSize(menuSize);
        mainMenu.add(fileMenu);
        mainMenu.add(helpMenu);

        //splitPane 
        mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                leftPanel, rightPanel);
        mainPane.setOneTouchExpandable(true);
        mainPane.setVisible(true);
        mainPane.setBounds(0, 50, 1000, 950);
        mainPane.setDividerLocation(495);
        mainPane.setDividerSize(10);

        //Jframe properties
        mainFrame = new JFrame();
        mainFrame.setLayout(null); //to make it open in the center
        mainFrame.setTitle("Arabic/Roman Number Converter");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(windowSize);
        mainFrame.setLocationRelativeTo(null); //to center the window
        mainFrame.setResizable(false);
        mainFrame.getContentPane().add(mainMenu);
        mainFrame.getContentPane().add(mainPane);

        mainFrame.setVisible(true);

        clearHistory.addActionListener(this);
        clearHistory.setActionCommand("clear");

        manual.addActionListener(this);
        manual.setActionCommand("manual");

        about.addActionListener(this);
        about.setActionCommand("about");

        quit.addActionListener(this);
        quit.setActionCommand("quit");
    }

    /**
     * action listner
     * @param e is the event 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clear":
                DefaultTableModel dm = (DefaultTableModel) historyTable.getModel();
                int rowCount = dm.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    dm.removeRow(i);
                }
                break;
            case "about":
                showAbout();
                break;
            case "manual":
                showManual();
                break;
            case "quit":
                System.exit(0);
                break;
        }

    }

    /**
     * Function for adding last successful operation to the history
     * @param _input the input number entered by user
     * @param output is the converted number
     */
    public void addHistoryEntry(String _input, String output) {

        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        Object[] entry = new Object[2];
        entry[0] = _input;
        entry[1] = output;
        model.addRow(entry);

    }

    /**
     * Creates a message dialog window when a validation error occurs.
     * @param message is the body of the warning
     */
    public void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Creates a message dialog window when an operation was successful.
     * @param message is the body of the info message
     */
    public void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Creates a dialog window showing how to use the app
     */
    public void showManual() {
        JOptionPane.showMessageDialog(this, """
                               To run the program:
                               
                               1- To convert from Arabic to Roman : choose mode "Arabic to Roman".
                               
                               2- To convert from Roman to Arabic : choose mode "Roman to Arabic"
                               
                               3- add your input number in the range 1 to 3999 in the input field
                                                    
                               4- press the \"convert\" Button  """,
                "Help", JOptionPane.PLAIN_MESSAGE);

    }

    /**
     * Shows some info in a dialog window
     */
    public void showAbout() {
        JOptionPane.showMessageDialog(this, """
                               I am Asser, an Informatics student. 
                                            I am trying my best
                                            don't judge me!! """,
                "About", JOptionPane.PLAIN_MESSAGE);
    }

    
    /**
     * class for the Table model.
     * @author asser.elfeki
     */
    class MyTableModel extends DefaultTableModel {

        MyTableModel(Object[] columnNames, int rows) {
            super(columnNames, rows);
        }

        public boolean isCellEditable(int row, int col) {
            //uwaga - adres komorki jest staly, niezaleznie
            //od aktualnego polozenia na ekranie
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

    }
}
