package com.vikko.demo.october;

import java.util.SortedMap;
import java.util.TreeMap;
import javax.sound.midi.Soundbank;

/**
 * @author: vikko
 * @Date: 2020/10/12 17:51
 * @Description:
 */
public class TreeMapDemo {
	public static void main(String[] args) {
		// creating maps
		TreeMap<Double, String> treemap = new TreeMap<Double, String>();
		SortedMap<Double, String> treemapincl = new TreeMap<Double, String>();

		// populating tree map
		treemap.put(2.0, "two");
		treemap.put(1.0, "one");
		treemap.put(3.0, "three");
		treemap.put(6.0, "six");
		treemap.put(5.0, "five");
		System.out.println(treemap.lastKey());

		System.out.println("Getting tail map");
		treemapincl=treemap.tailMap(3.1);
		treemapincl.put(8.0,"eight");
		System.out.println(treemapincl.lastKey());
		System.out.println("Tail map values: "+treemapincl);
	}
}


