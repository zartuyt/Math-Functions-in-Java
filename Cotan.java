public class Cotan extends Tan {
    public Cotan(Function innerFunction, double constant) {
        super(innerFunction, constant);
    }

    public Cotan(Cotan that) {
        super(that.getInnerFunction(), that.getConstant());
    }

    public double value(double x) {
        return getConstant() * (1 / Math.tan(getInnerFunction().value(x)));
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.QUOTIENT,
                new Constant(-1 * this.getConstant()).multiply(this.getInnerFunction().derivative()),
                (new Sine(this.getInnerFunction(), 1)).square());
    }

    public String toString() {
        return (this.getConstant() + "*cot(" + this.getInnerFunction().toString() + ")");
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Cotan)) {
            return false;
        }
        Cotan cotan = (Cotan) otherObject;
        return this.getConstant() == cotan.getConstant() && this.getInnerFunction().equals(cotan.getInnerFunction());
    }
}
