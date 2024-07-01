import java.util.Arrays;

public class Polynomial extends SimpleFunction {
    private int degree;
    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients.clone();
        this.degree = coefficients.length - 1;
    }

    public Polynomial(Polynomial that) {
        this.coefficients = that.coefficients.clone();
        this.degree = that.degree;
    }

    public int getDegree() {
        return degree;
    }

    public double[] getCoefficients() {
        return coefficients.clone();
    }

    public double value(double x) {
        double sum = 0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }
        return sum;
    }

    public Function derivative() {
        if (coefficients.length == 1) {
            return new Constant(0);
        }
        double[] derivedFunction = new double[this.coefficients.length - 1];
        for (int i = 1; i < this.coefficients.length; i++) {
            derivedFunction[i - 1] = this.coefficients[i] * i;
        }
        return new Polynomial(derivedFunction);
    }

    public void scale(double scalar) {
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] *= scalar;
        }
    }

    public Function add(SimpleFunction that) {
        if (that instanceof Constant) {
            double[] newCoefficients = this.coefficients.clone();
            newCoefficients[0] += ((Constant) that).value();
            return new Polynomial(newCoefficients);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = new double[Math.max(this.coefficients.length, p.coefficients.length)];
            for (int i = 0; i < newCoefficients.length; i++) {
                newCoefficients[i] = (i < this.coefficients.length ? this.coefficients[i] : 0) +
                        (i < p.coefficients.length ? p.coefficients[i] : 0);
            }
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function subtract(SimpleFunction that) {
        if (that instanceof Constant) {
            double[] newCoefficients = this.coefficients.clone();
            newCoefficients[0] -= ((Constant) that).value();
            return new Polynomial(newCoefficients);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = new double[Math.max(this.coefficients.length, p.coefficients.length)];
            for (int i = 0; i < newCoefficients.length; i++) {
                newCoefficients[i] = (i < this.coefficients.length ? this.coefficients[i] : 0) -
                        (i < p.coefficients.length ? p.coefficients[i] : 0);
            }
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function multiply(SimpleFunction that) {
        if (that instanceof Constant) {
            double[] newCoefficients = this.coefficients.clone();
            double scalar = ((Constant) that).value();
            for (int i = 0; i < newCoefficients.length; i++) {
                newCoefficients[i] *= scalar;
            }
            return new Polynomial(newCoefficients);
        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;
            double[] newCoefficients = new double[this.coefficients.length + p.coefficients.length - 1];
            for (int i = 0; i < this.coefficients.length; i++) {
                for (int j = 0; j < p.coefficients.length; j++) {
                    newCoefficients[i + j] += this.coefficients[i] * p.coefficients[j];
                }
            }
            return new Polynomial(newCoefficients);
        }
        return null;
    }

    public Function square() {
        return this.multiply(this);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = coefficients.length - 1; i > 0; i--) {
            if (coefficients[i] != 0) {
                result.append(coefficients[i]).append("*x^").append(i).append(" + ");
            }
        }
        result.append(coefficients[0]);
        return result.toString();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Polynomial)) {
            return false;
        }
        Polynomial that = (Polynomial) other;
        return Arrays.equals(this.coefficients, that.coefficients);
    }
}
