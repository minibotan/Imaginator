/**
 * Created by Ирек on 27.09.2016.
 */
public class Var extends Node {
    int type = 3;
    int var;

    public  Var() {
        Main.seed = (((((Main.seed/13)*11)/7)*19)/3) + Main.trueseed;
        var = (int)Main.seed%2;
        System.out.print("(" + type + "." + var);
        System.out.print(')');

    }

    @Override
    double getResult() {
        double k = 1; //resize image scale. works like a zoom
        return ((var%2==0)?((Main.x*1.0)/(Main.resolution*k)):((Main.y*1.0)/(Main.resolution*k)));
    }
}
