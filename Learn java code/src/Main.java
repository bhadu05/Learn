import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

@FunctionalInterface
interface Ano
{
     int a=8;
     void math1(int a);
     //void math2();

}
//Generics
class Gen<T1>
{
     int a;
     T1 t;

     public int getA() {
          return a;
     }

     public void setA(int a) {
          this.a = a;
     }

     public Gen(int a, T1 t) {
          this.a = a;
          this.t = t;
     }

     public T1 getT() {
          return t;
     }

     public void setT(T1 t) {
          this.t = t;
     }
}

//Comparable
class laptop implements Comparable<laptop>
{
     String brand;
     int ram;
     int price;

     public laptop(String brand, int ram, int price) {
          this.brand = brand;
          this.ram = ram;
          this.price = price;
     }

     public String getBrand() {
          return brand;
     }

     public void setBrand(String brand) {
          this.brand = brand;
     }

     public int getRam() {
          return ram;
     }

     public void setRam(int ram) {
          this.ram = ram;
     }

     public int getPrice() {
          return price;
     }

     public void setPrice(int price) {
          this.price = price;
     }

     @Override
     public String toString() {
          return "laptop{" +
                  "brand='" + brand + '\'' +
                  ", ram=" + ram +
                  ", price=" + price +
                  '}';
     }

     @Override
     public int compareTo(laptop obj) {
          if(this.brand.compareTo(obj.brand)>0)
               return 1;
          else
               return -1;
     }
}
//Inner Class
class Outer
{
     int a;
     class Inner
     {
          int b;
     }
}
//Abstract Class
abstract class Abs
{
     abstract void abs1();
}
public class Main{

     static <T> T logic(T ...x)
     {
          T sum = (T)new Object();
          Operators + (T)
          for(int i=0;i<x.length;i++)
          {
              sum= sum + x[i];
          }
          return sum;
     }
     
          //Varargs
     static int sum(int... a)
     {
          int sum=0;
          for(int x : a)
               sum+=x;
          return sum;
     }

     public static void main(String[] args) {
/*          Ano obj = new Ano() {
               @Override
               public void math1() {
                    System.out.println("method1");
               }

               @Override
               public void math2() {
                    System.out.println("method2");
               }
          };*/
 /*         Ano obj = (n)->{
            for(int i=0;i<n;i++)
                 System.out.println("Lambda created");
          };
          obj.math1(6);*/
/*          ArrayList<Integer> arrayList = new ArrayList<Integer>();
          arrayList.add(78);
          arrayList.add(67);

          int v =  arrayList.get(1);
          System.out.println(v);*/

          //Anonymous Class
/*          Ano obj = new Ano() {
               @Override
               public void math1(int a) {
                    System.out.println(a);
               }

               @Override
               public void math2() {
                    System.out.println("math2");
               }
          };
          obj.math1(34);*/

          //Lambda Expression
/*          Ano obj2 = (a)->{
               System.out.println("Lambda expression created " + a);
          };
          obj2.math1(56);*/

        //Generics (almost same as c++ templates)
      /*    Gen<String> obj3 = new Gen(34,"string");
          String str = obj3.getT();
          System.out.println(str);*/

/*          String str="Original";
          str="Duplicate";
          System.out.println(str);
          System.out.println(str.length());
          System.out.println(str.toLowerCase());
          System.out.println(str.toUpperCase());
          System.out.println(str.substring(2));
          System.out.println(str.charAt(2));*/

/*          Main obj = new Main();

          System.out.println(obj.logic(6,8));
          
*/
        
         //Comparable
          List<laptop> list = new ArrayList<laptop>();
          list.add(new laptop("hp",4,45678));
          list.add(new laptop("dell",21,34356));
          list.add(new laptop("lenevo",12,54257));

          Collections.sort(list);
          for(laptop l : list)
               System.out.println(l);

     }
     
               //Another way by passing comparator logic.
          Comparator<laptop> comp = (obj1, obj2) -> {
               if(obj1.price>obj2.price)
                    return 1;
               else return -1;
          };
          Collections.sort(list,comp);
          for(laptop l : list)
               System.out.println(l);
         
                   //Inner Class
          
          Outer obj = new Outer();
          Outer.Inner innerObject = obj.new Inner();
     
               //Jagged Arrays
          int a[][]={{1,2},{2,3},{1,2,3}};
          for(int j=0;j<a.length;j++)
          {
               for(int k=0;k<a[j].length;k++)
                    System.out.println(a[j][k]);
          }

          //Varargs
          System.out.println(sum(1,2,34,4,5,6));


}
