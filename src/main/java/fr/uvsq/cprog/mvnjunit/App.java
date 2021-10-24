package fr.uvsq.cprog.mvnjunit;


public class App
{
    public static void main(String[] args) {
        Fraction fr = new Fraction(6,3);
        System.out.println(fr.getNum());
        System.out.println(fr.getDen());
        System.out.println(fr.toDouble());
        System.out.println(fr.add(new Fraction(4,3)));
        System.out.println(fr.equals(new Fraction(2,7)));
        System.out.println(fr.compareTo(new Fraction(4,6)));
    }
}
