public class Cosine extends TrigonometricFunction {

    public Cosine(Function innerFunction, double constant) {
        super(constant, innerFunction);
    }

    public Cosine(Cosine that) {
        super(that.getConstant(), that.getInnerFunction());
    }
    public double value(double x) {
        return super.getConstant() * Math.cos(super.getInnerFunction().value(x));
    }

    //(c*cos(g(x)))' = c*g'(x)* − sin(g(x)) = −c ∗ g'(x) ∗ sin(g(x))
    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.PRODUCT,
                new Constant(-1 * this.getConstant()).multiply(this.getInnerFunction().derivative()),
                new Sine(this.getInnerFunction(), 1));
    }



    //c*cos(g(x))
    public String toString() {
        return (super.getConstant() + "*" + "cos(" + super.getInnerFunction().toString() + ")");
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Cosine)) {
            return false;
        }
        Cosine cos = (Cosine) otherObject;
        return this.getConstant() == cos.getConstant() && this.getInnerFunction().equals(cos.getInnerFunction());
    }
}
