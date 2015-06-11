public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        int dup = width <= 0 || height <= 0 ? 0 : width * height;
        
        return (D - B) * (C - A) + (H - F) * (G - E) - dup;
    }
}