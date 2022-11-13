/*
 * 
 */
package pl.polsl.lab.asser.moustafa.view;

import lombok.Data;

import java.awt.Color;
import static java.awt.Color.gray;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author asser.elfeki
 */
@Data
public class AppWindow implements ActionListener {

    private JFrame mainFrame; //main window

    //contents of the window
    private JMenuBar menuBar;
    private JSplitPane mainPane;

    //contents of the menuBar
    private JMenu fileMenu;
    private JMenu helpMenu;

    //contents of the SpltPane
    private JPanel leftPanel;
    private JPanel rightPanel;

    //content of left panel
    private JLabel modes;
    private ButtonGroup modesOfConvertion;
    private JRadioButton arToRn;
    private JRadioButton rnToAr;
    private JTextField input;
    private JTextArea output;
    private JButton convertBtn;
    private JProgressBar progressBar;

    //contents of the right panel
    private JTable historyTable;
    private JTextField historyFileName;
    private JButton loadHistory;
    private JButton clearHistory;

    public AppWindow() {
        init();
    }

    private void init() {
        
        Dimension minimumPanelSize = new Dimension(450, 500);
        Dimension menuSize = new Dimension(1000, 50);
        Dimension windowSize = new Dimension(1000, 1000);
        Dimension menuItemSize = new Dimension (100, 50);
//        Rectangle splitPaneSize = new Rectangle(890, 890);
        Dimension buttonSize = new Dimension(150, 50);
        Dimension radioButtonSize = new Dimension(250, 30);
        Dimension labelSize = new Dimension(80, 50);
        Dimension textFieldSize = new Dimension(400, 50);
        Dimension textAreaSize = new Dimension(400, 50);
        Dimension progressBarSize = new Dimension(495, 50);
        int buttonFontSize = 20;

        //right panel
        rightPanel = new JPanel();
        historyTable = new JTable(); //TODO
        loadHistory = new JButton("load");
        clearHistory = new JButton("clear history");
        historyFileName = new JTextField("file name");
        
        clearHistory.setLocation(50,800);
        loadHistory.setLocation(220,800);
        historyFileName.setLocation(20,700);
        loadHistory.setSize(buttonSize);
        clearHistory.setSize(buttonSize);
        historyFileName.setSize(textAreaSize);
        historyFileName.setForeground(Color.gray);
        
        rightPanel.setMinimumSize(minimumPanelSize);
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.gray);
        rightPanel.setBounds(505, 50, 495, 900);
        rightPanel.add(loadHistory);
        rightPanel.add(clearHistory);
        rightPanel.add(historyFileName);
        rightPanel.add(historyTable);
        
        
        //left panel
        leftPanel = new JPanel();
        modes = new JLabel("Modes:");
        arToRn = new JRadioButton("Arabic to Roman");
        rnToAr = new JRadioButton("Roman to Arabic");
        input = new JTextField("type a number here");
        output = new JTextArea("Converted number: ");
        convertBtn = new JButton("Convert");
        progressBar = new JProgressBar();
        modesOfConvertion = new ButtonGroup();
        
        modes.setFont(new Font(null, Font.BOLD, 28));
        modes.setForeground(new Color(0x228877));
        modes.setLocation(20,50);
        modes.setSize(buttonSize);
        
        
        arToRn.setFont(new Font(null,Font.ITALIC, buttonFontSize));
        arToRn.setForeground( new Color(0xffffff));
        arToRn.setLocation(100,100);
        arToRn.setSize(radioButtonSize);
        arToRn.setSelected(true);
        
        rnToAr.setFont(new Font(null,Font.ITALIC, buttonFontSize));
        rnToAr.setForeground( new Color(0xffffff));
        rnToAr.setLocation(100,130);
        rnToAr.setSize(radioButtonSize);
        
        modesOfConvertion.add(arToRn);
        modesOfConvertion.add(rnToAr);

        input.setLocation(50,300);
        input.setSize(textFieldSize);
        input.setForeground(Color.gray);  
        
        output.setLocation(50,400);
        output.setSize(textFieldSize);        
        output.setEditable(false);
        
        convertBtn.setLocation(170,500);
        convertBtn.setSize(buttonSize);
        convertBtn.setFont(new Font(null, Font.BOLD, buttonFontSize));
        
        progressBar.setLocation(0, 800);
        progressBar.setSize(progressBarSize);
        progressBar.setBounds(0,800,495,50);
        progressBar.setValue(10);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font(null, Font.ITALIC, 20));
        
        leftPanel.setMinimumSize(minimumPanelSize);
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.gray);
        leftPanel.setBounds(0, 50, 495, 900);
        leftPanel.add(modes);
        leftPanel.add(arToRn);
        leftPanel.add(rnToAr);
        leftPanel.add(input);
        leftPanel.add(output);
        leftPanel.add(convertBtn);
        leftPanel.add(progressBar);
        

        //MenuBar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        fileMenu.setSize(menuItemSize);
        helpMenu.setSize(menuItemSize);
        menuBar.setSize(menuSize);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //splitPane 
        mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                leftPanel, rightPanel);
        mainPane.setOneTouchExpandable(true);
        mainPane.setVisible(true);
        mainPane.setBounds(0,50,1000,950);
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
        mainFrame.add(menuBar);
        mainFrame.add(mainPane);
        
        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
