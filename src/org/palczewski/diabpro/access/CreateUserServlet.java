/*
 * Copyright (c) 2019. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;

import org.palczewski.connect.MainConnect;
import org.palczewski.core.UserMachine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/*
This will be a general class to allow creatiion of users in mySQL.

This class will connect as root to the mySQL program, and create the
user with appropriate permissions, then load the duabetes database.
 */
public class CreateUserServlet extends HttpServlet {

    private final String DBNAME = "diabetes";
    UserMachine um;

    public void doPost(HttpServletRequest req,
                           HttpServletResponse res) throws ServletException, IOException {

        // Get username and password
        String userN = req.getParameter("username");
        String userP = req.getParameter("password");

        // connect to mySQL
        //
        MainConnect mc = new MainConnect();
        Connection conn = mc.doConnect(userN, userP, DBNAME);
        um = new UserMachine(conn);
        PrintWriter pw = res.getWriter();
        pw.println("<h2>Connected to SQL server</h2>");

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }

}
