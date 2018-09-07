import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestFactor {
    @Test
    public void test1() {
        Factor factor = new Factor(Factor.Opcode.Multiply,
                new Integer(new BigInteger("56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("48690769805276980438967439867946789578967829769437648678")));
        String res = factor.calculate().toString();
        Assert.assertEquals(res, "2738158289591027312526106483677239467005696007733671563349946818225388831782172575939363115440890492794455152");
    }

    @Test
    public void test2() {
        Factor factor = new Factor(Factor.Opcode.Multiply,
                new Integer(new BigInteger("56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("-48690769805276980438967439867946789578967829769437648678")));
        String res = factor.calculate().toString();
        Assert.assertEquals(res, "-2738158289591027312526106483677239467005696007733671563349946818225388831782172575939363115440890492794455152");
    }

    @Test
    public void test3() {
        Factor factor = new Factor(Factor.Opcode.Multiply,
                new Integer(new BigInteger("-56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("-48690769805276980438967439867946789578967829769437648678")));
        String res = factor.calculate().toString();
        Assert.assertEquals(res, "2738158289591027312526106483677239467005696007733671563349946818225388831782172575939363115440890492794455152");
    }
}
