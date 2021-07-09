package javapractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) myNumberList.add(i);

        //Method 1: traversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Method1: Iterator Value::" + i);
        }

        //Method 2: traversing with Explicit Consumer interface implementation
        class myConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Method2: Consumer Implementation Value:: "+t);
            }
        }
        myConsumer action = new myConsumer();
        myNumberList.forEach(action);

        //Method3: Traversing with Anonymous Consumer Interface Implementation
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Method3: forEach Anonymous Class Value::"+t);
            }
        });

        //Method4: Explicit Lambda Function
        Consumer<Integer> myListAction = n-> {
          System.out.println("Method4: forEach Lambda Implementation Value:: " +n);
        };
        myNumberList.forEach(myListAction);

        //Method5: Implicit Lambda Function
        myNumberList.forEach(n->{
            System.out.println("Method5: forEach Lambda Implementation Value:: " +n);
        });

        //Method6: Implicit Lambda Function to print double value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n->{
            System.out.println("Method6: forEach Lambda Double Value:: " +toDoubleFunction.apply(n));
        });

        //Method7: Implicit Lambda Function to check even
        Predicate<Integer> isEvenFunction = n-> n>0 && n%2 == 0;
        myNumberList.forEach(n -> {
           System.out.println("Method7: forEach Value Of: " + n + ";" + "check for even: " + isEvenFunction.test(n));
        });
    }
}
