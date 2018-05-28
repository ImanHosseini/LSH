/**
 * Created by ImanH on 5/27/2018.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class Runner {
    public static void main(String[] args){
        // Take 1.0 * 1.0 square
        int N=60;
        PointFactory pf= new PointFactory(2);
        RealPoint[] curve = new RealPoint[16];
        double[] pos=new double[2];
        pos[0]=3.2; pos[1]=3.5;
        curve[0]=pf.makeRPoint(pos.clone());
        pos[0]=9.1; pos[1]=16.3;
        curve[1]=pf.makeRPoint(pos.clone());
        pos[0]=14.1; pos[1]=17.1;
        curve[2]=pf.makeRPoint(pos.clone());
        pos[0]= 20.1; pos[1]=18.9;
        curve[3]=pf.makeRPoint(pos.clone());
        pos[0]=25.0; pos[1]=21.0;
        curve[4]=pf.makeRPoint(pos.clone());
        pos[0]=29.0; pos[1]=28.0;
        curve[5]=pf.makeRPoint(pos.clone());
        pos[0]=32.0; pos[1]=34.0;
        curve[6]=pf.makeRPoint(pos.clone());
        pos[0]=36.0; pos[1]=39.0;
        curve[7] = pf.makeRPoint(pos.clone());
        pos[0]=39.0; pos[1]=43.0;
        curve[8] = pf.makeRPoint(pos.clone());
        pos[0]=53.0; pos[1]=48.0;
        curve[9] = pf.makeRPoint(pos.clone());
        pos[0]=59.0; pos[1]=53.0;
        curve[10] = pf.makeRPoint(pos.clone());
        pos[0]=66.0; pos[1]=59.0;
        curve[11] = pf.makeRPoint(pos.clone());
        pos[0]=70.0; pos[1]=61.0;
        curve[12] = pf.makeRPoint(pos.clone());
        pos[0]=71.0; pos[1]=66.0;
        curve[13] = pf.makeRPoint(pos.clone());
        pos[0]=72.0; pos[1]=73.0;
        curve[14] = pf.makeRPoint(pos.clone());
        pos[0]=84.0; pos[1]=79.0;
        curve[15] = pf.makeRPoint(pos.clone());
        drawCurve(curve);
        int n=(int)(100.0/1.0);
        double tx = StdRandom.uniform();
        double ty =StdRandom.uniform();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.00001);
        for(int i=0;i<n-1;i++){
            StdDraw.line((tx+((double)i))/100.0,0.0,(tx+((double)i))/100.0,1.0);
            StdDraw.line(0.0,(ty+((double)i))/100.0,1.0,(ty+((double)i))/100.0);
        }
        GridPoint[] snapped = new GridPoint[curve.length];
        for(int i=0;i<curve.length;i++){
            int xn,yn;
            if(((curve[i].pos[0]-tx)/1.0-(int)((curve[i].pos[0]-tx)/1))>0.5){
                xn=(int)((curve[i].pos[0]-tx)/1)+1;
            }else{
                xn = (int)((curve[i].pos[0]-tx)/1);
            }
            if(((curve[i].pos[1]-ty)/1.0-(int)((curve[i].pos[1]-ty)/1))>0.5){
                yn=(int)((curve[i].pos[1]-ty)/1)+1;
            }else{
                yn = (int)((curve[i].pos[1]-ty)/1);
            }
            int[] po=new int[2];
            po[0]=xn;po[1]=yn;
            snapped[i]=pf.makeGPoint(po);
        }

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius();
         drawCurve(snapped);
    }


    public static void drawCurve(Point[] pts){

        if(pts[0] instanceof RealPoint){
            for(int i=0;i<pts.length-1;i++){
                RealPoint p1 =(RealPoint) pts[i];
                RealPoint p2 = (RealPoint) pts[i+1];
                StdDraw.line(p1.pos[0]/100.0,p1.pos[1]/100.0,p2.pos[0]/100.0,p2.pos[1]/100.0);
            }
        }else{
            for(int i=0;i<pts.length-1;i++){
                GridPoint p1 =(GridPoint) pts[i];
                GridPoint p2 = (GridPoint) pts[i+1];
                StdDraw.line(p1.pos[0]/100.0,p1.pos[1]/100.0,p2.pos[0]/100.0,p2.pos[1]/100.0);
            }
        }

    }
}
