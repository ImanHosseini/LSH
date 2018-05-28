/**
 * Created by ImanH on 4/19/2018.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class RealPoint extends Point{
    int dim;
    double pos[];
    public RealPoint(int dim, double[] pos){
        this.dim=dim;
        this.pos=pos;
    }
    public double distanceTo(Point p){
        double aux=0.0;
        if (p instanceof RealPoint){
            RealPoint pr = (RealPoint) p;
            for(int i = 0; i<dim; i++){
                aux += Math.pow((this.pos[i]-pr.pos[i]),2.0);
            }
            aux = Math.sqrt(aux);
        }else{
            GridPoint gr = (GridPoint) p;
            for(int i = 0; i<dim; i++){
                aux += Math.pow((this.pos[i]-(double)gr.pos[i]),2.0);
            }
            aux = Math.sqrt(aux);
        }
        return aux;
    }
}
