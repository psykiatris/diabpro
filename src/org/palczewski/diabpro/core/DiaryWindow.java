/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.diabpro.resource.DiaryEntryPanel;
import org.palczewski.diabpro.resource.StatsListPanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DiaryWindow extends Frame {
    DiaryEntryPanel dep;
    DiaryEntryPanel dp;
    StatsListPanel slp;

    public DiaryWindow() {
        setLayout(new FlowLayout());

        // Wanna add panels to Frame

        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}

