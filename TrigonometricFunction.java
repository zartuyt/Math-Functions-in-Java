public abstract class TrigonometricFunction extends CompositeFunction {
    public TrigonometricFunction(double constant, Function innerFunction) {
        super(constant, innerFunction);
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        return super.equals(otherObject);
    }
}
