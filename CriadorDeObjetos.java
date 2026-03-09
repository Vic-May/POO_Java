import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import com.sun.management.OperatingSystemMXBean; // Necessário para métricas avançadas de CPU
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 1. A Classe
class ObjetoSimples {
    private byte[] espacoOcupado = new byte[1024]; // Cada objeto ocupa ~1KB
}

// 2. O Programa Principal
public class CriadorDeObjetos {
    public static void main(String[] args) {
        List<ObjetoSimples> listaDeObjetos = new ArrayList<>();
        long contador = 0;

        // Monitores de Memória, Sistema/CPU e Disco
        MemoryMXBean monitorDeMemoria = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean monitorOs = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        
        // O ponto "." representa o diretório atual onde o programa está rodando.
        // Ele vai monitorar o espaço da partição/disco onde a aplicação está salva.
        File disco = new File("."); 

        System.out.println("Iniciando a criação massiva de objetos...");
        System.out.println("Legenda: [Objetos] | [Memória Heap] | [CPU JVM / CPU Sistema] | [Disco Livre/Total]\n");

        try {
            while (true) {
                listaDeObjetos.add(new ObjetoSimples());
                contador++;

                if (contador % 100_000 == 0) {
                    // 1. Coletando Memória
                    MemoryUsage usoHeap = monitorDeMemoria.getHeapMemoryUsage();
                    long usadaMB = usoHeap.getUsed() / (1024 * 1024);
                    long maximaMB = usoHeap.getMax() / (1024 * 1024);

                    // 2. Coletando CPU
                    // Retorna um valor entre 0.0 e 1.0 (ou negativo se não estiver disponível imediatamente)
                    double usoCpuJvm = Math.max(monitorOs.getProcessCpuLoad() * 100, 0.0);
                    double usoCpuSistema = Math.max(monitorOs.getSystemCpuLoad() * 100, 0.0);

                    // 3. Coletando Disco
                    long discoLivreGB = disco.getFreeSpace() / (1024 * 1024 * 1024);
                    long discoTotalGB = disco.getTotalSpace() / (1024 * 1024 * 1024);

                    // Imprimindo tudo na mesma linha de forma formatada
                    System.out.printf("%d retidos | Heap: %d/%d MB | CPU: %.2f%% / %.2f%% | Disco: %d/%d GB\n", 
                            contador, usadaMB, maximaMB, usoCpuJvm, usoCpuSistema, discoLivreGB, discoTotalGB);
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n--- LIMITE DA MEMÓRIA ATINGIDO ---");
            System.out.println("Erro capturado: " + e.toString());
            System.out.println("Total máximo de objetos criados: " + contador);
            
            MemoryUsage usoFinalHeap = monitorDeMemoria.getHeapMemoryUsage();
            long finalUsadaMB = usoFinalHeap.getUsed() / (1024 * 1024);
            System.out.println("Memória Heap no momento da falha: " + finalUsadaMB + " MB");
        }
    }
}
