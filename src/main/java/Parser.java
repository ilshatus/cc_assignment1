import java.math.BigInteger;

public class Parser {
    private String expressionStr;
    private int currentPos;
    private boolean parsed;

    public Parser(String s) {
        expressionStr = s;
        parsed = false;
        currentPos = 0;
    }

    public boolean isParsed() {
        return parsed;
    }

    public Expression parse() {
        Expression result = parseRelation();
        if (currentPos == expressionStr.length() && result != null) {
            parsed = true;
            return result;
        }
        return null;
    }

    private Expression parseRelation() {
        Expression result = parseTerm();
        if (result == null) return null;
        Relation.Opcode op = parseRelOperator();
        if (op != Relation.Opcode.none) {
            Expression right = parseTerm();
            if (right == null) return null;
            result = new Relation(op, result, right);
        }
        return result;
    }

    private Expression parseTerm() {
        Expression result = parseFactor();
        if (result == null) return null;
        while (true) {
            Term.Opcode op = parseTermOperator();
            if (op != Term.Opcode.none) {
                Expression right = parseFactor();
                if (right == null) return null;
                result = new Term(op, result, right);
            } else break;
        }
        return result;
    }

    private Expression parseFactor() {
        Expression result = parsePrimary();
        if (result == null) return null;
        while (true) {
            Factor.Opcode op = parseFactOperator();
            if (op != Factor.Opcode.none) {
                Expression right = parsePrimary();
                if (right == null) return null;
                result = new Factor(op, result, right);
            } else break;
        }
        return result;
    }

    private Primary parsePrimary() {
        Character currentChar = getCurrentChar();
        if (currentChar == null) return null;
        Primary result = null;
        if (Character.isDigit(currentChar) || currentChar == '-')
            result = parseInteger();
        else if (currentChar == '(') {
            currentPos++;
            result = new Parenthesized(parseRelation());
            currentChar = getCurrentChar();
            if (currentChar == null)
                return null;
            if (currentChar == ')')
                currentPos++;
        }
        return result;
    }

    private Integer parseInteger() {
        Character currentChar = getCurrentChar();
        if (currentChar == null) return null;
        StringBuilder intBuilder = new StringBuilder();
        if (currentChar == '-') {
            intBuilder.append(currentChar);
            currentPos++;
            currentChar = getCurrentChar();
        }
        while (currentChar != null && Character.isDigit(currentChar)) {
            intBuilder.append(currentChar);
            currentPos++;
            currentChar = getCurrentChar();
        }
        try {
            BigInteger value = new BigInteger(intBuilder.toString());
            return new Integer(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Relation.Opcode parseRelOperator() {
        Character op = getCurrentChar();
        if (op == null) {
            return Relation.Opcode.none;
        }
        currentPos++;
        switch (op) {
            case '<':
                return Relation.Opcode.less;
            case '>':
                return Relation.Opcode.greater;
            case '=':
                return Relation.Opcode.equal;
            default:
                currentPos--;
        }
        return Relation.Opcode.none;
    }

    private Term.Opcode parseTermOperator() {
        Character op = getCurrentChar();
        if (op == null) {
            return Term.Opcode.none;
        }
        currentPos++;
        switch (op) {
            case '+':
                return Term.Opcode.Plus;
            case '-':
                return Term.Opcode.Minus;
            default:
                currentPos--;
        }
        return Term.Opcode.none;
    }

    private Factor.Opcode parseFactOperator() {
        Character op = getCurrentChar();
        if (op == null) {
            return Factor.Opcode.none;
        }
        currentPos++;
        switch (op) {
            case '*':
                return Factor.Opcode.Multiply;
            default:
                currentPos--;
        }
        return Factor.Opcode.none;
    }

    private Character getCurrentChar() {
        while (currentPos != expressionStr.length() && expressionStr.charAt(currentPos) == ' ') currentPos++;
        if (currentPos == expressionStr.length()) return null;
        return expressionStr.charAt(currentPos);
    }
}
