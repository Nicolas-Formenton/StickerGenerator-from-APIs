import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class StickerGenerator {
    
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception{

        /* LEITURA DE IMAGEM */
        
        //Arquivo
        /* InputStream inputStream = new FileInputStream(new File("stickers/filme.jpg")); */

        //URL
        /* InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream(); */

        //Resultado
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        /* Minha Imagem */
        BufferedImage minhaImagem = ImageIO.read(new URL("https://bafybeifjxk3me4fbduo2q7k37le2nwvvtvzncq2df6lxavugczdbbylqom.ipfs.dweb.link/3976.png?ext=png"));
        

        /* criar uma nova imagem em memória com transparência e com tamanho novo*/
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        /* int novaAltura = altura + 250; */

        BufferedImage novaImagem = new BufferedImage(600, 1000, BufferedImage.TRANSLUCENT);
        
        /* copiar a imagem original para a nova imagem (em memória) */
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, 600, 800, null);
        
        /* Minha Imagem */
        graphics.drawImage(minhaImagem, 0, 800, 200, 200, null);
        
        /* Configurar a fonte */
        var fonte = new Font("Impact", Font.BOLD, 48);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        

        /* escrever uma frase na nova imagem */
        graphics.drawString("TOPZERA", 320, 930);
        
        /* escrever a imagem em um arquivo (EM UMA PASTA[?])*/
        ImageIO.write(novaImagem, "png", new File("C:\\Dev\\Imersão Alura\\StickerImages\\" + nomeArquivo));

/*     public static void main(String[] args) throws Exception {
        var generator = new StickerGenerator();
        generator.criar();
    } */

    }
}
