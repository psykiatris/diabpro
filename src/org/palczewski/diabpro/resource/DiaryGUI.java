/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.resource;


import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.MessageFormat;
/*
* Main window of the application.*/

public class DiaryGUI extends Frame {

    private final JTextArea editorArea;
    JTree treeStats;
    JButton btnSave;
    JLabel lblDiaryEntry;
    JLabel lblStats;
    JPanel pnlDiaryEntry;
    DatePicker cmpDatePicker;
    JTextField tfDate;
    String msg = "";

    public DiaryGUI() {
        // TODO: 10/16/18 Create menu bar to put on Frame.
        setLocationRelativeTo(nu9ll);
        setLayout(new FlowLayout());


        // Setting up components for the panel.
        // Uainf GridBagLayout
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        // Set up panel
        pnlDiaryEntry = new JPanel(gbag);
        // Components
        cmpDatePicker = new DatePicker();
        lblDiaryEntry = new JLabel("Diary Entry: ");
        tfDate = new JTextField(8);
        lblStats = new JLabel("Statistics:");
        editorArea = new JTextArea(20, 30);
        editorArea.setLineWrap(true);
        editorArea.setTabSize(4);
        editorArea.setAutoscrolls(true);
        treeStats = new JTree();
        btnSave = new JButton("Save");
        pnlDiaryEntry.setSize(new Dimension(5900, 320));

        // This pads the cell
        gbc.insets = new Insets(0, 2, 0, 2);

        gbc.gridx = 580;
        gbc.gridwidth = 10;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        pnlDiaryEntry.add(cmpDatePicker, gbc);

        gbc.gridy = 5;
        gbc.gridx = 5;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlDiaryEntry.add(lblDiaryEntry, gbc);

        // text field
        gbc.gridx = 10;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        pnlDiaryEntry.add(tfDate, gbc);

        // Stats label
        gbc.gridx = 320;
        gbc.gridwidth = GridBagConstraints.LINE_END;
        pnlDiaryEntry.add(lblStats, gbc);

        //Editor
        gbc.gridx = 5;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridwidth = 300;
        gbc.gridheight = 300;
        gbc.fill = GridBagConstraints.BOTH;
        pnlDiaryEntry.add(editorArea, gbc);

        gbc.gridx = 320;
        pnlDiaryEntry.add(treeStats, gbc);

        // button
        gbc.gridy = 315;
        gbc.gridx = 588;
        gbc.gridwidth = 1;
        pnlDiaryEntry.add(btnSave, gbc);



        // Add panel to Frame
        add(pnlDiaryEntry);

        // Listener for the editor
        /*Actopm:ostemer interface was able to had a lambda*/
        cmpDatePicker.addActionListener(e -> {
            DateFormat df = cmpDatePicker.getDateFormat();
            tfDate.setText(df.format(cmpDatePicker.getDate()));
            editorArea.setText(MessageFormat.format("Date chosen: {0}",
                    df.format(cmpDatePicker.getDate())));

        });

        // Add mouse listener to button
        btnSave.addMouseListener(new MyMouseAdapter());


        // Window Listener for frame
        addWindowListener(new MyWindowAdapter());


    }

    private class MyMouseAdapter extends MouseAdapter {
        MyMouseAdapter() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO: 10/16/18 Put code here to save data to diarymap.
        }
    }

    /*Really, there should be made static, however, the uiDesigner form
    complains that it cannot bind fields to the class. If I built the
    GUI manually, I can change to static.*/
    private class MyWindowAdapter extends WindowAdapter {
        MyWindowAdapter() {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        public void windowOpened(WindowEvent e) {
            DateFormat df = cmpDatePicker.getDateFormat();
            tfDate.setText(df.format(cmpDatePicker.getDate()));
        }

    }
}
