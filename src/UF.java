/**
 * Created by Ирек on 27.09.2016.
 */
public class UF extends Node {
    int type = 1;
    Node child;
    int UFType;
    public UF(){
        System.out.print("(" + type);
        Main.seed = ((((Main.seed/13)*11)/7)*19)/3;
        UFType = (int)Main.seed%3;
        System.out.print("."+UFType);
        child = new Node().makeChild();
        System.out.print(')');
    }

    double getResult() {
        double ans = 0;
        switch (UFType) {
            case 1: ans = Math.sin(child.getResult()*Math.PI*2); break;
            case 2: ans = Math.cos(child.getResult()*Math.PI*2); break;
            case 3: ans = Math.exp(child.getResult()); break;
            case 0: ans = Math.tanh(child.getResult()); break;
        }
        return ans;
    }
}
