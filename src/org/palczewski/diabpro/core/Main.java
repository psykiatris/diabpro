/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.connect.MainConnect;

public class Main {

    public static void main(String[] args) {
        System.out.println("Database connects OK.");

        // Run GUI form
        /*
        DiaryGUI appwin = new DiaryGUI();


        appwin.setSize(new Dimension(595, 425));
        appwin.setTitle("Diabetes Pro v0.1");
        appwin.setVisible(true);
        */

        // Attempt db connect
        MainConnect mc = new MainConnect();
        mc.doConnect("diabpro", "diabpro");

        System.out.println("Is connection open?: " + mc.isOpen());











    }
}