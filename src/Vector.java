public class Vector {
    double b,c,d;
    public Vector(double b, double c,double d) {
      this.b=b;
      this.c=c;
      this.d=d;
    }



    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }



    @Override
    public String toString() {
        return  b+
                "*i + "  + c+
                "*j + " + d+
                "*k"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (Double.compare(vector.b, b) != 0) return false;
        if (Double.compare(vector.c, c) != 0) return false;
        return Double.compare(vector.d, d) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(b);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
