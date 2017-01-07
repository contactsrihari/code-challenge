package com.guruintech.problem.solving.solutions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * Given any string, find a longest substring containing same set of repeated characters   
 * 
 * @author srihari konakanchi
 *
 */
public class LongestSameSequenceChar {

	public static void main(String[] args) {
		System.out.println(findLongestSubString("thisw word aaaaa is 99999999999999 most bbbbbbbbb kkkk"));
	}

	public static String findLongestSubString(String s) {
		if (s == null || s.isEmpty()) return s;
		
		Map<Character, LinkedList<AtomicInteger>> m = new HashMap<>();
		char[] chars = s.toCharArray();
		Character previous = null;
		for(Character c : chars) {
			LinkedList<AtomicInteger> bucket = m.get(c);
			if (c == previous) {
				bucket.getLast().incrementAndGet();
			} else {
				if (bucket == null) {
					LinkedList<AtomicInteger> newBucket = new LinkedList<>();
					newBucket.add(new AtomicInteger(1));
					m.put(c, newBucket);
				} else {
					bucket.addLast(new AtomicInteger(1));
				}
				previous = c;
			}
		}

		int maxRepeatCount = 0;
		Character repeatChar = null;
		
		Comparator<AtomicInteger> comp = new Comparator<AtomicInteger>() {

			@Override
			public int compare(AtomicInteger o1, AtomicInteger o2) {
				return o1.get() == o2.get() ? 0 : o1.get() < o2.get() ? 1 : -1; 
			}
		};
		
		for(Character c : chars) {
			SortedSet<AtomicInteger> set = new TreeSet<AtomicInteger>(comp);
			set.addAll(m.get(c));
			if (maxRepeatCount == 0 || set.last().get() >= maxRepeatCount) {
				maxRepeatCount = set.last().get();
				repeatChar = c;
			}
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		char ch[] = new char[maxRepeatCount];
		Arrays.fill(ch, repeatChar);
		return new String(ch);
	}
	
}
