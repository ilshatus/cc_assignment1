import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestRelation {
    @Test
    public void test1() {
        Relation relation = new Relation(Relation.Opcode.equal,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "1");
    }

    @Test
    public void test2() {
        Relation relation = new Relation(Relation.Opcode.equal,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(223123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "0");
    }

    @Test
    public void test3() {
        Relation relation = new Relation(Relation.Opcode.less,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123124)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "1");
    }

    @Test
    public void test4() {
        Relation relation = new Relation(Relation.Opcode.less,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "0");
    }

    @Test
    public void test5() {
        Relation relation = new Relation(Relation.Opcode.less,
                new Integer(BigInteger.valueOf(123124)),
                new Integer(BigInteger.valueOf(123123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "0");
    }

    @Test
    public void test6() {
        Relation relation = new Relation(Relation.Opcode.greater,
                new Integer(BigInteger.valueOf(123124)),
                new Integer(BigInteger.valueOf(123123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "1");
    }

    @Test
    public void test7() {
        Relation relation = new Relation(Relation.Opcode.greater,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123123)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "0");
    }

    @Test
    public void test8() {
        Relation relation = new Relation(Relation.Opcode.greater,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123124)));
        String res = relation.calculate().toString();
        Assert.assertEquals(res, "0");
    }
}
