public class Logarithm extends CompositeFunction {
    private double base;

    public Logarithm(double constant, Function innerFunction, double base) {
        super(constant, innerFunction);
        this.base = base;
    }

    public Logarithm(Logarithm other) {
        super(other.getConstant(), Function.copy(other.getInnerFunction()));
        this.base = other.base;
    }

    public double value(double x) {
        return getConstant() * (Math.log(getInnerFunction().value(x)) / Math.log(base));
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.QUOTIENT,
                new Constant(this.getConstant()).multiply(this.getInnerFunction().derivative()),
                new Constant(Math.log(base)).multiply(getInnerFunction()));
    }

    public String toString() {
        return getConstant() + "*log[" + base + "](" + getInnerFunction().toString() + ")";
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Logarithm)) {
            return false;
        }
        Logarithm that = (Logarithm) otherObject;
        return super.equals(that) && Double.compare(base, that.base) == 0;
    }
}
