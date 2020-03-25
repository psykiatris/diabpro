/*
 * Copyright (c) 2019. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;

import org.palczewski.edit.DatabaseMachine;
import org.palczewski.edit.TableMachine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

/**
 * Extends dbutils.TableMachine, so that it may override the
 * table creation and insertRecords methods
 */
public class LocalTableMachine extends TableMachine {

    // Variables
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    private String user;
    String dbName;


    /**
     * Creates LocalTableMachine object
     * @param conn   Current connection
     * @param user Current user
     * @param dbName Database Name
     */
    public LocalTableMachine(Connection conn, String user,
                               String dbName) {
        super(conn);
        this.conn = conn;
        this.user = user;
        this.dbName = dbName;
    }

    /**
     * Creates 2 linked tables for each user, uniquely identified by the
     * username: username.diary and username.nutrition
     */
    // TODO: 2/25/20 Need to set up a User object (containing name) so that it can be passed around.
    public final void createTable() {

        if(conn != null) {
            try {
                stmt = conn.createStatement();
                String table1 = MessageFormat.format("CREATE TABLE IF NOT EXISTS {0}_diary (date DATE, user_id CHAR(20), entry MEDIUMTEXT, CONSTRAINT PRIMARY KEY (date, user_id))", user);
                stmt.executeUpdate(table1);
                stmt.close();
                stmt = conn.createStatement();
                // Create nutrition table
                String table2 =
                        MessageFormat.format("CREATE TABLE IF NOT EXISTS {0}_nutrition (date DATE, user_id CHAR(20), food CHAR(20), cal INT UNSIGNED, carbs INT UNSIGNED, sugar INT UNSIGNED, CONSTRAINT FOREIGN KEY (date, user_id) REFERENCES {1}_diary (date, user_id))", user, user);
                stmt.executeUpdate(table2);
                stmt.close();
            } catch (SQLException e) {
                System.out.printf("SQL error in DiabproTableMachine.createTable(): %s%n", e.getMessage());
            }
        } else {
            System.out.println(DatabaseMachine.NO_CONNECTION);
        }
    }


}
