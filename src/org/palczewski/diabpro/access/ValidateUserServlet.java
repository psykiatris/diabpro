/*
 * Copyright (c) 2019. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;
/*
This will validate user's password with mySQL. If it passes, will go to
main program. If not, goes back to sign in page.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Gets params
        String userN = req.getParameter("user");
        String pass = req.getParameter("pass");

        // Connect to mySQL
        DBFuncs.doConnect();

        // Proecess validation
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doPost(req, res);
    }
}
