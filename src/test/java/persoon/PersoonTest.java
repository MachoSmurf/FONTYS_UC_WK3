package persoon;

import ObjectUtils.CompareToUtils;
import ObjectUtils.EqualsUtils;
import ObjectUtils.HashCodeUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    //opdr 1.3
    @Test
    public void testList(){
        Persoon p1 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p2 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p3 = new Persoon("Rutte", "Mark", new Date(315532800), "Den Haag", "Nederland");
        Persoon p4 = new Persoon("Trump", "Donald", new Date(315532800), "Boston", "United States");

        List<Persoon> persoonList = new ArrayList<>();
        persoonList.add(p1);
        persoonList.add(p2);
        assertEquals(2, persoonList.size());
        persoonList.add(p3);
        persoonList.add(p4);
        assertEquals(4, persoonList.size());

        //Contains gebruikt equals om de juiste elementen terug te vinden: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#contains-java.lang.Object-
        //Dat betekend dat er onverwacht gedrag kan optreden wanneer p1 of p2 gezocht gaan worden. Een oplossing zou
        // kunnen zijn om een eigen list implementatie te schrijven en daarin de hashcode van objecten te gebruiken in
        // contains. Beter zou zijn om een implementatie van een verzameling te gebruiken die standaard al gebruik maakt
        // van de hashcode
        assertEquals(true, persoonList.contains(p3));
        assertEquals(true, persoonList.contains(p1));
        assertEquals(true, persoonList.contains(p2));

        persoonList.remove(p1);
        assertEquals(3, persoonList.size());
        persoonList.remove(p1);
        assertEquals(2, persoonList.size());
        //Hierboven is te zien dat hetzelfde object twee keer verwijderd kan worden, terwijl dit object maar één keer
        // expliciet is toegevoegd.
    }

    //opdr 1.4
    @Test
    public void testHashSet(){
        //Aan de klasse Persoon is een override toegevoegd voor de hashcode. Hierdoor wordt het contract afgedwongen: twee
        // objecten met gelijke inhoud hebben dezelfde hash, maar twee objecten met dezelfde hash hoeven niet perse dezelfde inhoud te hebben
        Persoon p1 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p2 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p3 = new Persoon("Rutte", "Mark", new Date(315532800), "Den Haag", "Nederland");
        Persoon p4 = new Persoon("Trump", "Donald", new Date(315532800), "Boston", "United States");
        Persoon p5 = null;

        //controlleer hashCodes:
        //twee objecten met dezelfde inhoud, deze moet slagen
        assertEquals(true, HashCodeUtils.compareHash(p1, p2));
        //twee objecten met verschillende inhoud, deze moet falen
        assertEquals(false, HashCodeUtils.compareHash(p1, p3));
        try{
            HashCodeUtils.compareHash(p1, p5);
            fail("Nullpointer was expected");
        }catch (NullPointerException npe){
            assertEquals(1, 1);
        }
        //Noot op bovenstaande: zonder hardcoded hashes in de code op te nemen is het deel van het contract dat
        // beschrijft dat twee dezelfde hashes niet per definitie dezelfde inhoud hebben, niet te testen.

        Set<Persoon> persoonSet = new HashSet<>();
        persoonSet.add(p1);
        persoonSet.add(p2);
        persoonSet.add(p3);
        persoonSet.add(p4);
        persoonSet.add(p5);
        //hashset voegt bij gelijke hash de nieuwe waarde niet toe (https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html#add%28E%29)
        assertEquals(4, persoonSet.size());

        assertEquals(true, persoonSet.contains(p1));
        assertEquals(true, persoonSet.contains(p2));
        assertEquals(true, persoonSet.contains(p3));

        persoonSet.remove(p1);

        assertEquals(3, persoonSet.size());
    }

    //opdr 1.5
    @Test
    public void testComparables(){
        //compareTo method in Persoon ingevuld

        Persoon p1 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p2 = new Persoon("Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        //vóór persoon 1 en 2
        Persoon p3 = new Persoon("Rutte", "Mark", new Date(315510000), "Den Haag", "Nederland");
        //ná persoon 1, 2 en 3
        Persoon p4 = new Persoon("Trump", "Donald", new Date(315550000), "Boston", "United States");
        Persoon p5 = null;

        assertEquals(true, CompareToUtils.checkEqualsVsSort(p1, p2));
        assertEquals(true, CompareToUtils.checkEqualsVsSort(p1, p3));
        assertEquals(true, CompareToUtils.checkEqualsVsSort(p2, p4));
        try{
            CompareToUtils.checkEqualsVsSort(p2, p5);
            fail("Nullpointer expected");
        }catch (NullPointerException npe){
            assertEquals(1, 1);
        }
    }

    //opdr 1.6 / opdr 1.7
    @Test
    public void testDocentStudent(){
        Persoon p1 = new Student(123456, "Janssen", "Jan", new Date(315532800), "Amsterdam", "Nederland");
        Persoon p2 = new Student(123457, "Pietsers", "Henk", new Date(315932800), "Amsterdam", "Nederland");
        Persoon p3 = new Student(123458, "Trump", "Donald", new Date(315932800), "Amsterdam", "Verenigde Staten");

        Persoon p4 = new Docent(54789, "Fritsen", "Julia", new Date(315132800), "Den Haag", "Nederland");
        Persoon p5 = new Docent(65894, "Vliet", "Frans", new Date(315152800), "Utrecht", "Nederland");
        Persoon p6 = new Docent(65894, "Duck", "Donald", new Date(315165800), "Duckstad", "Nederland");

        List<Persoon> personen = new ArrayList<>();
        personen.add(p1);
        personen.add(p2);
        personen.add(p3);
        personen.add(p4);
        personen.add(p5);
        personen.add(p6);
        assertEquals(6, personen.size());

        System.out.println("Persoon\t" + " - Persoon2\t\t" + "Equals (T/F)\t" + "compareTo(+,0,-)");
        for(int i=1; i<=6; i++){
            for (int j=1; j<=6; j++){
                Persoon base = personen.get(i-1);
                Persoon other = personen.get(j-1);

                boolean equal = base.equals(other);
                int compResult = base.compareTo(other);

                System.out.println(i + "\t\t\t" + j + "\t\t\t" + equal + "\t\t\t" + compResult);
            }
        }

        //Bovenstaande resultaten kloppen, ook wanneer twee Docenten hetzelfde accountnummer hebben worden ze (zoals in
        // de opdracht beschreven) als hetzelfde persoon gezien. Dit kan gecontroleerd worden door de accountnummers aan te passen.


        //Antw 1.8: Nee, niet volledig. De vergelijkingsmethode zorgt ervoor dat (zie output persoon 2 vs persoon 3) een
        // compareTo resultaat van 0 niet per definitie een Equals true oplevert (zelfde geboortedatum).


    }
}