import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestInteger {

    @Test
    public void test1() {
        Integer integer = new Integer(BigInteger.valueOf(123123));
        String res = integer.calculate().toString();
        Assert.assertEquals(res, "123123");
    }

    @Test
    public void test2() {
        Integer integer = new Integer(BigInteger.valueOf(-123123));
        String res = integer.calculate().toString();
        Assert.assertEquals(res, "-123123");
    }

    @Test
    public void test3() {
        Integer integer = new Integer(BigInteger.valueOf(-0));
        String res = integer.calculate().toString();
        Assert.assertEquals(res, "0");
    }
}
