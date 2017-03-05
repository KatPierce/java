public class Quaternion {
//    public static class Quaternions{
    private double a;
    private Vector u;

    public Quaternion(double a, Vector u) {
      this.a=a;
      this.u=u;

    }
//Умножение на скаляр
public Quaternion MultiplicationonScal(double x){
        double b1,c1,d1;
        b1= this.u.b*x;
        c1= this.u.c*x;
        d1= this.u.d*x;
        return new Quaternion(this.a*x,new Vector(b1,c1,d1));
}

//Модуль
public double Modulus(){
 return  Math.sqrt(this.a*this.a +this.u.b*this.u.b+this.u.c*this.u.c+ this.u.d*this.u.d);

}
//Сопряжение
public Quaternion Conjugating(){
    double b1,c1,d1;
    b1=this.u.b*-1;
    c1=this.u.c*-1;
    d1=this.u.d*-1;
    return new Quaternion(this.a, new Vector(b1,c1,d1));


}
//Сложение
public Quaternion Addition(Quaternion q){
        double b1,c1,d1;
        b1=this.u.b+q.u.b;
        c1=this.u.c*+q.u.c;
        d1=this.u.d*+q.u.d;
        return new Quaternion(this.a+q.a, new Vector(b1,c1,d1));
    }
//Разность
    public Quaternion Subtraction(Quaternion q){
        double b1,c1,d1;
        b1=this.u.b-q.u.b;
        c1=this.u.c*-q.u.c;
        d1=this.u.d*-q.u.d;
        return new Quaternion(this.a-q.a, new Vector(b1,c1,d1));
    }
    //Умножение на кватернион
    public Quaternion Multiplication(Quaternion q){
        double a1,b1,c1,d1;
        a1= this.a*q.a-this.u.b*q.u.b-this.u.c*q.u.c-this.u.d*q.u.d ;
        b1= this.a*q.u.b+this.u.b*q.a+this.u.c*q.u.d-this.u.d*q.u.c ;
        c1= this.a*q.u.c-this.u.b*q.u.d+this.u.c*q.a+this.u.d*q.u.b ;
        d1= this.a*q.u.d+this.u.b*q.u.c-this.u.c*q.u.b+this.u.d*q.a ;
        return new Quaternion(a1, new Vector(b1,c1,d1));
    }
    //Нормирование
    public Quaternion Normalazation(Quaternion q){
        double a1,b1,c1,d1;
        a1= this.a/q.Modulus() ;
        b1= this.u.b/q.Modulus();
        c1= this.u.c/q.Modulus() ;
        d1= this.u.d/q.Modulus() ;
        return new Quaternion(a1, new Vector(b1,c1,d1));
    }
    //Обращение
    public Quaternion Inversion(Quaternion q){
        Quaternion q1,result;
        double mod;
        q1= q.Conjugating();
        mod= this.Modulus()*this.Modulus();
        result=q1.MultiplicationonScal(1/mod);
        return result;
    }
    //Получение векторной величины
    public Vector Vpath(){
        return this.u;
    }
    //Получение скалярной величины
    public double Spath(){
        return this.a;
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
        return "q = "+
                a + " + "
                + u
                ;
    }

}
