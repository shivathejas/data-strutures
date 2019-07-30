package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Arrays {
	  public static void main(String args[] ) throws Exception {
	     
		  Scanner scan = new Scanner(System.in);
		  System.out.println("enter n");
		  int n = scan.nextInt();
		  List<String> names = new ArrayList<>();
		  System.out.println("enter names");
		  int i=0;
		  while(i<n) {
			  String str = scan.next();
			  names.add(str);
			  i++;
		  }
		  Set<String> setOfNames = new TreeSet<>(names);
		  System.out.println(setOfNames);
		  Iterator iterate = setOfNames.iterator();
		  Set<String> newSet = new TreeSet<String>();
		  while(iterate.hasNext()) {
			  Object  obj= iterate.next();
			  newSet.add(obj+" "+Collections.frequency(names,obj));
		  }
		  Iterator it = newSet.iterator();
		  while(it.hasNext()){
		      System.out.println(it.next());
		  }
	  }
	  public static int frequency(Collection<?> c, Object o){
		    int result=0;
		    if( o == null){
		        for(Object e : c){
		            result++;
		        }
		    }else{
		        for(Object e:c){
		            if(o.equals(c)){
		                result++;
		            }
		        }
		    }
		    return result;
		}
}
