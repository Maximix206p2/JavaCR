import com.google.common.collect.Ordering;
import com.sun.management.UnixOperatingSystemMXBean;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GiantTurnip {
    public static void main(String[] args) {
        FairyTale fairyTale = new FairyTale();
        fairyTale.tell();
        //oldMan.compareTo(oldWoman);
    }
}

class Personage implements Comparable {
    private String name;
    private int strength;

    public Personage(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public int compareTo(Object o) {
        return -(this.getStrength()-((Personage)o).getStrength());
    }
}

class FairyTale{
    private Queue<Personage> queue = new PriorityQueue<>();
    public FairyTale(){
        queue.add(new Personage("turnip", 25));
        queue.add(new Personage("dog", 3));
        queue.add(new Personage("mouse", 1));
        queue.add(new Personage("old man", 10));
        queue.add(new Personage("old woman", 7));
        queue.add(new Personage("grand daughter", 5));
        queue.add(new Personage("cat", 2));
    }

    public void tell(){
        int sum = 0;
        Personage prev = queue.poll(); //голосование
        int strength = prev.getStrength();
        //System.out.println(turnip.getName());
        Personage next = null;
        while (!queue.isEmpty()){
            next = queue.poll();
            sum+=next.getStrength();
            System.out.println("The " + next.getName() + " took hold of the " + prev.getName());
            prev = next;
        }

        if (sum>=strength) System.out.println("They pulled and pulled = and finally out came the turnip.");
        else System.out.println("They pulled and pulled. But still they could not pull the turnip out.");
    }
}