/**
 *  Created on Jan 22, 2008
 */
package com.jbergin.huffman;

class Node{
	
	private double value = 0.0;
	private char symbol = '\0';
	private Node left = null;
	private Node right = null;
	private Node parent = null;
	private String code = "";
	private boolean isLeaf = true;
	
	public Node(double value, char symbol){ // leaf nodes
		this.value = value;
		this.symbol = symbol;
	}
	
	public Node(double value, Node left, Node right){
		this.value = value;
		this.left = left;
		if(left != null){
			left.code = "0";
			left.parent = this;
		}
		this.right = right;
		if(right != null){
			right.code = "1";
			right.parent = this;
		}
		this.isLeaf = false;
	}
	
	public String code(){
		return code;
	}
	
	public void setLeft(Node node){
		left = node;
		node.parent = this;
		node.code = "0";
	}
	
	public void setRight(Node node){
		right = node;
		node.parent = this;
		node.code = "1";
	}
	
	public boolean isLeaf(){
		return isLeaf;
	}
	
	public Node parent(){
		return parent;
	}
	
//	public void setParent(Node parent){
//		this.parent = parent;
//	}
	
	public double value(){
		return value;
	}
	
	public char symbol(){
		return symbol;
	}
	
	public Node left(){
		return left;
	}
	
	public Node right(){
		return right;
	}
}