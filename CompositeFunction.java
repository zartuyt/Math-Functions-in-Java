public abstract class CompositeFunction extends Function {
    private double constant;
    private Function innerFunction;

    public CompositeFunction(double constant, Function innerFunction) {
        this.constant = constant;
        this.innerFunction = Function.copy(innerFunction);
    }

    // Getter methods
    public double getConstant() {
        return constant;
    }

    public Function getInnerFunction() {
        return innerFunction;
    }

    public void scale(double a) {
        constant *= a;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }

        if (!(otherObject instanceof CompositeFunction)) {
            return false;
        }

        CompositeFunction other = (CompositeFunction) otherObject;

        return Double.compare(constant, other.constant) == 0 && innerFunction.equals(other.getInnerFunction());
    }
}
