package ua.kpi.tef.ti71.lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Double a;
        Double b;
        Double c;

        Scanner scan = new Scanner(System.in);

        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        EquationSolver solver = new EquationSolver();

        solver.solveSquareEquation(a, b, c);
    }

}
