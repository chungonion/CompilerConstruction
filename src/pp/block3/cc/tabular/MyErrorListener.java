package pp.block3.cc.tabular;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class MyErrorListener extends BaseErrorListener {

    List<String> errors;
    
    public List<String> getErrors() {
        return errors;
    }

    public MyErrorListener() {
        errors = new ArrayList<String>();
    }
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        String error = String.format("line %d:%d %s",line,charPositionInLine,msg);
        errors.add(error);
    }
    
}
