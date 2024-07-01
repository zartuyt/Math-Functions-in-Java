//c*sin(g(x))
public class Sine extends TrigonometricFunction {

    public Sine(Function innerFunction, double constant) {
        super(constant, innerFunction);
    }

    public Sine(Sine that) {
        super(that.getConstant(), that.getInnerFunction());
    }
    public double value(double x) {
        return super.getConstant() * Math.sin(super.getInnerFunction().value(x));
    }

    public ComplexFunction derivative() {
        return new ComplexFunction(ComplexFunction.Type.PRODUCT,
                new Constant(this.getConstant()).multiply(this.getInnerFunction().derivative()),
                new Cosine(this.getInnerFunction(), 1));
    }


    //c*sin(g(x))
    public String toString() {
        return (super.getConstant() + "*" + "sin(" + super.getInnerFunction().toString() + ")");
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Sine)) {
            return false;
        }
        Sine sin = (Sine) otherObject;
        return this.getConstant() == sin.getConstant() && this.getInnerFunction().equals(sin.getInnerFunction());
    }
}
