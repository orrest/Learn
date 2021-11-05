package pers.xf.learn.jlang.multithread.threadpool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Executors class: 创建线程池
 *
 */
public class ExecutorDemo {
    /**
     * 计算一个词在一个文件中出现的次数.
     * @param word 单词
     * @param path 文件路径
     * @return word 在 path 所指的文件中出现的次数.
     */
    public static long occurrences(String word, Path path){
        try (var in = new Scanner(path)){
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count ++;
            return count;
        }catch (IOException e){
            return 0;
        }
    }

    /**
     * 找到一个目录的所有子文件.
     * @param rootDir 开始目录
     * @return 根目录的所有子文件
     * @throws IOException Stream
     */
    public static Set<Path> descendants(Path rootDir) throws IOException{
        try (Stream<Path> entries = Files.walk(rootDir)){
            return entries.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    /**
     * 查找文件中是否有这样的单词.
     * @param word the word to search
     * @param path the file in which to search
     * @return 返回文件的path代表文件中有这个word.
     */
    public static Callable<Path> searchForTask(String word, Path path){
        return () ->{
            try (var in = new Scanner(path)){
                while (in.hasNext()){
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Search in " + path + " cancel");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException,
            ExecutionException, IOException {
        try (var in = new Scanner(System.in)){
            System.out.println("Enter base directory: ");
            String start = in.nextLine();
            System.out.println("Enter keyword: ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));

            ExecutorService executor = Executors.newCachedThreadPool();
//            ExecutorService executor = Executors.newSingleThreadExecutor();


            var tasks = new ArrayList<Callable<Long>>();
            /*
             * 把搜寻每个文件作为一个task, 构造一个task集合.
             */
            for (Path file : files){
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results)
                total += result.get();
            Instant endTime = Instant.now();

            System.out.println("Occurrences of " + word + ": " + total);
            System.out.println("Time elapsed: "
                + Duration.between(startTime, endTime).toMillis() + " ms");

            /*
             * 文件中是否有这个词.
             * invokeAny 返回一个结果.
             */
            var searchTasks = new ArrayList<Callable<Path>>();
            for (Path file : files)
                searchTasks.add(searchForTask(word, file));

            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " occurs in: " + found);

            if (executor instanceof ThreadPoolExecutor)
                System.out.println("Largest pool size: "
                + ((ThreadPoolExecutor) executor).getLargestPoolSize());

            executor.shutdown();
        }
    }
}
