public class Ln extends Logarithm {
    public Ln(Function innerFunction, double constant) {
        super(constant, innerFunction, Math.E);
    }

    public Ln(Ln that) {
        super(that.getConstant(), that.getInnerFunction(), Math.E);
    }

    public String toString() {
        return super.toString().replace("log[" + Math.E + "]", "ln");
    }

    public boolean equals(Object otherObject) {
        if (otherObject instanceof Ln) {
            Ln other = (Ln) otherObject;
            return super.equals(other);
        }
        return false;
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.QUOTIENT,
                new Constant(this.getConstant()).multiply(this.getInnerFunction().derivative()),
                getInnerFunction());
    }
}
