package com.vergil;

import gen.CMMBaseVisitor;
import gen.CMMParser;

import java.util.HashMap;

/**
 * Created by vergil on 2016/10/19.
 */
public class CMMBaseVisitorIML extends CMMBaseVisitor<Double> {
    private HashMap<String, Double> variables = new HashMap<String, Double>();

    @Override
    public Double visitSmallThExpr(CMMParser.SmallThExprContext ctx) {
        return super.visitSmallThExpr(ctx);
    }
}

