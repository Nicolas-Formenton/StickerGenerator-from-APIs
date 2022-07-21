import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
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
        BufferedImage minhaImagem = ImageIO.read(new File("C://Dev//Imersão Alura//Top250MoviesAPI's//3976.png"));
       

        /* criar uma nova imagem em memória com transparência e com tamanho novo*/
        int largura = imagemOriginal.getWidth(); 
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        /* copiar a imagem original para a nova imagem (em memória) */
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        /* Minha Imagem */
        graphics.drawImage(minhaImagem, 0, novaAltura - 200, 200, 200, null);
        
        /* Configurar a fonte */
        var fonte = new Font("Impact", Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        
        /* escrever uma frase na nova imagem */
        graphics.drawString("TOPZERA", largura/2, novaAltura-100);
        
        
        /* escrever a imagem em um arquivo (EM UMA PASTA[?])*/
        ImageIO.write(novaImagem, "png", new File("C:\\Dev\\Imersão Alura\\StickerImages\\" + nomeArquivo));

    }
}
