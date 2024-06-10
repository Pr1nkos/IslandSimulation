package listeners;

public interface SimulationListener {
    void onPlantGrowth();
    void onAnimalLifeCycle();
    void onStatisticsPrinted();
    void onIslandUpdated();
}
