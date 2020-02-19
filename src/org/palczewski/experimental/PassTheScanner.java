/*
 * Copyright (c) 2020. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.experimental;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PassTheScanner {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in, StandardCharsets.UTF_8)) {

            System.out.print("Enter your name: ");
            String name = in.next();

            Console cons;
            char[] pwd;
            if((((cons = System.console())) != null) && (((pwd =
                    cons.readPassword("%s", "Enter password:"))) != null)) {
           // Run validity check
                System.out.println("Voila!");
                String pass = String.valueOf(pwd);

                System.out.printf("Your password was %s%n", pass);
                java.util.Arrays.fill(pwd, ' ');
            } else {    // not in console
                System.out.println("Bummer");
            }

        }
    }
}
