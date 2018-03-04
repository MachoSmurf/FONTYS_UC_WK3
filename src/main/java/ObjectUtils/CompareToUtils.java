/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectUtils;

import persoon.Persoon;

/**
 * this class contains methods to check specific aspects of the
 * compareTo method of Comparable objects.
 * @author YOU!
 */
public class CompareToUtils {

    public static boolean checkEqualsVsSort(Persoon a, Persoon b){
        //if a.equals(b) then a.compareTo(b) = 0
        if ((a.equals(b)) && (a.compareTo(b) == 0)){
            //adheres to contract
            return true;
        }
        if ((!a.equals(b)) && (a.compareTo(b) != 0)){
            return true;
        }
        else{
            return false;
        }
    }
}
