package liskovsubstitution;

public class BadPractice {

    static abstract class Bird {
        // "Bird" soyut sınıfımız herhangi bir kuşun yürüyebilme,
        // bir şeyler yiyebilme ve uçabilme yetilerine
        // sahip olduğu varsayımıyla yazılıyor.

        public abstract void walk();

        public abstract void eat();

        public abstract void fly();
    }

    static class Parrot extends Bird {
        // Papağan, üst sınıfından (Bird) kalıttığı bütün yetilere sahip.


        @Override
        public void walk() {
            System.out.println("The parrot is walking fast!");
        }

        @Override
        public void eat() {
            System.out.println("The parrot is eating seeds.");
        }

        @Override
        public void fly() {
            System.out.println("The parrot flaps its colourful wings and flies!");
        }

        // Bunlara ek olarak kendine has yetilere de sahip olmasında bir sakınca yok.
        public void speak(String phrase) {
            System.out.println("\"" + phrase + "\"");
        }
    }

    static class Mallard extends Bird {
        // Yaban ördeği de kalıttığı bütün metotları kullanabilme yetisine sahip.


        @Override
        public void walk() {
            System.out.println("The mallard is waddling around...");
        }

        @Override
        public void eat() {
            System.out.println("The mallard is eating something! Anything...");
        }

        @Override
        public void fly() {
            System.out.println("The mallard is flying to migrate. Hurray!");
        }

        // Aynı şekilde, Bird temel sınıfında bulunmayan ekstra metotlar barındırabilir.
        public void swim() {
            System.out.println("\"I can also swim well, you know.\"");
        }
    }

    static class Penguin extends  Bird {
        // Penguen için aynısını denediğimizde;

        @Override
        public void walk() {
            System.out.println("The penguin waddles. Left. Right. Left. Right. And so on.");
        }

        @Override
        public void eat() {
            System.out.println("\"Mmmh, seafood!\"");
        }

        @Override
        public void fly() {
            try {
                System.out.println("It tries to flap its wings, but...");
                throw new Exception("It tries but it cannot fly.");
            } catch (Exception e) {
                System.out.println("\u001B[31m" + e + "\u001B[0m");
            }
        }

        public void swim() {
            System.out.println("\"Might as well go for a swim...\"");
        }

    }

    public static void main(String[] args) {
        Parrot parrot = new Parrot();
        parrot.walk();
        parrot.eat();
        parrot.fly();
        parrot.speak("I'm a parrot!");

        System.out.println("-------------------");

        Mallard mallard = new Mallard();
        mallard.walk();
        mallard.eat();
        mallard.fly();
        mallard.swim();

        System.out.println("-------------------");

        Penguin penguin = new Penguin();
        penguin.walk();
        penguin.eat();
        penguin.fly();
        penguin.swim();
    }
}
