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
public class Student extends Persoon{
    private long studentNr;


    public Student(long studentNr, String familyname, String firstname, Date birthDate, String birthPlace, String birthCountry) {
        super(familyname, firstname, birthDate, birthPlace, birthCountry);
        this.studentNr = studentNr;
    }

    public long getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(long studentNr) {
        this.studentNr = studentNr;
    }

    //opdr 1.6
    @Override
    public boolean equals(Object other){
        if (other instanceof Student){
            if (this == other) {return true;}

            Student o = (Student)other;
            if (o.studentNr == this.studentNr){
                return true;
            }
        }
        return false;
    }
}
