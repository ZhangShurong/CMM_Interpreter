package rsyntax;

import org.fife.ui.rsyntaxtextarea.*;

import javax.swing.text.Segment;

import static org.fife.ui.rsyntaxtextarea.TokenTypes.*;

/**
 * Created by pendragon on 16-12-14.
 */
public class CmmTokenMaker extends AbstractTokenMaker {

    private int currentTokenStart;
    private int currentTokenType;

    private boolean isSlash;
    private boolean isCommentStar;

    /*
     * 设置TokenMap, 添加关键字进入字典，为addToken的前置方法
     */
    @Override
    public TokenMap getWordsToHighlight() {
        TokenMap tokenMap = new TokenMap();

        int func = Token.FUNCTION;
        tokenMap.put("read", func);
        tokenMap.put("write", func);

        int reservedWord = Token.RESERVED_WORD;
        tokenMap.put("if", reservedWord);
        tokenMap.put("else", reservedWord);

        tokenMap.put("while", reservedWord);
        tokenMap.put("break", reservedWord);

        tokenMap.put("int", reservedWord);
        tokenMap.put("double", reservedWord);
        tokenMap.put("string", reservedWord);

        tokenMap.put("true", reservedWord);
        tokenMap.put("false", reservedWord);

        return tokenMap;
    }

    //这个方法接收来自getTokenList方法返回的所有 Token, 如果这个token 在 之前定义的 tokenMap 里的话，高亮它
    @Override
    public void addToken(Segment segment, int start, int end, int tokenType, int startOffset) {
        // 处理一些比较难在 getTokenList里面进行判断的保留词。通过这种方式可以将已
        // 标识成identifier的key words 转换成 keyWords
        if (tokenType == Token.IDENTIFIER) {
            int value = wordsToHighlight.get(segment, start, end);
            //-1 表示什么没取到
            if (value != -1) {
                tokenType = value;
            }
        }
        //....
        super.addToken(segment, start, end, tokenType, startOffset);
    }

    /**
     * 核心方法.
     *
     * @param text             The text to break into tokens.
     * @param initialTokenType The token with which to start tokenizing.
     * @param startOffset      The offset at which the line of tokens begins.
     * @return A linked list of tokens representing <code>text</code>.
     */
    @Override
    public Token getTokenList(Segment text, int initialTokenType, int startOffset) {
        resetTokenList();
        char[] array = text.array;
        int offset = text.offset;
        int count = text.count;
        int end = offset + count;

        // Token starting offsets are always of the form:
        // 'startOffset + (currentTokenStart-offset)', but since startOffset and
        // offset are constant, tokens' starting positions become:
        // 'newStartOffset+currentTokenStart'.
        int newStartOffset = startOffset - offset;

        currentTokenStart = offset;
        currentTokenType = initialTokenType;

        for (int i = offset; i < end; i++) {
            char c = array[i];
            switch (currentTokenType) {
                case Token.NULL:
                    currentTokenStart = i;   // Starting a new token here.
                    switch (c) {
                        //whiteSpace直接忽略，不浪费空间存储
                        case ' ':
                        case '\t':
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '{':
                        case '}':
                        case '[':
                        case ']':
                        case '(':
                        case ')':
                            addToken(text, currentTokenStart, i, Token.SEPARATOR, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case ';':
                            addToken(text, currentTokenStart, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case '.':
                        case '+':
                        case '-':
                        case '*':
                        case '%':
                        case '=':
                        case '>':
                        case '<':
                        case '!':
                            currentTokenType = OPERATOR;
                            break;

                        case '/':
                            currentTokenType = OPERATOR;
                            isSlash = true;
                            break;

                        default:
                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }

                            //没有匹配到的进入 identifier 中去查字典.
                            currentTokenType = Token.IDENTIFIER;
                    } // End of switch (c).
                    break;

                case Token.WHITESPACE:
                    switch (c) {
                        case ' ':
                        case '\t':
                            break;   // Still whitespace.
                        case '"':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;
                        case '{':
                        case '}':
                        case '[':
                        case ']':
                        case '(':
                        case ')':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.SEPARATOR, newStartOffset + i);
                            currentTokenType = Token.NULL;
                            break;
                        case ';':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case '.':
                        case '+':
                        case '-':
                        case '*':
                        case '%':
                        case '=':
                        case '>':
                        case '<':
                        case '!':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = false;
                            break;

                        case '/':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = true;
                            break;

                        default:   // Add the whitespace token and start anew.
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;

                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }
                            //没有匹配到的进入 identifier 中去查字典.
                            currentTokenType = Token.IDENTIFIER;
                    } // End of switch (c).
                    break;

                case Token.LITERAL_STRING_DOUBLE_QUOTE:
                    if (c == '"') {
                        addToken(text, currentTokenStart, i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    break;

                case OPERATOR:
                    switch (c){
                        case ' ':
                        case '\t':
                            addToken(text, currentTokenStart, i - 1, OPERATOR, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            addToken(text, currentTokenStart, i - 1, OPERATOR, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '{':
                        case '}':
                        case '[':
                        case ']':
                        case '(':
                        case ')':
                            addToken(text, currentTokenStart, i - 1, Token.OPERATOR, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.SEPARATOR, newStartOffset + i);
                            currentTokenType = Token.NULL;
                            break;
                        case ';':
                            addToken(text, currentTokenStart, i - 1, Token.OPERATOR, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case '/':
                            if (isSlash){
                                currentTokenType = COMMENT_EOL;
                                isSlash = false;
                            } else {
                                isSlash = true;
                            }
                            break;
                        case '*':
                            if (isSlash){
                                addToken(text, currentTokenStart, i - 1, Token.COMMENT_MULTILINE, newStartOffset + currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = COMMENT_MULTILINE;
                            } else {
                                isSlash = false;
                            }
                            break;
                        case '.':
                        case '+':
                        case '-':
                        case '%':
                        case '=':
                        case '>':
                        case '<':
                        case '!':
                            break;

                        default:
                            isSlash = false;

                            addToken(text, currentTokenStart, i - 1, OPERATOR, newStartOffset + currentTokenStart);
                            currentTokenStart = i;

                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }
                            //没有匹配到的进入 identifier 中去查字典.
                            currentTokenType = Token.IDENTIFIER;
                            break;
                    }
                    break;

                case COMMENT_EOL:
                    i = end - 1; // end -1 是因为 break 之后 for 循环还要 +1
                    addToken(text, currentTokenStart, i, currentTokenType, newStartOffset + currentTokenStart);
                    currentTokenType = Token.NULL;
                    break;

                case COMMENT_MULTILINE:
                    if (c == '*'){
                        isCommentStar = true;
                    } else if (c == '/'){
                        if (isCommentStar){
                            addToken(text, currentTokenStart, i, currentTokenType, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                        }
                        isCommentStar = false;
                    } else {
                        isCommentStar = false;
                    }
                    break;

                case Token.LITERAL_NUMBER_DECIMAL_INT:
                    switch (c) {
                        case ' ':
                        case '\t':
                            addToken(text, currentTokenStart, i - 1, LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            addToken(text, currentTokenStart, i - 1, LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '{':
                        case '}':
                        case '[':
                        case ']':
                        case '(':
                        case ')':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.SEPARATOR, newStartOffset + i);
                            currentTokenType = Token.NULL;
                            break;
                        case ';':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case '.':
                        case '+':
                        case '-':
                        case '*':
                        case '%':
                        case '=':
                        case '>':
                        case '<':
                        case '!':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = false;
                            break;

                        case '/':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = true;
                            break;

                        default:
                            if (RSyntaxUtilities.isDigit(c)) {
                                break;   // Still a literal number.
                            }
                            // Otherwise, remember this was a number and start over.
                            addToken(text, currentTokenStart, i - 1, LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            i--;
                            currentTokenType = Token.NULL;
                    }
                    break;

                case Token.IDENTIFIER:
                    switch (c){
                        case ' ':
                        case '\t':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.WHITESPACE;
                            break;   // Still whitespace.
                        case '"':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;
                        case '{':
                        case '}':
                        case '[':
                        case ']':
                        case '(':
                        case ')':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.SEPARATOR, newStartOffset + i);
                            currentTokenType = Token.NULL;
                            break;
                        case ';':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            addToken(text, i, i, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenType = Token.NULL;
                            break;

                        case '.':
                        case '+':
                        case '-':
                        case '*':
                        case '%':
                        case '=':
                        case '>':
                        case '<':
                        case '!':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = false;
                            break;

                        case '/':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = OPERATOR;
                            isSlash = true;
                            break;

                        default:
                            if (RSyntaxUtilities.isLetterOrDigit(c) || c == '_') {
                                break;
                            }
                    }
                    break;

            } // End of switch (currentTokenType).

        } // End of for (int i=offset; i<end; i++).

        // 处理跨行的情况，以及在这里统一添加Token
        switch (currentTokenType) {

            // 跨行字符串.
            case Token.LITERAL_STRING_DOUBLE_QUOTE:
                addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
                break;

            //跨行注释
            case Token.COMMENT_MULTILINE:
                addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
                break;

            // Do nothing if everything was okay.
            case Token.NULL:
                addNullToken();
                break;

            // All other token types don't continue to the next line...
            default:
                addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
                addNullToken();

        }

        // Return the first token in our linked list. 这是 API 要求
        return firstToken;
    }


}
