
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.hamcrest.Matcher;;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void longDivisionWorks()
    {
        String answer = App.longDivision("10", "2");
        assertTrue("doesn't work", Integer.parseInt(answer) == 5);
    }   

    @Test
    public void testToInt() {
        assertEquals(9,App.toInt('9'));
    }
}
