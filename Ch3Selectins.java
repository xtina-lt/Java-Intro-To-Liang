import java.time.LocalDate;
import java.util.*;
import java.awt.*;

class Ch3Selections{
    /***********************************************************
    *                       TERNARY                            *
    ************************************************************/
    public static void ternary() {
        // IF ELSE
        boolean foo = true;
        System.out.println( (foo) ? "True" : "False" );

        // IF ELSEIF ELSE
        int e = 5;
        System.out.println( (e==1) ? "Great ONE!" : (e==2) ? "Be true to TWO" : "Searching..." );
        
    }

    public static void guess(){
        int num = 15;
        int guess = 15;
        // int guess = 5;
        System.out.println( (num == guess) ? "CORRECT" : "BOOO INCORRECT" );
    }


    /***********************************************************
     *                       NUMBERS                           *
    ************************************************************/
    public static void exclusiveOr() {
        //int num1 = 15;
        int num1 = 5;
        // String result = (num % 3 == 0 ^ num % 5 == 0) ? "One or other, but not both" : "errr wrong";
        String result = (num1 % 3 == 0 ^ num1 % 5 == 0) ? "One or other, but not both" : "errr wrong";
        System.out.println(result);
    }

    public static void isLeapYear(){
        int check = 2024;

        // is it divisible by 4?
        if (check % 4 == 0) System.out.println("Pass first");
        // is it divisible by 4 but not 100?
        if (check % 4 == 0 && check % 100 != 0) System.out.println("Pass Second");
        // not divisble by 400?
        if ( (check % 4 == 0 && check % 100 != 0) && (check %400 != 0) ) System.out.println("Pass third. IS LEAP YEAR!");
    }

    public static void increase(){
        int[] arr = {5,4,3};
        int temp = 0;

        for (int i = 0; i <arr.length; i++) {     
            for (int j = i+1; j <arr.length; j++) {     
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j]; // put the first as lowest 
                    temp = arr[i];   // hold the higher number 
                    arr[j] = temp;   // put the last as old temp 
                }     
            }     
        }  

        for (int i : arr) System.out.println(i);
    }

    public static void lottery(){
        int guess = 159;
        // int lotto = 951;
        // int lotto = 934;
        // int lotto = 234;
        int lotto = (int) (Math.random() * 1000);


        int g0 = guess / 100;
        int g1 = guess % 100 / 10;
        int g2 = guess % 100 % 10;

        int l0 = lotto / 100;
        int l1 = lotto % 100 / 10;
        int l2 = lotto % 100 % 10;

        // two digits
        // if (guess == lotto) {
        //     System.out.println("EXACT MATCH: WIN $10,000.");
        // } else if(g1 == l0 && g0 == l1) {
        //     System.out.println("Math all digits: Win %5,000.");
        // } else if (g0 == l0 || g1 == l0 || g0 == l1 || g1 == l1){
        //     System.out.println("Math one digit: Win %1,000.");
        // } else {
        //     System.out.println("You loose!!");
        // }

        System.out.println("Lotto number: " + lotto);
        System.out.println("Guess number: " + guess);
        if (guess == lotto){
            System.out.println("EXACT MATCH: WIN $10,000.");
        } else if ( (g0 == l0 || g0 == l1 || g0 == l2) &&
        			(g1 == l0 || g1 == l1 || g1 == l2) &&
        			(g2 == l0 || g2 == l1 || g2 == l2) ) {
            System.out.println("Match all digits: Win %5,000.");
        } else if ((g0 == l0 || g0 == l1 || g0 == l2) ||
                    (g1 == l0 || g1 == l1 || g1 == l2) ||
                    (g2 == l0 || g2 == l1 || g2 == l2)) {
            System.out.println("Match one digit: Win %1,000.");
        } else {
            System.out.println("No winner :(");
        }
    }


    public static void getIBSN() { 
        int ibsn = 513601267;
        int d1 = ibsn / 100000000;
        int d2 = (ibsn % 100000000) / 10000000;
        int d3 = (ibsn % 10000000) / 1000000;
        int d4 = (ibsn % 1000000) / 100000;
        int d5 = (ibsn % 100000) / 10000;
        int d6 = (ibsn % 10000) / 1000;
        int d7 = (ibsn % 1000) / 100;
        int d8 = (ibsn % 100) / 10;
        int d9 = (ibsn % 10);

        int checksum = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7
        + d8 * 8 + d9 * 9) % 11;
        System.out.println((checksum == 10) ? 'X': checksum) ;
    }

    public static void checkSub(){}
    public static void subtractionQuiz(){
        int num0 = (int) (Math.random() * 10);
        int num1 = (int) (Math.random() * 10);
        int count = 0;

        if (num0 < num1){
            int temp = num0;
            num0 = num1;
            num1 = temp;
        }

        System.out.println("****************************");
        System.out.println("Let's try to subtract :)");
        System.out.printf("%d - %d:\n", num0, num1);
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        count++;

        while ( (num0 - num1 != answer) && (count < 3) ) {
            count++;

            System.out.println("****************************");
            System.out.println("Tries: " + count);
            System.out.printf("LET'S TRY AGAIN!\n%d - %d:\n", num0, num1);
            answer = input.nextInt();

            System.out.println("The right answer is: " + (num0-num1)); 
        }

        System.out.println("****************************");
        System.out.printf("Correct answer! \nOnly took %d tries!", count);
        input.close();
        
    }

    public static void palindrome(){
        int e = 353;
        ///int e = 3153;
        String str = Integer.toString(e);
        int strLen = str.length();
        boolean isPalindrome = false;

        for (int i=0; i < strLen / 2; i++ ){
            isPalindrome  = (str.charAt(i) != str.charAt(strLen - i - 1)) ? false : true;
        }

        System.out.println( (isPalindrome) ? "Yay we found a PALINDROME!!" : "Houston we have a problem"  );
    }

    public static void headsTails(){
        // get guess
        int guess = 1;
        // int guess = 0;

        // get face value, 0 == heads 1 = tails
        String face = (guess == 0) ? "heads" : "tails";

        // generate random number 0 or 1
        int gen = (int) (Math.random() * 2);
        
        // check
        System.out.println(guess + " vs " + gen);
        System.out.println( (guess == gen) ? "Guessed CORRECT: " + face : "ERRRR WRONG" ); 
    }

    public static String getRPS(int e){
        String result = "";
        switch (e) {
            case 0: result = "scissor"; break;
            case 1 : result = "rock"; break;
            case 2 : result = "paper"; break;
        }
        return result;
    }
    public static void rockPaperScissors() {
        int user = 2;
        int comp = (int) (Math.random() * 3);
        
        String u = getRPS(user);
        String c = getRPS(comp);

        String winner = "";

        if (c == u){
            winner = "tie";
        } else {
            switch (u){
                case "scissor": 
                    winner = (c == "paper") ? "user" : "computer";
                    break;
                case "rock":
                    winner = (c == "scissor") ? "user" : "computer";
                    break;
                case "paper":
                    winner = (c == "rock") ? "user" : "computer";
                    break;
            }
        }

        System.out.printf("User: %s , Computer: %s\n", u, c);
        System.out.println("Winner: " + winner.toUpperCase());
    }

    public static void cardPick() {
        int card = new Random().nextInt(1, 14);
        System.out.println(card);
        String name = "";
        String face = "";

        switch (card){
            case 1:  name = "ace"; break;
            case 2:  name = "two"; break;
            case 3:  name = "three"; break;
            case 4:  name = "four"; break;
            case 5:  name = "five"; break;
            case 6:  name = "six"; break;
            case 7:  name = "seven"; break;
            case 8:  name = "eight"; break;
            case 9:  name = "nine"; break;
            case 10:  name = "ten"; break;
            case 11: name = "jack"; break;
            case 12: name = "queen"; break;
            case 13: name = "king"; break;
        }

        int f = (int) (Math.random() * 4);
        switch (f){
            case 0: face="clubs"; break;
            case 1: face="diamonds"; break;
            case 2: face="hearts"; break;
            case 3: face="spades"; break;
        }

        System.out.printf("Random card:\n%s %s", name.toUpperCase(), face.toUpperCase());
    }

    public static void fizzbuzz(){
        int e = 30;
        // int e = 2;
        String result = ""; 

        if ( (e % 6 == 0) && (e % 5==0) ){
            result = "fizzbuzz";
        } else if (e % 5==0) {
            result = "fizz";
        } else if (e % 6 == 0) {
            result = "buzz";
        } else {
            result = Integer.toString(e);
        }

        System.out.println(result.toUpperCase());
    }

    /***********************************************************
     *                       ALGEBRA                           *
    ************************************************************/
    public static void quadratic(double a, double b, double c){
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        System.out.println(discriminant);

        double r1 = ( -b + Math.sqrt( Math.pow(b, 2) - (4*a*c) ) ) / (2 * a);
        double r2 = ( -b - Math.sqrt( Math.pow(b, 2) - (4*a*c) ) ) / (2 * a);

        if (discriminant > 0) {
            System.out.println("POSITIVE DISCRIMINANT");
            System.out.printf("Two roots:\n1) %.2f\n2) %.2f\n", r1, r2);
        } else if (discriminant == 0) {
            System.out.println("ZERO DISCRIMINANT");
            System.out.printf("One root:\n1) %.2f\n", r1);
        } else {
            System.out.println("NEGATIVE DISCRIMINANT");
            System.out.println("No real roots");
        }
    }

    public static String cramers(double a, double b, double c, double d, double e, double f){
        
        if (a*d - b*c == 0) return "NO SOLUTIONS DUDE!";
        
        double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
        double y = ((a * f) - (e * c)) / ((a * d) - (b * c));

        return String.format("The solutions are %.2f and %.2f\n", x, y);
    }

    // /***********************************************************
    //  *                       GEOMETRY                           *
    // ************************************************************/
    
    // triangle is valid if sum of two sides is greater than third side
    public static void getPerimeter() {
        // int a = -5;
        // int b = -5;
        // int c = -5;
        int a = 5;
        int b = 5;
        int c = 5;
        
        System.out.println( ( (b + c > a) || ( a + c > b) || (b + c > c) ) ? "Sum of two sides are greater than third!\nValid Permater:\n" + (a + b + c) : "Not Valid Triangle" );
    }

    public static void circlePoint(){
        int x0 = 4;
        int y0 = 5;
        // int x0 = 9;
        // int y0 = 9;

        int x1= 0;
        int y1 = 0;
        int radius = 10;

        double distance = Math.sqrt( Math.pow((x1-x0), 2) + Math.pow((y1-y0),2) );

        System.out.println( (distance <= radius) ? "Is a point within the cirle" : "Not in the cirle" );
    }

    public static void rectanglePoint(){
        // int x0 = 6;
        // int y0 = 4;
        int x0 = 2;
        int y0 = 2;

        // int x1= 0;
        // int y1 = 0;
        int width = 10;
        int height = 5;
        Rectangle x = new Rectangle(width,height);

        System.out.println( (x.contains(x0, y0)) ? "Woohoo found point!" : "Sorry not in the rectangle.." );
    }

    // CRAMERS RULE
    // ax + by = e		x = ed - bf) / (ad - bc
	// cx + dy = f		y = af - ec / ad - bc
	// (y1 - y2)x - (x1 -x2)y = (y1 - y2)x1 - (x1 - x2)y1
	// (y3 - y4)x - (x3 -x4)y = (y3 - y4)x3 - (x3 - x4)y3
    public static void cramersRule(){
        double x1 = 2;
        double y1 = 2; 
        
        double x2 = 5;
        double y2 = -1; 

        double x3 = 4; 
        double y3 = 2;

        double x4 = -1; 
        double y4 = -2;

        double a = y1 - y2; 
        double b = x1 - x2;
        double c = y3 - y4; 
        double d = x3 - x4;

        double e = (a * x1) - (b * y1); 
        double f = (c * x3) - (d * y3); 

        double line0 = (e * d - b * f) / (a * d - b * c);
        double line1 = (a * f - e * c) /(a * d - b * c);

        System.out.println( ((line0 - line1) != 0 ) ? "Intersecting line: " + line0 + ", " + line1 : "The two lines are parrellel!" );
    }

    public static double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3){
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
    public static void triangePoint() {
        double x = 100.5;
        double y = 25.5;

        double x1 = 200;
        double y1 = 0;

        double x2 = 0;
        double y2 = 100;

        double x3 = 0;
        double y3 = 0;

        double abc = triangleArea(x1, y1, x2, y2, x3, y3);
        double pbc = triangleArea(x, y, x2, y2, x3, y3);
        double pac = triangleArea(x1, y1, x, y, x3, y3);
        double pab = triangleArea(x1, y1, x2, y2, x, y);

        System.out.println( (abc == (pbc + pac + pab) ) ? "We are in the triad!" : "Houston we have a problem!");
    }

    public static void rectangleOverlap() {
        // double x1 = 2.5;
        // double y1 = 4;
        // double w1 = 2.5;
        // double h1 = 43;

        // double x2 = 1.5;
        // double y2 = 5.0;
        // double w2 = 0.5;
        // double h2 = 3;

        double x1 = 1;
        double y1 = 2;
        double w1 = 3;
        double h1 = 5.5;

        double x2 = 3;
        double y2 = 4;
        double w2 = 4.5;
        double h2 = 5;

        double r1left = x1 - w1 / 2;
        double r1right = x1 + w1 / 2;
        double r1bottom = y1 - h1 / 2;
        double r1top = y1 + h1 / 2;

        double r2left = x2 - w2 / 2;
        double r2right = x2 + w2 / 2;
        double r2bottom = y2 - h2 / 2;
        double r2top = y2 + h2 / 2;

        // if ( r2left >= r1left && r2right <= r1right &&
        //     r2bottom >= r1bottom && r2top <= r1top ){
        //         System.out.println("Second is in First");
        // } else if (r2left >= r2left || r2right <= r2right ||
        //     r2bottom >= r1bottom || r2top <= r1top) {
        //         System.out.println("Second overlaps first");
        // } else {
        //     System.out.println("Houston we have a problem");
        // }

        System.out.println( (r2left >= r1left && r2right <= r1right && r2bottom >= r1bottom && r2top <= r1top) ? "Second is in First"
        : (r2left >= r2left || r2right <= r2right || r2bottom >= r1bottom || r2top <= r1top) ? "Second overlaps first"
        : "Houston we have a problem");

    }

    public static void circleOverlap() {
        // double x1 = 0.5;
        // double y1 = 5.1;
        // double r1 = 13;

        // double x2 = 1;
        // double y2 = 1.7;
        // double r2 = 4.5;

        // double x1 = 3.4;
        // double y1 = 5.7;
        // double r1 = 5.5;

        // double x2 = 6.7;
        // double y2 = 3.5;
        // double r2 = 3;

        double x1 = 3.4;
        double y1 = 5.5;
        double r1 = 1;

        double x2 = 5.5;
        double y2 = 7.2;
        double r2 = 1;

        // distance between centeres
        double c1c2 = Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));

        // if (c1c2 <= Math.abs(r1 - r2)){
        //     System.out.println("Found me! I am inside!");
        // } else if ( c1c2 <= r1 + r2) {
        //     System.out.println("I overlap!");
        // } else {
        //     System.out.println("Can't touch this! Dun nu nu na!");
        // }

        System.out.println( (c1c2 <= Math.abs(r1 - r2)) ? "Found me! I am inside!" : ( c1c2 <= r1 + r2) ?  "I overlap!" : "Can't touch this! Dun nu nu na!");
    }

    public static void pointPosition() {
        // ****************
        // double x0 = 4.4;
        // double y0 = 2;

        // double x1 = 6.5;
        // double y1 = 9.5;
        
        // double x2 = -5;
        // double y2 = 4;

        // ****************
        // double x0 = 1;
        // double y0 = 1;
        
        // double x1 = 5;
        // double y1 = 5;
        
        // double x2 = 2;
        // double y2 = 2;

        // ****************
        double x0 = 3.4;
        double y0 = 2;

        double x1 = 6.5;
        double y1 = 9.5;
        
        double x2 = 5;
        double y2 = 2.5;

        double result = (x1 - x0) * (y2-y0) - (x2-x0) * (y1 - y0);
        System.out.println( (result > 0) ? "left side" : (result==0) ? "same line" : "right side" );

    }


    /***********************************************************
     *                       DATETIME                          *
    ************************************************************/

    // GETS SEASON FROM DATE
    public static String getSeason(){
        // initalize date
        LocalDate now  = LocalDate.now();
        // get month value
        int monthVal = now.getMonthValue();
        if (monthVal > 2 && monthVal < 6){
            return "Spring";
        } else if ( monthVal > 5 && monthVal < 9){
            return "Summer";
        } else if ( monthVal > 8 && monthVal < 12) {
            return "Autumn";
        } else {
            return "Winter";
        }
    }

    // GETS CHINEASE ZODIAC FOR YEAR
    public static void ChineaseZodiac(){
        // initialize and get year in one
        int year = LocalDate.now().getYear();
        // int year = 1963; // rabbit
        String sign = "";

        switch (year % 12) {
            case 0: sign = "Monkey"; break;
            case 1: sign = "Rooseter"; break;
            case 2: sign = "Dog"; break;
            case 3: sign = "Pig"; break;
            case 4: sign = "Rat"; break;
            case 5: sign = "Ox"; break;
            case 6: sign = "Tiger"; break;
            case 7: sign = "Rabbit"; break;
            case 8: sign = "Dragon"; break;
            case 9: sign = "Snake"; break;
            case 10: sign = "Horse"; break;
            case 11: sign = "Sheep"; break;
        }

        System.out.println("The Chinease Zodiac Sign is: " + sign.toUpperCase());
    }

    // GETS DAYS IN MONTH
    public static void daysCount(){
        int year = 2022;
        int month = 1;

        LocalDate e = LocalDate.of(year, month, 01);
        System.out.print( "Days in selected month: " + e.lengthOfMonth() );
    }

    /***********************************************************
     *                       SCIENCE                         *
    ************************************************************/
        //  SCIENCE: BMI
    // weight kg / height m^2
    public static void getBMI(double lbs, double in){
        double kg = lbs * 0.45359237;
        double m = in * 0.0254;
        String result = "";

        double bmi = kg / Math.pow(m,2);
        if ( bmi < 18.5 ) {
            result = "Eat some more!";
        } else if ( bmi < 25 ) {
            result = "Keep doing what you're doing!";
        } else {
            result = "Lets work on portions....";
        }

        System.out.printf("You're current BMI: %.2f\n%s", bmi, result);
        
    }

    // SCIENCE: wind-chill temperature
    // measures coldness
    // ta = degrees fahrengheit
    // v = miles per hour
    // twc wind chill temp
    // cannot be used below 2mph || temp below -58f || temp above 41f
    // twc = 35.74 + 0.6215ta - 35.75v^0.16 + 0.4275ta(v^0.16)
    public static void windChill(double f, double v){
        if (v < 2 || f < -58 || f > 41){
            System.out.println("Invalid entry :(");
            System.out.println( (v < 2) ? "Error: Velocity" : "Error: Fahrenheight" );
        } else {
            double twc = (35.74 + 0.6215 * f) - (35.75 * Math.pow(v, 0.16)) + (0.4275 * f * Math.pow(v, 0.16));
            System.out.println("FEELS LIKE: " + twc);
        }
    }

    // SCIENCE: day of the week
    // h : day of the week
    // q : day of the month
    // m : month
    // 1: 3: March, 4: aprl, 12: Dec, 13: Jan 14: Feb
    // j : century
    // k : year
    public static void dayOfWeek(double k, double m, double q) {
        if (q==1) q=13;
        if (q==2) q=14;
        double j = k / 100;

        int h = (int) ( q + ((26 * (m+1))/10) + k + (k/4) + (j/4) + (5*j) ) % 7;
        
        String day = "";
        switch(h){
            case 0: day="Saturday" ; break;
            case 1: day="Sunday" ; break;
            case 2: day="Monday" ; break;
            case 3: day="Tuesday" ; break;
            case 4: day="Wedneday" ; break;
            case 5: day="Thursday" ; break;
            case 6: day="Friday" ; break;
            case 7: day="Saturday" ; break;
        }

        System.out.println(day);
    }

    /***********************************************************
     *               FINANCIAL APPLICATION                      *
    ************************************************************/
    static void computeChange(double e){
        int amount = (int) (e * 100);

        int dollars = amount / 100;
        if (dollars > 0) System.out.println("Dollars: " + dollars);
        amount %= 100;

        int quarters = amount / 25;
        if (quarters > 0) System.out.println("Quarters: " + quarters);
        amount %= 25;

        int dimes = amount / 10;
        if (dimes > 0) System.out.println("Dimes: " + dimes);
        amount %= 10;

        int nickels = amount / 5;
        if (nickels > 0) System.out.println("Nickels: " + nickels);
        amount %=5;

        int pennies = amount;
        if (pennies > 0) System.out.println("Pennies: " + pennies);
    }

    static void shipping(){
        int weight = (int) (Math.random() * 52);
        double cost = 0.0;
        
        if(weight > 50){
            System.out.println("Weight: " + weight);
            System.out.println("Cannot be shipped :(");
        } else {
            if (weight <= 1){
                cost = 3.5;
            } else if (weight <= 3){
                cost = 5.5;
            } else  if(weight <= 10){
                cost = 8.5;
            } else if (weight <= 20){
                cost = 10.5;
            } else {
                cost = 20.0;
            }
            System.out.println("Weight: " + weight);
            System.out.printf("Cost: $%.2f", cost);
        }
    }

    // USD to Chinease RMB
    public static void currencyExchange(){
        // 0 (usd -> rmb) or 1 (rmb to usd)
        int currency = 1;
        double amount = 5;
        double rate = 6.80;

        // usd is amount * exchange rate | rmb is amount / exchange rate
        System.out.println( (currency == 0) ? amount * rate : amount / rate);
    }

    public static void compareCost(double lbs0, double p0, double lbs1, double p1){
        double result0 = p0 / lbs0;
        double result1 = p1 / lbs1;

        System.out.println( (result0 == result1) ? "WE HAVE A TIE! BUY THEM BOTH" : (result0 < result1) ? "FIRST item is cheaper" : "Superior SECOND" );
    }

    public static void main(String[] args) {
        // /***********************************************************
        //  *                       TERNARY                           *
        // ************************************************************/
        // ternary();


        // /***********************************************************
        //  *                       NUMBERS                           *
        // ************************************************************/
        // exclusiveOr();
        // isLeapYear();
        // lottery();
        // guess();
        // increase();
        // getIBSN();
        // subtractionQuiz();
        // palindrome();
        // headsTails();
        // rockPaperScissors();
        // cardPick();
        // fizzbuzz();

        // /***********************************************************
        //  *                       ALGEBRA                           *
        // ************************************************************/
        // quadratic(1.0, 3, 1);
        // quadratic(1, 2.0, 1);
        // quadratic(1, 2, 3);
        // System.out.println(cramers( 9.0, 4.0, 3.0, -5.0, -6.0, -23.0) );
        // System.out.println( cramers(1.0, 2.0, 2.0, 4.0, 4.0, 5.0) );

        // /***********************************************************
        //  *                       GEOMETRY                           *
        // ************************************************************/
        //getPerimeter();
        // circlePoint();
        // rectanglePoint();
        // cramersRule();
        // triangePoint();
        // rectangleOverlap();
        // circleOverlap();
        // pointPosition();

        // /***********************************************************
        //  *                       DATETIME                          *
        // ************************************************************/
        // System.out.println( getSeason() );
        // ChineaseZodiac();
        // daysCount();


        // /***********************************************************
        //  *                       SCIENCE                         *
        // ************************************************************/
        // getBMI(123, 62);
        // windChill(5.3, 1);
        // windChill(42, 6);
        // windChill(5.3, 6);
        // dayOfWeek(2015, 1, 25);

        /***********************************************************
         *               FINANCIAL APPLICATION                      *
        ************************************************************/
        //computeChange(1.05);
        // shipping();
        //currencyExchange();
        compareCost(50, 24.59, 25, 11.99);
        compareCost(50, 25, 25, 12.5);
    }

}

