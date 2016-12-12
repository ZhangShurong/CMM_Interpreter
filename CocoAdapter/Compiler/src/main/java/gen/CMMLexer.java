package gen;// Generated from /home/pendragon/workspace/CMM_Interpreter/Compiler/src/main/CMM.g4 by ANTLR 4.5.3

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
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
		RSBRACKET=22, SEQUAL=23, SMALLER=24, GEQUAL=25, GREATER=26, DEQUAL=27, 
		NEQUAL=28, EQUAL=29, PLUS=30, MINUS=31, MULT=32, DIV=33, MOD=34, WS=35, 
		SL_COMMENT=36, MUL_COMMENT=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", "DOUBLE", 
		"COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", "TRUE", 
		"FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "SEQUAL", "SMALLER", "GEQUAL", "GREATER", "DEQUAL", "NEQUAL", 
		"EQUAL", "PLUS", "MINUS", "MULT", "DIV", "MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'read'", "'write'", "'if'", "'else'", "'else if'", "'while'", "'break'", 
		"'int'", "'double'", "','", "';'", null, null, null, "'true'", "'false'", 
		"'{'", "'}'", "'['", "']'", "'('", "')'", "'<='", "'<'", "'>='", "'>'", 
		"'=='", "'!='", "'='", "'+'", "'-'", "'*'", "'/'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "READ", "WRITE", "IF", "ELSE", "ELSEIF", "WHILE", "BREAK", "INT", 
		"DOUBLE", "COMMA", "SEMICOLON", "IDENT", "INTCONSTANT", "DOUBLECONSTANT", 
		"TRUE", "FALSE", "LBBRACKET", "RBBRACKET", "LMBRACKET", "RMBRACKET", "LSBRACKET", 
		"RSBRACKET", "SEQUAL", "SMALLER", "GEQUAL", "GREATER", "DEQUAL", "NEQUAL", 
		"EQUAL", "PLUS", "MINUS", "MULT", "DIV", "MOD", "WS", "SL_COMMENT", "MUL_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\r\u0086\n\r\f\r"+
		"\16\r\u0089\13\r\3\16\3\16\3\16\7\16\u008e\n\16\f\16\16\16\u0091\13\16"+
		"\5\16\u0093\n\16\3\17\3\17\3\17\6\17\u0098\n\17\r\17\16\17\u0099\5\17"+
		"\u009c\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\6$\u00d2\n$\r$\16$\u00d3"+
		"\3$\3$\3%\3%\3%\3%\7%\u00dc\n%\f%\16%\u00df\13%\3%\3%\3&\3&\3&\3&\7&\u00e7"+
		"\n&\f&\16&\u00ea\13&\3&\3&\3&\3&\3&\3\u00e8\2\'\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2"+
		"\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2\62;\6\2\13\f\17\17\"\"))\4\2"+
		"\f\f\17\17\u00f7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5R\3\2\2\2\7X\3\2"+
		"\2\2\t[\3\2\2\2\13`\3\2\2\2\rh\3\2\2\2\17n\3\2\2\2\21t\3\2\2\2\23x\3\2"+
		"\2\2\25\177\3\2\2\2\27\u0081\3\2\2\2\31\u0083\3\2\2\2\33\u0092\3\2\2\2"+
		"\35\u0094\3\2\2\2\37\u009d\3\2\2\2!\u00a2\3\2\2\2#\u00a8\3\2\2\2%\u00aa"+
		"\3\2\2\2\'\u00ac\3\2\2\2)\u00ae\3\2\2\2+\u00b0\3\2\2\2-\u00b2\3\2\2\2"+
		"/\u00b4\3\2\2\2\61\u00b7\3\2\2\2\63\u00b9\3\2\2\2\65\u00bc\3\2\2\2\67"+
		"\u00be\3\2\2\29\u00c1\3\2\2\2;\u00c4\3\2\2\2=\u00c6\3\2\2\2?\u00c8\3\2"+
		"\2\2A\u00ca\3\2\2\2C\u00cc\3\2\2\2E\u00ce\3\2\2\2G\u00d1\3\2\2\2I\u00d7"+
		"\3\2\2\2K\u00e2\3\2\2\2MN\7t\2\2NO\7g\2\2OP\7c\2\2PQ\7f\2\2Q\4\3\2\2\2"+
		"RS\7y\2\2ST\7t\2\2TU\7k\2\2UV\7v\2\2VW\7g\2\2W\6\3\2\2\2XY\7k\2\2YZ\7"+
		"h\2\2Z\b\3\2\2\2[\\\7g\2\2\\]\7n\2\2]^\7u\2\2^_\7g\2\2_\n\3\2\2\2`a\7"+
		"g\2\2ab\7n\2\2bc\7u\2\2cd\7g\2\2de\7\"\2\2ef\7k\2\2fg\7h\2\2g\f\3\2\2"+
		"\2hi\7y\2\2ij\7j\2\2jk\7k\2\2kl\7n\2\2lm\7g\2\2m\16\3\2\2\2no\7d\2\2o"+
		"p\7t\2\2pq\7g\2\2qr\7c\2\2rs\7m\2\2s\20\3\2\2\2tu\7k\2\2uv\7p\2\2vw\7"+
		"v\2\2w\22\3\2\2\2xy\7f\2\2yz\7q\2\2z{\7w\2\2{|\7d\2\2|}\7n\2\2}~\7g\2"+
		"\2~\24\3\2\2\2\177\u0080\7.\2\2\u0080\26\3\2\2\2\u0081\u0082\7=\2\2\u0082"+
		"\30\3\2\2\2\u0083\u0087\t\2\2\2\u0084\u0086\t\3\2\2\u0085\u0084\3\2\2"+
		"\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\32"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u0093\7\62\2\2\u008b\u008f\t\4\2\2"+
		"\u008c\u008e\t\5\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u008a\3\2\2\2\u0092\u008b\3\2\2\2\u0093\34\3\2\2\2\u0094\u009b\5\33\16"+
		"\2\u0095\u0097\7\60\2\2\u0096\u0098\t\5\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0095\3\2\2\2\u009b\u009c\3\2\2\2\u009c\36\3\2\2\2\u009d\u009e"+
		"\7v\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		" \3\2\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7n\2\2\u00a5"+
		"\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7}\2\2\u00a9"+
		"$\3\2\2\2\u00aa\u00ab\7\177\2\2\u00ab&\3\2\2\2\u00ac\u00ad\7]\2\2\u00ad"+
		"(\3\2\2\2\u00ae\u00af\7_\2\2\u00af*\3\2\2\2\u00b0\u00b1\7*\2\2\u00b1,"+
		"\3\2\2\2\u00b2\u00b3\7+\2\2\u00b3.\3\2\2\2\u00b4\u00b5\7>\2\2\u00b5\u00b6"+
		"\7?\2\2\u00b6\60\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\62\3\2\2\2\u00b9\u00ba"+
		"\7@\2\2\u00ba\u00bb\7?\2\2\u00bb\64\3\2\2\2\u00bc\u00bd\7@\2\2\u00bd\66"+
		"\3\2\2\2\u00be\u00bf\7?\2\2\u00bf\u00c0\7?\2\2\u00c08\3\2\2\2\u00c1\u00c2"+
		"\7#\2\2\u00c2\u00c3\7?\2\2\u00c3:\3\2\2\2\u00c4\u00c5\7?\2\2\u00c5<\3"+
		"\2\2\2\u00c6\u00c7\7-\2\2\u00c7>\3\2\2\2\u00c8\u00c9\7/\2\2\u00c9@\3\2"+
		"\2\2\u00ca\u00cb\7,\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7\61\2\2\u00cdD\3\2"+
		"\2\2\u00ce\u00cf\7\'\2\2\u00cfF\3\2\2\2\u00d0\u00d2\t\6\2\2\u00d1\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\b$\2\2\u00d6H\3\2\2\2\u00d7\u00d8\7\61\2\2"+
		"\u00d8\u00d9\7\61\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\n\7\2\2\u00db\u00da"+
		"\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\b%\3\2\u00e1J\3\2\2\2\u00e2"+
		"\u00e3\7\61\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e7\13"+
		"\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7,"+
		"\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b&\3\2\u00ef"+
		"L\3\2\2\2\13\2\u0087\u008f\u0092\u0099\u009b\u00d3\u00dd\u00e8\4\b\2\2"+
		"\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}