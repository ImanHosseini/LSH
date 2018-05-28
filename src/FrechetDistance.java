import java.util.HashMap;

/**
 * Created by ImanH on 4/19/2018.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class FrechetDistance {
    Point[] path1;
    Point[] path2;
    double[][] c;
    public FrechetDistance (Point[] path1,Point[] path2){
        this.path1 = path1;
        this.path2= path2;
        c = new double[path1.length][path2.length];
        for(int i =0; i<path1.length; i++){
            for (int j= 0; j<path2.length; j++){
                c[i][j]=-1.0;
            }
        }
    }
    public double cFunction(int i,int j){
        if(c[i][j] > -1.0 ) return c[i][j];
        if(i==0 && j==0) {
            c[i][j] = Point.distance(path1[0],path2[0]);
        } else if(i>0 && j==0) {
            c[i][j] = Math.max(c[i-1][0],Point.distance(path1[i],path2[0]));
        } else if (i==0 && j>0) {
            c[i][j] = Math.max(c[0][j-1],Point.distance(path1[0],path2[j]));
        }else if (i>0 && j>0) {
            c[i][j] = Math.max(triMin(c[i-1][j],c[i-1][j-1],c[i][j-1]),
                    Point.distance(path1[i],path2[j]));
        }
        else c[i][j]=Double.POSITIVE_INFINITY;
        return c[i][j];
    }

    public double calcDistance(){
        return cFunction(path1.length,path2.length);
    }

    public static double triMin(double a, double b, double c){
        return Math.min(a,Math.min(b,c));
    }
}
