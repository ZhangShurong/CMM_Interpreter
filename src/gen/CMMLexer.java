package gen;// Generated from D:/GitOSChina/CMM_Interpreter/src\CMM.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CMMLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", "DOUBLE", 
		"COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", "TRUE", 
		"FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "SEQUAL", "GEQUAL", "DEQUAL", "EQUAL", "PLUS", "MINUS", "MULT", 
		"DIV", "MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u00e3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\r\u0080\n\r\f\r\16\r\u0083\13\r\3"+
		"\16\3\16\3\16\7\16\u0088\n\16\f\16\16\16\u008b\13\16\5\16\u008d\n\16\3"+
		"\17\3\17\3\17\6\17\u0092\n\17\r\17\16\17\u0093\5\17\u0096\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\6!\u00c5\n!\r!\16!\u00c6\3!\3!\3\"\3\"\3\"\3\"\7\"\u00cf\n\"\f\"\16"+
		"\"\u00d2\13\"\3\"\3\"\3#\3#\3#\3#\7#\u00da\n#\f#\16#\u00dd\13#\3#\3#\3"+
		"#\3#\3#\3\u00db\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\63"+
		";\3\2\62;\6\2\13\f\17\17\"\"))\4\2\f\f\17\17\u00ea\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5L\3\2\2\2\7R\3\2\2"+
		"\2\tU\3\2\2\2\13Z\3\2\2\2\rb\3\2\2\2\17h\3\2\2\2\21n\3\2\2\2\23r\3\2\2"+
		"\2\25y\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2\2"+
		"\2\37\u0097\3\2\2\2!\u009c\3\2\2\2#\u00a2\3\2\2\2%\u00a4\3\2\2\2\'\u00a6"+
		"\3\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2-\u00ac\3\2\2\2/\u00ae\3\2\2\2\61"+
		"\u00b1\3\2\2\2\63\u00b4\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb"+
		"\3\2\2\2;\u00bd\3\2\2\2=\u00bf\3\2\2\2?\u00c1\3\2\2\2A\u00c4\3\2\2\2C"+
		"\u00ca\3\2\2\2E\u00d5\3\2\2\2GH\7t\2\2HI\7g\2\2IJ\7c\2\2JK\7f\2\2K\4\3"+
		"\2\2\2LM\7y\2\2MN\7t\2\2NO\7k\2\2OP\7v\2\2PQ\7g\2\2Q\6\3\2\2\2RS\7k\2"+
		"\2ST\7h\2\2T\b\3\2\2\2UV\7g\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2Y\n\3\2\2\2"+
		"Z[\7g\2\2[\\\7n\2\2\\]\7u\2\2]^\7g\2\2^_\7\"\2\2_`\7k\2\2`a\7h\2\2a\f"+
		"\3\2\2\2bc\7y\2\2cd\7j\2\2de\7k\2\2ef\7n\2\2fg\7g\2\2g\16\3\2\2\2hi\7"+
		"d\2\2ij\7t\2\2jk\7g\2\2kl\7c\2\2lm\7m\2\2m\20\3\2\2\2no\7k\2\2op\7p\2"+
		"\2pq\7v\2\2q\22\3\2\2\2rs\7f\2\2st\7q\2\2tu\7w\2\2uv\7d\2\2vw\7n\2\2w"+
		"x\7g\2\2x\24\3\2\2\2yz\7.\2\2z\26\3\2\2\2{|\7=\2\2|\30\3\2\2\2}\u0081"+
		"\t\2\2\2~\u0080\t\3\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\32\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u008d"+
		"\7\62\2\2\u0085\u0089\t\4\2\2\u0086\u0088\t\5\2\2\u0087\u0086\3\2\2\2"+
		"\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0085\3\2\2\2\u008d"+
		"\34\3\2\2\2\u008e\u0095\5\33\16\2\u008f\u0091\7\60\2\2\u0090\u0092\t\5"+
		"\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\36\3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a"+
		"\7w\2\2\u009a\u009b\7g\2\2\u009b \3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e"+
		"\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"\"\3\2\2\2\u00a2\u00a3\7}\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7\177\2\2\u00a5"+
		"&\3\2\2\2\u00a6\u00a7\7]\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7_\2\2\u00a9*"+
		"\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab,\3\2\2\2\u00ac\u00ad\7+\2\2\u00ad.\3"+
		"\2\2\2\u00ae\u00af\7>\2\2\u00af\u00b0\7?\2\2\u00b0\60\3\2\2\2\u00b1\u00b2"+
		"\7@\2\2\u00b2\u00b3\7?\2\2\u00b3\62\3\2\2\2\u00b4\u00b5\7?\2\2\u00b5\u00b6"+
		"\7?\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7?\2\2\u00b8\66\3\2\2\2\u00b9\u00ba"+
		"\7-\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc:\3\2\2\2\u00bd\u00be\7"+
		",\2\2\u00be<\3\2\2\2\u00bf\u00c0\7\61\2\2\u00c0>\3\2\2\2\u00c1\u00c2\7"+
		"\'\2\2\u00c2@\3\2\2\2\u00c3\u00c5\t\6\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\b!\2\2\u00c9B\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb\u00cc\7\61\2\2"+
		"\u00cc\u00d0\3\2\2\2\u00cd\u00cf\n\7\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\b\"\3\2\u00d4D\3\2\2\2\u00d5\u00d6\7\61\2\2"+
		"\u00d6\u00d7\7,\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e0\7\61"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b#\3\2\u00e2F\3\2\2\2\13\2\u0081"+
		"\u0089\u008c\u0093\u0095\u00c6\u00d0\u00db\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}