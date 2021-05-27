
/**
 * ueb 17 - Main Klasse
 * 
 * @author Simon Klasen & Andreas Scheuer
 * @version 0.1
 */

public class Main {
    private final int min = 0;
    private final int max = 10;

    // Definierte Lambda Funktionen

    private final MyFunction sqrL = i -> i * i;
    private final MyFunction facL = i -> (i == 0) ? 1 : i * this.facL.apply(i - 1);
    private final MyFunction powL = i -> (int) Math.pow(i, i + 1);
    private final MyFunction fibL = i -> (i <= 2) ? 1 : this.fibL.apply(i - 1) + this.fibL.apply(i - 2);
    private final Preadikat even = i -> i % 2 != 0;

    /**
     * Annonyme Klasse fuer x^2
     */

    MyFunction sqrA = new MyFunction() {
        @Override
        public int apply(int i) {
            return i * i;
        }
    };

    /**
     * Annonyme Klasse fuer fakultaet
     */

    MyFunction facA = new MyFunction() {
        @Override
        public int apply(int i) {
            return (i == 0) ? 1 : i * apply(i - 1);
        }
    };

    /**
     * Annonyme Klasse fuer hoch x +1
     */

    MyFunction powA = new MyFunction() {
        @Override
        public int apply(int i) {
            return (int) Math.pow(i, i + 1);
        }
    };

    /**
     * Annonyme Klasse fuer fibonacci zahlenreihe
     */

    MyFunction fibA = new MyFunction() {
        @Override
        public int apply(int i) {
            return (i <= 2) ? 1 : apply(i - 1) + apply(i - 2);
        }
    };

    /**
     * Annonyme Klasse zur pruefung ob ein Wert gerade ist
     */

    Preadikat odd = new Preadikat() {
        @Override
        public boolean checkNumber(int i) {
            return i % 2 == 0;
        }
    };

    /**
     * Static nested class von fakultaet
     */

    public static class FacStatic implements MyFunction {

        @Override
        public int apply(int i) {
            return (i == 0) ? 1 : i * apply(i - 1);
        }

    }

    /**
     * Start Methode
     */

    public void start() {
        // f(x) = x*x
        System.out.println("F(x) = x*x :\n");
        System.out.println("Mit Lambda:");
        applyAndPrint(min, max, sqrL);
        System.out.println("Mit anonymer Klasse:");
        applyAndPrint(min, max, sqrA);
        System.out.println("--------------------------------------------");

        // f(x) = x!
        System.out.println("F(x) = x! :\n");
        System.out.println("Mit Lambda:");
        applyAndPrint(min, max, facL);
        System.out.println("Mit anonymer Klasse:");
        applyAndPrint(min, max, facA);
        System.out.println("Mit TopLevel Klasse:");
        applyAndPrint(min, max, new Fac());
        System.out.println("Mit StaticNested Klasse:");
        applyAndPrint(min, max, new FacStatic());
        System.out.println("--------------------------------------------");

        // f(x) = x^(x+1)
        System.out.println("F(x) = x^(x+1) :\n");
        System.out.println("Mit Lambda:");
        applyAndPrint(min, max, powL);
        System.out.println("Mit anonymer Klasse:");
        applyAndPrint(min, max, powA);
        System.out.println("--------------------------------------------");

        // f(x) = fib(x)
        System.out.println("F(x) = fib(x) :\n");
        System.out.println("Mit Lambda:");
        applyAndPrint(min, max, fibL);
        System.out.println("Mit anonymer Klasse:");
        applyAndPrint(min, max, fibA);
        System.out.println("--------------------------------------------");

        // Quadratzahlen von geraden Zahlen
        System.out.println("Gerade Quadratzahlen:");
        applyAndPrint(min, max, i -> sqrL.conditionateInput(i, odd));
        System.out.println("--------------------------------------------");

        // ungerade Falkutäten
        System.out.println("Ungerade Fakultät:");
        applyAndPrint(min, max, i -> facL.conditionateOutput(i, even));
        System.out.println("--------------------------------------------");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        new Main().start();

    }

    /**
     * @param i   darf nicht kleiner 0 sein
     * @param j   darf nicht kleiner 0 sein
     * @param fkt übergebene Funktion die ausgefuehrt werden soll
     */
    public static void applyAndPrint(int i, int j, MyFunction fkt) {
        Lib_Digits.checkMin(0, i, "Min");
        Lib_Digits.checkMin(0, j, "Max");

        for (int index = i + 1; index < j; index++) {

            System.out.println("f(" + index + ") = " + fkt.apply(index));
        }

    }
}
