package streaming;

public class Main {
    public static void main(String[] args) {
        // Simulando a entrada de um arquivo de vídeo bruto
        String arquivoVideoEntrada = "Average Deadlock Interaction Animated.mp4";
        
        System.out.println("=== SISTEMA DE CONVERSAO DE STREAMING ===");
        System.out.println("Arquivo de Entrada: " + arquivoVideoEntrada);
        System.out.println("=========================================\n");

        // Gerando 3 formatos de áudio a partir do vídeo
        System.out.println("--- GERANDO FORMATOS DE AUDIO ---");
        Stream audio1 = new StreamMp3(arquivoVideoEntrada);
        Stream audio2 = new StreamOgg(arquivoVideoEntrada);
        Stream audio3 = new StreamM4u(arquivoVideoEntrada);
        
        audio1.encoder();
        audio2.encoder();
        audio3.encoder();

        // Gerando 3 formatos de vídeo a partir do vídeo
        System.out.println("\n--- GERANDO FORMATOS DE VIDEO ---");
        Stream video1 = new StreamMP4(arquivoVideoEntrada);
        Stream video2 = new StreamMPG1(arquivoVideoEntrada);
        Stream video3 = new StreamH264(arquivoVideoEntrada);
        
        video1.encoder();
        video2.encoder();
        video3.encoder();
        
        System.out.println("\n=== PROCESSAMENTO CONCLUIDO ===");
    }
}