/*
 * Copyright (c) 2019. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;

import org.palczewski.core.UserMachine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
/*
This class extends dbutils' UserMachine for customization, along with
adding methods to validate user's credentials with the server.
 */
public class LocalUserMachine extends UserMachine {

    Connection conn;
    PreparedStatement pstmt;
    Statement stmt;
    String user;


    public LocalUserMachine(Connection conn, String user, String pw) {
        super(conn);
        this.conn = conn;
        this.user = user;
        // Run method to create user.
        createUser(user, pw);
    }


}


