/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.test;

import org.palczewski.diabpro.access.DBFuncs;

class DBFuncsTest {
    DBFuncs db;

    DBFuncsTest() {
        db = new DBFuncs();
    }

    @org.junit.jupiter.api.Test
    void doConnect() {

        db.doConnect();
    }

    @org.junit.jupiter.api.Test
    void createDB() {
        db.createDB("diabetes");
    }

    @org.junit.jupiter.api.Test
    void listDB() {
        db.listDB();
    }

    @org.junit.jupiter.api.Test
    void editDB() {

    }

    @org.junit.jupiter.api.Test
    void doClose() {
    }

    @org.junit.jupiter.api.Test
    void isOpen() {
    }
}