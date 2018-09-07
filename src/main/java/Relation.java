import java.math.BigInteger;

public class Relation extends Expression {
    enum Opcode {less, greater, equal, none}

    private Opcode op;
    private Expression left, right;

    public Relation(Opcode op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public BigInteger calculate() {
        BigInteger r1 = left.calculate();
        BigInteger r2 = right.calculate();
        int comparison = r1.compareTo(r2);
        switch (op) {
            case less:
                return comparison < 0  ? BigInteger.ONE : BigInteger.ZERO;
            case greater:
                return comparison > 0 ? BigInteger.ONE : BigInteger.ZERO;
            case equal:
                return comparison == 0 ? BigInteger.ONE : BigInteger.ZERO;
        }
        return BigInteger.ZERO;
    }

    @Override
    public String toString() {
        return "{ \"" + op + "\" : [ " + left + ", " + right + " ] }";
    }
}
