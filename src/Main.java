import java.util.Locale;

public class Main {

    static double[][] X = {{0.175, 0.932, 1.654, 2.731, 2.892},
                           {0.124, 0.431, 0.842, 1.124, 1.489},
                           {1.598, 1.934, 2.278, 2.697, 2.925},
                           {0.124, 0.431, 0.842, 1.124, 1.489, 1.598, 1.934, 2.278, 2.697, 2.925}};

    public static void main(String[] args) {
        for (int m = 0; m <= 2; m++) {
            for (int n = 1; n <= 2; n++) {
                System.out.println(" xi          f(xi)                    L4(xi)                        |f-L4|                         A");
                for (double i = 0; i <= 3; i += 0.15) {
                    double Rn = Math.abs(F(i, n) - L4(i, n, X[m]));
                    double max  ;
                   if (n==1)  max = 1; else  max = 100000 ;
                    System.out.println(String.format(Locale.ENGLISH, "%.2f", i)+ "    " +
                            String.format(Locale.ENGLISH, "%.15f", F(i, n))+ "        " +L4(i, n, X[m])+
                            "        " +Rn+ "        " +A(max, 4, i, X[m]));
                }
                System.out.println(" ");
            }
        }
        for (int n = 1; n <= 2; n++) {
            System.out.println(" xi          f(xi)                 L9(xi)                    |f-L9|                     A");
            for (double i = 0; i <= 3; i += 0.15) {
                double Rn = Math.abs(F(i, n) - L9(i, n, X[3]));
                double max  ;
                if (n==1)  max = 1; else  max = 10000000000.0 ;
                System.out.println(String.format(Locale.ENGLISH, "%.2f", i) + "    " +
                        String.format(Locale.ENGLISH, "%.15f", F(i, n)) + "     " + L9(i, n, X[3]) +
                        "     " + Rn + "     " + A(max, 9, i, X[3]));
            }
            System.out.println(" ");
        }
    }

    static double F(double x,int f){
        if (f==1) return Math.sin(x); else return Math.cos(10*x);

    }

    static double L4(double x, int n, double[] X){
        return  ((x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(F(X[0],n)))/((X[0]-X[1])*(X[0]-X[2])*(X[0]-X[3])*(X[0]-X[4])) +
                ((x-X[0])*(x-X[2])*(x-X[3])*(x-X[4])*(F(X[1],n)))/((X[1]-X[0])*(X[1]-X[2])*(X[1]-X[3])*(X[1]-X[4])) +
                ((x-X[0])*(x-X[1])*(x-X[3])*(x-X[4])*(F(X[2],n)))/((X[2]-X[0])*(X[2]-X[1])*(X[2]-X[3])*(X[2]-X[4])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[4])*(F(X[3],n)))/((X[3]-X[0])*(X[3]-X[1])*(X[3]-X[2])*(X[3]-X[4])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(F(X[4],n)))/((X[4]-X[0])*(X[4]-X[1])*(X[4]-X[2])*(X[4]-X[3]));
    }

    static double L9(double x, int n, double[] X){
        return  ((x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[0],n)))/((X[0]-X[1])*(X[0]-X[2])*(X[0]-X[3])*(X[0]-X[4])*(X[0]-X[5])*(X[0]-X[6])*(X[0]-X[7])*(X[0]-X[8])*(X[0]-X[9])) +
                ((x-X[0])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[1],n)))/((X[1]-X[0])*(X[1]-X[2])*(X[1]-X[3])*(X[1]-X[4])*(X[1]-X[5])*(X[1]-X[6])*(X[1]-X[7])*(X[1]-X[8])*(X[1]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[2],n)))/((X[2]-X[0])*(X[2]-X[1])*(X[2]-X[3])*(X[2]-X[4])*(X[2]-X[5])*(X[2]-X[6])*(X[2]-X[7])*(X[2]-X[8])*(X[2]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[3],n)))/((X[3]-X[0])*(X[3]-X[1])*(X[3]-X[2])*(X[3]-X[4])*(X[3]-X[5])*(X[3]-X[6])*(X[3]-X[7])*(X[3]-X[8])*(X[3]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[4],n)))/((X[4]-X[0])*(X[4]-X[1])*(X[4]-X[2])*(X[4]-X[3])*(X[4]-X[5])*(X[4]-X[6])*(X[4]-X[7])*(X[4]-X[8])*(X[4]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[6])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[5],n)))/((X[5]-X[0])*(X[5]-X[1])*(X[5]-X[2])*(X[5]-X[3])*(X[5]-X[4])*(X[5]-X[6])*(X[5]-X[7])*(X[5]-X[8])*(X[5]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[7])*(x-X[8])*(x-X[9])*(F(X[6],n)))/((X[6]-X[0])*(X[6]-X[1])*(X[6]-X[2])*(X[6]-X[3])*(X[6]-X[4])*(X[6]-X[5])*(X[6]-X[7])*(X[6]-X[8])*(X[6]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[8])*(x-X[9])*(F(X[7],n)))/((X[7]-X[0])*(X[7]-X[1])*(X[7]-X[2])*(X[7]-X[3])*(X[7]-X[4])*(X[7]-X[5])*(X[7]-X[6])*(X[7]-X[8])*(X[7]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[9])*(F(X[8],n)))/((X[8]-X[0])*(X[8]-X[1])*(X[8]-X[2])*(X[8]-X[3])*(X[8]-X[4])*(X[8]-X[5])*(X[8]-X[6])*(X[8]-X[7])*(X[8]-X[9])) +
                ((x-X[0])*(x-X[1])*(x-X[2])*(x-X[3])*(x-X[4])*(x-X[5])*(x-X[6])*(x-X[7])*(x-X[8])*(F(X[9],n)))/((X[9]-X[0])*(X[9]-X[1])*(X[9]-X[2])*(X[9]-X[3])*(X[9]-X[4])*(X[9]-X[5])*(X[9]-X[6])*(X[9]-X[7])*(X[9]-X[8]));
    }

    static double A(double max, int n,double x,double[] X){
        double fact = 1;
        for (int i=2;i<=n+1;i++){
            fact = fact*i;
        }
        double omega = 1;
        for (int k=0;k<=n;k++){
            omega=omega*(x-X[k]);
        }
        return max*Math.abs(omega)/fact;
    }
}