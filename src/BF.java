/**
 * Created by Ирек on 27.09.2016.
 */
public class BF extends Node {
    int type = 2;
    Node child1, child2;
    int BFType;
    public BF(){
        Main.seed = ((((Main.seed/13)*11)/7)*19)/3;
        System.out.print("(" + type);
        BFType = (int)Main.seed%3;
        System.out.print("."+BFType);
        child1 = new Node().makeChild();
        child2 = new Node().makeChild();
        System.out.print(')');

    }

    double getResult() {
        double ans = 0;
        switch (BFType) {
            case 1: ans = (child1.getResult() + child2.getResult())/2.d; break;
            case 2: ans = (child1.getResult() - child2.getResult()); break;
            case 0: ans = (child1.getResult() * child2.getResult()); break;
        }
        return ans;
    }
}
