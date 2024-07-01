public class Exponential extends CompositeFunction {
    private double base;

    public Exponential(double constant, double base, Function exponent) {
        super(constant, exponent);
        this.base = base;
    }

    public Exponential(Exponential that) {
        super(that.getConstant(), Function.copy(that.getInnerFunction()));
        this.base = that.base;
    }

    public double value(double x) {
        double exponent = getInnerFunction().value(x);
        return getConstant() * Math.pow(base, exponent);
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.PRODUCT,
                new Constant(this.getConstant() * Math.log(this.base)).multiply(this.getInnerFunction().derivative()),
                new Exponential(1, this.base, this.getInnerFunction()));
    }

    public String toString() {
        return (getConstant() + "*" + base + "^{" + getInnerFunction().toString() + "}");
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Exponential)) {
            return false;
        }
        Exponential other = (Exponential) otherObject;
        return super.equals(other) && Double.compare(base, other.base) == 0;
    }
}
