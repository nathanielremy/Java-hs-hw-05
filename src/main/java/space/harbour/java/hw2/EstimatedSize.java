package space.harbour.java.hw2;

import java.util.HashMap;
import java.util.Map;

//public class EstimatedSize {
    //public static void main(String[] args) {
        //Pascal.pTriangle(20);
        //Slang.fixAbbreviations("GTFO");
        //Slang.fixSmiles(":)");
    //}
//}

class Slang {
    static void fixAbbreviations(String abbreviation) {
        Map<String, String> abrv = new HashMap<String, String>();
        abrv.put("PLZ", "please");
        abrv.put("FYI", "for your information");
        abrv.put("GTFO", "get the fuck out");
        abrv.put("ASAP", "as soon as possible");

        if (abrv.get(abbreviation) != null) {
            System.out.println(abrv.get(abbreviation));
            return;
        }

        System.out.println("Sorry, we do not know this abbreviation :(");
    }

    static void fixSmiles(String smile) {
        Map<String, String> smiles = new HashMap<String, String>();
        smiles.put(":)", "[smiling]");
        smiles.put(":(", "[sad]");
        smiles.put("¯\\_(ツ)_/¯", "[such is life]");

        if (smiles.get(smile) != null) {
            System.out.println(smiles.get(smile));
            return;
        }

        System.out.println(smile);
    }
}

class Pascal {
        static void pTriangle(int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {

                    System.out.print(binomialCoefficient(i, j) + " ");

                }
                System.out.println();
            }
        }

        static int binomialCoefficient(int n, int m) {
            int res = 1;

            if (m > n - m)
                m = n - m;

            for (int i = 0; i < m; ++i)
            {
                res *= (n - i);
                res /= (i + 1);
            }
            return res;
        }
}