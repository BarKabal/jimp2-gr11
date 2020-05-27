package loadsavefile;


import wireworldfiles.Matrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*https://www.javamex.com/tutorials/graphics/bufferedimage.shtml*/

public class CreateImage {
    Color hollow = Color.BLACK;
    Color head = Color.BLUE;
    Color tail = Color.RED;
    Color transmitter = Color.YELLOW;
    BufferedImage img = new BufferedImage(600,600, BufferedImage.TYPE_INT_RGB);     /*ca³oœæ 600x600 pikseli, obs³uguje 100x100 komórek wiêc komórka 6x6 pikseli*/

    private void MakeImageFromMatrix(Matrix matrix, int iteration) {
        for (int i = 0; i < 100; i++)                         // patrz na ka¿d¹ linijkê komórek
            for (int a = 0; a < 6; a++)                       // ka¿d¹ linijkê komórek powtarzaj 6 razy
                for (int j = 0; j < 100; j++)                 // patrz na ka¿d¹ komórkê w linijce
                    for (int b = 0; b < 6; b++) {             // ka¿d¹ komórkê w linijce powtarzaj 6 razy
                        if (matrix.board[i][j][iteration].getState() == 0)
                            img.setRGB(i*6+a,j*6+b, hollow.getRGB());
                        else if (matrix.board[i][j][iteration].getState() == 1)
                            img.setRGB(i*6+a,j*6+b, head.getRGB());
                        else if (matrix.board[i][j][iteration].getState() == 2)
                            img.setRGB(i*6+a,j*6+b, tail.getRGB());
                        else if (matrix.board[i][j][iteration].getState() == 3)
                            img.setRGB(i*6+a,j*6+b, transmitter.getRGB());
                    }
    }

    private void MakeJPEGFromBufferedImage(String name) throws IOException {
        File file = new File(name);
        ImageIO.write(img, "JPEG", file);
    }

    public void MakeImage(Matrix matrix, int iteration) {        //tworzy obrazek (IOException przy wystêpuj¹cej ju¿ nazwie obrazka)
        MakeImageFromMatrix(matrix, iteration);
        String name = Integer.toString(iteration);
        try {
            MakeJPEGFromBufferedImage(name+".jpg");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}