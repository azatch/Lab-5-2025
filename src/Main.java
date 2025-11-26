import functions.*;
import functions.basic.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Function sin = new Sin();

        TabulatedFunction arr1 = TabulatedFunctions.tabulate(sin, 0.0, Math.PI, 5);
        TabulatedFunction arr2 = TabulatedFunctions.tabulate(sin, 0.0, Math.PI, 5);
        TabulatedFunction list1;
        {
            FunctionPoint[] pts = new FunctionPoint[arr1.getPointsCount()];
            for (int i = 0; i < pts.length; i++) {
                pts[i] = arr1.getPoint(i);
            }
            list1 = new LinkedListTabulatedFunction(pts);
        }

        System.out.println("toString ArrayTabulatedFunction:");
        System.out.println(arr1.toString());
        System.out.println("toString LinkedListTabulatedFunction:");
        System.out.println(list1.toString());

        System.out.println("equals:");
        System.out.println("arr1.equals(arr2) = " + arr1.equals(arr2));
        System.out.println("arr1.equals(list1) = " + arr1.equals(list1));
        System.out.println("list1.equals(arr1) = " + list1.equals(arr1));

        System.out.println("hashCode:");
        System.out.println("arr1.hashCode() = " + arr1.hashCode());
        System.out.println("arr2.hashCode() = " + arr2.hashCode());
        System.out.println("list1.hashCode() = " + list1.hashCode());

        arr2.setPointY(0, arr2.getPointY(0) + 0.001);
        System.out.println("После небольшого изменения arr2:");
        System.out.println("arr1.equals(arr2) = " + arr1.equals(arr2));
        System.out.println("arr2.hashCode() = " + arr2.hashCode());

        TabulatedFunction arrClone = (TabulatedFunction) arr1.clone();
        TabulatedFunction listClone = (TabulatedFunction) list1.clone();

        System.out.println("clone:");
        System.out.println("arr1.equals(arrClone) = " + arr1.equals(arrClone));
        System.out.println("list1.equals(listClone) = " + list1.equals(listClone));

        arr1.setPointY(1, arr1.getPointY(1) + 1.0);
        list1.setPointY(1, list1.getPointY(1) + 1.0);

        System.out.println("После изменения исходных объектов:");
        System.out.println("arr1.equals(arrClone) = " + arr1.equals(arrClone));
        System.out.println("list1.equals(listClone) = " + list1.equals(listClone));
    }
}
