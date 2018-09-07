import java.math.BigInteger;

public class Integer extends Primary {
    private BigInteger value;

    public Integer(BigInteger value) {
        this.value = value;
    }

    @Override
    public BigInteger calculate() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
