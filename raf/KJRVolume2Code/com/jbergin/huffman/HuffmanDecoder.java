package com.jbergin.huffman;


public class HuffmanDecoder {
	
	private Node codeTree;

	public void createCodeTree(String codedTree){
		this.codeTree = recodeTree(new Node(0.0, null, null), new StringBuffer(codedTree));
	}
	
	public Node recodeTree(Node node, StringBuffer codedTree){
		if(! codedTree.equals("")){
			char ch = codedTree.charAt(0);
			if(ch == 'L'){
				char symbol = codedTree.charAt(1);
				
//				System.out.println("leaf with " + symbol);
				codedTree.delete(0, 2);
				return new Node(0.0, symbol);
			}
			if(ch == '0'){
				codedTree.delete(0, 1);
				Node another = new Node(0.0, null, null);
				node.setLeft(recodeTree(another, codedTree));	
			}
			else{ // x)
				System.out.println("error l");
			}
			ch = codedTree.charAt(0);
			if(ch == 'L'){
				char symbol = codedTree.charAt(1);
				
//				System.out.println("leaf with " + symbol);
				codedTree.delete(0, 2);
				return new Node(0.0, symbol);
			}
			if (ch == '1'){
				codedTree.delete(0, 1);
				Node another = new Node(0.0, null, null);
				node.setRight(recodeTree(another, codedTree));
			}
			else{ // x
				System.out.println("error r");
			}
		}
		return node;
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
			
			System.out.print(node.symbol());
			node = codeTree;
		}
		
		return result;
	}


	
	public static void main(String [] args){
		HuffmanDecoder decoder = new HuffmanDecoder();
		
		String codedTreex = "00L xx1000Lwxx1Lbxx100L.xx10Lcxx1LAxx1Lyxx10Lhxx10Lu" +
				"xx1Ldxx1000Laxx10Llxx100L-xx1LMxx1L,xx10Lexx1Loxx1000Lsxx1Lrxx10L" +
				"ixx1000LIxx10LUxx10LOxx1LSxx10Lfxx1Lvxx100LPxx1Lgxx1Lkxx10Ltxx10Lnxx" +
				"10Lmxx100L'xx100LYxx1LDxx10LWxx1L;xx1LTxx";
		
		String codedTreey = "0L 100LwLbLh10Ly1L.1LcLA1LuLd100La1Ll10L-LM10LILf1LvLP1Le" +
				"Lo100LsLr1Li1L,10LgL'Lk1Lt1Ln1Lm100LU1LOLS10LYLD1LWL;LT";
		
		String codedTree = "00L 1000Lw1Lb1Lh100Ly10L.10Lc1LA10Lu1Ld1000La10Ll100L-1" +
				"LM100LI1Lf10Lv1LP10Le1Lo1000Ls1Lr10Li10L,100Lg1L'1Lk10Lt10Ln10Lm1000LU" +
				"10LO1LS100LY1LD10LW1L;1LT";


		
		decoder.createCodeTree(codedTree);
		
		String code = "111111010011111100101111110000001111101111110110111011110001101" +
				"111111101011010000010000100110110111011100011111010100001000110101110" +
				"010110110111011100001100101101110000101100010011110101000110011010100" +
				"001111001000000100110111011110111100010010110000111001011010001111010" +
				"001111101010001011100111010011111110101101000011011101111100111101010" +
				"1111011100111011001101011000001011100111010011111111011111110001111110" +
				"0111000010000110010101100111111101110001001011101110001110010110001110" +
				"0010001101011110110111011110001111010110011111010001110111010101100101" +
				"10100000111111101011000111000010011011101111011110001000100011000001111" +
				"10100001111101000010010110000100110111001011010001001101100011001110111" +
				"10011111110100010001101011110110110001000111100111100010110100011101011" +
				"10010011110011100101101000111011001011101110010111011000111110100011010" +
				"11110100100110001101000001111111010110101100110100001000100011000001110" +
				"01011101011110110111001100000010000101110100110110010100010110100011000" +
				"11101100110101110011011001011010011111101100001001011101110001111101000" +
				"11010111101001001100000101101000111010111001001111001110010110100011101" +
				"10010111011100101011010000011111110101100011100011010110000011110101111" +
				"10010111010111101101110001101000001001110000111101010100111101010110010" +
				"01100010101010111100010001111001100010011011011110110000010010111011100" +
				"01001011010101001111001011111101010001110110101111101010001011110010010" +
				"00111101011111001011010110011101100001000110101110010110110111011100011" +
				"01011100001000100011000000110111011101111011100010011111101110010100100" +
				"11001101100010111100100111001011010000100011010011111011010001101100010" +
				"11110010011111010000110001001101000100110110001100101100011010000001101" +
				"11011101111011100010011111101110010100100110010011001001100111111110111" +
				"11110110111011100000011011101110111101110001001111110111001010010011001" +
				"10110001100001011010001101011000100110010011001000111100111100100110110" +
				"00110010110011011000100011110011110011100101101000111111011011010011111" +
				"01101000001111110101101101110110111001001010001100000110101100000100010" +
				"01010010001110101110010011110010000100110110111011100011010111100011100" +
				"10110001110000100110111011110111111011000010000101110100110110010100110" +
				"10110000011111010111100011101001001100001000001110110010111010100001001" +
				"10111011110111111011000010001101011100101001100010111111101010001100011" +
				"10110011010111001101100101101011001110001101100010001100000100111000011" +
				"  0001000110100111100010011010100111011011110011010011010";

		System.out.println("Decoding");
		System.out.println(decoder.decodeIt(code));
		

	}

}
