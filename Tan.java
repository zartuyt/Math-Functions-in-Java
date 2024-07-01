//c*tan(g(x))
public class Tan extends TrigonometricFunction {

    public Tan(Function innerFunction, double constant) {
        super(constant, innerFunction);
    }

    public Tan(Tan that) {
        super(that.getConstant(), that.getInnerFunction());
    }
    public double value(double x) {
        return super.getConstant() * Math.tan(super.getInnerFunction().value(x));
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.QUOTIENT,
                new Constant(this.getConstant()).multiply(this.getInnerFunction().derivative()),
                new Cosine(this.getInnerFunction(), 1).multiply(new Cosine(this.getInnerFunction(), 1)));
    }

    public String toString() {
        return super.getConstant() + "*tan(" + super.getInnerFunction() + ")";
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Tan)) {
            return false;
        }
        Tan tan = (Tan) otherObject;
        return this.getConstant() == tan.getConstant() && this.getInnerFunction().equals(tan.getInnerFunction());
    }
}
