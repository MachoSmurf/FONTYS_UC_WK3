package persoon;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * persoon object
 *
 * @author erik
 */
public class Persoon implements Comparable {

    private long BSN; // burgerservicenummer
    private String familyname; // familie naam
    private String firstname; // voornaam
    private Date birthDate;   // birthDate in EPOCH time
    private String birthPlace; // birthplace during birth
    private String birthCountry; // birth county during birth

    public Persoon(String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        this.familyname = familyname;
        this.firstname = firstname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.birthCountry = birthCountry;
    }
    
    public long getBSN() {
        return BSN;
    }

    public void setBSN(long BSN) {
        this.BSN = BSN;
    }

    @Override
    public String toString() {
        return this.firstname + "," + this.familyname + "," + 
                DateFormat.getInstance().format(birthDate) 
                + "," + this.birthPlace + " ," + this.birthCountry;
    }

    /**
     * natuurlijke ordening op birthDate, vervolgens op familyname, vervolgens
     * op firstname.
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet.");
        //Todo
    }

}
