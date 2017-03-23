public class Quaternion {

    private double a;
    private Vector u;



    public Quaternion(double a, Vector u) {
        this.a = a;
        this.u = u;

    }

    public Quaternion(Vector axis,double angle) {
        this(round(10,Math.cos(angle / 2)),
                new Vector(axis.b *Math.sin(angle / 2),axis.c *Math.sin(angle / 2),axis.d *Math.sin(angle / 2)));
    }


    //Умножение на скаляр
    public Quaternion multiplyScal(double x) {
        double b1, c1, d1;
        b1=this.u.b*x;
        c1 = this.u.c * x;
        d1 = this.u.d * x;
        if ((x == 0) && (this.u.b < 0)) b1 *= -1;
        if ((x == 0) && (this.u.c < 0)) c1 *= -1;
        if ((x == 0) && (this.u.d < 0)) d1 *= -1;

        return new Quaternion(this.a * x, new Vector(b1, c1, d1));
    }

    //Модуль
    public double modulus() {
        return Math.sqrt(this.a * this.a + this.u.b * this.u.b + this.u.c * this.u.c + this.u.d * this.u.d);

    }

    //Сопряжение
    public Quaternion conjugating() {
        double b1, c1, d1;
        if (this.u.b == 0) b1 = this.u.b;
        else b1 = this.u.b * (-1);
        if (this.u.c == 0) c1 = this.u.c;
        else c1 = this.u.c * (-1);
        if (this.u.d == 0) d1 = this.u.d;
         else d1 = this.u.d * (-1);
        return new Quaternion(this.a, new Vector(b1, c1, d1));


    }

    //Сложение
    public Quaternion add(Quaternion q) {
        double b1, c1, d1;
        b1 = this.u.b + q.u.b;
        c1 = this.u.c + q.u.c;
        d1 = this.u.d + q.u.d;
        return new Quaternion(this.a + q.a, new Vector(b1, c1, d1));
    }

    //Разность
    public Quaternion subtract(Quaternion q) {
        double a1,b1, c1, d1;
        a1=round(1,this.a - q.a);
        b1 = round(1,this.u.b - q.u.b);
        c1 = round(1,this.u.c - q.u.c);
        d1 = round(1,this.u.d - q.u.d);

        return new Quaternion(a1, new Vector(b1, c1, d1));
    }

    //Умножение на кватернион
    public Quaternion multiply(Quaternion q) {
        double a1, b1, c1, d1;
        a1 = this.a * q.a - this.u.b * q.u.b - this.u.c * q.u.c - this.u.d * q.u.d;
        b1 = this.a * q.u.b + this.u.b * q.a + this.u.c * q.u.d - this.u.d * q.u.c;
        c1 = this.a * q.u.c - this.u.b * q.u.d + this.u.c * q.a + this.u.d * q.u.b;
        d1 = this.a * q.u.d + this.u.b * q.u.c - this.u.c * q.u.b + this.u.d * q.a;
        return new Quaternion(a1, new Vector(b1, c1, d1));
    }

    //Нормирование
    public Quaternion normalize() {
        double a1, b1, c1, d1;
        if (this.modulus()==0) throw new IllegalArgumentException("На ноль делить нельзя");
        a1 = this.a / this.modulus();
        b1 = this.u.b / this.modulus();
        c1 = this.u.c / this.modulus();
        d1 = this.u.d / this.modulus();
        return new Quaternion(a1, new Vector(b1, c1, d1));
    }

    //Обращение
    public Quaternion invert() {
        Quaternion q1, result;
        double mod;
        q1 = this.conjugating();
        mod = this.modulus() * this.modulus();
        if (mod==0) throw new IllegalArgumentException("Обратный кватернион существует только для ненулевого");
        result = q1.multiplyScal(1 / mod);
        return result;
    }

    //Получение векторной величины
    public Vector vectorPart() {
        return this.u;
    }

    //Получение скалярной величины
    public double scalPart() {
        return this.a;
    }


    //Возращает угол
    public double angl(){
        double angle;
        angle= 2*Math.acos(this.a);
        return angle;
    }

    //Возвращает ось
    public Vector ax(double angle){
        if (angle%(2*Math.PI)==0) return this.u;
        double b1,c1,d1;
        Vector axis;
        b1=this.u.b/Math.sin(angle/2);
        c1=this.u.c/Math.sin(angle/2);
        d1=this.u.d/Math.sin(angle/2);
        axis= new Vector(b1,c1,d1);
        return axis;
    }

    //Округление
    private static double round(int q, double precise) {
        double b = Math.pow(10, q);
        double res = precise * b;
        int r = (int) res;
        if (((precise*b*10%10)>=5)&&(precise>=0)) r++;
        if ((Math.abs(precise*b*10%10)>=5)&&(precise<0)) r--;
        return r / b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Vector getU() {
        return u;
    }

    public void setU(Vector u) {
        this.u = u;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quaternion that = (Quaternion) o;

        if (Double.compare(that.a, a) != 0) return false;
        return u != null ? u.equals(that.u) : that.u == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (u != null ? u.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s="q= "+String.format("%.1f",a);
        if (u.b>=0) s+='+';
        s+=u;
        return s;


    }

}
