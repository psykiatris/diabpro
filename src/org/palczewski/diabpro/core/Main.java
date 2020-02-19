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

    static final String DIABPRO = "diabpro";
    static Connection conn;
    static String user;
    static String pw;
    static String dbName = "diabetes";
    private final String rootUser = DIABPRO;
    private final String rootPW = DIABPRO;

    public static void main(String[] args) {
        // TODO: 4/4/19 Password field is exposed. FIX FIX
        //Get input
        // TODO: 4/13/19 Move log in out of main into its own function.

        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)){


            System.out.println("\tWelcome to Diabetes Pro 1.0!\nThis system will allow you to input diary information along with stats on the things you eat.");
            System.out.println();
            System.out.println("\tPlease log in");
            System.out.print("Enter your username: ");
            user = in.nextLine();
            Console cons;
            char[] pwd;
            if((((cons = System.console())) != null) && (((pwd =
                    cons.readPassword("%s", "Password:"))) != null)) {
                String pw = String.valueOf(pwd);

                java.util.Arrays.fill(pwd, ' ');
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

            SQLConnect sconn = new SQLConnect();

            // SQL connection
            conn = sconn.doConnect(user, pw, dbName);

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
