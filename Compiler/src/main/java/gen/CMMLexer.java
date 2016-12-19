package gen;// Generated from /home/vergil/Projects/GitOSChina/CMM_Interpreter/Compiler/src/main/CMM.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		READ=1, WRITE=2, IF=3, ELSE=4, ELSEIF=5, WHILE=6, BREAK=7, INT=8, DOUBLE=9, 
		STRING=10, COMMA=11, SEMICOLON=12, IDENT=13, INTCONSTANT=14, DOUBLECONSTANT=15, 
		STRINGCONSTANT=16, TRUE=17, FALSE=18, LBBRACKET=19, RBBRACKET=20, LMBRACKET=21, 
		RMBRACKET=22, LSBRACKET=23, RSBRACKET=24, SEQUAL=25, SMALLER=26, GEQUAL=27, 
		GREATER=28, DEQUAL=29, NEQUAL=30, EQUAL=31, PLUS=32, MINUS=33, MULT=34, 
		DIV=35, MOD=36, WS=37, SL_COMMENT=38, MUL_COMMENT=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", "DOUBLE", 
		"STRING", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"STRINGCONSTANT", "EncodingPrefix", "SCharSequence", "SChar", "SimpleEscapeSequence", 
		"TRUE", "FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "SEQUAL", "SMALLER", "GEQUAL", "GREATER", "DEQUAL", "NEQUAL", 
		"EQUAL", "PLUS", "MINUS", "MULT", "DIV", "MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read'", "'write'", "'if'", "'else'", "'else if'", "'while'", "'break'", 
		"'int'", "'double'", "'string'", "','", "';'", null, null, null, null, 
		"'true'", "'false'", "'{'", "'}'", "'['", "']'", "'('", "')'", "'<='", 
		"'<'", "'>='", "'>'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", "'/'", 
		"'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", 
		"DOUBLE", "STRING", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"STRINGCONSTANT", "TRUE", "FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", 
		"RMBRACKET", "LSBRACKET", "RSBRACKET", "SEQUAL", "SMALLER", "GEQUAL", 
		"GREATER", "DEQUAL", "NEQUAL", "EQUAL", "PLUS", "MINUS", "MULT", "DIV", 
		"MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
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


	public CMMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CMM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u0122\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\7\16\u0099\n"+
		"\16\f\16\16\16\u009c\13\16\3\17\3\17\3\17\7\17\u00a1\n\17\f\17\16\17\u00a4"+
		"\13\17\5\17\u00a6\n\17\3\20\3\20\3\20\6\20\u00ab\n\20\r\20\16\20\u00ac"+
		"\5\20\u00af\n\20\3\21\5\21\u00b2\n\21\3\21\3\21\5\21\u00b6\n\21\3\21\3"+
		"\21\3\22\3\22\3\22\5\22\u00bd\n\22\3\23\6\23\u00c0\n\23\r\23\16\23\u00c1"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cb\n\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3"+
		" \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\6*\u0104\n*\r*\16*\u0105\3*\3*\3+\3+\3+\3+\7+\u010e\n+\f+\16+\u0111"+
		"\13+\3+\3+\3,\3,\3,\3,\7,\u0119\n,\f,\16,\u011c\13,\3,\3,\3,\3,\3,\3\u011a"+
		"\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2%\2\'\2)\2+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33"+
		"=\34?\35A\36C\37E G!I\"K#M$O%Q&S\'U(W)\3\2\13\5\2C\\aac|\6\2\62;C\\aa"+
		"c|\3\2\63;\3\2\62;\5\2NNWWww\6\2\f\f\17\17$$^^\f\2$$))AA^^cdhhppttvvx"+
		"x\6\2\13\f\17\17\"\"))\4\2\f\f\17\17\u012c\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5^\3\2\2\2\7d\3\2\2\2\tg\3\2\2\2\13l\3\2"+
		"\2\2\rt\3\2\2\2\17z\3\2\2\2\21\u0080\3\2\2\2\23\u0084\3\2\2\2\25\u008b"+
		"\3\2\2\2\27\u0092\3\2\2\2\31\u0094\3\2\2\2\33\u0096\3\2\2\2\35\u00a5\3"+
		"\2\2\2\37\u00a7\3\2\2\2!\u00b1\3\2\2\2#\u00bc\3\2\2\2%\u00bf\3\2\2\2\'"+
		"\u00ca\3\2\2\2)\u00cc\3\2\2\2+\u00cf\3\2\2\2-\u00d4\3\2\2\2/\u00da\3\2"+
		"\2\2\61\u00dc\3\2\2\2\63\u00de\3\2\2\2\65\u00e0\3\2\2\2\67\u00e2\3\2\2"+
		"\29\u00e4\3\2\2\2;\u00e6\3\2\2\2=\u00e9\3\2\2\2?\u00eb\3\2\2\2A\u00ee"+
		"\3\2\2\2C\u00f0\3\2\2\2E\u00f3\3\2\2\2G\u00f6\3\2\2\2I\u00f8\3\2\2\2K"+
		"\u00fa\3\2\2\2M\u00fc\3\2\2\2O\u00fe\3\2\2\2Q\u0100\3\2\2\2S\u0103\3\2"+
		"\2\2U\u0109\3\2\2\2W\u0114\3\2\2\2YZ\7t\2\2Z[\7g\2\2[\\\7c\2\2\\]\7f\2"+
		"\2]\4\3\2\2\2^_\7y\2\2_`\7t\2\2`a\7k\2\2ab\7v\2\2bc\7g\2\2c\6\3\2\2\2"+
		"de\7k\2\2ef\7h\2\2f\b\3\2\2\2gh\7g\2\2hi\7n\2\2ij\7u\2\2jk\7g\2\2k\n\3"+
		"\2\2\2lm\7g\2\2mn\7n\2\2no\7u\2\2op\7g\2\2pq\7\"\2\2qr\7k\2\2rs\7h\2\2"+
		"s\f\3\2\2\2tu\7y\2\2uv\7j\2\2vw\7k\2\2wx\7n\2\2xy\7g\2\2y\16\3\2\2\2z"+
		"{\7d\2\2{|\7t\2\2|}\7g\2\2}~\7c\2\2~\177\7m\2\2\177\20\3\2\2\2\u0080\u0081"+
		"\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7v\2\2\u0083\22\3\2\2\2\u0084\u0085"+
		"\7f\2\2\u0085\u0086\7q\2\2\u0086\u0087\7w\2\2\u0087\u0088\7d\2\2\u0088"+
		"\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\24\3\2\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u008e\7t\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2"+
		"\u0090\u0091\7i\2\2\u0091\26\3\2\2\2\u0092\u0093\7.\2\2\u0093\30\3\2\2"+
		"\2\u0094\u0095\7=\2\2\u0095\32\3\2\2\2\u0096\u009a\t\2\2\2\u0097\u0099"+
		"\t\3\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\34\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a6\7\62\2"+
		"\2\u009e\u00a2\t\4\2\2\u009f\u00a1\t\5\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a6\36\3\2\2"+
		"\2\u00a7\u00ae\5\35\17\2\u00a8\u00aa\7\60\2\2\u00a9\u00ab\t\5\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		" \3\2\2\2\u00b0\u00b2\5#\22\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u00b5\7$\2\2\u00b4\u00b6\5%\23\2\u00b5\u00b4"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8"+
		"\"\3\2\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bd\7:\2\2\u00bb\u00bd\t\6\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd$\3\2\2\2\u00be\u00c0\5\'\24\2"+
		"\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2&\3\2\2\2\u00c3\u00cb\n\7\2\2\u00c4\u00cb\5)\25\2\u00c5"+
		"\u00c6\7^\2\2\u00c6\u00cb\7\f\2\2\u00c7\u00c8\7^\2\2\u00c8\u00c9\7\17"+
		"\2\2\u00c9\u00cb\7\f\2\2\u00ca\u00c3\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca"+
		"\u00c5\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb(\3\2\2\2\u00cc\u00cd\7^\2\2\u00cd"+
		"\u00ce\t\b\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7t\2\2\u00d1"+
		"\u00d2\7w\2\2\u00d2\u00d3\7g\2\2\u00d3,\3\2\2\2\u00d4\u00d5\7h\2\2\u00d5"+
		"\u00d6\7c\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7g\2\2"+
		"\u00d9.\3\2\2\2\u00da\u00db\7}\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7\177"+
		"\2\2\u00dd\62\3\2\2\2\u00de\u00df\7]\2\2\u00df\64\3\2\2\2\u00e0\u00e1"+
		"\7_\2\2\u00e1\66\3\2\2\2\u00e2\u00e3\7*\2\2\u00e38\3\2\2\2\u00e4\u00e5"+
		"\7+\2\2\u00e5:\3\2\2\2\u00e6\u00e7\7>\2\2\u00e7\u00e8\7?\2\2\u00e8<\3"+
		"\2\2\2\u00e9\u00ea\7>\2\2\u00ea>\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec\u00ed"+
		"\7?\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7@\2\2\u00efB\3\2\2\2\u00f0\u00f1\7"+
		"?\2\2\u00f1\u00f2\7?\2\2\u00f2D\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4\u00f5"+
		"\7?\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7?\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7"+
		"-\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7/\2\2\u00fbL\3\2\2\2\u00fc\u00fd\7,"+
		"\2\2\u00fdN\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ffP\3\2\2\2\u0100\u0101\7"+
		"\'\2\2\u0101R\3\2\2\2\u0102\u0104\t\t\2\2\u0103\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u0108\b*\2\2\u0108T\3\2\2\2\u0109\u010a\7\61\2\2\u010a\u010b\7\61\2\2"+
		"\u010b\u010f\3\2\2\2\u010c\u010e\n\n\2\2\u010d\u010c\3\2\2\2\u010e\u0111"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\b+\3\2\u0113V\3\2\2\2\u0114\u0115\7\61\2\2"+
		"\u0115\u0116\7,\2\2\u0116\u011a\3\2\2\2\u0117\u0119\13\2\2\2\u0118\u0117"+
		"\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7,\2\2\u011e\u011f\7\61"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\b,\3\2\u0121X\3\2\2\2\20\2\u009a"+
		"\u00a2\u00a5\u00ac\u00ae\u00b1\u00b5\u00bc\u00c1\u00ca\u0105\u010f\u011a"+
		"\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}