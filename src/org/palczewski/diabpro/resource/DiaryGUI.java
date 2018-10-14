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
        setLayout(new GridBagLayout());

        // Initialized components
        diaryEntryPan = new JPanel();
        lDiaryEntry = new JLabel("Diary Entry:");
        /* dateStye options is:
        * 1 - Month spelled out (i.e. January 1, 2018)
        * 2 - Month abbreviated (i.e. Jan 1, 2018)
        * 3 - Numeric (i.e. 1/1/2018
        * */
        diaryDatePicker = new DatePicker(new Date(), 2);

        //Add to panel
        diaryEntryPan.add(lDiaryEntry, BorderLayout.NORTH);
        diaryEntryPan.add(diaryDatePicker, BorderLayout.NORTH);

        // Add Panel to Frame
        add(diaryEntryPan);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }
}
