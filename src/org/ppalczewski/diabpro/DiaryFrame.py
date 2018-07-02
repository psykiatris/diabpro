# coding=utf-8
"""
Running window through Jython.
Currently, issues with finding packages...
It seems Jython already has a folder named resource, so it doesn't like
my resource folder
"""
# Unoirt created Java package
import org.ppalczewski.diabpro.resource as rs

import javax.swing as swing
import java.awt as awt
import java.lang as lang


def exit(event):
    lang.System.exit(0)


class DiaryFrame(swing.JFrame):
    panel1 = rs.DiaryPanel

    def __init__(self, title="Diabetes Pro - 0.99", size=(500, 500)):
        swing.JFrame.__init__(self, title, size=size, windowClosing=exit)
        self.contentPane.layout = awt.FlowLayout()
        # Success in creating frame.
        # Fails when attempting to add panels I've created.









if __name__ == '__main__':
    DiaryFrame().show()
