package computer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.jbergin.generic.DenseList;


public class Assembler {

	private Map<String, Integer> table = new HashMap<String, Integer>();
	private DenseList<String> program = new DenseList<String>();
	private boolean translateOK = true;
	private DenseList<String> translated = new DenseList<String>();
	
	public Assembler(){
		table.put("push", 0);
		table.put("pop", 1);
		table.put("toss", 2);
		table.put("outp", 3);
		table.put("dupl", 4);
		table.put("add", 5);
		table.put("subtr", 6);
		table.put("halt", 7);
		table.put("inp", 8);
		table.put("jmp", 9);
		table.put("jnn", 10);
		table.put("ldd", 11);
		table.put("zer", 12);
		table.put("inc", 13);
		table.put("lda", 14);
	}
	
	public void assemble() throws IOException{
		readProgram();
		pass1();
		pass2();
		writeResult();
	}

	private void writeResult() throws IOException {
		if (! translateOK){
			return;
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("translated.txt"));
		for(String instruction: translated){
			writer.write(instruction);
			writer.newLine();
		}
		writer.close();
	}

	private void pass2() {
		if (! translateOK){
			return;
		}
		int instructionCounter = 0;
		for(int count = 0; count < program.size(); count+=2){
			String opcode = program.get(count);
			String operand = program.get(count + 1);
			if(opcode.equalsIgnoreCase("label")){
				continue; 
			}
			else{
				if(opcode.equalsIgnoreCase("double")){
					translated.add("		computer.loadData(" + operand + ", "+ instructionCounter + ");");
				}
				else{
					int value = 0;
					try{
						value = Integer.parseInt(operand);
						// don't process numeric operands yet
					}
					catch(Exception e){
						value = table.get(operand);
					}
					
					translated.add("		computer.loadInstruction(" + opcode + ", " + value + ");");
				}
				instructionCounter ++;

			}
		}
	}

	private void pass1() {
		Stack<String> toBeDefined = new Stack<String>();
		int instructionCounter = 0;
		for(int count = 0; count < program.size()-1; count+=2){
			String opcode = program.get(count);
			String operand = program.get(count + 1);
			if(opcode.equalsIgnoreCase("label")){
				table.put(operand, instructionCounter); 
			}
			else {
				instructionCounter++;
				if(opcode.equalsIgnoreCase("double")){
					continue;
				}
				try{
					int value = Integer.parseInt(operand);
					// don't process numeric operands yet
				}
				catch(Exception e){
					toBeDefined.push(operand);
				}
			}
		}
		while(!toBeDefined.isEmpty()){
			String value = toBeDefined.pop();
			if(table.get(value) == null){
				System.out.println("Label: " + value + " not defined.");
				translateOK = false;
			}
		}
	}

	private void readProgram() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("prog.txt"));
		while(scan.hasNext()){
			String next = scan.next();
//			System.out.println(next);
			program.add(next.trim());
		}
		
	}
	
	public static void main(String [] args) throws IOException{
		Assembler asmb = new Assembler();
		asmb.assemble();
	}
}
