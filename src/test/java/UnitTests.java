import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
            TestRelation.class,
            TestTerm.class,
            TestFactor.class,
            TestParenthesized.class,
            TestInteger.class,
            TestParser.class
    }
)
public class UnitTests {
}
