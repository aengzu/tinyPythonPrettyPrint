import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        tinyPythonLexer lexer = new tinyPythonLexer(CharStreams.fromFileName("test.tpy"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tinyPythonParser parser = new tinyPythonParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        //생성된 파스트리를 DFS 로 순회하며, listener 동작 수행
        walker.walk(new tinyPythonPrintListener(), tree);
        }
    }
