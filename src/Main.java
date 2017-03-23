public class Main {

    public static void main(String[] args) {
//        Vector c1=new Vector(5,4,6);
//       System.out.println(c1);
        Quaternion q1= new Quaternion(2, new Vector(4.3, 1, 2));
        Quaternion q2 =new Quaternion(2.1, new Vector(2.1, 1, 1));

        System.out.println(q1.subtract(q2));

    }


}
