
package com.cloverassociation.twenwy_point_game.util.algorithm;

import java.util.ArrayList;


public class Panduan {
    public static boolean point24(double a,double b,double c ,double d){
        return fourCal4(a,b,c,d)||fourCal4(a,b,d,c)||fourCal4(a,c,d,b)||fourCal4(d,c,d,a);
    }

    private static double[] fourCal2(double a, double b) {
        double[] res = new double[]{a+b,a-b,a*b,a/b,b-a,b/a};
        if (res[1]==0){
            res[1]=res[4]=1;
        }
        return res;
    }
    private static ArrayList<double[]> fourCal3(double a,double b,double c ){
        double[][] aa = new double[3][6];
        aa[0] = fourCal2(a,b);
        aa[1] = fourCal2(a,c);
        aa[2] = fourCal2(c,b);
        ArrayList<double[]> res = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            res.add(fourCal2(aa[0][i],c));
            res.add(fourCal2(aa[1][i],b));
            res.add(fourCal2(aa[2][i],a));

        }
        return res;
    }
    public static boolean fourCal4(double a,double b,double c ,double d) {
        ArrayList<double[]> list1 = fourCal3(a, b, c);
        for (double[]dou : list1) {
            for (double v : dou) {
                double[] doubles = fourCal2(v, d);
                for (double last : doubles) {
                    if (last==24) return true;
                }

            }

        }
        return false;
    }

}
