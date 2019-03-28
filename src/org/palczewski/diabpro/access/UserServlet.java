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
This will be a general class to allow creatiion of users in mySQL.

This class will connect as root to the mySQL program, and create the
user with appropriate permissions, then load the duabetes database.
 */
public class UserServlet extends HttpServlet {

    public void createUser(HttpServletRequest req,
                           HttpServletResponse res) throws ServletException, IOException {

        // Get username and password
        String userN = req.getParameter("username");
        String userP = req.getParameter("password");

        // connect to mySQL
        // TODO: 3/28/19 Change connection code to be able to log in as anyone to mySQL. 
        DBFuncs.doConnect();
    }

}
