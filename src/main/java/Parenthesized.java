import java.math.BigInteger;

public class Parenthesized extends Primary {
    private Expression expression;

    public Parenthesized(Expression expression) {
        this.expression = expression;
    }

    @Override
    public BigInteger calculate() {
        return expression.calculate();
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return expression.toString();
    }
}
