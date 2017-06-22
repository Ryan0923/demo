/**
 * Created by mojunbin on 2017/6/22.
 */
public class FindMaxDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(2.0);
        Circle circle2 = new Circle(3.0);
        Circle[] circleArr = new Circle[] {circle, circle2};
        Circle max = (Circle)findMax(circleArr);
        System.out.println(max);
    }

    public static Comparable findMax(Comparable[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static <T extends Comparable<? super T>> T findMax2(T[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    static class Circle implements Comparable<Circle> {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public int compareTo(Circle o) {
            return new Double(this.radius).compareTo(new Double(o.radius));
        }

        @Override
        public String toString() {
            return "Circle{" +
                "radius=" + radius +
                '}';
        }
    }
}
