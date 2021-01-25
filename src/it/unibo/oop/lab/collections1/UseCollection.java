package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	List<Integer> arrayList = new ArrayList<>();
    	
    	for (int i = 1_000; i < 2_000; i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	List<Integer> linkedList = new LinkedList<>();
    	
    	linkedList.addAll(arrayList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int last = arrayList.get(arrayList.size() - 1);
    	
    	arrayList.set(arrayList.size() - 1, arrayList.get(0));
    	
    	arrayList.set(0, last);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (Integer elem : arrayList) {
    		System.out.println("\nElem dell'arrayList: \t" + elem);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	for (int i = 0; i < 100_000; i++) {
    		arrayList.add(0, i);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("\nInserimento 100_000 in arrayList\ttime: " + time + " ns");
    	
    	time = System.nanoTime();
    	
    	for (int i = 0; i < 100_000; i++) {
    		linkedList.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	
    	System.out.println("\nInserimento 100_000 in linkedList\ttime: " + time + " ns");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	time = System.nanoTime();
    	
    	for (int i = 0; i < 1000; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	
    	int num1 = arrayList.get(arrayList.size() / 2);
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("\nArrayList:\tlettura dell'elemento " + num1 + "1000 volte in " + time + " ns");
    	
    	time = System.nanoTime();
    	
    	for (int i = 0; i < 1000; i++) {
    		linkedList.get(linkedList.size() / 2);
    	}
    	
    	int num2 = linkedList.get(linkedList.size() / 2);
    	
    	time = System.nanoTime() - time;

    	System.out.println("\nLinkedList:\tlettura dell'elemento " + num2 + "1000 volte in " + time + " ns");
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String, Long> map = new HashMap<>();
    	map.put("Africa", 1_110_635_000L);
    	map.put("Americas", 972_005_000L);
    	map.put("Antarctica", 0L);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000L);
    	map.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	long pm = 0;
    	for (long popolazione : map.values()) {
    		pm += popolazione;
    	}
    	
    	System.out.println("\nPopolazione Mondiale: " + pm);
    	
    }
}
