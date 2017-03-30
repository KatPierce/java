public class Vector {
    private double b,c,d;
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



public static String sign(double x){
        if (x>0) return "+"+x; else
    if (x==0) return "+"+(double)((int)x); else
        return java.lang.Double.toString(x);
}

    @Override
    public String toString() {
        return sign(b)+ "*i"+ sign(c)+"*j"+sign(d)+"*k";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;

        Vector vector = (Vector) o;

        if (Double.compare(vector.getB(), getB()) != 0) return false;
        if (Double.compare(vector.getC(), getC()) != 0) return false;
        return Double.compare(vector.getD(), getD()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getB());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getC());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getD());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
