package loadsavefile;


import wireworldfiles.Matrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*https://www.javamex.com/tutorials/graphics/bufferedimage.shtml*/

public class CreateImage {
    static Color hollow = Color.BLACK;
    static Color head = Color.BLUE;
    static Color tail = Color.RED;
    static Color transmitter = Color.YELLOW;
    static BufferedImage img = new BufferedImage(600,600, BufferedImage.TYPE_INT_RGB);     /*ca³oœæ 600x600 pikseli, obs³uguje 100x100 komórek wiêc komórka 6x6 pikseli*/

    private static void MakeImageFromMatrix(Matrix matrix, int iteration) {
    	int cellWidth = (600/matrix.columns);
    	int cellHeight = (600/matrix.rows);
        for (int i = 0; i < matrix.rows; i++)                         // patrz na ka¿d¹ linijkê komórek
            for (int a = 0; a < cellHeight; a++)                       // ka¿d¹ linijkê komórek powtarzaj 6 razy
                for (int j = 0; j < matrix.columns; j++)                 // patrz na ka¿d¹ komórkê w linijce
                    for (int b = 0; b < cellWidth; b++) {             // ka¿d¹ komórkê w linijce powtarzaj 6 razy
                        if (matrix.board[i][j].get(iteration).getState() == 0)
                            img.setRGB(j*cellWidth+b, i*cellHeight+a,hollow.getRGB());
                        else if (matrix.board[i][j].get(iteration).getState() == 1)
                        	img.setRGB(j*cellWidth+b, i*cellHeight+a, head.getRGB());
                        else if (matrix.board[i][j].get(iteration).getState() == 2)
                        	img.setRGB(j*cellWidth+b, i*cellHeight+a, tail.getRGB());
                        else if (matrix.board[i][j].get(iteration).getState() == 3)
                            img.setRGB(j*cellWidth+b, i*cellHeight+a, transmitter.getRGB());
                    }
    }

    private static void MakeJPEGFromBufferedImage(String name) throws IOException {
        File file = new File(name);
        ImageIO.write(img, "PNG", file);
    }

    public static void MakeImage(Matrix matrix, int iteration) {        //tworzy obrazek (IOException przy wystêpuj¹cej ju¿ nazwie obrazka)
        MakeImageFromMatrix(matrix, iteration);
        String name = Integer.toString(iteration);
        try {
            MakeJPEGFromBufferedImage(name+".png");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}