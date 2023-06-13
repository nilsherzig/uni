package student;

public class Main {
    public static void main(String[] args) {
        Length l1;
        Length l2;
        l1 = new Length(LengthUnit.METER, 3704.0);
        l2 = new Length(LengthUnit.NAUTICAL_MILE, 2.0);

        System.out.println(l1.equals(l2));

        System.out.println(AtmosphericLayer.EXO.toString());
    }
}
