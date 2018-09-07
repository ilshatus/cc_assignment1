import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class TestTerm {
    @Test
    public void test1() {
        Term term = new Term(Term.Opcode.Plus,
                new Integer(new BigInteger("56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("48690769805276980438967439867946789578967829769437648678")));
        String res = term.calculate().toString();
        Assert.assertEquals(res, "48747005479934444424213089692303887936860292139936251662");
    }

    @Test
    public void test2() {
        Term term = new Term(Term.Opcode.Minus,
                new Integer(new BigInteger("45354245354985049543679204867829623693469073246803")),
                new Integer(new BigInteger("74584753948967039486903487069340870845869374534")));
        String res = term.calculate().toString();
        Assert.assertEquals(res, "45279660601036082504192301380760282822623203872269");
    }

    @Test
    public void test3() {
        Term term = new Term(Term.Opcode.Plus,
                new Integer(new BigInteger("56235674657463985245649824357098357892462370498602984")),
                new Integer(new BigInteger("-48690769805276980438967439867946789578967829769437648678")));
        String res = term.calculate().toString();
        Assert.assertEquals(res, "-48634534130619516453721790043589691221075367398939045694");
    }

    @Test
    public void test4() {
        Term term = new Term(Term.Opcode.Minus,
                new Integer(new BigInteger("45354245354985049543679204867829623693469073246803")),
                new Integer(new BigInteger("-74584753948967039486903487069340870845869374534")));
        String res = term.calculate().toString();
        Assert.assertEquals(res, "45428830108934016583166108354898964564314942621337");
    }
}
