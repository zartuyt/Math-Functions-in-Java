public class Constant extends SimpleFunction {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    public Constant(Constant that) {
        this.value = that.value;
    }

    public double value(double input) {
        return this.value;
    }

    public double value() {
        return value;
    }

    public Constant derivative() {
        return new Constant(0);
    }

    public void scale(double scalar) {
        this.value *= scalar;
    }

    public Function add(SimpleFunction that) {
        if (that instanceof Constant) {
            Constant c = (Constant) that;
            return new Constant(this.value + c.value);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = p.getCoefficients();
            newCoefficients[newCoefficients.length - 1] += this.value;
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function subtract(SimpleFunction that) {
        if (that instanceof Constant) {
            Constant c = (Constant) that;
            return new Constant(this.value - c.value);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = p.getCoefficients();
            newCoefficients[newCoefficients.length - 1] -= this.value;
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function multiply(SimpleFunction that) {
        if (that instanceof Constant) {
            Constant c = (Constant) that;
            return new Constant(this.value * c.value);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = p.getCoefficients();
            for (int i = 0; i < newCoefficients.length; i++) {
                newCoefficients[i] *= this.value;
            }
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function square() {
        return new Constant(value * value);
    }

    public Constant divide(Constant constantFunction) {
        return new Constant(this.value / constantFunction.value);
    }

    public String toString() {
        return "" + this.value;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == this) {
            return true;
        }
        if (!(otherObject instanceof Constant)) {
            return false;
        }
        Constant other = (Constant) otherObject;
        return Double.compare(this.value, other.value) == 0;
    }
}
