/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.ppalczewski.diabpro.resource;

import javax.swing.JPanel;
import java.text.MessageFormat;

public class DatePickPanel {
    private JPanel panel1;

    public DatePickPanel() {
    }

    @Override
    public final String toString() {
        return MessageFormat.format("DatePickPanel'{'panel1={0}'}'", panel1);
    }
}
