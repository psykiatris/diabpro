/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.ppalczewski.diabpro.access;
/*
Once connected to database, these functions will allow creation of
initial database, editing fields in database.
 */


public class DatabaseFunctions {

    public void crateDDB() {
        // Check if database is open
        if(!ConnectDatabase.isOpen())
            return;
        // Set up new database.
        // TODO: 8/19/18 Create mySQL db

    }

    public void editDB() {
        // Make changes to db
        // TODO: 8/19/18 - Edit db
    }
    // When done
    // TODO: 8/19/18 Move doCloase function here, if can't call it.


}
