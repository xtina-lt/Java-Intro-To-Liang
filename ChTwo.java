import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
class ChTwo{
    
    /***********************************************************
     *                       NUMBERS                           *
    ************************************************************/
    // NUMBERS: average = inut + input / count input
    static int average(List<Integer> e){
        int sum = 0;
        int count = 0;
        for (int i : e){
            sum += i;
            count ++;
        }
        return sum / count;
    }

    // NUMBERS: sum of digits
    static void sumOfDigs(int e){
        int sum = 0;
        int num = e;
        
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }

        System.out.println(sum);
    }


    /***********************************************************
     *                       GEOMETRY                          *
    ************************************************************/

    // GEOMETRY: area of a circle
    // area = radius * radius * Math.PI;
    static double area(double r){
        return r * r * Math.PI;
    }

    // GEOMETRY: volume of a cylinder
    static void cylinderVol(double r, double length){
        double area = r * r * Math.PI;
        double volume = area * length;
        System.out.printf("The VOLUME of a CYLINDER with the RADIUS of %.2f and LENGTH of %.2f is %.0f\n", r, length, volume);
    }

    // GEOMETRY: area of hexagon
    // area = (3 * sqrt(3) / 2) * side^2
    public static void areaOfHex(double s){
        double area = (3 * Math.sqrt(3) / 2) * Math.pow(s, 2);
        System.out.println("Area of a HEXAGON: " + area);
    }
    
    // GEOMETRY: distance of two points
    // (x1, y1) , (x2, y2)
    // Squrt((x2-x1)^2 + (y2-y1)^2)
    public static double getDistance(double x1, double y1, double x2, double y2){
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("Distance: " + distance);
        return distance;
    }

    // GEOMETRY: area of a triangle
    public static void areaTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        double s1 = getDistance(x1, y1, x2, y2);
        double s2 = getDistance(x2, y2, x3, y3);
        double s3 = getDistance(x3, y3, x1, y1);

        double s = (s1 + s2 + s3)  / 2;
        double area = Math.sqrt( s*(s-s1)*(s-s2)*(s-s3) );
        System.out.println("The area of the TRIANGLE is: " + area);
    }


    /***********************************************************
     *                   UNIT CONVERSION                       *
    ************************************************************/

    // UNIT CONVERSION: feet to meters
    // 1 foot = 0.305
    static void feetMeters(double f){
        double meters = f * 0.305;
        System.out.printf("%.2f FEET in METERS is %.2f\n", f, meters);
    }

    // UNIT CONVERSION: lb to kg
    // 1lb = 0.454 kg
    static void lbKg(double lb){
        double kg = lb * 0.454;
        System.out.println(lb + " lb = " + kg + " kg");
    }

    // UNIT CONVERSION: fahrenheight to ceslius
    static void fahrToCels(double f){
        double c = (5.0/9) * (f-32);
        System.out.printf("%.0f degrees Fahrenheit to Celsius is: %.2f degrees\n", f, c);
    }


    /***********************************************************
     *               FINANCIAL APPLICATION                      *
    ************************************************************/
    // FINANCIAL: calculate FUTURE INVESTMENT VALUE
    // fv = p * (1+mir) ^ (y * 12)
    public static void getFIV(double p, double air, int y){
        double mir = air / 1200;
        double fv = p * Math.pow((1 + mir), y * (double) 12);
        System.out.printf("FUTURE value: %.2f\n", fv);
    }

    // FINANCIAL: calculate INTEREST on next MONTHLY PAYMENT
    // mir = bal * (air / 1200)
    public static void getMIR(double bal, double air){
        double mir = bal * (air / 1200);
        System.out.printf("Monthly interest rate: %.2f\n", mir);
    }

    // FINANCIAL: compound value
    // savey $100 each month
    // annualIR 0.05%
    // monnthlyIR = 0.05 / 12 = =.00417 = 1 + 0.00417
    public static void compoundValue(double e){
        double bal = 0;
        double ir= 1.00417;

        for (int i = 0; i < 6; i++){
            System.out.printf("bal += (%.2f + %.3f) * %f\n", e, bal, ir);
            bal = (e + bal) * ir;
            System.out.printf("%.2f\n", bal);
        }
        System.out.printf("AMOUNT after 6 months: %.2f\n", bal);
    }

    // FINANCIAL: get sales tax amount
    static void salesTax(double e){
        double tax = 0.6;
        System.out.println( (int) (e * tax * 100) / 100.0 );
    }

    // FINANCIAL: monthly payment
    static void computeLoan(double ar, int y, double p){
        double mir = ar / 1200; //monthly interest rate = annual rate / 12 * 100
        double mp = p*mir / (1-1 / Math.pow(1+mir, y*12));
        System.out.println(mp);
    }

    // FINANCIAL: compute change
    static void computeChange(double e){
        int amount = (int) (e * 100);
        int dollars = amount / 100;
        amount %= 100;
        int quarters = amount / 25;
        amount %= 25;
        int dimes = amount / 10;
        amount %= 10;
        int nickels = amount / 5;
        amount %=5;
        int pennies = amount;

        System.out.printf("Input: %.2f\nChange Conversion: %d\nDollars: %d, Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d.\n", e, amount, dollars, quarters, dimes, nickels, pennies);
    }

    //  cost of driving
    public static void drivingCost(double d, double mpg, double cpg){
        double cost = (d / mpg) * cpg;
        System.out.printf("COST of your trip: %.2f\n", cost);
    }

    /***********************************************************
     *                        TIME                             *
    ************************************************************/
    // TIME: see future day of week
    static String playDate(int e){
        // DINOSAUR
        // Date today = new Date();
        // int x = today.getDay() + e;
        // String future = DayOfWeek.of( x ).toString();
        // return future;

        // CAVEMAN
        // LocalDateTime today = LocalDateTime.now();
        // int x = today.getDayOfWeek().getValue() + e;
        // return DayOfWeek.of(x).toString();

        // SUPERWOMAN
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tplus = today.plus(1, ChronoUnit.DAYS);
        return tplus.getDayOfWeek().toString();
    }

    // TIME: show current time 
    static void showCurrent(){
        // Date today = new Date();
        // long milliseconds = today.getTime(); // 1651773923837 IN GMT
        LocalTime now = LocalTime.now();
        int milliseconds = now.get(ChronoField.MILLI_OF_DAY);

        
        int seconds = milliseconds / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;

        int m = minutes % 60;
        int s = seconds % 60;
        int h = hours % 24; 

        System.out.println(LocalDateTime.now());
        System.out.printf("Time: %s, Milliseconds: %d\n", now.toString(), milliseconds);
        System.out.println(h + ": " + m + ": " + s );
    }

    static void minutesYears(int m){
        int hours = m / 60;
        int days = hours / 24;
        int years = days / 365;

        int d = days % 365;
        System.out.println(years);
        System.out.printf("Minutes: %d = %d years and %d days\n", m, years, d);
    }

    /***********************************************************
     *                      SCIENCE                            *
    ************************************************************/
    // SCIENCE: wind-chill temperature
    // measures coldness
    // ta = degrees fahrengheit
    // v = miles per hour
    // twc wind chill temp
    // cannot be used below 2mph || temp below -58f || temp above 41f
    // twc = 35.74 + 0.6215ta - 35.75v^0.16 + 0.4275ta(v^0.16)
    public static void windChill(double f, double v){
        double twc = (35.74 + 0.6215 * f) - (35.75 * Math.pow(v, 0.16)) + (0.4275 * f * Math.pow(v, 0.16));
        System.out.println("FEELS LIKE: " + twc);
    }

    //  SCIENCE: BMI
    // weight kg / height m^2
    public static void getBMI(double lbs, double in){
        double kg = lbs * 0.45359237;
        double m = in * 0.0254;
        double bmi = kg / Math.pow(m,2);

        System.out.println("BMI is: " + bmi);
    }

    // SCIENCE: population calc
    // 1 birth every 7 seconds
    // 1 death every 13 seconds
    // 1 death every 45 seconds
    static void population(int y){
        int population = 312032486;
        int seconds = 60 * 60 * 24 * 365;
        for (int i = 0; i < y; i++){
            population += seconds / 7;
            population -= seconds / 13;
            population += seconds / 45;
        }
        System.out.printf("Current Population: 31203248.\nPopulation in %d years: %d\n", y, population);
    }

    // SCIENCE: calculating energy neeeded to heat water
    // joules(energy) = weight in kng * (final temp - initial temp) * 4184
    // M is weight of water in kg
    static void calcEnergy(double kg, double t0, double t1){
        double j = kg * (t1 - t0) * 4148;
        System.out.printf("Water weight: %.2f, Initial Temp: %.2f, End Temp:%.2f\nNEEDED ENERGY: %.2f\n", kg, t0, t1, j);
    }

    /***********************************************************
     *                      PHYSICS                            *
    ************************************************************/
    // PHYSICS: finding runway length
    // give: plane's acceleration a meters/scndsquared, take-off speed v meters per second
    // find: min runway length neeeded
    // length = (v*v) / 2a
    static void runway(double v, double a){
        double length = Math.pow(v, 2) / (2 * a);
        System.out.printf("Velocity: %.2f, Acceleration: %.2f\nRUNWAY LENGTH: %.2f\n", v, a, length);
    }

    // PHYSICS: accelleration
    static void accelleration(double v0, double v1, double t){
        double accelleration = ( v1 - v0 ) / t;
        System.out.printf("%.2f - %.2f / %.2f = %2f\nThe ACCELERATION is: %.2f\n",v0, v1, t, accelleration, accelleration);
    }
    public static void main(String[] args){
        /***********************************************************
         *                       NUMBERS                           *
        ************************************************************/
        List<Integer> nums = new ArrayList<>( List.of(1,2,3) );
        System.out.println( average(nums) );
        sumOfDigs(999);

        /***********************************************************
         *                       GEOMETRY                          *
        ************************************************************/
        System.out.println( area(20) );
        cylinderVol(5.5, 12);
        areaOfHex(5.5);
        getDistance(1.5, -3.4, 4, 5);
        areaTriangle(1.5, -3.4, 4.6, 5, 9.5, -3.4);

        /***********************************************************
        *                   UNIT CONVERSION                       *
        ************************************************************/
        feetMeters(16.5);
        lbKg(55.5);
        fahrToCels(100.00);

        /***********************************************************
         *               FINANCIAL APPLICATION                      *
        ************************************************************/
        getFIV(1000.56, 4.25, 1);
        getMIR(1000, 3.5);
        compoundValue(100);
        salesTax(11.85) ;
        computeLoan(5.75, 15, 250000);
        computeChange(1.05);
        drivingCost(900.5, 25.5, 3.55);

    /***********************************************************
     *                        TIME                             *
    ************************************************************/
    System.out.println( playDate(1) );
    showCurrent();
    minutesYears(1000000000);

    /***********************************************************
     *                      SCIENCE                            *
    ************************************************************/
    windChill(5.3, 6);
    getBMI(95.5, 50);
    population(5);
    calcEnergy(55.5, 3.5, 10.5);

    /***********************************************************
     *                      PHYSICS                            *
    ************************************************************/
    runway(60, 3.5);
    accelleration(5.5, 50.9, 4.5);
    }
}