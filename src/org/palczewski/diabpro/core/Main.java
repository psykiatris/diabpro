/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.connect.MainConnect;
import org.palczewski.edit.DatabaseMachine;

import java.sql.Connection;

public class Main {

    static Connection conn;

    public static void main(String[] args) {
        System.out.println("Attempting to connect to mySQL");

        // Run GUI form
        /*
        DiaryGUI appwin = new DiaryGUI();


        appwin.setSize(new Dimension(595, 425));
        appwin.setTitle("Diabetes Pro v0.1");
        appwin.setVisible(true);
        */

        // Attempt db connect
        MainConnect mc = new MainConnect();
        /*
        Update this to take params from user. Use Scanner object to read
         input.
         */
        conn = mc.doConnect("diabpro", "diabpro");
        // Pass connection
        // to DatabaseMachine
        DatabaseMachine dm = new DatabaseMachine(conn);
        dm.viewDatabase();













    }
}