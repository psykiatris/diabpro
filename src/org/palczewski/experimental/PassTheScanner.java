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
                    cons.readPassword("%s", "Password:"))) != null)) {
                System.out.println("Voila!");
                System.out.printf("Your pwd was %s%n", (Object) pwd);
                java.util.Arrays.fill(pwd, ' ');
            } else {
                System.out.println("Bummer");
            }
        }
    }
}
