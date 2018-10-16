/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.resource;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
/*
* This form uses IntrelliJs formatting, so it was very easy to call. Did
 * not need to add the components to th epanel, then the panel to the
 * frame.
 * IntelliJ adds its own package tot he JAR file when it builds the
 * classes, so works with java from command-line. The form is as-is.*/

public class DiaryGUI extends Frame {
    JEditorPane editorDiary;
    JTree treeStats;
    JButton btnSave;
    JLabel lblDiaryEntry;
    JLabel lblStats;
    JPanel pnlDiaryEntry;
    DatePicker cmpDatePicker;
    String msg = "";

    public DiaryGUI() {

        // Set DatePicker


        // Add to Frame
        add(pnlDiaryEntry);

        // Listener for the editor
        editorDiary.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                cmpDatePicker.commitEdit();
                DateFormat df = cmpDatePicker.getDateFormat();
                editorDiary.setText("This should be good: " + df.format(cmpDatePicker.getDate()));
            }
        });
        // Add mouse listener to button
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                // TODO: 10/16/18 Put code here to save data to diarymap.
            }
        });


        // Window Listener for frame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnlDiaryEntry = new JPanel();
        pnlDiaryEntry.setLayout(new GridLayoutManager(4, 3, new Insets(2, 5, 10, 5), 5, 10));
        pnlDiaryEntry.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        cmpDatePicker = new DatePicker();
        pnlDiaryEntry.add(cmpDatePicker, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_NORTHEAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        pnlDiaryEntry.add(spacer1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        pnlDiaryEntry.add(spacer2, new GridConstraints(1, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblDiaryEntry = new JLabel();
        lblDiaryEntry.setText("Diary Entry:");
        pnlDiaryEntry.add(lblDiaryEntry, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editorDiary = new JEditorPane();
        pnlDiaryEntry.add(editorDiary, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lblStats = new JLabel();
        lblStats.setText("Statistics:");
        pnlDiaryEntry.add(lblStats, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        treeStats = new JTree();
        pnlDiaryEntry.add(treeStats, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        btnSave = new JButton();
        btnSave.setText("Save");
        pnlDiaryEntry.add(btnSave, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlDiaryEntry;
    }
}
