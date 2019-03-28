/*
 * Copyright (c) 2019. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
This processes deletion of a user account. Will log in as root to mySQL
and delete user.
 */
public class RemoveUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Gets params from calling page
        String userN = req.getParameter("user");

        // connect to database
        DBFuncs.doConnect();

        // Set up commands
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doPost(req, res);
    }
}
