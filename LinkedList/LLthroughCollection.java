
import java.util.*;

public class LLthroughCollection {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);

        list.addFirst("this");
        list.addLast("list");
        list.add("wohoo");     
        System.out.println(list);

        System.out.println(list.size());

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("null");

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
    
}
