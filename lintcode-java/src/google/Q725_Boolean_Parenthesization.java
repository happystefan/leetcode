package google;

/**
 * Created by mingqiangliang on 12/26/17.
 */
public class Q725_Boolean_Parenthesization {

    public int countParenth(char[] symb, char[] oper) {
        // write your code here
        int[][] t = new int[symb.length][symb.length];
        int[][] f = new int[symb.length][symb.length];
        for (int i = 0; i < symb.length; i++) {
            t[i][i] = symb[i]=='T' ? 1 : 0;
            f[i][i] = symb[i]=='F' ? 1 : 0;
        }

        for (int d = 1; d < symb.length; d++) {
            for (int i = 0, j = i+d; j < symb.length; i++, j++) {
                for (int k = i; k < j; k++) {
                    int tik = t[i][k] + f[i][k];
                    int tkj = t[k+1][j] + f[k+1][j];

                    if (oper[k] == '&') {
                        t[i][j] += t[i][k]*t[k+1][j];
                        f[i][j] += tik*tkj - t[i][k]*t[k+1][j];
                    }
                    if (oper[k] == '|') {
                        f[i][j] += f[i][k]*f[k+1][j];
                        t[i][j] += tik*tkj - f[i][k]*f[k+1][j];
                    }
                    if (oper[k] == '^') {
                        t[i][j] += f[i][k]*t[k+1][j] + t[i][k]*f[k+1][j];
                        f[i][j] += t[i][k]*t[k+1][j] + f[i][k]*f[k+1][j];
                    }
                }
            }
        }
        return t[0][symb.length-1];
    }

}
