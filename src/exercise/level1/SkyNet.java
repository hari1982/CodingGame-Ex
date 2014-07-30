/**
 * @author HariBabu.T
 *
 *
 */
package exercise.level1;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Map.Entry;
/*
 * 
Line:...0......0....0........0..0..0..0.....
B1 Line:....0............000........0...0......
B2 Line:.....0..........000..........0.0.......
Line:...0......0....0........0..0..0..0.....
 */
class SkyNet {

	
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bykeCount = in.nextInt();
        int sCount = in.nextInt();
        // Read init information from standard input, if any
        int line =0;
        HashMap<Integer,char[]> linesMap = new HashMap<Integer,char[]>();
         
        while(line<4){
            String lineStr = in.next();
            System.err.println("Line:" + lineStr);
            char[] chars = new char[lineStr.length()-1]; 
            lineStr.getChars(0, lineStr.length()-1,chars,0);
            linesMap.put(line, chars);
            line++;
        }
        System.err.println("Lines:" + linesMap);
        int bykePos=0;
        while (true) {
            // Read information from standard input
            int speed = in.nextInt();
            //speed+=1;
            System.err.println("Speed " + speed);
           // boolean isSlow = false;
            for(int i=0; i<bykeCount;i++){
                bykePos = in.nextInt();
                System.err.println("Byke Pos" + bykePos);
                int bykeY = in.nextInt();
                 System.err.println("Byke Line" + bykeY);
                int isActive = in.nextInt();
                if(isActive==0 || i>0) 
                    continue;
                char[] curPath = linesMap.get(bykeY);
                char[] nextPath = null;
                char[] prevPath = null;
                System.err.println("New Pos" + bykePos);
                if(bykeY>0)
                   prevPath = linesMap.get(bykeY-1);
                if(bykeY<3)
                   nextPath = linesMap.get(bykeY+1);
                else
                    nextPath = null;
               // System.err.println("Next Path" +Arrays.toString(nextPath));
                if((bykePos+speed)>=curPath.length){
                        System.out.println("WAIT");
                        continue;
                }
                if(!checkPath(curPath,bykePos+speed)){
                    if(nextPath!=null && checkPath(nextPath,bykePos+speed)){
                        System.err.println("Next Path " +Arrays.toString(nextPath));
                        System.out.println("UP");
                    }else if(prevPath!=null && checkPath(prevPath,bykePos+speed)){
                        
                        System.out.println("DOWN");
                    }else{
                        System.out.println("WAIT");
                    }
                }else if(!checkPath(curPath,bykePos,speed)){
                        System.out.println("JUMP");
                }else if(!checkPath(curPath,bykePos+speed+1)){
                	
                   System.out.println("SLOW");
                }else{
                        int nextPos = (bykePos+speed)+(speed+1);
                        if(!(nextPos>curPath.length) && !checkPath(curPath,nextPos)){
                             nextPos = (bykePos+speed-1)+(speed-1);
                             if(!checkPath(curPath,nextPos))
                                System.out.println("WAIT");
                             else
                                System.out.println("SLOW");
                            
                        }else{    
                            System.out.println("SPEED");     
                        }
                }
                
            }
            
        }
    }
    
    public static boolean checkPath(char[] path , int pos){
        System.err.println("ePath Check: "+Arrays.toString(path));
        if(path!=null && path[pos] != '.'){
             System.err.println("ePath Value: "+path[pos]);
            return false;           
        }
          
        return true;
    }
     public static boolean checkPath(char[] path , int pos, int speed){
        if(path!=null){
            System.err.println("Path Check: "+Arrays.toString(path));     
            for(int i=1;i<=speed;i++){
                System.err.println("Path Value: "+path[pos+i]);     
                if(path[pos+i] != '.')
                    return false; 
            }           
        }
        return true;
    }
}