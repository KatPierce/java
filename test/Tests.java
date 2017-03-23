import com.sun.xml.internal.bind.v2.util.QNameMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class Tests {


        @Tag("Сложение кватернионов")
        @Test
        public void add() {
        Assertions.assertEquals(new Quaternion(4, new Vector(1, -7, 2)),
                new Quaternion(2, new Vector(0, 1, 2)).add(new Quaternion(2, new Vector(1, -8, 0))));
        Assertions.assertEquals(new Quaternion(2, new Vector(-0.5, 2, 3)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).add(new Quaternion(2, new Vector(0, 1, 1))));

        }

        @Tag("Вычитание кватернионов")
        @Test
        public void subtract() {
            Assertions.assertEquals(new Quaternion(-0.1, new Vector(2.2, 0, 1)),
                    new Quaternion(2, new Vector(4.3, 1, 2)).subtract(new Quaternion(2.1, new Vector(2.1, 1, 1))));
        }


        @Tag("Умножение кватерниона на скаляр")
        @Test
        public void multiplyScal() {
        Assertions.assertEquals(new Quaternion(4.2, new Vector(0, 2.1, 4.2)),
                new Quaternion(2, new Vector(0, 1, 2)).multiplyScal(2.1));
        Assertions.assertEquals(new Quaternion(0, new Vector(-1.5, 3, 6)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).multiplyScal(3));
        Assertions.assertEquals(new Quaternion(0, new Vector(0, 0, 0)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).multiplyScal(0));

        }

        @Tag("Модуль")
        @Test
        public void modulus() {
        Assertions.assertEquals(3.0,
                new Quaternion(2, new Vector(0, 1, 2)).modulus());
        Assertions.assertEquals(0.0,
                new Quaternion(0, new Vector(0, 0, 0)).modulus());
        }

        @Tag("Сопряжение")
        @Test
        public void conjugating() {
          Assertions.assertEquals(new Quaternion(4.3, new Vector(-2.2, -7, -1)),
                  new Quaternion(4.3, new Vector(2.2, 7, 1)).conjugating());
            Assertions.assertEquals(new Quaternion(4.3, new Vector(0, -7, -1)),
                    new Quaternion(4.3, new Vector(0, 7, 1)).conjugating());
                Assertions.assertEquals(new Quaternion(4.3, new Vector(0, 0, 0)),
                        new Quaternion(4.3, new Vector(0, 0, 0)).conjugating());

        }
        @Tag("Скалярная часть")
        @Test
        public void scalPart() {
                Assertions.assertEquals(2.0,
                        new Quaternion(2, new Vector(0, 1, 2)).scalPart());
                Assertions.assertEquals(0.0,
                        new Quaternion(0, new Vector(0, 0, 0)).scalPart());
                Assertions.assertEquals(-14.0,
                        new Quaternion(-14, new Vector(3, 5, 0)).scalPart());
        }

        @Tag("Векторная часть")
        @Test
        public void vectorPart() {
                Assertions.assertEquals(new Vector(0, 1, 2),
                        new Quaternion(2, new Vector(0, 1, 2)).vectorPart());
                Assertions.assertEquals(new Vector(0, 0, 0),
                        new Quaternion(0, new Vector(0, 0, 0)).vectorPart());
                Assertions.assertEquals(new Vector(3, 5, 0),
                        new Quaternion(-14, new Vector(3, 5, 0)).vectorPart());
        }

        @Tag("Нормирование")
        @Test
        public void normalize() {
                Assertions.assertEquals(new Quaternion(1, new Vector(0, 0, 0)),
                        new Quaternion(2, new Vector(0, 0, 0)).normalize());
                Assertions.assertEquals(new Quaternion(-1, new Vector(0, 0, 0)),
                        new Quaternion(-2, new Vector(0, 0, 0)).normalize());
                Assertions.assertEquals(new Quaternion(0.5, new Vector(0.5, 0.5, 0.5)),
                        new Quaternion(1, new Vector(1, 1, 1)).normalize());
        }
        @Tag("Обращение")
        @Test
        public void invert() {

                Assertions.assertEquals(new Quaternion(0.08, new Vector(-0.04, -0.04, -0.02)),
                        new Quaternion(8, new Vector(4, 4, 2)).invert());
                Assertions.assertEquals(new Quaternion(0.25, new Vector(-0.25, -0.25, -0.25)),
                        new Quaternion(1, new Vector(1, 1, 1)).invert());
        }

        @Tag("Умножение")
        @Test
        public void multiply() {
                Assertions.assertEquals(new Quaternion(-6, new Vector(1, -5, 2)),
                        new Quaternion(0, new Vector(1, 1, 2)).multiply(new Quaternion(0, new Vector(-1, 1, 3))));
                Assertions.assertEquals(new Quaternion(-6, new Vector(-1, 5, -2)),
                        new Quaternion(0, new Vector(-1, 1, 3)).multiply(new Quaternion(0, new Vector(1, 1, 2))));
        }
        @Tag("Построение")
        @Test
        public void construct() {
                Assertions.assertEquals(new Quaternion(0, new Vector(1, 1, 1)),
                        new Quaternion(new Vector(1,1,1),Math.PI));

        }

        @Tag("Угол")
        @Test
        public void Angl() {
                Assertions.assertEquals(0,
                        new Quaternion(1,new Vector(1,1,1)).angl());

        }

        @Tag("Ось")
        @Test
        public void ax() {
                Assertions.assertEquals(new Vector(2,2,1),
                        new Quaternion(1,new Vector(2,2,1)).ax(Math.PI));
                Assertions.assertEquals(new Vector(2,2,1),
                        new Quaternion(1,new Vector(2,2,1)).ax(0));

        }



}
