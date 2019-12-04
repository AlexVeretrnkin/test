package ua.kpi.tef.ti71.lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EquationSolver {

    private static Logger logger = LogManager.getLogger();

    public  Double[] solveSquareEquation(Double a, Double b, Double c) {

        Double d = b * b - 4 * a * c;
        Double x1;
        Double x2;

        if (a == 0d) {
            //Linear
            return new Double[]{solveLinearEquation(b, c)};
        }
        //Quadratic
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            logger.info("x1 = {}", x1);
            logger.info("x2 = {}", x2);

            return new Double[]{x1, x2};
        } else if (d == 0) {
            x1 = (-b + Math.sqrt(d)) / (2d * a);
            x2 = x1;

            logger.info("x1 = x2 = {}", x1);

            return new Double[]{x1, x2};
        } else {
            Double im;
            Double re;

            im = Math.sqrt(-d) / (2d * a);
            re = (-b) / (2 * a);

            String res1 = "x1 = " + re + " +" + im + "i";
            String res2 = "x2 = " + re + " -" + im + "i";
            logger.info(res1);
            logger.info(res2);

            return new Double[]{re, im, im * -1};

        }

    }


    public Double solveLinearEquation(Double b, Double c){
        double x;

        if (b != 0d) {
            x = -c / b;

            logger.info("This equation has 1 solution ");
            logger.info("x = {}", x);

            return x;
        } else  if (c == 0d) {
            logger.info("This equation has infinite solutions ");

            return null;
        } else {
            logger.info("This equation is not solvable");

            return null;
    }
    }
}
