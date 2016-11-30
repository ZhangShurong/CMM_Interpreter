// Generated from D:/GitOSChina/CMM_Interpreter/src\CMM.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		READ=1, WRITE=2, IF=3, ELSE=4, ELSEIF=5, WHILE=6, BREAK=7, INT=8, DOUBLE=9, 
		COMMA=10, SEMICOLON=11, IDENT=12, INTCONSTANT=13, DOUBLECONSTANT=14, TRUE=15, 
		FALSE=16, LBBRACKET=17, RBBRACKET=18, LMBRACKET=19, RMBRACKET=20, LSBRACKET=21, 
		RSBRACKET=22, SEQUAL=23, GEQUAL=24, DEQUAL=25, EQUAL=26, PLUS=27, MINUS=28, 
		MULT=29, DIV=30, MOD=31, WS=32, SL_COMMENT=33, MUL_COMMENT=34;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_stmtBlock = 2, RULE_varDecl = 3, 
		RULE_type = 4, RULE_array = 5, RULE_varList = 6, RULE_elseiflist = 7, 
		RULE_elseif = 8, RULE_ifStmt = 9, RULE_whileStmt = 10, RULE_breakStmt = 11, 
		RULE_readStmt = 12, RULE_writeStmt = 13, RULE_assignStmt = 14, RULE_value = 15, 
		RULE_constant = 16, RULE_expr = 17, RULE_addMin = 18, RULE_mulDiv = 19, 
		RULE_unaryMinus = 20, RULE_atom = 21;
	public static final String[] ruleNames = {
		"program", "stmt", "stmtBlock", "varDecl", "type", "array", "varList", 
		"elseiflist", "elseif", "ifStmt", "whileStmt", "breakStmt", "readStmt", 
		"writeStmt", "assignStmt", "value", "constant", "expr", "addMin", "mulDiv", 
		"unaryMinus", "atom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read'", "'write'", "'if'", "'else'", "'else if'", "'while'", "'break'", 
		"'int'", "'double'", "','", "';'", null, null, null, "'true'", "'false'", 
		"'{'", "'}'", "'['", "']'", "'('", "')'", "'<='", "'>='", "'=='", "'='", 
		"'+'", "'-'", "'*'", "'/'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", 
		"DOUBLE", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"TRUE", "FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "SEQUAL", "GEQUAL", "DEQUAL", "EQUAL", "PLUS", "MINUS", "MULT", 
		"DIV", "MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CMM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CMMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				stmt();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << WRITE) | (1L << IF) | (1L << WHILE) | (1L << BREAK) | (1L << INT) | (1L << DOUBLE) | (1L << IDENT) | (1L << LBBRACKET))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				varDecl();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				ifStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				whileStmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				breakStmt();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				assignStmt();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 6);
				{
				setState(54);
				readStmt();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 7);
				{
				setState(55);
				writeStmt();
				}
				break;
			case LBBRACKET:
				enterOuterAlt(_localctx, 8);
				{
				setState(56);
				stmtBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtBlockContext extends ParserRuleContext {
		public TerminalNode LBBRACKET() { return getToken(CMMParser.LBBRACKET, 0); }
		public TerminalNode RBBRACKET() { return getToken(CMMParser.RBBRACKET, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterStmtBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitStmtBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitStmtBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtBlockContext stmtBlock() throws RecognitionException {
		StmtBlockContext _localctx = new StmtBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmtBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LBBRACKET);
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				stmt();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << WRITE) | (1L << IF) | (1L << WHILE) | (1L << BREAK) | (1L << INT) | (1L << DOUBLE) | (1L << IDENT) | (1L << LBBRACKET))) != 0) );
			setState(65);
			match(RBBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMMParser.SEMICOLON, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			type();
			setState(68);
			varList();
			setState(69);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToArrayContext extends TypeContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ToArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterToArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitToArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitToArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIntContext extends TypeContext {
		public TerminalNode INT() { return getToken(CMMParser.INT, 0); }
		public TypeIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeDoubleContext extends TypeContext {
		public TerminalNode DOUBLE() { return getToken(CMMParser.DOUBLE, 0); }
		public TypeDoubleContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterTypeDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitTypeDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitTypeDouble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(INT);
				}
				break;
			case 2:
				_localctx = new TypeDoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(DOUBLE);
				}
				break;
			case 3:
				_localctx = new ToArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				array();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LMBRACKET() { return getToken(CMMParser.LMBRACKET, 0); }
		public TerminalNode INTCONSTANT() { return getToken(CMMParser.INTCONSTANT, 0); }
		public TerminalNode RMBRACKET() { return getToken(CMMParser.RMBRACKET, 0); }
		public TerminalNode DOUBLE() { return getToken(CMMParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(CMMParser.INT, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(77);
			match(LMBRACKET);
			setState(78);
			match(INTCONSTANT);
			setState(79);
			match(RMBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarListContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CMMParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CMMParser.IDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CMMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CMMParser.COMMA, i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(IDENT);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				match(IDENT);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseiflistContext extends ParserRuleContext {
		public List<ElseifContext> elseif() {
			return getRuleContexts(ElseifContext.class);
		}
		public ElseifContext elseif(int i) {
			return getRuleContext(ElseifContext.class,i);
		}
		public ElseiflistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseiflist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterElseiflist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitElseiflist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitElseiflist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseiflistContext elseiflist() throws RecognitionException {
		ElseiflistContext _localctx = new ElseiflistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseiflist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				elseif();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELSEIF );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseifContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(CMMParser.ELSEIF, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitElseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ELSEIF);
			setState(95);
			match(LSBRACKET);
			setState(96);
			expr(0);
			setState(97);
			match(RSBRACKET);
			setState(98);
			stmtBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IFELSELISTContext extends IfStmtContext {
		public TerminalNode IF() { return getToken(CMMParser.IF, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public ElseiflistContext elseiflist() {
			return getRuleContext(ElseiflistContext.class,0);
		}
		public IFELSELISTContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterIFELSELIST(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitIFELSELIST(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitIFELSELIST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IFELSELISTELSEContext extends IfStmtContext {
		public TerminalNode IF() { return getToken(CMMParser.IF, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public List<StmtBlockContext> stmtBlock() {
			return getRuleContexts(StmtBlockContext.class);
		}
		public StmtBlockContext stmtBlock(int i) {
			return getRuleContext(StmtBlockContext.class,i);
		}
		public ElseiflistContext elseiflist() {
			return getRuleContext(ElseiflistContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(CMMParser.ELSE, 0); }
		public IFELSELISTELSEContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterIFELSELISTELSE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitIFELSELISTELSE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitIFELSELISTELSE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ONLYIFContext extends IfStmtContext {
		public TerminalNode IF() { return getToken(CMMParser.IF, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public ONLYIFContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterONLYIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitONLYIF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitONLYIF(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IFELSEContext extends IfStmtContext {
		public TerminalNode IF() { return getToken(CMMParser.IF, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public List<StmtBlockContext> stmtBlock() {
			return getRuleContexts(StmtBlockContext.class);
		}
		public StmtBlockContext stmtBlock(int i) {
			return getRuleContext(StmtBlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CMMParser.ELSE, 0); }
		public IFELSEContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterIFELSE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitIFELSE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitIFELSE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStmt);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ONLYIFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(IF);
				setState(101);
				match(LSBRACKET);
				setState(102);
				expr(0);
				setState(103);
				match(RSBRACKET);
				setState(104);
				stmtBlock();
				}
				break;
			case 2:
				_localctx = new IFELSEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(IF);
				setState(107);
				match(LSBRACKET);
				setState(108);
				expr(0);
				setState(109);
				match(RSBRACKET);
				setState(110);
				stmtBlock();
				setState(111);
				match(ELSE);
				setState(112);
				stmtBlock();
				}
				break;
			case 3:
				_localctx = new IFELSELISTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(IF);
				setState(115);
				match(LSBRACKET);
				setState(116);
				expr(0);
				setState(117);
				match(RSBRACKET);
				setState(118);
				stmtBlock();
				setState(119);
				elseiflist();
				}
				break;
			case 4:
				_localctx = new IFELSELISTELSEContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				match(IF);
				setState(122);
				match(LSBRACKET);
				setState(123);
				expr(0);
				setState(124);
				match(RSBRACKET);
				setState(125);
				stmtBlock();
				setState(126);
				elseiflist();
				setState(127);
				match(ELSE);
				setState(128);
				stmtBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CMMParser.WHILE, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public StmtBlockContext stmtBlock() {
			return getRuleContext(StmtBlockContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(WHILE);
			setState(133);
			match(LSBRACKET);
			setState(134);
			expr(0);
			setState(135);
			match(RSBRACKET);
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(136);
				stmtBlock();
				}
				break;
			case 2:
				{
				setState(137);
				stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(CMMParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMMParser.SEMICOLON, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterBreakStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitBreakStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(BREAK);
			setState(141);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadStmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(CMMParser.READ, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMMParser.SEMICOLON, 0); }
		public TerminalNode IDENT() { return getToken(CMMParser.IDENT, 0); }
		public TerminalNode LMBRACKET() { return getToken(CMMParser.LMBRACKET, 0); }
		public TerminalNode INTCONSTANT() { return getToken(CMMParser.INTCONSTANT, 0); }
		public TerminalNode RMBRACKET() { return getToken(CMMParser.RMBRACKET, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitReadStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitReadStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_readStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(READ);
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(144);
				match(IDENT);
				}
				}
				break;
			case 2:
				{
				{
				setState(145);
				match(IDENT);
				setState(146);
				match(LMBRACKET);
				setState(147);
				match(INTCONSTANT);
				setState(148);
				match(RMBRACKET);
				}
				}
				break;
			}
			setState(151);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteStmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(CMMParser.WRITE, 0); }
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(CMMParser.SEMICOLON, 0); }
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitWriteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitWriteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(WRITE);
			setState(154);
			match(LSBRACKET);
			setState(155);
			expr(0);
			setState(156);
			match(RSBRACKET);
			setState(157);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(CMMParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CMMParser.SEMICOLON, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			value();
			setState(160);
			match(EQUAL);
			setState(161);
			expr(0);
			setState(162);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CMMParser.IDENT, 0); }
		public TerminalNode LMBRACKET() { return getToken(CMMParser.LMBRACKET, 0); }
		public TerminalNode INTCONSTANT() { return getToken(CMMParser.INTCONSTANT, 0); }
		public TerminalNode RMBRACKET() { return getToken(CMMParser.RMBRACKET, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(164);
				match(IDENT);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(165);
				match(IDENT);
				setState(166);
				match(LMBRACKET);
				setState(167);
				match(INTCONSTANT);
				setState(168);
				match(RMBRACKET);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BOOLContext extends ConstantContext {
		public TerminalNode TRUE() { return getToken(CMMParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CMMParser.FALSE, 0); }
		public BOOLContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterBOOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitBOOL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitBOOL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NUMContext extends ConstantContext {
		public TerminalNode INTCONSTANT() { return getToken(CMMParser.INTCONSTANT, 0); }
		public TerminalNode DOUBLECONSTANT() { return getToken(CMMParser.DOUBLECONSTANT, 0); }
		public NUMContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterNUM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitNUM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitNUM(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constant);
		int _la;
		try {
			setState(173);
			switch (_input.LA(1)) {
			case INTCONSTANT:
			case DOUBLECONSTANT:
				_localctx = new NUMContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				_la = _input.LA(1);
				if ( !(_la==INTCONSTANT || _la==DOUBLECONSTANT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BOOLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DEQUAL() { return getToken(CMMParser.DEQUAL, 0); }
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallThExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEQUAL() { return getToken(CMMParser.SEQUAL, 0); }
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public SmallThExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterSmallThExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitSmallThExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitSmallThExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAddminExprContext extends ExprContext {
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public ToAddminExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterToAddminExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitToAddminExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitToAddminExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GrateThanExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode GEQUAL() { return getToken(CMMParser.GEQUAL, 0); }
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public GrateThanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterGrateThanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitGrateThanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitGrateThanExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAddminExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(176);
			addMin(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(187);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new SmallThExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(179);
						match(SEQUAL);
						setState(180);
						addMin(0);
						}
						break;
					case 2:
						{
						_localctx = new GrateThanExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(182);
						match(GEQUAL);
						setState(183);
						addMin(0);
						}
						break;
					case 3:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(185);
						match(DEQUAL);
						setState(186);
						addMin(0);
						}
						break;
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddMinContext extends ParserRuleContext {
		public AddMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMin; }
	 
		public AddMinContext() { }
		public void copyFrom(AddMinContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TomulDivContext extends AddMinContext {
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public TomulDivContext(AddMinContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterTomulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitTomulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitTomulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends AddMinContext {
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(CMMParser.PLUS, 0); }
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public PlusContext(AddMinContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusContext extends AddMinContext {
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CMMParser.MINUS, 0); }
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public MinusContext(AddMinContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddMinContext addMin() throws RecognitionException {
		return addMin(0);
	}

	private AddMinContext addMin(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddMinContext _localctx = new AddMinContext(_ctx, _parentState);
		AddMinContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_addMin, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TomulDivContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(193);
			mulDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(201);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new AddMinContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_addMin);
						setState(195);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(196);
						match(PLUS);
						setState(197);
						mulDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new AddMinContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_addMin);
						setState(198);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(199);
						match(MINUS);
						setState(200);
						mulDiv(0);
						}
						break;
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulDivContext extends ParserRuleContext {
		public MulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDiv; }
	 
		public MulDivContext() { }
		public void copyFrom(MulDivContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TounaryMinusContext extends MulDivContext {
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public TounaryMinusContext(MulDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterTounaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitTounaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitTounaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends MulDivContext {
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CMMParser.MULT, 0); }
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public MultiplicationContext(MulDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionContext extends MulDivContext {
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public TerminalNode DIV() { return getToken(CMMParser.DIV, 0); }
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public DivisionContext(MulDivContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivContext mulDiv() throws RecognitionException {
		return mulDiv(0);
	}

	private MulDivContext mulDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulDivContext _localctx = new MulDivContext(_ctx, _parentState);
		MulDivContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_mulDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TounaryMinusContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(207);
			unaryMinus();
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(215);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new MulDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulDiv);
						setState(209);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(210);
						match(MULT);
						setState(211);
						unaryMinus();
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new MulDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulDiv);
						setState(212);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(213);
						match(DIV);
						setState(214);
						unaryMinus();
						}
						break;
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryMinusContext extends ParserRuleContext {
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
	 
		public UnaryMinusContext() { }
		public void copyFrom(UnaryMinusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChangeSignContext extends UnaryMinusContext {
		public TerminalNode MINUS() { return getToken(CMMParser.MINUS, 0); }
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public ChangeSignContext(UnaryMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterChangeSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitChangeSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitChangeSign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAtomContext extends UnaryMinusContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(UnaryMinusContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterToAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitToAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryMinus);
		try {
			setState(223);
			switch (_input.LA(1)) {
			case MINUS:
				_localctx = new ChangeSignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(MINUS);
				setState(221);
				unaryMinus();
				}
				break;
			case IDENT:
			case INTCONSTANT:
			case DOUBLECONSTANT:
			case TRUE:
			case FALSE:
			case LSBRACKET:
				_localctx = new ToAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentifierContext extends AtomContext {
		public TerminalNode IDENT() { return getToken(CMMParser.IDENT, 0); }
		public IdentifierContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToExprContext extends AtomContext {
		public TerminalNode LSBRACKET() { return getToken(CMMParser.LSBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSBRACKET() { return getToken(CMMParser.RSBRACKET, 0); }
		public ToExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterToExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitToExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToConstantContext extends AtomContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ToConstantContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).enterToConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CMMListener ) ((CMMListener)listener).exitToConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CMMVisitor ) return ((CMMVisitor<? extends T>)visitor).visitToConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_atom);
		try {
			setState(231);
			switch (_input.LA(1)) {
			case IDENT:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(IDENT);
				}
				break;
			case INTCONSTANT:
			case DOUBLECONSTANT:
			case TRUE:
			case FALSE:
				_localctx = new ToConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				constant();
				}
				break;
			case LSBRACKET:
				_localctx = new ToExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(LSBRACKET);
				setState(228);
				expr(0);
				setState(229);
				match(RSBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 18:
			return addMin_sempred((AddMinContext)_localctx, predIndex);
		case 19:
			return mulDiv_sempred((MulDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addMin_sempred(AddMinContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulDiv_sempred(MulDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u00ec\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\6\2\60\n\2\r\2"+
		"\16\2\61\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\6\4@\n\4\r\4"+
		"\16\4A\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\7\bW\n\b\f\b\16\bZ\13\b\3\t\6\t]\n\t\r\t\16\t^\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0085\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u008d\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0098\n\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00ac\n\21\3\22\3\22\5\22\u00b0\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00be\n\23\f\23"+
		"\16\23\u00c1\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00cc"+
		"\n\24\f\24\16\24\u00cf\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\7\25\u00da\n\25\f\25\16\25\u00dd\13\25\3\26\3\26\3\26\5\26\u00e2\n"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ea\n\27\3\27\2\5$&(\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\5\3\2\n\13\3\2\17\20\3\2\21"+
		"\22\u00f3\2/\3\2\2\2\4;\3\2\2\2\6=\3\2\2\2\bE\3\2\2\2\nL\3\2\2\2\fN\3"+
		"\2\2\2\16S\3\2\2\2\20\\\3\2\2\2\22`\3\2\2\2\24\u0084\3\2\2\2\26\u0086"+
		"\3\2\2\2\30\u008e\3\2\2\2\32\u0091\3\2\2\2\34\u009b\3\2\2\2\36\u00a1\3"+
		"\2\2\2 \u00ab\3\2\2\2\"\u00af\3\2\2\2$\u00b1\3\2\2\2&\u00c2\3\2\2\2(\u00d0"+
		"\3\2\2\2*\u00e1\3\2\2\2,\u00e9\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\61\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63<\5\b\5\2\64<\5\24\13\2"+
		"\65<\5\26\f\2\66<\5\30\r\2\67<\5\36\20\28<\5\32\16\29<\5\34\17\2:<\5\6"+
		"\4\2;\63\3\2\2\2;\64\3\2\2\2;\65\3\2\2\2;\66\3\2\2\2;\67\3\2\2\2;8\3\2"+
		"\2\2;9\3\2\2\2;:\3\2\2\2<\5\3\2\2\2=?\7\23\2\2>@\5\4\3\2?>\3\2\2\2@A\3"+
		"\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\24\2\2D\7\3\2\2\2EF\5\n\6\2F"+
		"G\5\16\b\2GH\7\r\2\2H\t\3\2\2\2IM\7\n\2\2JM\7\13\2\2KM\5\f\7\2LI\3\2\2"+
		"\2LJ\3\2\2\2LK\3\2\2\2M\13\3\2\2\2NO\t\2\2\2OP\7\25\2\2PQ\7\17\2\2QR\7"+
		"\26\2\2R\r\3\2\2\2SX\7\16\2\2TU\7\f\2\2UW\7\16\2\2VT\3\2\2\2WZ\3\2\2\2"+
		"XV\3\2\2\2XY\3\2\2\2Y\17\3\2\2\2ZX\3\2\2\2[]\5\22\n\2\\[\3\2\2\2]^\3\2"+
		"\2\2^\\\3\2\2\2^_\3\2\2\2_\21\3\2\2\2`a\7\7\2\2ab\7\27\2\2bc\5$\23\2c"+
		"d\7\30\2\2de\5\6\4\2e\23\3\2\2\2fg\7\5\2\2gh\7\27\2\2hi\5$\23\2ij\7\30"+
		"\2\2jk\5\6\4\2k\u0085\3\2\2\2lm\7\5\2\2mn\7\27\2\2no\5$\23\2op\7\30\2"+
		"\2pq\5\6\4\2qr\7\6\2\2rs\5\6\4\2s\u0085\3\2\2\2tu\7\5\2\2uv\7\27\2\2v"+
		"w\5$\23\2wx\7\30\2\2xy\5\6\4\2yz\5\20\t\2z\u0085\3\2\2\2{|\7\5\2\2|}\7"+
		"\27\2\2}~\5$\23\2~\177\7\30\2\2\177\u0080\5\6\4\2\u0080\u0081\5\20\t\2"+
		"\u0081\u0082\7\6\2\2\u0082\u0083\5\6\4\2\u0083\u0085\3\2\2\2\u0084f\3"+
		"\2\2\2\u0084l\3\2\2\2\u0084t\3\2\2\2\u0084{\3\2\2\2\u0085\25\3\2\2\2\u0086"+
		"\u0087\7\b\2\2\u0087\u0088\7\27\2\2\u0088\u0089\5$\23\2\u0089\u008c\7"+
		"\30\2\2\u008a\u008d\5\6\4\2\u008b\u008d\5\4\3\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\27\3\2\2\2\u008e\u008f\7\t\2\2\u008f\u0090\7\r\2"+
		"\2\u0090\31\3\2\2\2\u0091\u0097\7\3\2\2\u0092\u0098\7\16\2\2\u0093\u0094"+
		"\7\16\2\2\u0094\u0095\7\25\2\2\u0095\u0096\7\17\2\2\u0096\u0098\7\26\2"+
		"\2\u0097\u0092\3\2\2\2\u0097\u0093\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\7\r\2\2\u009a\33\3\2\2\2\u009b\u009c\7\4\2\2\u009c\u009d\7\27\2\2\u009d"+
		"\u009e\5$\23\2\u009e\u009f\7\30\2\2\u009f\u00a0\7\r\2\2\u00a0\35\3\2\2"+
		"\2\u00a1\u00a2\5 \21\2\u00a2\u00a3\7\34\2\2\u00a3\u00a4\5$\23\2\u00a4"+
		"\u00a5\7\r\2\2\u00a5\37\3\2\2\2\u00a6\u00ac\7\16\2\2\u00a7\u00a8\7\16"+
		"\2\2\u00a8\u00a9\7\25\2\2\u00a9\u00aa\7\17\2\2\u00aa\u00ac\7\26\2\2\u00ab"+
		"\u00a6\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac!\3\2\2\2\u00ad\u00b0\t\3\2\2"+
		"\u00ae\u00b0\t\4\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0#\3"+
		"\2\2\2\u00b1\u00b2\b\23\1\2\u00b2\u00b3\5&\24\2\u00b3\u00bf\3\2\2\2\u00b4"+
		"\u00b5\f\6\2\2\u00b5\u00b6\7\31\2\2\u00b6\u00be\5&\24\2\u00b7\u00b8\f"+
		"\5\2\2\u00b8\u00b9\7\32\2\2\u00b9\u00be\5&\24\2\u00ba\u00bb\f\4\2\2\u00bb"+
		"\u00bc\7\33\2\2\u00bc\u00be\5&\24\2\u00bd\u00b4\3\2\2\2\u00bd\u00b7\3"+
		"\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0%\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\b\24\1\2"+
		"\u00c3\u00c4\5(\25\2\u00c4\u00cd\3\2\2\2\u00c5\u00c6\f\5\2\2\u00c6\u00c7"+
		"\7\35\2\2\u00c7\u00cc\5(\25\2\u00c8\u00c9\f\4\2\2\u00c9\u00ca\7\36\2\2"+
		"\u00ca\u00cc\5(\25\2\u00cb\u00c5\3\2\2\2\u00cb\u00c8\3\2\2\2\u00cc\u00cf"+
		"\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\'\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00d1\b\25\1\2\u00d1\u00d2\5*\26\2\u00d2\u00db\3"+
		"\2\2\2\u00d3\u00d4\f\5\2\2\u00d4\u00d5\7\37\2\2\u00d5\u00da\5*\26\2\u00d6"+
		"\u00d7\f\4\2\2\u00d7\u00d8\7 \2\2\u00d8\u00da\5*\26\2\u00d9\u00d3\3\2"+
		"\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc)\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\36\2\2"+
		"\u00df\u00e2\5*\26\2\u00e0\u00e2\5,\27\2\u00e1\u00de\3\2\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2+\3\2\2\2\u00e3\u00ea\7\16\2\2\u00e4\u00ea\5\"\22\2\u00e5"+
		"\u00e6\7\27\2\2\u00e6\u00e7\5$\23\2\u00e7\u00e8\7\30\2\2\u00e8\u00ea\3"+
		"\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00ea"+
		"-\3\2\2\2\25\61;ALX^\u0084\u008c\u0097\u00ab\u00af\u00bd\u00bf\u00cb\u00cd"+
		"\u00d9\u00db\u00e1\u00e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}