package com.vergil;

import gen.CMMBaseListener;
import gen.CMMParser;
import org.antlr.v4.runtime.tree.ErrorNode;

import javax.swing.*;

/**
 * Created by vergil on 2016/10/22.
 */
public class CMMBaseListenerIML extends CMMBaseListener {
    CMMParser cmmParser;
    JTextArea info;

    public CMMBaseListenerIML(CMMParser parser) {
        this.cmmParser = parser;
    }

    public void setArea(JTextArea textArea) {
        info = textArea;
    }

    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        info.append("ERROR: " + node.getText()
                + " in line " + node.getSymbol().getLine()
                + ":" + node.getSymbol().getCharPositionInLine() + "\n");
    }
}

