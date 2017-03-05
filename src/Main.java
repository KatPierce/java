public class Main {

    public static void main(String[] args) {
        Vector c1=new Vector(5,4,6);
       System.out.println(c1);
       Quaternion q1= new Quaternion(4,c1);

        System.out.println(q1.Spath());
        System.out.println("klkm");
    }

}
