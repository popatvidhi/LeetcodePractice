package Math;

public class RobotBoundedInCircle {

    public static void main(String args[]){
        String instructions = "GGLLGG";
        boolean res = isRobotBounded(instructions);
        System.out.println(res);
    }

    public static boolean isRobotBounded(String instructions) {
        int dirX = 0, dirY = 1;
        int x = 0, y = 0;
        for(char d : instructions.toCharArray()){
            if(d == 'G'){
                x += dirX;
                y += dirY;
            }else if(d == 'L'){
                int temp = dirX;
                dirX = -1 * dirY;
                dirY = temp;
            }else{
                int temp = dirX;
                dirX = dirY;
                dirY = -1 * temp;
            }
        }
        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }
}
