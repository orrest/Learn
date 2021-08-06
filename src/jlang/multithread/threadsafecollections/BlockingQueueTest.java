package jlang.multithread.threadsafecollections;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 如果队列满了或空，那么线程将被阻塞。
 * add
 * element
 * offer
 * peek
 * poll
 * put
 * remove
 * take
 *
 * add, remove, element 失败会抛异常；
 * put, take 使用于多线程，失败不抛异常，而是阻塞线程；
 * offer, poll, peek 返回 null 暗示失败，因此不能将null加入队列。
 *
 * 生产者： 遍历文件目录，将文件放入 BlockingQueue,
 * 消费者： 从队列中取出文件，搜索关键字。
 *
 * 使用 BlockingQueue 作为同步机制， put, take 都是同步的。
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Path.of("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (var in = new Scanner(System.in)){
            System.out.println("Enter base directory: ");
            String directory = in.nextLine();

            System.out.println("Enter keyword: ");
            String keyword = in.nextLine();

            // 生产者： 开一个线程遍历所有文件，加入BlockingQueue
            Runnable enumerator = () -> {
              try{
                  enumerate(Path.of(directory));
                  queue.put(DUMMY);
              }catch (IOException e){
                  e.printStackTrace();
              }catch (InterruptedException e){

              }
            };
            new Thread(enumerator).start();

            // 消费者： 从BlockingQueue取文件，开多个线程查找文件中的关键字
            for (int i = 1; i <= SEARCH_THREADS; i++){
                Runnable searcher = () -> {
                    try{
                        var done = false;
                        while (!done){
                            Path file = queue.take();
                            if (file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else{
                                search(file, keyword);
                            }
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){

                    }
                };

                new Thread(searcher).start();
            }
        }
    }

    /**
     * 遍历文件，加入队列
     * @param directory
     * @throws IOException
     * @throws InterruptedException
     */
    public static void enumerate(Path directory) throws IOException, InterruptedException{
        try (Stream<Path> children = Files.list(directory)){
            for (Path child : children.collect(Collectors.toList())){
                if (Files.isDirectory(child))   enumerate(child);
                else                            queue.put(child);
            }
        }
    }

    /**
     * 在文件中寻找关键字
     * @param file
     * @param keyword
     * @throws IOException
     * @throws InterruptedException
     */
    public static void search(Path file, String keyword) throws IOException, InterruptedException{
        try (var in = new Scanner(file, StandardCharsets.UTF_8)){
            int lineNumber = 0;
            while (in.hasNextLine()){
                lineNumber ++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s\n", file, lineNumber, line);
            }
        }
    }
}
