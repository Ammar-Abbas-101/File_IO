package com.ammarabbas;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class FileIO extends JFrame implements ActionListener {

    boolean readcityerror = true;
    JTextField[] field = new JTextField[6];
    int indexappend = 0;

    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    JComboBox fontBox;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

// NEW METHOD.
// OPEN A FILE OF CHOICE OR MOVE TO THE WEATHER FEATURE?

    public void randomorcityortexteditor() {

        String[] buttonsrandomorweatherortexteditor = {"Open A File Of Choice", "Weather Feature", "Text Editor"};

        int varRandomOrWeatherOrTexteditor = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonsrandomorweatherortexteditor, buttonsrandomorweatherortexteditor[0]);

        if (varRandomOrWeatherOrTexteditor == 0) {
            fileofchoice();
        } else if (varRandomOrWeatherOrTexteditor == 1) {
            cityfeature();
        } else {
            TextEditor();
        }
        ;

    }


// NEW METHOD.
// IF YOU WANT TO OPEN A FILE OF CHOICE.

    public void fileofchoice() {

        JFileChooser fileselect = new JFileChooser();
        int fileselectresponse = fileselect.showOpenDialog(null);

        if (fileselectresponse == JFileChooser.APPROVE_OPTION) {
            File fileofchoicefilepath = new File(fileselect.getSelectedFile().getAbsolutePath());

            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(fileofchoicefilepath);
            } catch (Exception e) {
                System.out.println("Could not open this file. Would you like to try again?");
            }
        } else {
            System.out.println("Program ended successfully.");
            System.exit(0);
        }
        ;

    }


// NEW METHOD.
// IF YOU WANT TO MOVE TO THE WEATHER FEATURE.

    public void cityfeature() {


        Object buttonscityfeature[] = {"Would you like to read a file?", "Would you like to add to a file?"};

        int varReadOrWrite = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonscityfeature, buttonscityfeature[0]);

        if (varReadOrWrite == 0) {
            readcityfeature();
        } else if (varReadOrWrite == 1) {
            addcityfeature();
        } else {
            System.exit(0);
        }
        ;

    }

    // NEW METHOD.
    // IF YOU WANT TO READ THE WEATHER FILE, THIS METHOD WILL RUN WITH A TRY AND CATCH.

    public void readcityfeature() {
        String CSVfilelocation = "D:\\Intellij\\File IO\\src\\com\\ammarabbas\\CSV1.csv";
        String line = "";
        String[] readspecific = {"Would you like to read a specific record cell?", "Would you like to see specific statistics about a city?", "End program."};

        while (readcityerror == true) {
            ArrayList<String> khala = new ArrayList();
            String[] dud;
            try {
                BufferedReader readingtool = new BufferedReader(new FileReader(CSVfilelocation));
                while ((line = readingtool.readLine()) != null) {
                    dud = line.split(",");
                    khala.add(Arrays.deepToString(new String[]{dud[0]}) + "\t\t\t\t");
                    khala.add((Arrays.deepToString(new String[]{dud[1]}) + "\t\t\t\t"));
                    khala.add(Arrays.deepToString(new String[]{dud[2]}) + "\t\t\t\t");
                    khala.add(Arrays.deepToString(new String[]{dud[3]}) + "\t\t\t");
                    khala.add(Arrays.deepToString(new String[]{dud[4]}) + "\n");

                }
            } catch (Exception e) {
                System.out.println("An error occured. Please try again or contact the amazing person who programed this.");
                e.printStackTrace();

            } finally {
                System.out.println("\n\nProcess completed.");
                readcityerror = false;
                int readspecificorno = JOptionPane.showOptionDialog(null, "What would you like to do?",
                        "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                        readspecific, readspecific[0]);
                if (readspecificorno == 0) {

                    System.out.println(khala.get(readspecificvalue(0)));
                }
                ;
                //System.out.println(khala.get(11));


            }

        }
        ;
    }

    // OVERRIDING METHOD.

    @Override
    public String toString() {
        return "FileIO{}";
    }


// NEW METHOD.
    // IF YOU WANT TO MAKE CHANGES TO THE WEATHER FILE, THIS METHOD WILL RUN WITH A TRY AND CATCH.

    public void addcityfeature() {

        Object buttonsaddcityfeature[] = {"Would you like to add to a file?", "Would you like to overwrite a file?"};
        int varAppendOrOverwrite = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonsaddcityfeature, buttonsaddcityfeature[0]);
        if (varAppendOrOverwrite == 0) {
            appendweatherfeature();
        } else if (varAppendOrOverwrite == 1) {
            overwriteweatherfeature();
        } else {
            makeanewfile();
        }

        ;
    }

    public void appendweatherfeature() {
        String CSVfilelocation = "D:\\Intellij\\File IO\\src\\com\\ammarabbas\\CSV1.csv";
        try {
            FileWriter appendfile = new FileWriter(CSVfilelocation, true);
            PrintWriter appender = new PrintWriter(appendfile);
            ArrayList<Integer> CSVarraylist = new ArrayList();
            for (int indexappend = 0; indexappend < 6; indexappend++) {
                field[indexappend] = new JTextField();
                //field[indexappend] = input.nextInt();
            }
            ;
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();
            JTextField field4 = new JTextField();
            JTextField field5 = new JTextField();
            Object[] fields = {
                    "City", field1,
                    "Population", field2,
                    "Reported Crimes (Annual)", field3,
                    "Unemployed Population", field4,
                    "Size (km squared", field5
            };

            JOptionPane.showConfirmDialog(null, fields, "Title", JOptionPane.DEFAULT_OPTION);
            appender.println(field1.getText() + ",\t\t\t\t" + field2.getText() + ",\t\t\t" + field3.getText() + ",\t\t\t\t\t\t\t" +
                    field4.getText() + ",\t\t\t" + field5.getText());
            appender.close();
        } catch (Exception e) {
            System.out.println("The file could not be appended.");
        }
    }

    public void overwriteweatherfeature() {

    }

    public static int readspecificvalue(int i) {

        String CSVfilelocation = "D:\\Intellij\\File IO\\src\\com\\ammarabbas\\CSV1.csv";
        String line = "";
        String whichvalue = JOptionPane.showInputDialog("Please enter the city for which you would like to see the value for.");
        String[] dud = new String[5];
        boolean foundword = false;

        i = 0;

        try {
            BufferedReader readingtool = new BufferedReader(new FileReader(CSVfilelocation));
            while ((line = readingtool.readLine()) != null) {
                dud = line.split(",");
                i = i + 1;
                if (dud[0].equals(whichvalue)) {
                    foundword = true;
                    if (foundword = true) {
                        String whichcategory = JOptionPane.showInputDialog("Which category would you like to see? " +
                                "Please type 'population', 'crimes', 'unemployment', or 'size'. ");
                        if (whichcategory == "population") {
                            i = ((i - 1) * 5) + 2;
                        } else if (whichcategory == "crimes") {
                            i = ((i - 1) * 5) + 3;
                        } else if (whichcategory == "unemployment") {
                            i = ((i - 1) * 5) + 4;
                        } else if (whichcategory == "size") {
                            i = ((i - 1) * 5) + 5;
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured. Please try again or contact the amazing person who programed this.");
            e.printStackTrace();
        } finally {
            if (foundword == false) {
                System.out.println("Could not find " + whichvalue + " in the file.");
            }
            //System.out.println(i);
        }
        return i;
    }



    public void makeanewfile(){

                System.out.println();
            }





    // NEW METHOD. THIS IS THE TEXT EDITOR.
    public void TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bro text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLabel = new JLabel("Font: ");

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
            }

        });

        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");

        // ------ menubar ------

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // ------ /menubar ------

        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontBox);
        this.add(scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==fontColorButton) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

            textArea.setForeground(color);
        }

        if(e.getSource()==fontBox) {
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }

        if(e.getSource()==openItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                finally {
                    fileIn.close();
                }
            }
        }
        if(e.getSource()==saveItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter fileOut = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());
                }
                catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                finally {
                    fileOut.close();
                }
            }
        }
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
    }

}














// YOU GOT THIS! FEEL POSITIVE! Work sensibly according to what you can do in a reasonable amount of time. Don't stress, you're learning useful and exciting things. On your way to hacking XD Create a schedule for how you're gonna work.

/*

Try coding a printtoprinter() method for a printer.

Create a createacopy() method.


Create a saveformat() method where you can ask the user to save the file in a format of their choice, probably pdf.
  Use the file manager option so they can select where they wanna save.

Create a searchforcity() method.
  Create a JOptionPane asking "would you like to search for a specific city?"
    If the user selects "Yes", call the "Search" method to search for that city.

    If no city is found, display "City not found."

    If city is found, display the line number through a message box or actually the line itself if you can.

When Run is pressed;

Make the first JOptionPane asking what the user wants to do.

  If the user selects "Open",
    Create a file manager which lets the user select whichever file they wanna open. Copy their selected path, store it in a variable, and insert that variable into the file path which you will open. Put everything in to a try and catch for Exceptions. The JOptionPane  should say, "This file cannot be opened. Would you like to try and again?"

    Rerun the program if the user selects "Yes." System.Exit if the user selects "No". If the user selects "Yes", variable 'keepgoing1' stays true. Otherwise, variable 'keepgoing1' = false.

    Call the searchforcity() method.

    Define 'keepgoing1' outside of the main method so you're able to change it, try defining it in the class or just make a separate non-static method or something? Look at TicTacToe for help.

    If 'keepgoing1' == true, run the while loop. If 'keepgoing1' == false, System.Exit();.

    Call the saveformat() method.
    createacopy() if possible;

  If the user selects "Weather";
    Make a JOptionPane asking whether the user wants to read a file or write to a file.

      If the user selects "Read";
        Print all data from the CSV nicely to the console.


        Call the searchforcity() method.
        Call the saveformat() method.
        createacopy();

      If the user selects "Write";

        Create an option for the user where they are able to choose whether they want to override the data or append it. Change the boolean value in the printer function accordingly so use a variable.

        Create a JOption input with various textfields where the user puts in infromation. Put everything in a try and catch so if the user messes around, it can create an exception. Put everything in to a while loop so that the program can rerun if the user wants it to.

        Create a while loop so the user has the option to make more than one entry.

        Print everything to the console at the end of the program.

        Call the searchforcity() method.

        Call the saveformat() method once everything is done.

        createacopy();



*/





























/*
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;

public class FileIO {

    boolean readweathererror = true;
    //int indexappend = 0;
    JTextField[] field = new JTextField[6];

// NEW METHOD.
// OPEN A FILE OF CHOICE OR MOVE TO THE WEATHER FEATURE?

    public void randomorweather() {

        String[] buttonsrandomorweather = {"Open A File Of Choice", "Weather Feature"};

        int varRandomOrWeather = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonsrandomorweather, buttonsrandomorweather[0]);

        if (varRandomOrWeather == 0) {
            fileofchoice();
        } else {
            weatherfeature();
        }
        ;

    }


// NEW METHOD.
// IF YOU WANT TO OPEN A FILE OF CHOICE.

    public void fileofchoice() {

        JFileChooser fileselect = new JFileChooser();
        int fileselectresponse = fileselect.showOpenDialog(null);

        if (fileselectresponse == JFileChooser.APPROVE_OPTION) {
            File fileofchoicefilepath = new File(fileselect.getSelectedFile().getAbsolutePath());

            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(fileofchoicefilepath);
            } catch (Exception e) {
                System.out.println("Could not open this file. Would you like to try again?");
            }
        } else {
            System.out.println("Program ended successfully.");
            System.exit(0);
        }
        ;

    }


// NEW METHOD.
// IF YOU WANT TO MOVE TO THE WEATHER FEATURE.

    public void weatherfeature() {


        Object buttonsweatherfeature[] = {"Would you like to read a file?", "Would you like to add to a file?"};

        int varReadOrWrite = JOptionPane.showOptionDialog(null, "What would you like to do?",
                "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                buttonsweatherfeature, buttonsweatherfeature[0]);

        if (varReadOrWrite == 0) {
            readweatherfeature();
        } else {
            addweatherfeature();
        }
        ;

    }

    // NEW METHOD.
    // IF YOU WANT TO READ THE WEATHER FILE, THIS METHOD WILL RUN WITH A TRY AND CATCH.

    public void readweatherfeature() {
        String CSVfilelocation = "src\\CSV1.csv";
        String line = "";

        while (readweathererror == true) {
            try {
                BufferedReader readingtool = new BufferedReader(new FileReader(CSVfilelocation));
                while ((line = readingtool.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {

                System.out.println("An error occured. Please try again or contact the amazing person who programed this.");
            } finally {
                System.out.println("\n\nProcess completed.");
                readweathererror = false;
            }

        };
    }

    // NEW METHOD.
    // IF YOU WANT TO MAKE CHANGES TO THE WEATHER FILE, THIS METHOD WILL RUN WITH A TRY AND CATCH.

        public void addweatherfeature () {

            Object buttonsaddweatherfeature[] = {"Would you like to add to a file?", "Would you like to overwrite a file?"};

            int varReadOrWrite = JOptionPane.showOptionDialog(null, "What would you like to do?",
                    "Welcome!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null,
                    buttonsaddweatherfeature, buttonsaddweatherfeature[0]);

            if (varReadOrWrite == 0) {
                appendweatherfeature();
            } else {
                overwriteweatherfeature();
            }
            ;


        }

        public void appendweatherfeature() {


            for (int indexappend = 0; indexappend < 6; indexappend++) {

                field[indexappend] = new JTextField();

            };


            Object[] fields = {

                    "City", field[1],
                    "Population", field[2],
                    "Reported Crimes (Annual)", field[3],
                    "Unemployed Population", field[4],
                    "Size (km squared", field[5]

            };


            JOptionPane.showConfirmDialog(null, fields, "Title", JOptionPane.DEFAULT_OPTION);

        }

          public void overwriteweatherfeature(){

        }

    }














// YOU GOT THIS! FEEL POSITIVE! Work sensibly according to what you can do in a reasonable amount of time. Don't stress, you're learning useful and exciting things. On your way to hacking XD Create a schedule for how you're gonna work.

/*

Try coding a printtoprinter() method for a printer.

Create a createacopy() method.


Create a saveformat() method where you can ask the user to save the file in a format of their choice, probably pdf.
  Use the file manager option so they can select where they wanna save.

Create a searchforcity() method.
  Create a JOptionPane asking "would you like to search for a specific city?"
    If the user selects "Yes", call the "Search" method to search for that city.

    If no city is found, display "City not found."

    If city is found, display the line number through a message box or actually the line itself if you can.

When Run is pressed;

Make the first JOptionPane asking what the user wants to do.

  If the user selects "Open",
    Create a file manager which lets the user select whichever file they wanna open. Copy their selected path, store it in a variable, and insert that variable into the file path which you will open. Put everything in to a try and catch for Exceptions. The JOptionPane  should say, "This file cannot be opened. Would you like to try and again?"

    Rerun the program if the user selects "Yes." System.Exit if the user selects "No". If the user selects "Yes", variable 'keepgoing1' stays true. Otherwise, variable 'keepgoing1' = false.

    Call the searchforcity() method.

    Define 'keepgoing1' outside of the main method so you're able to change it, try defining it in the class or just make a separate non-static method or something? Look at TicTacToe for help.

    If 'keepgoing1' == true, run the while loop. If 'keepgoing1' == false, System.Exit();.

    Call the saveformat() method.
    createacopy() if possible;

  If the user selects "Weather";
    Make a JOptionPane asking whether the user wants to read a file or write to a file.

      If the user selects "Read";
        Print all data from the CSV nicely to the console.


        Call the searchforcity() method.
        Call the saveformat() method.
        createacopy();

      If the user selects "Write";

        Create an option for the user where they are able to choose whether they want to override the data or append it. Change the boolean value in the printer function accordingly so use a variable.

        Create a JOption input with various textfields where the user puts in infromation. Put everything in a try and catch so if the user messes around, it can create an exception. Put everything in to a while loop so that the program can rerun if the user wants it to.

        Create a while loop so the user has the option to make more than one entry.

        Print everything to the console at the end of the program.

        Call the searchforcity() method.

        Call the saveformat() method once everything is done.

        createacopy();



*/