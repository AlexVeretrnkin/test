package ua.procamp.equasion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Double a,b,c;

        Scanner scan = new Scanner(System.in);

        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();

        EquationSolver solver = new EquationSolver();

        solver.solveSquareEquation(a, b, c);
    }

}
