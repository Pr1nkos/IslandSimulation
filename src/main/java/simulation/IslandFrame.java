package simulation;

import animals.herbivores.*;
import animals.predators.*;
import environment.Island;
import environment.Location;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class IslandFrame extends JFrame {
    private final IslandPanel islandPanel;

    public IslandFrame(Island island) {
        setTitle("Island Simulation");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        islandPanel = new IslandPanel(island);

        add(islandPanel);

        setVisible(true);
    }

    public void updateIsland() {
        islandPanel.repaint();
    }

    private static class IslandPanel extends JPanel {
        private final Island island;

        public IslandPanel(Island island) {
            this.island = island;
            setPreferredSize(new Dimension(island.getWidth() * 20, island.getHeight() * 20));
            setBorder(new EmptyBorder(20, 10, 10, 10)); // Добавляем верхний отступ
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Font font = new Font("Serif", Font.PLAIN, 12);
            g.setFont(font);
            FontMetrics metrics = g.getFontMetrics(font);

            int cellSize = metrics.getHeight();

            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Location location = island.getLocation(x, y);

                    if (location.getAnimals().isEmpty()) {
                        g.drawString("◻️", x * cellSize, (y + 1) * cellSize);
                    } else {
                        // Проверяем типы животных в ячейке и выводим соответствующий символ Unicode
                        boolean hasBear = location.getAnimals().stream().anyMatch(Bear.class::isInstance);
                        boolean hasBoa = location.getAnimals().stream().anyMatch(Boa.class::isInstance);
                        boolean hasEagle = location.getAnimals().stream().anyMatch(Eagle.class::isInstance);
                        boolean hasFox = location.getAnimals().stream().anyMatch(Fox.class::isInstance);
                        boolean hasWolf = location.getAnimals().stream().anyMatch(Wolf.class::isInstance);

                        boolean hasBoar = location.getAnimals().stream().anyMatch(Boar.class::isInstance);
                        boolean hasBuffalo = location.getAnimals().stream().anyMatch(Buffalo.class::isInstance);
                        boolean hasCaterpillar = location.getAnimals().stream().anyMatch(Caterpillar.class::isInstance);
                        boolean hasDeer = location.getAnimals().stream().anyMatch(Deer.class::isInstance);
                        boolean hasDuck = location.getAnimals().stream().anyMatch(Duck.class::isInstance);
                        boolean hasGoat = location.getAnimals().stream().anyMatch(Goat.class::isInstance);
                        boolean hasHorse = location.getAnimals().stream().anyMatch(Horse.class::isInstance);
                        boolean hasMouse = location.getAnimals().stream().anyMatch(Mouse.class::isInstance);
                        boolean hasRabbit = location.getAnimals().stream().anyMatch(Rabbit.class::isInstance);
                        boolean hasSheep = location.getAnimals().stream().anyMatch(Sheep.class::isInstance);

                        if (hasBear) g.drawString("🐻", x * cellSize, (y + 1) * cellSize);
                        else if (hasBoa) g.drawString("🐍", x * cellSize, (y + 1) * cellSize);
                        else if (hasEagle) g.drawString("🦅", x * cellSize, (y + 1) * cellSize);
                        else if (hasFox) g.drawString("🦊", x * cellSize, (y + 1) * cellSize);
                        else if (hasWolf) g.drawString("🐺", x * cellSize, (y + 1) * cellSize);
                        else if (hasBoar) g.drawString("🐗", x * cellSize, (y + 1) * cellSize);
                        else if (hasBuffalo) g.drawString("🐃", x * cellSize, (y + 1) * cellSize);
                        else if (hasCaterpillar) g.drawString("🐛", x * cellSize, (y + 1) * cellSize);
                        else if (hasDeer) g.drawString("🦌", x * cellSize, (y + 1) * cellSize);
                        else if (hasDuck) g.drawString("🦆", x * cellSize, (y + 1) * cellSize);
                        else if (hasGoat) g.drawString("🐐", x * cellSize, (y + 1) * cellSize);
                        else if (hasHorse) g.drawString("🐎", x * cellSize, (y + 1) * cellSize);
                        else if (hasMouse) g.drawString("🐁", x * cellSize, (y + 1) * cellSize);
                        else if (hasRabbit) g.drawString("🐇", x * cellSize, (y + 1) * cellSize);
                        else if (hasSheep) g.drawString("🐑", x * cellSize, (y + 1) * cellSize);
                    }
                }
            }
        }
    }
}

