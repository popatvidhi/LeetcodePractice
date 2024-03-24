package Array;

import java.util.Stack;

public class AsteriodCollision {

    public static void main(String args[]){
        int[] asteriods = {5,10,-5};
        int[] res = asteroidCollision(asteriods);
        for(int r : res){
            System.out.print(r + " ");
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            //first element
            if(st.isEmpty() || asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                while(true){
                    if (st.isEmpty() || st.peek() < 0) {
                        st.push(asteroids[i]);
                        break;
                    }
                    int peek = st.peek();
                    if(peek == -asteroids[i]){
                        st.pop();
                        break;
                    }else if(peek > -asteroids[i]){
                        break;
                    }else{
                        st.pop();
                        if(st.isEmpty()){
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}
