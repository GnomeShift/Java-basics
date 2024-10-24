public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imag + other.imag);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imag - other.imag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real, imag * other.imag);
    }

    public ComplexNumber divide(ComplexNumber other) {
        return new ComplexNumber(real / other.real, imag / other.imag);
    }
}

class Main12 {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(1, 2);
        System.out.println(c1.add(c1));
        System.out.println(c1.subtract(c1));
        System.out.println(c1.multiply(c1));
        System.out.println(c1.divide(c1));
    }
}
