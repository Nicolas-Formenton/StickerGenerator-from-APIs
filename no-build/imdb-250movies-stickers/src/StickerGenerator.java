import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void criar() throws Exception{

        /* leitura da imagem */
        BufferedImage imagemOriginal = ImageIO.read(new File("../stickers/filme.jpg"));

        /* criar uma nova imagem em memória com transparência e com tamanho novo*/
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        /* copiar a imagem original para a nova imagem (em memória) */
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        /* escrever uma frase na nova imagem */


        /* escrever a imagem em um arquivo */
        ImageIO.write(novaImagem, "png", new File("saida/filmeSticker.png"));

    }

    public static void main(String[] args) throws Exception {
        var generator = new StickerGenerator();
        generator.criar();
    }
}
