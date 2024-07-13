import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int maxItems;

    public Producer(BlockingQueue<Integer> queue, int maxItems) {
        this.queue = queue;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        IntStream.range(0, maxItems)
                .forEach(i -> {
                    try {
                        queue.put(i);
                        System.out.println("Produced: " + i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final String name;

    public Consumer(BlockingQueue<Integer> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = queue.take();
                System.out.println(name + " consumed: " + item);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        final int QUEUE_SIZE = 15;
        final int MAX_ITEMS_PRODUCED = 29;

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Producer producer = new Producer(queue, MAX_ITEMS_PRODUCED);
        Consumer consumer1 = new Consumer(queue, "Consumer 1");
        Consumer consumer2 = new Consumer(queue, "Consumer 2");

        executorService.submit(producer);
        executorService.submit(consumer1);
        executorService.submit(consumer2);

        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}