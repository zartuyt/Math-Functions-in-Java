public class ComplexFunction extends Function {
    private Function f;
    private Function g;
    private Type type;

    enum Type {SUM, DIFFERENCE, PRODUCT, QUOTIENT}

    public ComplexFunction(Type type, Function f, Function g) {
        this.type = type;
        this.f = Function.copy(f);
        this.g = Function.copy(g);
    }

    public ComplexFunction(ComplexFunction that) {
        this.type = that.type;
        this.f = Function.copy(that.f);
        this.g = Function.copy(that.g);
    }

    public void scale(double scalar) {
        switch (type) {
            case SUM:
            case DIFFERENCE:
                f.scale(scalar);
                g.scale(scalar);
                break;
            case PRODUCT:
            case QUOTIENT:
                f.scale(scalar);
                break;
        }
    }

    public double value(double input) {
        switch (type) {
            case SUM:
                return f.value(input) + g.value(input);
            case DIFFERENCE:
                return f.value(input) - g.value(input);
            case PRODUCT:
                return f.value(input) * g.value(input);
            case QUOTIENT:
                return f.value(input) / g.value(input);
            default:
                return 0;
        }
    }

    public Function derivative() {
        switch (type) {
            case SUM:
                return f.derivative().add(g.derivative());
            case DIFFERENCE:
                return f.derivative().subtract(g.derivative());
            case PRODUCT:
                return (f.derivative().multiply(g)).add(f.multiply(g.derivative()));
            case QUOTIENT:
                return ((f.derivative().multiply(g)).subtract(f.multiply(g.derivative()))).divide(g.square());
            default:
                return null;
        }
    }

    public String toString() {
        switch (type) {
            case SUM:
                return "(" + f.toString() + ") + (" + g.toString() + ")";
            case DIFFERENCE:
                return "(" + f.toString() + ") - (" + g.toString() + ")";
            case PRODUCT:
                return "(" + f.toString() + ") * (" + g.toString() + ")";
            case QUOTIENT:
                return "(" + f.toString() + ") / (" + g.toString() + ")";
            default:
                return "";
        }
    }
}
