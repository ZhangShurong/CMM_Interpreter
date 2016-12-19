package gen;// Generated from D:/GitOSChina/CMM_Interpreter/Compiler/src/main\CMM.g4 by ANTLR 4.5.3
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
		RMBRACKET=22, LSBRACKET=23, RSBRACKET=24, QUOTE=25, SEQUAL=26, SMALLER=27, 
		GEQUAL=28, GREATER=29, DEQUAL=30, NEQUAL=31, EQUAL=32, PLUS=33, MINUS=34, 
		MULT=35, DIV=36, MOD=37, WS=38, SL_COMMENT=39, MUL_COMMENT=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", "DOUBLE", 
		"STRING", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"STRINGCONSTANT", "SCharSequence", "SChar", "SimpleEscapeSequence", "TRUE", 
		"FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "QUOTE", "SEQUAL", "SMALLER", "GEQUAL", "GREATER", "DEQUAL", 
		"NEQUAL", "EQUAL", "PLUS", "MINUS", "MULT", "DIV", "MOD", "WS", "SL_COMMENT", 
		"MUL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read'", "'write'", "'if'", "'else'", "'else if'", "'while'", "'break'", 
		"'int'", "'double'", "'string'", "','", "';'", null, null, null, null, 
		"'true'", "'false'", "'{'", "'}'", "'['", "']'", "'('", "')'", "'\"'", 
		"'<='", "'<'", "'>='", "'>'", "'=='", "'!='", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", 
		"DOUBLE", "STRING", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"STRINGCONSTANT", "TRUE", "FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", 
		"RMBRACKET", "LSBRACKET", "RSBRACKET", "QUOTE", "SEQUAL", "SMALLER", "GEQUAL", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u011c\b\1\4\2\t"+
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
		"\5\20\u00af\n\20\3\21\3\21\5\21\u00b3\n\21\3\21\3\21\3\22\6\22\u00b8\n"+
		"\22\r\22\16\22\u00b9\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c3\n\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\6*\u00fe\n*\r*\16*\u00ff\3*\3*\3+\3"+
		"+\3+\3+\7+\u0108\n+\f+\16+\u010b\13+\3+\3+\3,\3,\3,\3,\7,\u0113\n,\f,"+
		"\16,\u0116\13,\3,\3,\3,\3,\3,\3\u0114\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\2)\23+\24-\25"+
		"/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U"+
		")W*\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2\62;\6\2\f\f\17\17$$^^"+
		"\f\2$$))AA^^cdhhppttvvxx\6\2\13\f\17\17\"\"))\4\2\f\f\17\17\u0125\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5^\3\2"+
		"\2\2\7d\3\2\2\2\tg\3\2\2\2\13l\3\2\2\2\rt\3\2\2\2\17z\3\2\2\2\21\u0080"+
		"\3\2\2\2\23\u0084\3\2\2\2\25\u008b\3\2\2\2\27\u0092\3\2\2\2\31\u0094\3"+
		"\2\2\2\33\u0096\3\2\2\2\35\u00a5\3\2\2\2\37\u00a7\3\2\2\2!\u00b0\3\2\2"+
		"\2#\u00b7\3\2\2\2%\u00c2\3\2\2\2\'\u00c4\3\2\2\2)\u00c7\3\2\2\2+\u00cc"+
		"\3\2\2\2-\u00d2\3\2\2\2/\u00d4\3\2\2\2\61\u00d6\3\2\2\2\63\u00d8\3\2\2"+
		"\2\65\u00da\3\2\2\2\67\u00dc\3\2\2\29\u00de\3\2\2\2;\u00e0\3\2\2\2=\u00e3"+
		"\3\2\2\2?\u00e5\3\2\2\2A\u00e8\3\2\2\2C\u00ea\3\2\2\2E\u00ed\3\2\2\2G"+
		"\u00f0\3\2\2\2I\u00f2\3\2\2\2K\u00f4\3\2\2\2M\u00f6\3\2\2\2O\u00f8\3\2"+
		"\2\2Q\u00fa\3\2\2\2S\u00fd\3\2\2\2U\u0103\3\2\2\2W\u010e\3\2\2\2YZ\7t"+
		"\2\2Z[\7g\2\2[\\\7c\2\2\\]\7f\2\2]\4\3\2\2\2^_\7y\2\2_`\7t\2\2`a\7k\2"+
		"\2ab\7v\2\2bc\7g\2\2c\6\3\2\2\2de\7k\2\2ef\7h\2\2f\b\3\2\2\2gh\7g\2\2"+
		"hi\7n\2\2ij\7u\2\2jk\7g\2\2k\n\3\2\2\2lm\7g\2\2mn\7n\2\2no\7u\2\2op\7"+
		"g\2\2pq\7\"\2\2qr\7k\2\2rs\7h\2\2s\f\3\2\2\2tu\7y\2\2uv\7j\2\2vw\7k\2"+
		"\2wx\7n\2\2xy\7g\2\2y\16\3\2\2\2z{\7d\2\2{|\7t\2\2|}\7g\2\2}~\7c\2\2~"+
		"\177\7m\2\2\177\20\3\2\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082"+
		"\u0083\7v\2\2\u0083\22\3\2\2\2\u0084\u0085\7f\2\2\u0085\u0086\7q\2\2\u0086"+
		"\u0087\7w\2\2\u0087\u0088\7d\2\2\u0088\u0089\7n\2\2\u0089\u008a\7g\2\2"+
		"\u008a\24\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d\u008e\7"+
		"t\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7i\2\2\u0091\26"+
		"\3\2\2\2\u0092\u0093\7.\2\2\u0093\30\3\2\2\2\u0094\u0095\7=\2\2\u0095"+
		"\32\3\2\2\2\u0096\u009a\t\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097\3\2\2"+
		"\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\34"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a6\7\62\2\2\u009e\u00a2\t\4\2\2"+
		"\u009f\u00a1\t\5\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a6\36\3\2\2\2\u00a7\u00ae\5\35\17"+
		"\2\u00a8\u00aa\7\60\2\2\u00a9\u00ab\t\5\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2"+
		"\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00af\3\2\2\2\u00af \3\2\2\2\u00b0\u00b2"+
		"\59\35\2\u00b1\u00b3\5#\22\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\59\35\2\u00b5\"\3\2\2\2\u00b6\u00b8\5%\23\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba$\3\2\2\2\u00bb\u00c3\n\6\2\2\u00bc\u00c3\5\'\24\2\u00bd"+
		"\u00be\7^\2\2\u00be\u00c3\7\f\2\2\u00bf\u00c0\7^\2\2\u00c0\u00c1\7\17"+
		"\2\2\u00c1\u00c3\7\f\2\2\u00c2\u00bb\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2"+
		"\u00bd\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c3&\3\2\2\2\u00c4\u00c5\7^\2\2\u00c5"+
		"\u00c6\t\7\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7t\2\2\u00c9"+
		"\u00ca\7w\2\2\u00ca\u00cb\7g\2\2\u00cb*\3\2\2\2\u00cc\u00cd\7h\2\2\u00cd"+
		"\u00ce\7c\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7g\2\2"+
		"\u00d1,\3\2\2\2\u00d2\u00d3\7}\2\2\u00d3.\3\2\2\2\u00d4\u00d5\7\177\2"+
		"\2\u00d5\60\3\2\2\2\u00d6\u00d7\7]\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7"+
		"_\2\2\u00d9\64\3\2\2\2\u00da\u00db\7*\2\2\u00db\66\3\2\2\2\u00dc\u00dd"+
		"\7+\2\2\u00dd8\3\2\2\2\u00de\u00df\7$\2\2\u00df:\3\2\2\2\u00e0\u00e1\7"+
		">\2\2\u00e1\u00e2\7?\2\2\u00e2<\3\2\2\2\u00e3\u00e4\7>\2\2\u00e4>\3\2"+
		"\2\2\u00e5\u00e6\7@\2\2\u00e6\u00e7\7?\2\2\u00e7@\3\2\2\2\u00e8\u00e9"+
		"\7@\2\2\u00e9B\3\2\2\2\u00ea\u00eb\7?\2\2\u00eb\u00ec\7?\2\2\u00ecD\3"+
		"\2\2\2\u00ed\u00ee\7#\2\2\u00ee\u00ef\7?\2\2\u00efF\3\2\2\2\u00f0\u00f1"+
		"\7?\2\2\u00f1H\3\2\2\2\u00f2\u00f3\7-\2\2\u00f3J\3\2\2\2\u00f4\u00f5\7"+
		"/\2\2\u00f5L\3\2\2\2\u00f6\u00f7\7,\2\2\u00f7N\3\2\2\2\u00f8\u00f9\7\61"+
		"\2\2\u00f9P\3\2\2\2\u00fa\u00fb\7\'\2\2\u00fbR\3\2\2\2\u00fc\u00fe\t\b"+
		"\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\b*\2\2\u0102T\3\2\2\2\u0103"+
		"\u0104\7\61\2\2\u0104\u0105\7\61\2\2\u0105\u0109\3\2\2\2\u0106\u0108\n"+
		"\t\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\b+"+
		"\3\2\u010dV\3\2\2\2\u010e\u010f\7\61\2\2\u010f\u0110\7,\2\2\u0110\u0114"+
		"\3\2\2\2\u0111\u0113\13\2\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2"+
		"\u0114\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0118\7,\2\2\u0118\u0119\7\61\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\b,\3\2\u011bX\3\2\2\2\16\2\u009a\u00a2\u00a5\u00ac\u00ae\u00b2"+
		"\u00b9\u00c2\u00ff\u0109\u0114\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}