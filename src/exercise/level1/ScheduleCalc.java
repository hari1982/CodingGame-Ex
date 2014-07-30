/**
 * @author HariBabu.T
 *
 *
 */
package exercise.level1;

//Read inputs from System.in, Write outputs to System.out.
//Your class name has to be Solution
/*
 * In the Computer2000 data center, you are responsible for planning the usage of a supercomputer for scientists.
 
 

​Therefore you've decided to organize things a bit by planning everybody’s tasks. The logic is simple: the higher the number of calculations which can be performed, the more people you can satisfy.
Scientists give you the starting day of their calculation and the number of consecutive days they need to reserve the calculator.
 
For example:
Calculation 	Starting Day 	Duration
A 	2 	5
B 	9 	7
C 	15 	6
D 	9 	3

    Calculation A starts on day 2 and ends on day 6
    Calculation B starts on day 9 and ends on day 15
    Calculation starts on day 15 and ends on day 20
    Calculation D starts on day 9 and ends on day 11

In this example, it’s not possible to carry out all the calculations because the periods for B and C overlap. 3 calculations maximum can be carried out: A, D and C. . 
 
INPUT:
Line 1: The number N of calculations
The N following lines: on each line, the starting day J and the duration D of reservation, separated by a blank space.
 
OUTPUT:
The maximum number of calculations that can be carried out.
 
CONSTRAINTS:
0 < N < 100000
0 < J < 1000000
0 < D < 1000
 
EXAMPLE :
Input
4
2 5
9 7
15 6
9 3
Output
3
 
 
Input
5
3 5
9 2
24 5
16 9
11 6
Output
4
 
Available RAM : 512MB
Timeout: 2 seconds

    The program has to read inputs from standard input
    The program has to write the solution to standard output
    The program must run in the test environment

 */
import java.util.*;
import java.io.*;
import java.math.*;

class ScheduleCalc {
	
	/*
	 * 	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	
		ArrayList<Integer> startDays = new ArrayList<Integer>();
		ArrayList<Integer> endDays = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
		    int startDay = in.nextInt();
			int duration = in.nextInt();
			int endDay = startDay+ duration -1;
			
			if(!(startDays.contains(startDay) || endDays.contains(startDay))){
			    if(!(endDays.contains(endDay) || startDays.contains(endDay))){
			        startDays.add(startDay);
			         endDays.add(endDay);
			    }
			}
			
		
	}
	
	System.out.println(startDays.size());
}
	 */

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Schedule> schedules = new ArrayList<Schedule>();
		for (int i = 0; i < n; i++) {
			int startDay = in.nextInt();
			int duration = in.nextInt();
			Schedule sch = new Schedule(startDay, duration);
			System.err.println("Schedule- st:" + startDay + ", Du: "+duration);
			schedules.add(sch);
		}
		updateCount(schedules);
		while(true){
		        int index = 0;
		        int overLapCount = 0;
		        int maxIndex = 0;
		        for(Schedule s : schedules){
		            int c = s.overLapCount;
		            if(c>overLapCount){
		                  overLapCount = c;
		                  maxIndex = index;
		            }
		            index=index+1;
		        }
		        System.err.println("overLapCount :" + overLapCount);
		        System.err.println("maxIndex :" + maxIndex);
		        if(overLapCount!=0){
		            schedules.remove(maxIndex);
		            updateCount(schedules);
		        }else{
		            break;
		        }
		}
		
		System.out.println(schedules.size());
	}
	
	public static void updateCount(ArrayList<Schedule> schs){
	    for(int i = 0; i <schs.size(); i++){
		    Schedule s = schs.get(i);
		    int fromIndex = i+1;
		    if(fromIndex>=schs.size())
		        fromIndex = i;
		    int count = overLapCount(schs.subList(fromIndex,schs.size()-1), s);
		    s.overLapCount = count;
		}
	}
	
	public static int overLapCount(List<Schedule> schs, Schedule sc){
	    int count = 0;
	    for(Schedule s:schs){
	        if(s.isOverLap(sc)) count++;
	    }
	    return count;
	}
	
}

class Schedule{
	    int startDay;
	    int duration;
	    int overLapCount = 0;
	    int endDay = 0;
	    Schedule(int st, int d){
	        this.startDay = st;
	        this.duration = d;
	        this.endDay = startDay + duration -1;
	    }
	    
	public boolean isOverLap(Schedule sc) {
		boolean retval = false;
		if(startDay==sc.startDay || startDay==sc.endDay){
	    	retval = true;
		}else if(endDay==sc.startDay || endDay==sc.endDay){
			retval = true;
		}else if (startDay >= sc.startDay && startDay <= sc.endDay) {
			retval = true;
		} else if (endDay>=sc.startDay && endDay <= sc.endDay) {
		retval = true;
		}
		return retval;
	}

	    public int[] dateRange(){
	        int[] range = new int[duration];
	        int index =0;
	        for(int i=0;i<duration; i++){
	            range[index] = startDay+i;
	            ++index;
	        }
	        return range;
	    }
	    
	}