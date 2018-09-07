import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestParser {
    @Test
    public void test1() {
        Parser parser = new Parser("123+222*12");
        Expression expression = parser.parse();
        Assert.assertTrue(parser.isParsed());
        Assert.assertEquals(expression.calculate(), BigInteger.valueOf(2787L));
        Assert.assertEquals(expression.toString(), "{ \"Plus\" : [ 123, { \"Multiply\" : [ 222, 12 ] } ] }");
    }

    @Test
    public void test2() {
        Parser parser = new Parser("(10 + 34 * 2993) * 123 * (123 + 3892) + 123");
        Expression expression = parser.parse();
        Assert.assertTrue(parser.isParsed());
        Assert.assertEquals(expression.calculate(), BigInteger.valueOf(50259593463L));
        Assert.assertEquals(expression.toString(), "{ \"Plus\" : [ { \"Multiply\" : [ { \"Multiply\" : [ { \"Plus\" : [ 10, { \"Multiply\" : [ 34, 2993 ] } ] }, 123 ] }, { \"Plus\" : [ 123, 3892 ] } ] }, 123 ] }");
    }

    @Test
    public void test3() {
        Parser parser = new Parser("12+-2");
        Expression expression = parser.parse();
        Assert.assertTrue(parser.isParsed());
        Assert.assertEquals(expression.calculate(), BigInteger.valueOf(10L));
        Assert.assertEquals(expression.toString(), "{ \"Plus\" : [ 12, -2 ] }");
    }

    @Test
    public void test4() {
        Parser parser = new Parser("((123 * 12312 > 34234) > (12321 > 23213)) > (22123321232123)");
        Expression expression = parser.parse();
        Assert.assertTrue(parser.isParsed());
        Assert.assertEquals(expression.calculate(), BigInteger.ZERO);
        Assert.assertEquals(expression.toString(), "{ \"greater\" : [ { \"greater\" : [ { \"greater\" : [ { \"Multiply\" : [ 123, 12312 ] }, 34234 ] }, { \"greater\" : [ 12321, 23213 ] } ] }, 22123321232123 ] }");
    }

    @Test
    public void test5() {
        Parser parser = new Parser("1232132 * 12312321 * 123123123 * 123123123123 * 123123123123 * 43243242343");
        Expression expression = parser.parse();
        Assert.assertTrue(parser.isParsed());
        Assert.assertEquals(expression.calculate(), new BigInteger("1224430912078133566138790077494470962625965667357127732"));
        Assert.assertEquals(expression.toString(), "{ \"Multiply\" : [ { \"Multiply\" : [ { \"Multiply\" : [ { \"Multiply\" : [ { \"Multiply\" : [ 1232132, 12312321 ] }, 123123123 ] }, 123123123123 ] }, 123123123123 ] }, 43243242343 ] }");
    }

    @Test
    public void test6() {
        Parser parser = new Parser("23123 ** 342");
        Expression expression = parser.parse();
        Assert.assertFalse(parser.isParsed());
    }

    @Test
    public void test7() {
        Parser parser = new Parser("11 * (23123 * 342");
        Expression expression = parser.parse();
        Assert.assertFalse(parser.isParsed());
    }

    @Test
    public void test8() {
        Parser parser = new Parser("11 * |23123 * 342|");
        Expression expression = parser.parse();
        Assert.assertFalse(parser.isParsed());
    }

    @Test
    public void test9() {
        Parser parser = new Parser("11 * (23123 / 342)");
        Expression expression = parser.parse();
        Assert.assertFalse(parser.isParsed());
    }

    @Test
    public void test10() {
        Parser parser = new Parser("1 > 3 > 6");
        Expression expression = parser.parse();
        Assert.assertFalse(parser.isParsed());
    }
}
