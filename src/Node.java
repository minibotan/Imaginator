/**
 * Created by Ирек on 27.09.2016.
 */
public class Node {
    //type = 1 is unary function
    //2 is binary
    //3 is variable
    //4 is number
    int type;
    double getResult(){return 0;};
    public Node makeChild(){
        ++Main.depthReached;
        if (Main.depthReached > Main.maxDepth) {
            return new Var();
        }
        switch ((int)Main.seed%10) {
            case 4:
            case 0: return new UF();
            case 6:
            case 8:
            case 5:
            case 7:
            case 9:
            case 1: return new BF();
            case 2: return new Var();
            case 3: return new Num();
        }
        return null;
    }

}
