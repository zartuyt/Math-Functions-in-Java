public abstract class Function {
    public abstract double value(double input);

    public abstract Function derivative();

    public abstract void scale(double scalar);

    public Function subtract(Function that) {
        return new ComplexFunction(ComplexFunction.Type.DIFFERENCE, this, that);
    }

    public Function add(Function that) {
        return new ComplexFunction(ComplexFunction.Type.SUM, this, that);
    }

    public Function divide(Function that) {
        return new ComplexFunction(ComplexFunction.Type.QUOTIENT, this, that);

    }

    public Function multiply(Function that) {
            return new ComplexFunction(ComplexFunction.Type.PRODUCT, this, that);
    }

        public Function square() {
            return new ComplexFunction(ComplexFunction.Type.PRODUCT, this, this);
        }

    public static Function copy(Function that) {
        if (that instanceof Ln) {
            return new Ln((Ln) that);
        } else if (that instanceof Cotan) {
            return new Cotan((Cotan) that);
        } else if (that instanceof ComplexFunction) {
            return new ComplexFunction((ComplexFunction) that);
        } else if (that instanceof Polynomial) {
            return new Polynomial((Polynomial) that);
        } else if (that instanceof Constant) {
            return new Constant((Constant) that);
        } else if (that instanceof Sine) {
            return new Sine((Sine) that);
        } else if (that instanceof Cosine) {
            return new Cosine((Cosine) that);
        } else if (that instanceof Tan) {
            return new Tan((Tan) that);
        } else if (that instanceof Exponential) {
            return new Exponential((Exponential) that);
        } else if (that instanceof Logarithm) {
            return new Logarithm((Logarithm) that);
        }
        return null;
    }


}