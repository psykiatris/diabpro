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

/*
This class extends dbutils.TableMachine, so that it may override the
table creation and insetRecords methods
 */
public class DiabproTableMachine extends TableMachine {

    // Variables
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    String user;
    String dbName;

    public DiabproTableMachine(Connection conn, String user,
                               String dbName) {
        super(conn);
        this.conn = conn;
        this.user = user;
        this.dbName = dbName;
    }

    public void createTable() {
        /*
        This method creates two tables with user's name, the diary and
        nutrition tables.

         */
        if(conn != null) {
            try {
                stmt = conn.createStatement();
                String table1 = MessageFormat.format("CREATE TABLE IF NOT EXISTS {0}_diary (date DATE, user_id CHAR(20), entry MEDIUMTEXT, CONSTRAINT PRIMARY KEY (date, user_id))", user);
                stmt.executeUpdate(table1);
                stmt.close();
                stmt = conn.createStatement();
                // Create nutrition table
                String table2 =
                        MessageFormat.format("CREATE TABLE IF NOT EXISTS {0}_nutrition (user CHAR(20),date DATE, food CHAR(20), cal INT, carbs INT, sugar INT, CONSTRAINT FOREIGN KEY (user, date) REFERENCES {1}_diary (date, user_id))", user, user);
                stmt.executeUpdate(table2);
                stmt.close();
            } catch (SQLException e) {
                System.out.println("SQL error in DiabproTableMachine" +
                        ".createTable(): " + e.getMessage());
            }
        } else {
            System.out.println(DatabaseMachine.NO_CONNECTION);
        }
    }


}
