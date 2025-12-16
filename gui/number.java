
package gui;



public class number {

    public  long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++)result *= i;
        return result;
    }

    public  boolean prime(int number) {
        if (number <= 1)  return false; 
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false; 
        return true;
    }

    public  boolean palindrome(int number) {
        int rev = 0, orig = number;
        while (number != 0) { rev = rev*10 + number%10; number/=10; }
        return rev ==orig;
    }

    public  int minNumber(int number) {
        int min=9;
        while (number!=0){ int d=number%10; if(d<min) min=d; number/=10; }
        return min;
    }

    public  int maxNumber(int number) {
        int max=0;
        while(number!=0){ int d=number%10; if(d>max) max=d; number/=10; }
        return max;
    }

    public  int sumOfDigits(int number) {
        int sum=0;
        while(number!=0){ sum+=number%10; number/=10; }
        return sum;
    }

    public  double averageOfDigits(int number) {
        int  sum=0, count=0;
        while(number!=0){ sum+=number%10; number/=10; count++; }
        return count ==0 ? 0:(double)sum/count;
    }

    public  boolean isEven(int number) {
        return number%2==0;

    }

    public  boolean isOdd(int number) {
        return number%2!=0;

    }

    public  boolean isPerfectNumber(int number) {
        int sum=0;
        for(int i=1;i<=number/2;i++) if(number%i==0) sum+=i;
        return sum==number;
    }
}

