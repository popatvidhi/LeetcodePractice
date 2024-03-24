package Math;

public class ReachingPoints {

    public static void main(String args[]){
        int sx = 1, sy = 1;
        int tx = 3, ty = 5;
        boolean rec = reachingPoints(sx, sy, tx, ty);
        System.out.println(rec);
        boolean opt = reachingPointsOptimized(sx, sy, tx, ty);
        System.out.println(opt);
    }
    //brute force approach using recursion
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty){
            return true;
        }
        if(sx > tx || sy > ty){
            return false;
        }

        return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sy + sx, tx, ty);
    }

    public static boolean reachingPointsOptimized(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >= sy){
            if(tx == sx && ty == sy){
                return true;
            }
            if(tx > ty){
                if(ty > sy){
                    tx %= ty;
                }else{
                    return (tx - sx) % ty == 0;
                }
            }else{
                if(tx > sx){
                    ty %= tx;
                }else{
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return false;
    }
}
