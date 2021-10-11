public class FractionalCalculation{
    public static void main(String[] args){
        Fraction myFractionOne = new Fraction(1,3);
         Fraction myFractionTwo = new Fraction(1, 2);
         
        System.out.println(myFractionOne.toDecimalNotation());
        System.out.println(myFractionOne.toString());
        
        System.out.println(myFractionOne.reduce());  
        System.out.println(myFractionTwo.reduce());  
        
        System.out.println(myFractionOne.add(1).toString());
         System.out.println(myFractionOne.add(myFractionTwo));
         
        System.out.println(myFractionOne.subtract(1).toString());
        System.out.println(myFractionOne.subtract(myFractionTwo).toString());
        
        System.out.println(myFractionOne.multiply(2).toString());
        System.out.println(myFractionOne.multiply(myFractionTwo).toString());
        
        System.out.println(myFractionOne.divide(2).toString());
        System.out.println(myFractionOne.divide(myFractionTwo).toString());
        
    
    }
}
