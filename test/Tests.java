import com.sun.xml.internal.bind.v2.util.QNameMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class Tests {


        @Tag("Сложение кватернионов")
        @Test
        public void Addition() {
        Assertions.assertEquals(new Quaternion(4, new Vector(1, -7, 2)),
                new Quaternion(2, new Vector(0, 1, 2)).Addition(new Quaternion(2, new Vector(1, -8, 0))));
        Assertions.assertEquals(new Quaternion(2, new Vector(-0.5, 2, 3)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).Addition(new Quaternion(2, new Vector(0, 1, 1))));

        }

        @Tag("Вычитание кватернионов")
        @Test
        public void Subtraction() {
            Assertions.assertEquals(new Quaternion(-0.1, new Vector(2.2, 0, 1)),
                    new Quaternion(2, new Vector(4.3, 1, 2)).Subtraction(new Quaternion(2.1, new Vector(2.1, 1, 1))));
        }


        @Tag("Умножение кватерниона на скаляр")
        @Test
        public void MultiplicationonScal() {
        Assertions.assertEquals(new Quaternion(4.2, new Vector(0, 2.1, 4.2)),
                new Quaternion(2, new Vector(0, 1, 2)).MultiplicationonScal(2.1));
        Assertions.assertEquals(new Quaternion(0, new Vector(-1.5, 3, 6)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).MultiplicationonScal(3));
        Assertions.assertEquals(new Quaternion(0, new Vector(0, 0, 0)),
                new Quaternion(0, new Vector(-0.5, 1, 2)).MultiplicationonScal(0));

        }

        @Tag("Модуль")
        @Test
        public void Modulus() {
        Assertions.assertEquals(3.0,
                new Quaternion(2, new Vector(0, 1, 2)).Modulus());
        Assertions.assertEquals(0.0,
                new Quaternion(0, new Vector(0, 0, 0)).Modulus());
        }

        @Tag("Сопряжение")
        @Test
        public void Conjugating() {
          Assertions.assertEquals(new Quaternion(4.3, new Vector(-2.2, -7, -1)),
                  new Quaternion(4.3, new Vector(2.2, 7, 1)).Conjugating());
            Assertions.assertEquals(new Quaternion(4.3, new Vector(0, -7, -1)),
                    new Quaternion(4.3, new Vector(0, 7, 1)).Conjugating());
                Assertions.assertEquals(new Quaternion(4.3, new Vector(0, 0, 0)),
                        new Quaternion(4.3, new Vector(0, 0, 0)).Conjugating());

        }
        @Tag("Скалярная часть")
        @Test
        public void Spart() {
                Assertions.assertEquals(2.0,
                        new Quaternion(2, new Vector(0, 1, 2)).Spart());
                Assertions.assertEquals(0.0,
                        new Quaternion(0, new Vector(0, 0, 0)).Spart());
                Assertions.assertEquals(-14.0,
                        new Quaternion(-14, new Vector(3, 5, 0)).Spart());
        }

        @Tag("Векторная часть")
        @Test
        public void Vpart() {
                Assertions.assertEquals(new Vector(0, 1, 2),
                        new Quaternion(2, new Vector(0, 1, 2)).Vpart());
                Assertions.assertEquals(new Vector(0, 0, 0),
                        new Quaternion(0, new Vector(0, 0, 0)).Vpart());
                Assertions.assertEquals(new Vector(3, 5, 0),
                        new Quaternion(-14, new Vector(3, 5, 0)).Vpart());
        }

        @Tag("Нормирование")
        @Test
        public void Normalazation() {
                Assertions.assertEquals(new Quaternion(1, new Vector(0, 0, 0)),
                        new Quaternion(2, new Vector(0, 0, 0)).Normalazation());
                Assertions.assertEquals(new Quaternion(-1, new Vector(0, 0, 0)),
                        new Quaternion(-2, new Vector(0, 0, 0)).Normalazation());
                Assertions.assertEquals(new Quaternion(0.5, new Vector(0.5, 0.5, 0.5)),
                        new Quaternion(1, new Vector(1, 1, 1)).Normalazation());
        }
        @Tag("Обращение")
        @Test
        public void Inversion() {

                Assertions.assertEquals(new Quaternion(0.08, new Vector(-0.04, -0.04, -0.02)),
                        new Quaternion(8, new Vector(4, 4, 2)).Inversion());
                Assertions.assertEquals(new Quaternion(0.25, new Vector(-0.25, -0.25, -0.25)),
                        new Quaternion(1, new Vector(1, 1, 1)).Inversion());
        }

        @Tag("Умножение")
        @Test
        public void Multiplication() {
                Assertions.assertEquals(new Quaternion(-6, new Vector(1, -5, 2)),
                        new Quaternion(0, new Vector(1, 1, 2)).Multiplication(new Quaternion(0, new Vector(-1, 1, 3))));
                Assertions.assertEquals(new Quaternion(-6, new Vector(-1, 5, -2)),
                        new Quaternion(0, new Vector(-1, 1, 3)).Multiplication(new Quaternion(0, new Vector(1, 1, 2))));
        }
        @Tag("Построение")
        @Test
        public void Construction() {
                Assertions.assertEquals(new Quaternion(0, new Vector(1, 1, 1)),
                        new Quaternion(new Vector(1,1,1),Math.PI));

        }

        @Tag("Угол")
        @Test
        public void Angl() {
                Assertions.assertEquals(0,
                        new Quaternion(1,new Vector(1,1,1)).Angl());

        }

        @Tag("Ось")
        @Test
        public void Ax() {
                Assertions.assertEquals(new Vector(2,2,1),
                        new Quaternion(1,new Vector(2,2,1)).Ax(Math.PI));
                Assertions.assertEquals(new Vector(2,2,1),
                        new Quaternion(1,new Vector(2,2,1)).Ax(0));

        }



}
