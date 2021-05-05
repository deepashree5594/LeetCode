// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         //TreeMap<float, float> map = new TreeMap();
//         int n = position.length;
//         double[][] cars = new double[n][2];
//         for (int i = 0; i < n; i++){
//             cars[i] = new double[]{position[i], (double)((target - position[i]) / speed[i])};
//         }
//         Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
//         int carFleet = 0;
//         double lastTime = 0 ;
//         for (int i = n-1; i>=0 ; i--){
//             if (cars[i][1] > lastTime){
//                 carFleet++;
//                 lastTime = cars[i][1];
//             }
//         }
//         return carFleet;
//     }
// }

class Solution {
public int carFleet(int target, int[] pos, int[] speed) {
        int N = pos.length, res = 0;
        double[][] cars = new double[N][2];
        for (int i = 0; i < N; ++i)
            cars[i] = new double[] {pos[i], (double)(target - pos[i]) / speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = N - 1; i >= 0 ; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }
}