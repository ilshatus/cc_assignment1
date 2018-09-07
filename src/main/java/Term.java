import java.math.BigInteger;

public class Term extends Expression {
    enum Opcode {Plus, Minus, none}

    private Opcode op;
    private Expression left, right;

    public Term(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public BigInteger calculate() {
        BigInteger r1 = left.calculate();
        BigInteger r2 = right.calculate();
        switch (op) {
            case Plus:
                return r1.add(r2);
            case Minus:
                return r1.subtract(r2);
        }
        return BigInteger.ZERO;
    }

    @Override
    public String toString() {
        return "{ \"" + op + "\" : [ " + left + ", " + right + " ] }";
    }
}
