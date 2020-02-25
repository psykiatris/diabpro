/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.connect.SQLConnect;
import org.palczewski.core.UserMachine;
import org.palczewski.diabpro.access.LocalTableMachine;
import org.palczewski.diabpro.resource.DiaryGUI;
import org.palczewski.edit.DatabaseMachine;

import java.awt.*;
import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String DIABPRO = "diabpro";
    private static String user = null;
    private static final String dbName = null;
    private static final String rootUser = DIABPRO;
    private static final String rootPW = DIABPRO;
    private static Connection conn = null;

    public static void main(String[] args) {

        System.out.print(welcome());;

        setConnecion();

        /*
        Initialize objects with new SQL connection.
         */
        DatabaseMachine dm = getDM();
        LocalTableMachine tm = getLTM();
        UserMachine um = getUM();


        tm.createTable();
        tm.viewTables();

        closeSQLConn();

        System.out.println("Thank you for using Diabpro!");


    }

    /**
     * Generate welcome message
     * @return Welcome message
     */
    private static String welcome() {
        return "\tWelcome to Diabetes Pro 1.0!\nThis system will allow you to input diary information along with stats on the things you eat.\n";
    }

    /**
     * Manually closes SQL connection
     */
    private static void closeSQLConn() {

        try {
            if (conn.isValid(120)) {
                conn.close();
            }
        } catch (
                SQLException e) {
            System.out.printf("Error closing SQL connection: %s%n", e.getMessage());
        }
    }

    /**
     * Returns a UserMachine instance
     * @return UserMachine
     */
    private static UserMachine getUM() {
        return new UserMachine(conn);
    }

    /**
     * Returns a LocalTableMachine instance
     * @return LocalTableMachine
     */
    private static LocalTableMachine getLTM() {
        return new LocalTableMachine(conn, user,
                dbName);
    }

    /**
     * Returns DatabaseMachine instance
     * @return DatabaseMachine
     */
    private static DatabaseMachine getDM() {

        return new DatabaseMachine(conn);
    }

    /**
     *
     * Returns a connection instance
     * @return Connection
     */
    private static Connection setConnecion() {
        try (Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {



            System.out.println("\tPlease log in");
            System.out.print("Enter your username: ");
            String user = in.nextLine();
            // Console will intercept input
            Console cons;
            char[] pwd;
            String dbName = "diabetes";
            if ((((cons = System.console())) != null) && (((pwd =
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
        }
        user = user;
        return conn;
    }

    /**
     * Configures and runs GUI.
     */
    private void runGUI() {
        // Run GUI form

        DiaryGUI appwin = new DiaryGUI();


        appwin.setSize(new Dimension(595, 425));
        appwin.setTitle("Diabetes Pro v0.1");
        appwin.setVisible(true);


    }
}
