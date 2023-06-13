package student;

public class Main {

    public static void main(String[] args) {

        MinMidMax m1 = new MinMidMax<String>();
        System.out.println(m1.toString());
        System.out.println(m1.getMid());
        System.out.println(m1.popRight());
    }
    // //Signatur der Methode darf nicht verändert werden!
    // public void addObserverForIntegerList(MinMidMax<Integer> mmm)
    // {
    // //Fügen Sie hier einen Beobachter mit geeigneter Implementation (siehe
    // Aufgabenstellung) zum Objekt mmm hinzu
    // }
    //
    // //Signatur der Methode darf nicht verändert werden!
    // public void addObserverForStringList(MinMidMax<String> mmm)
    // {
    // //Fügen Sie hier einen Beobachter mit geeigneter Implementation (siehe
    // Aufgabenstellung) zum Objekt mmm hinzu
    //
    // }
    //
    // //Führen Sie das Programm aus, um Ihre Implementation zu testen und das
    // Ergebnis mit den in der Aufgabenstellung
    // //dargestellten Ausgaben zu vergleichen
    // //Methode nicht verändern!
    // public static void main(String[] args)
    // {
    // Main main = new Main();
    // main.testWithInteger();
    //
    // System.out.println();
    // main.testWithString();
    // }
    //
    // //Methode nicht verändern!
    // public void testWithInteger()
    // {
    // MinMidMax<Integer> mmm = new MinMidMax<>(3, 9, 1);
    // addObserverForIntegerList(mmm);
    // System.out.printf("Liste: %s\n", mmm);
    // mmm.push(0);
    // mmm.push(5);
    // mmm.push(4);
    // mmm.push(11);
    // mmm.push(10);
    // mmm.push(101);
    // mmm.push(-15);
    // mmm.push(-1);
    // mmm.push(-1); //Wert schon vorhanden
    // mmm.popRight();
    // mmm.popLeft();
    // mmm.popLeft();
    // System.out.printf("Minimum: %d\n", mmm.getMinimum());
    // System.out.printf("Maximum: %d\n", mmm.getMaximum());
    // System.out.printf("Median: %d\n", mmm.getMid());
    // }
    //
    // //Methode nicht verändern!
    // public void testWithString()
    // {
    // MinMidMax<String> mmm = new MinMidMax<>("bh", "ah", "fa", "ch", "bh");
    // //Element bh doppelt
    // addObserverForStringList(mmm);
    // System.out.printf("Liste: %s\n", mmm);
    // mmm.push("ae");
    // mmm.push("bb");
    // mmm.push("ba");
    // mmm.push("ck");
    // mmm.push("cj");
    // mmm.push("qa");
    // mmm.push("aa");
    // mmm.push("ac");
    // mmm.push("ac"); //Element schon vorhanden
    // mmm.popRight();
    // mmm.popLeft();
    // mmm.popLeft();
    // mmm.popRight();
    // mmm.popRight();
    // System.out.printf("Minimum: %s\n", mmm.getMinimum());
    // System.out.printf("Maximum: %s\n", mmm.getMaximum());
    // System.out.printf("Median: %s\n", mmm.getMid());
    // System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
    // System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
    // System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
    // System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
    // System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
    // System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
    // System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
    // System.out.printf("Rückgabe popRight: %s\n", mmm.popRight()); //Element
    // existiert nicht
    // }
}
