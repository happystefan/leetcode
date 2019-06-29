package Q001_Q300;

public class Q223_Rectangle_Area {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap;
        if (C < E || G < A || B > H || F > D) overlap = 0;
        else {
            int length = Math.min(C, G) - Math.max(A, E);
            int height = Math.min(D, H) - Math.max(B, F);
            overlap = length * height;
            System.out.println(overlap);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }

}
