package timsmodularalgo;
import java.util.Random;
import java.util.Scanner;

/**
 * Alternative algorithm for solving basic modular equalities
 * @author Tim Swyzen
 */
public class TimsModularAlgo {

    /**
     * 
     * @param a First number to check
     * @param b Second number to check
     * @return The Greatest Common Divisor of a and b
     */
    public static int gcd( int a, int b )
    {
        if ( b == 0 )
          return a;
        else
          return gcd( b, a % b );
    }
    
    /**
     * Proves that if GCD(a,c) != 1 then this does not work
     */
    public static void modularGCDTest()
    {
        Random rand = new Random();
        int a = 0;
        int b = 0;
        int c = 0;
        for( int j=0;j<500;j++ )
        {
            
            a = rand.nextInt( 100 );
            b = rand.nextInt( 100 );
            c = rand.nextInt( 100 );
            
            if ( gcd( a, c ) == 1 )
            {
               return ;
            }
            
            for( int i=0;i<50000;i++ )
            {
                if ( ( (b + i*c) % a ) == 0 )
                    System.out.println( "Found one" );
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Init
        Scanner scan = new Scanner( System.in );
        int a, b, c;
        
        //User input
        System.out.println( "Simple formula to solve for y is in format ay = b(mod c)" );
        System.out.println( "What is a?" );
        a = scan.nextInt();
        System.out.println( "What is b?" );
        b = scan.nextInt();
        System.out.println( "What is c?" );
        c = scan.nextInt();
        
        System.out.println( "Solving " + a + "y = " + b + "(mod " + c + ") for y:" );
        
        //GCD check
        if ( gcd( a, c ) != 1 )
        {
            System.out.println( "GCD of a and c is not 1, therefore this does not work. Exiting." );
            return;
        }
        
        int eff = 0;
        //Actual algorithm
        while( b%a != 0)
        {
            b += c;
            eff++;
        }
        int result = ( b / a ) % c;
        
        //Report result to user
        System.out.println( "y = " + result + "(mod " + c + ")" );
        System.out.println( "Efficiency O(n). This run's n was " + eff + "." );
        System.out.println( "Efficiency was determined by how many c's had to be added to b." );
    }
}
    
    
