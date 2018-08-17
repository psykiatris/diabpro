/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.ppalczewski.diabpro.core;

public class Main {

    public static void main(String[] args) {
        System.out.println("Runs Diabetes Pro.");
        System.out.println("Connecting to database");
        ConnectDatabase.doConnect();
        System.out.println("Is database open? " + ConnectDatabase.isOpen());

    }
}