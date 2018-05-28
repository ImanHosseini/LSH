/**
 * Created by ImanH on 4/19/2018.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public abstract class Point {
    public abstract double distanceTo(Point p);
    public static double distance(Point p , Point q){
        return p.distanceTo(q);
    }
    

}
