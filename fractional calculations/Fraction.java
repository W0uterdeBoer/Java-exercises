
public class Fraction {
    final int numerator;
    final int denominator;
    public Fraction(int p, int q){
        numerator = p; /* "final"=final after constructor is finished */
        denominator = q;      
    };
    
    
    public double toDecimalNotation(){
        double decimal = (double) numerator/ (double) denominator;      
        return decimal;
    }
    
    
    public String toString(){
        String stringOfFraction = numerator + "/" + denominator;
        return stringOfFraction;
    }
    
    
    /*We can use the Class Fraction to make a new object Fraction. 
    The original ojbect has not meen adjusted*/
    
    
    /*We need this to reduce the fractions, If we need it on the inside we might
    *as well make it usible to the outside 
    */
    public Fraction reduce(){
        int reducedDenominator = this.denominator;
        int reducedNumerator = this.numerator;
        
        /* We need only check for divisibility up to half the number value */
        for(int i = 2; i <= reducedDenominator/2 & i <= reducedNumerator/2; i++){
            if(reducedDenominator % i == 0 & reducedNumerator % i == 0){
                reducedDenominator = reducedDenominator/i; /*Does the computer know this is an integer?*/
                reducedNumerator = reducedNumerator/i;
                i=1; /* Need to restart the Count in divisor is found (i++ is executed at the end of the for loop */
            }
        }
        
        /* Boundary case where one is divisible by the other */
        if(reducedDenominator % reducedNumerator == 0){
            reducedDenominator = reducedDenominator/reducedNumerator;
            reducedNumerator = 1;
        }
        if(reducedNumerator % reducedDenominator == 0){
            reducedNumerator = reducedNumerator/reducedDenominator;
            reducedDenominator = 1; 
        }
        
        if(reducedDenominator < 0){
            reducedNumerator = -reducedNumerator;
            reducedDenominator = -reducedDenominator;
        } 
        
        /*Java does this by itself:
        if(reducedDenominator == 0){
            throw new ArithmeticException("Error: Dividing by zero"); 
        }*/
        
        Fraction reducedFraction = new Fraction(reducedNumerator, reducedDenominator);
        return reducedFraction;
    };
    
    /* add ft. method overload */
    public Fraction add(int k){ 
        Fraction newFraction = new Fraction(numerator + k*denominator, denominator);
        return newFraction.reduce();
    }
    
    public Fraction add(Fraction addedFraction){        
        int newNumerator = numerator*addedFraction.denominator + denominator*addedFraction.numerator;
        int newDenominator = addedFraction.denominator*denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);  
        return newFraction.reduce();
    };
    
    
    /*subtract ft. method overload*/
    public Fraction subtract(int k){ 
        Fraction newFraction = new Fraction(numerator - k*denominator, denominator);
        return newFraction.reduce();
    }
    
    public Fraction subtract(Fraction subtractedFunction){        
        int newNumerator = numerator*subtractedFunction.denominator - denominator*subtractedFunction.numerator;
        int newDenominator = subtractedFunction.denominator*denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);  
        return newFraction.reduce();
    };
    
    
    /*Multiply*/
    public Fraction multiply(int k){
        Fraction newFraction= new Fraction(k*numerator, denominator);
    return newFraction.reduce();
    }
   
    public Fraction multiply(Fraction multipliedFraction){
        int newNumerator = numerator*multipliedFraction.numerator;
        int newDenominator = denominator*multipliedFraction.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);   
        return newFraction.reduce();
    };
    
    
    /*Divide*/
    public Fraction divide(int k){
        Fraction newFraction = new Fraction(numerator, denominator *k);   
        return newFraction.reduce();
    }
    
    public Fraction divide(Fraction dividedFraction){
        int newNumerator = numerator*dividedFraction.denominator;
        int newDenominator = denominator*dividedFraction.numerator;
         Fraction newFraction = new Fraction(newNumerator, newDenominator);   
        return newFraction.reduce();
    };
}
