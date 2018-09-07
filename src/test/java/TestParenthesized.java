import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestParenthesized {

    @Test
    public void test1() {
        Parenthesized parenthesized = new Parenthesized(new Integer(BigInteger.valueOf(123123)));
        String res = parenthesized.calculate().toString();
        Assert.assertEquals(res, "123123");
    }

    @Test
    public void test2() {
        Term term = new Term(Term.Opcode.Plus,
                new Integer(new BigInteger("56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("-48690769805276980438967439867946789578967829769437648678")));
        Parenthesized parenthesized = new Parenthesized(term);
        String res = parenthesized.calculate().toString();
        Assert.assertEquals(res, "-48634534130619516453721790043589691221075367398939045694");
    }

    @Test
    public void test3() {
        Factor factor = new Factor(Factor.Opcode.Multiply,
                new Integer(new BigInteger("-56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("-48690769805276980438967439867946789578967829769437648678")));
        Parenthesized parenthesized = new Parenthesized(factor);
        String res = parenthesized.calculate().toString();
        Assert.assertEquals(res, "2738158289591027312526106483677239467005696007733671563349946818225388831782172575939363115440890492794455152");
    }

    @Test
    public void test4() {
        Relation relation = new Relation(Relation.Opcode.equal,
                new Integer(BigInteger.valueOf(123123)),
                new Integer(BigInteger.valueOf(123123)));
        Parenthesized parenthesized = new Parenthesized(relation);
        String res = parenthesized.calculate().toString();
        Assert.assertEquals(res, "1");
    }
}
