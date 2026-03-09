import java.util.ArrayList;
import java.util.List;

// 1. A Classe
// Criamos uma classe simples. Adicionei um pequeno array de bytes 
// para que cada objeto ocupe um pouco de espaço, acelerando o teste.
class ObjetoSimples {
    private byte[] espacoOcupado = new byte[1024]; // Cada objeto ocupa ~1KB
}

// 2. O Programa Principal
public class CriadorDeObjetos {
    public static void main(String[] args) {
        // Usamos uma lista para segurar as referências. 
        // Se não fizermos isso, o Garbage Collector apaga os objetos instantaneamente.
        List<ObjetoSimples> listaDeObjetos = new ArrayList<>();
        long contador = 0;

        System.out.println("Iniciando a criação massiva de objetos...");

        try {
            // Um loop infinito que cria e armazena os objetos
            while (true) {
                listaDeObjetos.add(new ObjetoSimples());
                contador++;

                // Imprime o progresso no console de forma espaçada para não travar a tela
                if (contador % 100_000 == 0) {
                    System.out.println(contador + " objetos retidos na memória até agora...");
                }
            }
        } catch (OutOfMemoryError e) {
            // A exceção OutOfMemoryError é lançada quando a JVM não tem mais espaço
            System.out.println("\n--- LIMITE DA MEMÓRIA ATINGIDO ---");
            System.out.println("Erro capturado: " + e.toString());
            System.out.println("Total máximo de objetos que puderam ser criados: " + contador);
        }
    }
}