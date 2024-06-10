package services;

import listeners.SimulationListener;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import simulation.IslandSimulation;
import utils.ConsoleHelper;

import java.io.IOException;
import java.util.concurrent.*;

@RequiredArgsConstructor
public class SimulationService {
    private final IslandSimulation islandSimulation;
    private final SimulationListener simulationListener;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @SneakyThrows
    public void start() {
        scheduler.scheduleAtFixedRate(this::growPlants, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::animalLifeCycle, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::printStatistics, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::updateIslandAndPrint, 0, 1, TimeUnit.SECONDS);
    }

    private void growPlants() {
        islandSimulation.growPlants();
        simulationListener.onPlantGrowth();
    }

    private void animalLifeCycle() {
        executor.submit(() -> {
            islandSimulation.animalLifeCycle();
            simulationListener.onAnimalLifeCycle();
        });
    }

    private void printStatistics() {
        islandSimulation.printStatistics();
        simulationListener.onStatisticsPrinted();
    }

    @SneakyThrows
    private void updateIslandAndPrint(){
        synchronized (System.out) {
            islandSimulation.updateIsland(); // Обновляем состояние острова
            simulationListener.onIslandUpdated(); // Сообщаем слушателю об обновлении острова
        }
    }

}
