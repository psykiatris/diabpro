/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.connect.SQLConnect;
import org.palczewski.core.UserMachine;
import org.palczewski.diabpro.access.LocalTableMachine;
import org.palczewski.edit.DatabaseMachine;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    private static final String DIABPRO = "diabpro";
    private static Connection conn = null;
    private static final String rootUser = DIABPRO;
    private static final String rootPW = DIABPRO;

    public static void main(String[] args) {

        //Get input
        // TODO: 4/13/19 Move log in out of main into its own function.

        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)){


            System.out.println("\tWelcome to Diabetes Pro 1.0!\nThis system will allow you to input diary information along with stats on the things you eat.");
            System.out.println();
            System.out.println("\tPlease log in");
            System.out.print("Enter your username: ");
            String user = in.nextLine();
            // Console will intercept input
            Console cons;
            char[] pwd;
            String dbName = "diabetes";
            if((((cons = System.console())) != null) && (((pwd =
                    cons.readPassword("%s", "Password:"))) != null)) {
                String pw = String.valueOf(pwd);
                SQLConnect sconn = new SQLConnect();

                // SQL connection
                conn = sconn.doConnect(user, pw, dbName);

                java.util.Arrays.fill(pwd, ' ');    // Encure password
                // is not saved

            } else {    // not in console
                System.out.println("No password");
            }
            System.out.println();

            // Run GUI form
        /*
        DiaryGUI appwin = new DiaryGUI();


        appwin.setSize(new Dimension(595, 425));
        appwin.setTitle("Diabetes Pro v0.1");
        appwin.setVisible(true);
        */



            /*
            The new connection is passed to the other classes.
             */
            DatabaseMachine dm = new DatabaseMachine(conn);
            LocalTableMachine tm = new LocalTableMachine(conn, user,
                    dbName);
            UserMachine um = new UserMachine(conn);

            tm.viewTables();




        } catch (RuntimeException e) {
            System.out.println(MessageFormat.format("Exception in main(): {0}", e.getMessage()));
        }
            /*
            Not autocloseable. Must manually Close connection
             */

            try {
                if(conn.isValid(120)) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.printf("Error closing SQL connection: %s%n", e.getMessage());
            }
        }

}
