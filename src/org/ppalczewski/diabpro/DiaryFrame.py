# coding=utf-8
"""
Running window through Jython.
Currently, issues with finding packages...
May have to create empty __init__.py files to work.
"""
import javax.swing as swing
import java.awt as awt
import java.lang as lang
import org.ppalczewski.diabpro.resource as rs


def exit(event):
    lang.System.exit(0)


class DiaryFrame(swing.JFrame):
    title = "Diabetes pro - 0.99"

    def __init__(self, title, size=(500, 500)):
        swing.JFrame.__init__(self, title, size=size, windowClosing=exit)
        self.contentPane.layout = awt.FlowLayout()
        self.contentPane.add(rs.DiaryPanel)
        self.contentPane.add(rs.datePanel)
        self.contentPane.add(rs.statPanel)


if __name__ == '__main__':
    DiaryFrame()
