package liskovsubstitution;

public class GoodPractice {

    // Eğer sınıflar çok değişken özelliklere sahipse, kalıtım (inheritance) mantığından vazgeçip
    // bu özellikleri küçük modüler interface'ler şeklinde yazıp daha sonrasında istediğimiz
    // sınıflar için kullanabiliriz.

    // Daha temel özellikler için inheritance kullanıp ayrışan özelliklerde interface'lere başvurmak
    // da bir başka makul seçenek. Bu örnekte kolaylık ve tam modülarite için ilk yolu uygulayacağız.

    protected interface Walking {
        void walk();
    }

    protected interface Eating {
        void eat();
    }

    interface Flying {
        void fly();
    }

    interface Speaking {
        void speak(String phrase);
    }

    interface  Swimming {
        void swim();
    }

    static class Parrot implements Walking, Eating, Flying, Speaking {


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

        public void speak(String phrase) {
            System.out.println("\"" + phrase + "\"");
        }
    }

    static class Mallard implements Walking, Eating, Flying, Swimming {

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

        public void swim() {
            System.out.println("\"I can also swim well, you know.\"");
        }
    }

    static class Penguin implements Walking, Eating, Swimming {

        @Override
        public void walk() {
            System.out.println("The penguin waddles. Left. Right. Left. Right. And so on.");
        }

        @Override
        public void eat() {
            System.out.println("\"Mmmh, seafood!\"");
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
        penguin.swim();
    }
}
