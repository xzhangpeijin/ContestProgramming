package contests.current;
import java.io.*;
import java.util.*;
import java.awt.geom.*;

/**
 * Solution to Burnout.
 * 
 * @author vanb
 */
public class burnout
{
    public Scanner sc;
    public PrintStream ps;
    
    // This will accumulate the total time elapsed.
    public long totaltime;
    
    // This will hold the amount of bulb-on time we've still got to cover.
    public long timeleft;
    
    // This is the total on time that must be covered.
    public long n;
    
    // This is for the judges, to make sure that cases don't violate
    // the specifications of the problem.
    public boolean success;
    
    /**
     * An element of a Pattern. It could be either a number or a repeating list.
     * 
     * @author vanb
     */
    public class Element
    {
        // Overall length of this element (one pass, not repeating)
        public long length=0;
        
        // The number of times it repeats
        public long repeat=1;
        
        // Time on IF the bulb is on entering this element (one pass, not repeating)
        public long timeon=0;
        
        // Time off IF the bulb is off entering this element (one pass, not repeating)
        public long timeoff=0;
        
        // Does this element exit with the bulb in the
        // opposite condition of when it entered?
        public boolean flip = false;
        
        // If this Element is a list, these are its subelements.
        public List<Element> subs = new LinkedList<Element>(); 
        
        /**
         * Total time the bulb is on, through all repeats, assuming it's 
         * on when entering this Element.
         * 
         * @return Total time on
         */
        public long totalTimeOn()
        {
            long result;
            
            // Does this element flip the bulb?
            if( flip )
            {
                // If so, then we alternate entering with
                // the bulb on, then off, then on, then off...
                
                // If we enter with the bulb on, then 'timeon'
                // is the time on. If we enter with the bulb off, 
                // then everything is reversed. Time on is 'timeoff', and
                // time off is 'timeon'
                
                // So, it's half-n-half. Let's first figure out how many
                // times we enter with the bulb off, and on.
                long off = repeat / 2;
                long on = repeat - off;
                
                // And then, this is the total time on.
                result = timeon * on + timeoff * off;
            }
            else
            {
                // If the bulb is on when we exit this Element
                // and repeat, the  it's much simpler. We don't
                // flip states.
                result = timeon * repeat;
            }
            return result;
        }
        
        /**
         * Total time the bulb is off, through all repeats, assuming it's 
         * on when entering this Element.
         * 
         * @return Total time off
         */
        public long totalTimeOff()
        {
            // It's just the total running time minus the total time on.
            return length*repeat - totalTimeOn();
        }
        
        /**
         * Compute the total time elapsed until the bulb has been on
         * for the correct amount of time.
         * 
         * The results are kept in the global variables 'timeleft' and 'totaltime'
         * 
         * @param starton Do we enter this element with the bulb on?
         */
        public void timeto( boolean starton )
        {
            if( timeleft>0 )
            {
                // It's a single number, not a list
                if( subs.size()==0 )
                {
                    // If it's on...
                    if( starton )
                    {
                        // Burn the bulb
                        long burn = Math.min( timeleft, timeon );
                        timeleft -= burn;
                        totaltime += burn;
                    }
                    else if( timeleft>0 )
                    {
                        // If it's not on, eat the time without burning the bulb.
                        totaltime += timeon;   
                    }
                }
                else
                {
                    // Figure out how many FULL repetitions it will take
                    long reps = 0;
                    if( flip )
                    {
                        // This is tricky.
                        // If this element flips the bulb, then 
                        // the time on changes. It flips back
                        // and forth between 'timeon' and 'timeoff'
                        //
                        // So, we've got to look at PAIRS of passes 
                        // through this element. In two consecutive
                        // passes, the total time on will be 'timeon' + 'timeoff',
                        // and that's just the length of the segment!
                        //
                        // So, 'reps' will be the number of repetitions
                        // of pairs of passes through this Element
                        reps = (timeleft>length) ? timeleft / length - 1 : 0;
                        reps = Math.min( reps, repeat/2 );
                        timeleft -= reps * length;
                        
                        // Now, adjust reps to be the actual number of repetitions.
                        reps += reps;
                        totaltime += reps * length;
                    }
                    else
                    {
                        // No flip? Then it's much more straightforward.
                        long increment = starton ? timeon : timeoff;
                        reps = (timeleft>increment) ? timeleft / increment - 1 : 0;
                        reps = Math.min( reps, repeat );
                        timeleft -= reps * increment;
                        totaltime += reps * length;
                    }
                    
                    // Now, for the remaining partial repetitions.
                    while( timeleft>0 && reps<repeat )
                    {
                        ++reps;
                        for( Element sub : subs )
                        {
                            sub.timeto( starton );
                            
                            // The bulb flips state only if the subelement flips
                            // the bulb, AND the subelement is repeated an odd number of times!
                            if( sub.flip && sub.repeat%2==1 ) starton = !starton;
                        }
                    }
                }
            }
        }
        

        
        /**
         * Print the pattern that an element was parsed from.
         * 
         * @return String version of the pattern
         */
        public String pattern()
        {
            String result;
            if( subs.size()==0 )
            {
                // No subs? Then it's just an integer.
                result = ""+timeon;
            }
            else
            {
                // Start the list
                result = "(";
                
                // Collect all of the subelements
                for( int i=0; i<subs.size(); i++ )
                {
                    result += (i==0?"":" ") + subs.get( i ).pattern();
                }
                
                // End the list
                result += ")*" + repeat;
            }
            
            return result;
        }
    }
    
    // This is all about the parsing.
    // p is a pointer into the input line of characters
    public int p;
    
    // This is the input line of characters of the pattern
    public char line[];
    
    /**
     * Parse an integer from the input line.
     * 
     * @return Parsed integer
     */
    public int getInteger()
    {
        int value = 0;
        while( Character.isDigit( line[p] ) )
        {
            value *= 10;
            value += (int)(line[p]-'0');
            ++p;
        }
        
        return value;
    }
    
    /**
     * Parse a list from the input pattern.
     * 
     * @return An Element containing the list.
     */
    public Element parseList()
    {
        // Create a new element to hold this list
        Element element = new Element();
        element.repeat = 1;
        
        // Is the bulb on?
        boolean on = true;
        
        for(;;)
        {
            // End of line. 
            if( line[p]=='$' ) 
            {
                // This is a bit tricky.
                // We'll only get here at the end of the outermost list.
                // 2n is way more than we'll need.
                element.repeat = n+n; 
                
                // If the bulb isn't on at the end of the Element, 
                // then the Element flips the bulb.
                element.flip = !on;
                break;
            }
            else if( line[p]=='(' )
            {
                // This is the start of a sublist
                ++p;
                
                // Parse off the sublist
                Element sublist = parseList();
                element.subs.add( sublist );
                
                // Add the length of the sublist to this element
                element.length += sublist.length * sublist.repeat;
                
                // Grab time on & time off. 
                // Remember that if we enter with the bulb off,
                // everything reverses.
                if( on )
                {
                    element.timeon += sublist.totalTimeOn();
                    element.timeoff += sublist.totalTimeOff();
                }
                else
                {
                    element.timeon += sublist.totalTimeOff();
                    element.timeoff += sublist.totalTimeOn();
                }
                
                // This is a bit tricky, too.
                // If the sublist flips the bulb AND it's repeated an odd
                // number of times, then the bulb ends up flipped after
                // all repeats.
                if( sublist.flip && sublist.repeat%2==1 ) on=!on;                
            }
            else if( line[p]==')' )
            {
                // This is the end of this list.
                ++p; // should now be at the '*'
                if( line[p]!='*' ) System.err.println( "Syntax error at " + p + " of " + new String(line) );
                ++p;
                
                // Parse off the repeat number
                element.repeat = getInteger();
                
                if( element.repeat > 100 ) System.err.println( "PANIC!! Repeat>100" );
                
                // Did we flip the bulb?
                element.flip = !on;
                break;
            }
            else if( Character.isDigit( line[p] ) )
            {
                // This is a number.
                int value = getInteger();
                if( value > 1000000 ) System.err.println( "PANIC!! Repeat>100" );
                
                // Create a new Element for this number
                Element number = new Element();
                number.length = value;
                number.repeat = 1;
                number.timeon = value;
                number.timeoff = 0;
                number.flip = true;
                
                // Add it to the list
                element.subs.add( number );
                element.length += number.length;
                
                // See how it affects timeon/timeoff for this list 
                if( on )
                {
                    element.timeon += value;
                }
                else
                {
                    element.timeoff += value;
                }
                
                // Numbers always flip the bulb
                on = !on;
            }
            else if( line[p]==' ' )
            {
                // Move right on past spaces
                ++p;
            }
            else
            {
                System.err.println( "PANIC!! Wasn't expecting " + line[p] + " at char " + p + " of " + new String(line) );
                ++p;
            }            
        }
        
        // For the judges, check a constraint.
        if( element.length > 1000000000 / element.repeat )
        {
            success = false;
        }
        
        return element;
    }
    
    /**
     * Driver.
     * @throws Exception
     */
    public void doit() throws Exception
    {
        sc = new Scanner( new File( "burnout.judge" ) );
        ps = System.out; //new PrintStream( new FileOutputStream( "burnout.solution" ) ); 
        
        for(;;)
        {
            n = sc.nextInt();
            if( n==0 ) break;
            
            // Read the pattern, stick a '$' on the end, and parse it
            sc.nextLine();
            String pattern = sc.nextLine() + "$";
            line = pattern.toCharArray();
            p = 0;
            Element element = parseList();
            
            // Starting condition - Time left to cover is n, and our total time is 0.
            timeleft = n;
            totaltime = 0;
            
            // Do it! (Start with the bulb on)
            element.timeto( true );
            
            // Show the result.
            ps.println( totaltime );
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) throws Exception
    {
        new burnout().doit();
    }
}