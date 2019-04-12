/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.connect.MainConnect;
import org.palczewski.core.UserMachine;
import org.palczewski.diabpro.access.DiabproTableMachine;
import org.palczewski.edit.DatabaseMachine;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    static Connection conn;
    static String user;
    static String pw;
    static String dbName = "diabetes";

    public static void main(String[] args) {
        // TODO: 4/4/19 Password field is exposed. FIX FIX
        //Get input
        Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
        try {


            System.out.println("Welcome to Diabetes Pro 1.0!");
            System.out.print("Enter your username: ");
            user = in.nextLine();
            System.out.print("Enter your password: ");
            pw = in.nextLine();
            System.out.println();

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
            conn = mc.doConnect(user, pw, dbName);
            // Pass connection
            // to DatabaseMachine
            DatabaseMachine dm = new DatabaseMachine(conn);
            DiabproTableMachine tm = new DiabproTableMachine(conn, user,
                    dbName);
            UserMachine um = new UserMachine(conn);

            // Create a table
            tm.createTable();
            tm.viewTables();



            in.close(); // Close scanner
        } catch (Exception e) {
            System.out.println(MessageFormat.format("Exception in main(): {0}", e.getMessage()));
        }

    }
}