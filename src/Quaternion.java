public class Quaternion {

    private double a;
    private Vector u;



    public Quaternion(double a, Vector u) {
        this.a = a;
        this.u = u;

    }

    public static Quaternion fromAngleAndAxis(double angle, Vector axis){
        return new Quaternion(round(10,Math.cos(angle / 2)),
                new Vector(axis.getB() *Math.sin(angle / 2),axis.getC() *Math.sin(angle / 2),axis.getD() *Math.sin(angle / 2)));
    }


    //Умножение на скаляр
    public Quaternion multiplyScal(double x) {
        double b1, c1, d1;
        b1=this.u.getB()*x;
        c1 = this.u.getC() * x;
        d1 = this.u.getD() * x;

        return new Quaternion(this.a * x, new Vector(b1, c1, d1));
    }

    //Модуль
    public double modulus() {
        return Math.sqrt(this.a * this.a + this.u.getB() * this.u.getB() + this.u.getC() * this.u.getC() + this.u.getD() * this.u.getD());

    }

    //Сопряжение
    public Quaternion conjugating() {
        double b1, c1, d1;
        b1 = this.u.getB() * (-1);
        c1 = this.u.getC() * (-1);
        d1 = this.u.getD() * (-1);
        return new Quaternion(this.a, new Vector(b1, c1, d1));


    }

    //Сложение
    public Quaternion add(Quaternion q) {
        double b1, c1, d1;
        b1 = this.u.getB() + q.u.getB();
        c1 = this.u.getC() + q.u.getC();
        d1 = this.u.getD() + q.u.getD();
        return new Quaternion(this.a + q.a, new Vector(b1, c1, d1));
    }

    //Разность
    public Quaternion subtract(Quaternion q) {
        double a1,b1, c1, d1;
        a1=this.a - q.a;
        b1 = this.u.getB() - q.u.getB();
        c1 = this.u.getC() - q.u.getC();
        d1 = this.u.getD() - q.u.getD();
        return new Quaternion(a1, new Vector(b1, c1, d1));
    }

    public Quaternion approximatelyEquals(){
        return new Quaternion(round(4,a),new Vector(round(4,u.getB()),round(4,u.getC()),round(4,u.getD())));
    }
    //Умножение на кватернион
    public Quaternion multiply(Quaternion q) {
        double a1, b1, c1, d1;
        a1 = this.a * q.a - this.u.getB() * q.u.getB() - this.u.getC() * q.u.getC() - this.u.getD() * q.u.getD();
        b1 = this.a * q.u.getB() + this.u.getB() * q.a + this.u.getC() * q.u.getD() - this.u.getD() * q.u.getC();
        c1 = this.a * q.u.getC() - this.u.getB() * q.u.getD() + this.u.getC() * q.a + this.u.getD() * q.u.getB();
        d1 = this.a * q.u.getD() + this.u.getB() * q.u.getC() - this.u.getC() * q.u.getB() + this.u.getD() * q.a;
        return new Quaternion(a1, new Vector(b1, c1, d1));
    }

    //Нормирование
    public Quaternion normalize() {
        double a1, b1, c1, d1;
        if (this.modulus()==0) throw new IllegalArgumentException("На ноль делить нельзя");
        a1 = this.a / this.modulus();
        b1 = this.u.getB() / this.modulus();
        c1 = this.u.getC() / this.modulus();
        d1 = this.u.getD() / this.modulus();
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
        b1=this.u.getB()/Math.sin(angle/2);
        c1=this.u.getC()/Math.sin(angle/2);
        d1=this.u.getD()/Math.sin(angle/2);
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
        if (!(o instanceof Quaternion)) return false;

        Quaternion that = (Quaternion) o;

        if (Double.compare(that.getA(), getA()) != 0) return false;
        return getU().equals(that.getU());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getA());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getU().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "q= " + a +
                u;
    }
}
