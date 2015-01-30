package com.jbergin.huffman;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.jbergin.generic.DefaultHashMap;




public class HuffmanCoder {
	
	private DefaultHashMap<Character, Integer> characterFrequencies = new DefaultHashMap<Character, Integer>();
//	private boolean [] code;
	private Queue<Node> rightQueue = new LinkedList<Node>();
	private Map<Character, Node> encodings = new TreeMap<Character, Node>();
	private NodeComparator compare = new NodeComparator();
	private PriorityQueue<Node> leftQueue = new PriorityQueue<Node>(30, compare);
	private Node codeTree = null;
	
	private class NodeComparator implements Comparator<Node>{

		public int compare(Node o1, Node o2) {
			return Double.compare(o1.value(), o2.value());
		}
		
	}
	
	public void getFrequencies(String text){
		for(int i = 0; i < text.length(); ++i){
			char character = text.charAt(i);
			int current = characterFrequencies.get(character, 0);
			characterFrequencies.put(character, current+1);
		}
	}
	
	public void makeLeaves(int textLength){
		for(char character:characterFrequencies.keySet()){
			int frequency = characterFrequencies.get(character);
			Node node = new Node(frequency*1.0/textLength, character);
			encodings.put(character, node);
			leftQueue.add(node);
		}
	}
	
	private Node getNode(){ // pre at least two elements
		if(leftQueue.isEmpty()){
			return rightQueue.poll();
		}
		else if(rightQueue.isEmpty()){
			return leftQueue.poll();
		}
		else if (compare.compare(leftQueue.peek(),rightQueue.peek()) < 0){
			return leftQueue.poll();
		}
		else {
			return rightQueue.poll();
		}
	}
	
	public void buildTrees(){
		while (leftQueue.size() + rightQueue.size() > 1){
			Node small = getNode();
			Node next = getNode(); // two smallest values
			Node newNode = new Node(small.value() + next.value(), small, next);
//			small.setParent(newNode);
//			next.setParent(newNode);
			rightQueue.add(newNode);
		}
		codeTree = rightQueue.poll();
	}
	
	public void showFrequencies(){
		int total = 0;
		for(char ch:characterFrequencies.keySet()){
			int freq = characterFrequencies.get(ch);
			total += freq;
			System.out.println("" + ch + " : " + freq);
		}
		System.out.println("total frequency: " + total);
//		System.out.println("text length    : " + textLength);
	}
	
	public String codeIt(String text){
		
		getFrequencies(text);
		makeLeaves(text.length());
		buildTrees();
		return mapIt(text);
	}
	
	public String mapIt(String text){
		String result = "";
		for(int i = 0; i < text.length(); ++i){
			result += codeFor(text.charAt(i));
		}
		return result;
	}
	
//	public void showCode(){
//		for(boolean b: code){
//			if(b){
//				System.out.print(1);
//			}
//			else{
//				System.out.print(0);
//			}
//			System.out.println();
//		}
//	}
	
	public String codeFor(char ch){
		String result = "";
		Node node = encodings.get(ch);
		if(node != null){
			result = node.code();
			while(node.parent() != null){
				node = node.parent();
				result = node.code() + result;
			}
		}
		return result;
	}
	
	public String decodeIt(String coded){
		String result = "";
		Node node = codeTree;
		int i = 0;
		while( i < coded.length()){
			while(! node.isLeaf()){
				if(coded.charAt(i) == '0'){
					node = node.left();
				}
				else{
					node = node.right();
				}
				i++;
			}
			result += node.symbol();
			node = codeTree;
		}
		
		return result;
	}
	
	public String encodeTree(Node node, String soFar){
		String tempLeft = "";
		String tempRight = "";
		if(node.isLeaf()){
			soFar += "L"+node.symbol();
		}
		else { 
			if(node.left() != null){
				tempLeft = "0" + encodeTree(node.left(), soFar);
			}
			else{
				tempLeft = "x"; // should never appear
			}
			if(node.right() != null){
				tempRight = "1" + encodeTree(node.right(), soFar);
			}
			else{
				tempRight = "x"; // should never appear
			}		}
		return soFar + tempLeft + tempRight;
	}
	
	public String et(Node node, String soFar){
		if(node.isLeaf()){
			return soFar + "L"+node.symbol();
		}
		
		return soFar + "0(" + et(node.left(), soFar) + ")1(" + et(node.right(), soFar) + ")";
	}
	
	
	public static void main(String [] args){
		String text = "YOU don't know about me without you have " +
		"read a book by the name of The " +
		"Adventures of Tom Sawyer; but that ain't no matter.  That book was made " +
		"by Mr. Mark Twain, and he told the truth, mainly.  There was things which " +
		"he stretched, but mainly he told the truth.  That is nothing.  I never " +
		"seen anybody but lied one time or another, without it was Aunt Polly, or " +
		"the widow, or maybe Mary.  Aunt Polly--Tom's Aunt Polly, she is--and " +
		"Mary, and the Widow Douglas is all told about in that book, which is " +
		"mostly a true book, with some stretchers, as I said before.";
		String texty = "this";

		HuffmanCoder coder = new HuffmanCoder();
		String result = coder.codeIt(text);
		System.out.println(result);
		System.out.println(coder.decodeIt(result));
		String tree = coder.encodeTree(coder.codeTree, "");
		System.out.println(tree);
		System.out.println(coder.et(coder.codeTree, ""));
//		Node node = coder.recodeTree(new Node(0.0, null, null), new StringBuffer(tree));
//		coder.codeTree = node;
//		String second = coder.mapIt(text);
//		System.out.println(second);
//		System.out.println(coder.decodeIt(second));

		
//		coder.getFrequencies(coder.text);
//		coder.makeLeaves();
//		Node n = coder.leftQueue.peek();
//		
//		coder.showFrequencies(text.length());
//		System.out.println("first in queue is " +n.symbol() + " : " + n.value() );
//		coder.buildTrees();
//		System.out.println(coder.codeTree.value());
		for(char ch:coder.encodings.keySet()){
			System.out.println(ch + " : " + coder.codeFor(ch));
		}	
		
		System.out.println("Frequencies");
		coder.showFrequencies();
		
		System.out.println("leafcount " + coder.characterFrequencies.size());
	}
}


