package exercise.level1;
import java.util.*;
/*
 * 
In stations and airports you often see this type of screen. Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? We have: with ASCII art!
 
ASCII art allows you to represent forms by using characters. To be precise, in our case, these forms are words. For example, the word "MANHATTAN" could be displayed as follows in ASCII art:
# #  #  ### # #  #  ### ###  #  ###
### # # # # # # # #  #   #  # # # #
### ### # # ### ###  #   #  ### # #
# # # # # # # # # #  #   #  # # # #
# # # # # # # # # #  #   #  # # # #

​Your mission is to write a program that can display a line of text in ASCII art.

INPUT:
Line 1: the width L of a letter represented in ASCII art. All letters are the same width.
Line 2: the height H of a letter represented in ASCII art. All letters are the same height.
Line 3: The line of text T, composed of N ASCII characters.
Following Lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
 
OUTPUT:
The text T in ASCII art.
The characters a to z are shown in ASCII art by their equivalent in upper case.
The characters which are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
 */
public class AsciiArt {
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			int w = in.nextInt();
			int h = in.nextInt();
			String word = in.next();
			
			char[] chrs = new char[word.length()];
			word.getChars(0, word.length(),chrs, 0);
			
			String[] chLines = new String[h];
		    Scanner s = in.useDelimiter("\\n");
		    for(int j=0;j<h;j++){
		        chLines[j] = s.next();
		        System.err.println("Line:" +(j +1)+ chLines[j]  );
		        
		    }
			//if (in.hasNext()) {
			//    System.err.println(in.nextLine());
			    
			    /*char[] line = new char[27*w];
			    for(int k=0;k<line.length;k++){
			        line[k] = in.next().toCharArray()[0];
			        //System.err.println(line.length);
			    }
			    System.err.println("Line: " + Arrays.toString(line));
			    chLines[j] = new String(line);
			    j++;
			    */
			//}
			String[] out = null;
			int j = 0;
			for(char c: chrs){
			    j=0;
			    String[] st = getChar(c,chLines,w);
			    if(out==null)
			        out = st;
			    else{
			        for(String i : st){
			            out[j] += i; 
			            j++;
			        }
			    }
			    
			}
			for(String o : out){
			        System.out.println(o);
			}
		}
		
		public static String[] getChar(int charector,String[] chLines, int w){
		    int startIndex = 65;
		    int charIndex = 26;
		    if(charector>=65 && charector<=90){
		        startIndex = 65;
		        charIndex = charector - startIndex;
		    }else if(charector>=97 && charector<=122){
		        startIndex = 97;
		        charIndex = charector - startIndex;
		    }
		    System.err.println("Char= " + charector);
		    String[] ch = new String[chLines.length];
		    /*
		    int charIndex = charector - startIndex
		    if(charector == '?'){
		        charIndex = 26*w +1;
		    }
		    */
		    System.err.println("Char Start: " + charIndex);
		    int h =0 ;
		    for(String i : chLines){
		        int srcStart = (charIndex*w);
		        int srcEnd = (charIndex*w) + w;
		        System.err.println("Start: " + srcStart);
		        System.err.println("End: " + srcEnd);
		        if(srcEnd>i.length()) srcEnd = i.length() -1;
		        ch[h] = i.substring(srcStart,srcEnd);
		        h++;
		    }
		    return ch;
		}
	
}
/*
  
Samples
  
Sample1
Input:-
4
5
E
 #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### 
# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # 
### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## 
# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       
# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  
Output:-
### 
#   
##  
#   
### 
Sample2:-
4
5
MANHATTAN
 #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ### 
# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   # 
### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ## 
# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #       
# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  
OutPut:-
# #  #  ### # #  #  ### ###  #  ### 
### # # # # # # # #  #   #  # # # # 
### ### # # ### ###  #   #  ### # # 
# # # # # # # # # #  #   #  # # # # 
# # # # # # # # # #  #   #  # # # # 

 * 
 * 
 * */
