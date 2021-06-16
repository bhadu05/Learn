import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

@FunctionalInterface
interface Ano
{
     int a=8;
     void math1(int a);
     //void math2();

}
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

          Main obj = new Main();

          System.out.println(obj.logic(6,8));


     }

}
