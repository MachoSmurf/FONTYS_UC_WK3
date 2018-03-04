package persoon;

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

        if (!p1.equals(p2)){
            fail("Expected p1 to be equal to p2");
        }
        if (p1.equals(p3)){
            fail("Expected p1 to be not equal to p3");
        }
    }
}