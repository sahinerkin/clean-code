package interfacesegregation;

import java.util.ArrayList;
import java.util.List;

public class BadPractice {

    // Bütün şekiller için tek bir interface yazılmış fakat interface'teki
    // metotlar hepsi tüm şekiller için anlamlı değil.
    // Bu tasarımda her şekil sınıfı, kendisiyle alakasız
    // metotları da dizayn etmeye zorlanıyor.

    public interface Shape {
        float calculatePerimeter();
        float calculateArea();
        float calculateVolume();
    }

    static class Line implements Shape {

        private float length;

        Line(float length) { this.length = length; }

        public void setLength(float length) { this.length = length; }

        public float getLength() { return length; }


        // Düz çizgi için "çevre"yi uzunluk gibi kabul edip metodu yazabiliriz.
        @Override
        public float calculatePerimeter() { return length; }

        // Fakat alan veya hacimden söz etmek mümkün değil.
        // Null veya 0 döndürmek ya da exception atmak gibi ideal olmayan çözümlere başvurmamız gerek.
        @Override
        public float calculateArea() { return 0; }

        @Override
        public float calculateVolume() { return 0; }

    }

    static class Rectangle implements Shape {

        private float width, height;

        Rectangle(float width, float height) {
            this.width = width;
            this.height = height;
        }

        public void setWidth(float width) { this.width = width; }
        public void setHeight(float height) { this.height = height;}
        public float getWidth() { return width; }
        public float getHeight() { return height; }


        // İki boyutlu olan dikdörtgen şeklinin çevresi mevcut.
        @Override
        public float calculatePerimeter() {
            return 2 * (width + height);
        }

        // Alanı da hesaplanabilir.
        @Override
        public float calculateArea() {
            return width * height;
        }

        // Fakat hacimden söz etmemiz yine mümkün değil.
        @Override
        public float calculateVolume() { return 0; }

    }

    static class Sphere implements Shape {

        private float r;

        Sphere(float r) { this.r = r; }

        public void setRadius(float r) { this.r = r; }
        public float getRadius() { return r; }

        // Kürenin en geniş kesit alanından belki çevre hesaplayabiliriz fakat
        // bütün üç boyutlu objelerde "çevre" konseptinden bahsedemeyeceğimiz için
        // daha fazla kafa karışıklığına da sebep olabilir.
        @Override
        public float calculatePerimeter() { return (float) (2 * Math.PI * r); }

        // "Alan" yüzey alanı gibi kabul edilebilip yazılmaya çalışılabilir ama yine de
        // bu isimlendirme kafa karışıklığı yaratabilir.
        @Override
        public float calculateArea() { return (float) (4 * Math.PI * r * r); }

        // Üç boyutlu kürenin hacmi hesaplanabilir.
        @Override
        public float calculateVolume() { return (float) (4.0/3.0 * Math.PI * Math.pow(r, 3)); }

    }

    public static void main(String[] args) {
        Line line = new Line(10);
        Rectangle rectangle = new Rectangle(12, 8);
        Sphere sphere = new Sphere(6);

        System.out.println("The perimeter of the line is " + line.calculatePerimeter() + ".");
        System.out.println("The area of the line is " + line.calculateArea() + ".");
        System.out.println("The volume of the line is " + line.calculateVolume() + ".");

        System.out.println("-------------------");

        System.out.println("The perimeter of the rectangle is " + rectangle.calculatePerimeter() + ".");
        System.out.println("The area of the rectangle is " + rectangle.calculateArea() + ".");
        System.out.println("The volume of the rectangle is " + rectangle.calculateVolume() + ".");

        System.out.println("-------------------");

        System.out.println("The perimeter of the sphere is " + sphere.calculatePerimeter() + ".");
        System.out.println("The area of the sphere is " + sphere.calculateArea() + ".");
        System.out.println("The volume of the sphere is " + sphere.calculateVolume() + ".");

        System.out.println("-------------------");


    }
}
