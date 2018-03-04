package persoon;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

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
        /*throw new UnsupportedOperationException("Not supported yet.");
        //Todo*/
        //in de constructor wordt afgedwongen dat Date is ingevuld, daarmee is date een geschikte kandidaat om ordening op toe te passen.
        if (t == null){
            throw new NullPointerException();
        }
        if (t instanceof Persoon){
            Persoon other = (Persoon)t;
            return this.birthDate.compareTo(other.birthDate);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (other == this) return true;
        if (other.getClass().equals(Persoon.class)){
            Persoon p2 = (Persoon) other;
            return ((p2.firstname.equals(firstname))
                    && (p2.familyname.equals(familyname))
                    && (p2.birthDate.equals(birthDate))
                    && (p2.birthCountry.equals(birthCountry)));
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(BSN, familyname, firstname, birthDate, birthPlace, birthCountry);
    }
}
