package persoon;

import ObjectUtils.EqualsUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PersoonTest {

    @Test
    public void testProppertyEquals(){
        System.out.println("Testing proppertyEquals");
        //01-01-1980
        Persoon p1 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p2 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p3 = new Persoon("Jansse", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p4 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p5 = null;


        //opdr1.1
        if (!p1.equals(p2)){
            fail("Expected p1 to be equal to p2");
        }
        if (p1.equals(p3)){
            fail("Expected p1 to be not equal to p3");
        }

        //opdr1.2
        //object should equal itself
        assertEquals(true, EqualsUtils.testReflexitivity(p1));
        assertEquals(true, EqualsUtils.testReflexitivity(p2));
        assertEquals(true, EqualsUtils.testReflexitivity(p3));

        //objects should equals eachother (both true OR both false).
        assertEquals(true, EqualsUtils.testSymmetry(p1, p2));
        assertEquals(true, EqualsUtils.testSymmetry(p1, p3));

        //if a==b and b==c, then a==c --> results in true
        assertEquals(true, EqualsUtils.testTransitivity(p1, p2, p4));
        //if a!=b and b!=c, then a!=c --> results in true
        assertEquals(true, EqualsUtils.testTransitivity(p1, p2, p3));

        //should not equal null (if a != null --> true)
        assertEquals(true, EqualsUtils.testNullIsFalse(p1));
        try{
            //using a nullpointer in a method invocation allways throws a nullpointer
            assertEquals(true, EqualsUtils.testNullIsFalse(p5));
        }
        catch (NullPointerException ex){
            assertEquals(true, true);
        }
    }
}