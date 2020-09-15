
package framework;


public class Helper {
    
public static String getRandomUsername(){
    return "Ana-" + getRandomInteger();
} 

private static int getRandomInteger(){
   return(int) (Math.random()* 1000);
}
   
}
