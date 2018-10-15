/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.resource;

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

public class DiaryGUI extends JFrame implements InputMethodListener {
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
        cmpDatePicker.setKeepTime(true);
        cmpDatePicker.setFieldEditable(true);

        // Add to Frame
        add(pnlDiaryEntry);

        // Listener for DatePicker
        cmpDatePicker.addInputMethodListener(this);




        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }



    //    Process events for DatePicker object
    public void inputMethodTextChanged(InputMethodEvent ime) {

        // commit field
        cmpDatePicker.commitEdit();
        DateFormat df = cmpDatePicker.getDateFormat();
        String d = df.format(cmpDatePicker.getDate());
        editorDiary.setText("This is the date of all dates: " + d);
        repaint();
    }
    public void caretPositionChanged(InputMethodEvent ime) {

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
        pnlDiaryEntry.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 3, new Insets(2, 5, 10, 5), 5, 10));
        pnlDiaryEntry.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        cmpDatePicker = new DatePicker();
        pnlDiaryEntry.add(cmpDatePicker, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        pnlDiaryEntry.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        pnlDiaryEntry.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lblDiaryEntry = new JLabel();
        lblDiaryEntry.setText("Diary Entry:");
        pnlDiaryEntry.add(lblDiaryEntry, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editorDiary = new JEditorPane();
        pnlDiaryEntry.add(editorDiary, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lblStats = new JLabel();
        lblStats.setText("Statistics:");
        pnlDiaryEntry.add(lblStats, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        treeStats = new JTree();
        pnlDiaryEntry.add(treeStats, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        btnSave = new JButton();
        btnSave.setText("Save");
        pnlDiaryEntry.add(btnSave, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlDiaryEntry;
    }
}
