import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

/**
 * Created by Ирек on 27.09.2016.
 */
public class Main {
    static int x,y,maxDepth = 8,resolution = 256, depthReached;
    static long seed,trueseed;   //seed changes while tree growing. the true one don't
    public static void main(String args[]) {
       // int seed;
        int a = 1,r,g,b;  //for image
        Node tree;

        BufferedImage img = new BufferedImage(resolution,resolution, BufferedImage.TYPE_3BYTE_BGR);

        Scanner sc = new Scanner(System.in);

        String foldName = "images\\images_"+maxDepth+"_" + System.currentTimeMillis();  //folder
//        seed = sc.nextInt();
        for (int i = 0; i < 2000; i++) {
            depthReached = 0;   //counts depth of the tree
            seed = (long) (Math.random()*1000000l)%100627;    //random seed
            trueseed = seed;
            String fileName = foldName+"\\"+seed + "_" + resolution + ".png";
            System.out.print(seed);
            int r1 = (int)seed%113, r2 = (int)seed%117, r3 = (int)seed%131;
            int g1 = (int)seed%111, g2 = (int)seed%131, g3 = (int)seed%119;
            int b1 = (int)seed%171, b2 = (int)seed%191, b3 = (int)seed%117;
            tree = new Node().makeChild();
//            if (depthReached<2) continue;   //to prevent bad images. doesn't work
            for (x = 0; x < resolution; x++) {
                for (y = 0; y < resolution; y++) {
                    double tmp = tree.getResult();
                    r = (int) (tmp * tmp * r1 + tmp * r2 + r3) % 256;
                    g = (int) (tmp * tmp * g1 + tmp * g2 + g3) % 256;
                    b = (int) (tmp * tmp * b1 + tmp * b2 + b3) % 256;
                    int p = (r << 16) | (g << 8) | b;
                    img.setRGB(x, y, p);
                }
            }
            try {
                File d = new File(foldName);
                d.mkdir();
                File f = new File(fileName);
                ImageIO.write(img, "png", f);
            } catch (IOException e) {

            }
            System.out.print("\n");
        }
    }

    public double getX(){ return x;}
    public double getY(){ return y;}

}
