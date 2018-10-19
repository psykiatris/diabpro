/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.diabpro.resource.DiaryGUI;

import java.awt.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("Database connects OK.");

        // Run GUI form
        DiaryGUI appwin = new DiaryGUI();

        appwin.setSize(new Dimension(595, 320));
        appwin.setTitle("Diabetes Pro v0.1");
        appwin.setVisible(true);




    }
}