/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.core;

import org.palczewski.diabpro.access.DBFuncs;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("Runs Diabetes Pro.");
        out.println("Connecting to database");
        DBFuncs.doConnect();
        out.println("Is database open? " + DBFuncs.isOpen());

    }
}