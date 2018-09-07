import java.math.BigInteger;

public class Factor extends Expression {
    enum Opcode {Multiply, none}

    private Opcode op;
    private Expression left, right;

    public Factor(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public BigInteger calculate() {
        BigInteger r1 = left.calculate();
        BigInteger r2 = right.calculate();
        switch (op) {
            case Multiply:
                return r1.multiply(r2);
        }
        return BigInteger.ONE;
    }

    @Override
    public String toString() {
        return "{ \"" + op + "\" : [ " + left + ", " + right + " ] }";
    }
}
