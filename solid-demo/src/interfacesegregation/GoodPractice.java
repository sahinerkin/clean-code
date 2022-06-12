package interfacesegregation;

import java.util.ArrayList;
import java.util.List;

public class GoodPractice {

    // Interface'ler farklı kullanım alanlarına göre daha net ve
    // ayrı sorumluluklara sahip olacak şekilde ayrılmış.

    public interface Shape2D {
        float calculatePerimeter();
        float calculateArea();
    }

    public interface Shape3D {
        float calculateSurfaceArea();
        float calculateVolume();
    }

    static class Line {

        private float length;

        Line(float length) { this.length = length; }

        public void setLength(float length) { this.length = length; }

        public float getLength() { return length; }

    }

    static class Rectangle implements Shape2D {

        private float width, height;

        Rectangle(float width, float height) {
            this.width = width;
            this.height = height;
        }

        public void setWidth(float width) { this.width = width; }
        public void setHeight(float height) { this.height = height;}
        public float getWidth() { return width; }
        public float getHeight() { return height; }


        @Override
        public float calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public float calculateArea() {
            return width * height;
        }
    }

    static class Sphere implements Shape3D {

        private float r;

        Sphere(float r) { this.r = r; }

        public void setRadius(float r) { this.r = r; }
        public float getRadius() { return r; }

        @Override
        public float calculateSurfaceArea() { return (float) (4 * Math.PI * r * r); }

        @Override
        public float calculateVolume() { return (float) (4.0/3.0 * Math.PI * Math.pow(r, 3)); }

        // Farklı sınıflara özel ekstra metotlar eklemek mümkün.
        // Bu metotların birden fazla sınıfta mevcut olması durumunda
        // farklı interface'ler olarak da dizayn edilmesi bir seçenek.
        public float calculateGreatCircleCircumference() { return (float) (2 * Math.PI * r); }

        public float calculateGreatCircleSurface() { return (float) (Math.PI * r * r); }
    }

    public static void main(String[] args) {
        Line line = new Line(10);
        Rectangle rectangle = new Rectangle(12, 8);
        Sphere sphere = new Sphere(6);

        System.out.println("The length of the line is " + line.getLength() + ".");

        System.out.println("-------------------");

        System.out.println("The perimeter of the rectangle is " + rectangle.calculatePerimeter() + ".");
        System.out.println("The area of the rectangle is " + rectangle.calculateArea() + ".");

        System.out.println("-------------------");

        System.out.println("The surface area of the sphere is " + sphere.calculateSurfaceArea() + ".");
        System.out.println("The volume of the sphere is " + sphere.calculateVolume() + ".");
        System.out.println("The circumference of the great circle of the sphere is " + sphere.calculateGreatCircleCircumference() + ".");
        System.out.println("The area of the great circle of the sphere is " + sphere.calculateGreatCircleSurface() + ".");

        System.out.println("-------------------");


    }
}
