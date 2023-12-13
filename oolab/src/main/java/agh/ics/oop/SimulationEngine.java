package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements Runnable{
    private List<Simulation> simulations;
    private List<Thread> threads = new ArrayList<>();
    private ExecutorService threadPool;

    @Override
    public void run() {
        System.out.println("Thread started.");
    }
    public SimulationEngine(List<Simulation> simulations) {
        this.threadPool = Executors.newFixedThreadPool(4);
        this.simulations = simulations;
    }
    public void runSync() {
        for(Simulation simulation : simulations) {
            simulation.run();
        }
    }
    public void runAsync() {
        for(Simulation simulation : simulations) {
            Thread thread = new Thread(simulation::run);
            threads.add(thread);
            thread.start();
        }
    }
    public void awaitSimulationsEnd() {
        if(threads.isEmpty()) {
            try {
                threadPool.shutdown();
                if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                    System.err.println("Thread pool shutdown. (+10s)");
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        } else {
            for(Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

    }
    public void runAsyncInThreadPool() {
        for(Simulation simulation : simulations) {
            threadPool.submit(simulation::run);
        }
    }
}
