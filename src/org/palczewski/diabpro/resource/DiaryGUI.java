/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.resource;

import com.michaelbaranov.microba.calendar.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class DiaryGUI extends Frame {
    private JLabel lDiaryEntry;
    private DatePicker diaryDatePicker;
    private JPanel diaryEntryPan;

    public DiaryGUI() {
        setLayout(new FlowLayout());

        diaryEntryPan = new JPanel();
        lDiaryEntry = new JLabel("Diary Entry:");
        diaryDatePicker = new DatePicker(new Date(), 2);
        add(diaryEntryPan);

        diaryEntryPan.add(lDiaryEntry);
        diaryEntryPan.add(diaryDatePicker);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }
}
