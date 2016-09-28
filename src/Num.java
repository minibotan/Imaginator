/**
 * Created by Ирек on 27.09.2016.
 */
public class Num extends Node {
    int type = 4;
    double var;

    public Num() {
        Main.seed = (((((Main.seed/13)*11)/7)*19)/3);
        var = (Main.seed%1000)/100000.0;
        System.out.print("(" + type);
        System.out.print(')');

    }

    @Override
    double getResult() {
        return var;
    }
}
