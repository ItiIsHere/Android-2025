package com.example.actividad_m6_01;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private TextView statusTextView;
    private EditText sizeInput;
    private Button initButton;
    private int gridSize = 10; // Tamaño inicial predeterminado
    private int[][] grid; // Representación del grid
    private int[][] directions; // Dirección de los aviones
    private int step = 0;
    private int collisions = 0;
    private Stack<int[][]> gridHistory = new Stack<>(); // Historial de grids
    private Stack<int[][]> directionHistory = new Stack<>(); // Historial de direcciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);
        statusTextView = findViewById(R.id.statusTextView);
        sizeInput = findViewById(R.id.sizeInput);
        initButton = findViewById(R.id.initButton);

        Button backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        initButton.setOnClickListener(v -> initializeGrid());
        backButton.setOnClickListener(v -> stepBack());
        nextButton.setOnClickListener(v -> stepForward());
    }

    private void initializeGrid() {
        try {
            gridSize = Integer.parseInt(sizeInput.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese un tamaño válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        grid = new int[gridSize][gridSize];
        directions = new int[gridSize][gridSize];

        // Permitir al usuario seleccionar las posiciones y direcciones iniciales
        selectInitialPositions();
    }

    private void selectInitialPositions() {
        gridLayout.removeAllViews();
        gridLayout.setRowCount(gridSize);
        gridLayout.setColumnCount(gridSize);

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                TextView cell = new TextView(this);
                cell.setLayoutParams(new GridLayout.LayoutParams());
                cell.setGravity(Gravity.CENTER);
                cell.setWidth(100);
                cell.setHeight(100);
                cell.setBackgroundColor(Color.LTGRAY);

                final int row = i;
                final int col = j;

                cell.setOnClickListener(v -> {
                    // Marcar posición inicial de un avión
                    grid[row][col] = 1;
                    directions[row][col] = (directions[row][col] + 1) % 4; // Cambiar dirección cíclicamente
                    cell.setText(getDirectionSymbol(directions[row][col]));
                    cell.setBackgroundColor(Color.GREEN);
                });

                gridLayout.addView(cell);
            }
        }
    }

    private void stepForward() {
        step++;
        gridHistory.push(copyGrid(grid));
        directionHistory.push(copyGrid(directions));

        moveAirplanes();
        detectCollisions();
        updateStatus();
        drawGrid();

        // Verificar si todos los aviones han salido
        if (isSimulationOver()) {
            Toast.makeText(this, "Simulación terminada.", Toast.LENGTH_LONG).show();
        }
    }

    private void stepBack() {
        if (!gridHistory.isEmpty() && !directionHistory.isEmpty()) {
            grid = gridHistory.pop();
            directions = directionHistory.pop();
            step--;
            updateStatus();
            drawGrid();
        } else {
            Toast.makeText(this, "No hay pasos anteriores.", Toast.LENGTH_SHORT).show();
        }
    }

    private void moveAirplanes() {
        int[][] newGrid = new int[gridSize][gridSize];
        int[][] newDirections = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 1) {
                    int newX = i;
                    int newY = j;

                    switch (directions[i][j]) {
                        case 0: newX = i - 1; break; // Arriba
                        case 1: newY = j + 1; break; // Derecha
                        case 2: newX = i + 1; break; // Abajo
                        case 3: newY = j - 1; break; // Izquierda
                    }

                    if (newX >= 0 && newX < gridSize && newY >= 0 && newY < gridSize) {
                        newGrid[newX][newY] = 1;
                        newDirections[newX][newY] = directions[i][j];
                    }
                }
            }
        }

        grid = newGrid;
        directions = newDirections;
    }

    private boolean isSimulationOver() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }

    private void detectCollisions() {
        // Detectar colisiones (ya manejado en moveAirplanes)
    }

    private void updateStatus() {
        statusTextView.setText("Paso: " + step + " | Colisiones: " + collisions);
    }

    private void drawGrid() {
        gridLayout.removeAllViews();

        // Obtener dimensiones de la pantalla
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;

        // Determinar el tamaño de la celda (mantener cuadrado y ajustar al más pequeño)
        int cellSize = Math.min(screenWidth, screenHeight) / gridSize;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                TextView cell = new TextView(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = cellSize;
                params.height = cellSize;
                params.setMargins(1, 1, 1, 1); // Márgenes entre celdas
                cell.setLayoutParams(params);

                cell.setGravity(Gravity.CENTER);
                cell.setBackgroundColor(grid[i][j] == 1 ? Color.GREEN : Color.LTGRAY);
                cell.setText(grid[i][j] == 1 ? getDirectionSymbol(directions[i][j]) : "");
                cell.setTextColor(Color.WHITE);

                gridLayout.addView(cell);
            }
        }
    }

    private String getDirectionSymbol(int direction) {
        switch (direction) {
            case 0: return "↑";
            case 1: return "→";
            case 2: return "↓";
            case 3: return "←";
            default: return "";
        }
    }

    private int[][] copyGrid(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        return copy;
    }
}
