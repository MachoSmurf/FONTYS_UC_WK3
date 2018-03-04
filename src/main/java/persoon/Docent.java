/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persoon;

import java.util.Date;

/**
 *
 * @author erik
 */
public class Docent extends Persoon {

    private long loginAccountNr;

    public Docent(long loginAccountNr, String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        super(familyname, firstname, birthDate, birthPlace, birthCountry);
        this.loginAccountNr = loginAccountNr;
    }

    public long getLoginAccountNr() {
        return loginAccountNr;
    }

    public void setLoginAccountNr(long loginAccountNr) {
        this.loginAccountNr = loginAccountNr;
    }

}
