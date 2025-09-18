package Recursion.BasicRecursion;

public class PrintPattern {
    private static void recursivePrint(int start, int end) {
        if (start > end) {
            return;
        }
        System.out.print(start + " ");
        recursivePrint(start + 1, end);
    }

    private static void BackPrint(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        BackPrint(n - 1);
    }

    private static void recursivePrintUsingBackTrack(int start) {
        if (start == 0) {
            return;
        }
        recursivePrintUsingBackTrack(start - 1);
        System.out.print(start + " ");
    }

    private static void BackPrintUsingBackTrack(int start, int end) {
        if (start > end) {
            return;
        }
        BackPrintUsingBackTrack(start + 1, end);
        System.out.print(start + " ");
    }

    static void printTillN(int N) {
        // code here
        recursivePrint(1, N);
        System.out.println();
        BackPrint(N);
        System.out.println();
        recursivePrintUsingBackTrack(N);
        System.out.println();
        BackPrintUsingBackTrack(1, N);
    }


     static void printGfg(int N) {
        // code here
        if(N==0){
            return;
        }
        System.out.print("GFG"+" ");
        printGfg(N-1);
    } 

    public static void main(String[] args) {
        int N = 5;
        printTillN(N);
        System.out.println("\nThe pattern is :    ");
        printGfg(N);
    }
}
