/**
 * Created by ImanH on 4/19/2018.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class PointFactory {
    public int dim;
    public PointFactory(int d){
        this.dim=d;
    }
    public RealPoint makeRPoint(double[] pos){
        return new RealPoint(dim,pos);
    }
    public GridPoint makeGPoint(int[] pos){
        return new GridPoint(dim,pos);
    }
}
