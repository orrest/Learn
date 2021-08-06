package jlang.multithread.threadsafecollections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentHashMapTest {
    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    /**
     * 计算一个文件中内容的词频。
     * @param file
     */
    public static void process(Path file){
        try (var in = new Scanner(file)){
            while(in.hasNext()){
                String word = in.next();
                /**
                 * 原子性的put？
                 */
                map.merge(word, 1L, Long::sum);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 遍历文件树。
     * @param rootDir
     * @return
     * @throws IOException
     */
    public static Set<Path> descendants(Path rootDir) throws IOException{
        try (Stream<Path> entries = Files.walk(rootDir)){
            return entries.collect(Collectors.toSet());
        }
    }

    /**
     * 计算一个目录下所有文件中的词频。
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws IOException
     */
    public static void main(String[] args)
        throws InterruptedException, ExecutionException, IOException{

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processors);

        Path pathToRoot = Path.of(".");
        for (Path p : descendants(pathToRoot)){
            if (p.getFileName().toString().endsWith(".java")){
                executor.execute(() -> process(p));
            }
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        map.forEach((k, v) ->{
            if (v >= 10)
                System.out.println(k + "\toccurs\t" + v + "\ttimes");
        });

    }
}
