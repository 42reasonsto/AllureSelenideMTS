package Data.RandomData;

public class RandomNumber {
    public static String phoneNumber() {
        int intPervoechislo=0;

        int intOstalnoechislo=0;

        int nine=9;

        int one=1;

        int devytDevytok = 999999999;

        int odinVosemNuly=100000000;

        String stringSumma="";

        intPervoechislo=(int)(Math.random()*nine+one);

        intOstalnoechislo=(int)(Math.random()*devytDevytok);

        if (intOstalnoechislo < odinVosemNuly) {
            intOstalnoechislo=odinVosemNuly;
        }

        stringSumma = stringSumma+Integer.toString(intPervoechislo)+Integer.toString(intOstalnoechislo);

        return stringSumma;
    }

    public static String innNumber() {
        int number=0;

        String regionMoscow = "77";

        String ifns = "14";

        int nine = 9;

        String stringSumma="";

        for (int i=0; i<7; i++) {
            number = (int) (Math.random() * nine);
            stringSumma = stringSumma+Integer.toString(number);
        }

        return regionMoscow+ifns+stringSumma;
    }
}
