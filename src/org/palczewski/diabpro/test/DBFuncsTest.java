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
    void createDB(String dbName) {
        db.createDB(dbName);
    }

    @org.junit.jupiter.api.Test
    void editDB() {
        db.listDb();
    }

    @org.junit.jupiter.api.Test
    void doClose() {
    }

    @org.junit.jupiter.api.Test
    void isOpen() {
    }
}