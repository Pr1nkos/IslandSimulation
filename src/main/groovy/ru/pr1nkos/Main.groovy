package ru.pr1nkos

import listeners.IslandSimulationListener
import services.SimulationService
import simulation.IslandSimulation

static void main(String[] args) {
    IslandSimulation simulation = new IslandSimulation(60, 30);
    IslandSimulationListener listener = new IslandSimulationListener();
    SimulationService service = new SimulationService(simulation, listener);
    service.start();
}
