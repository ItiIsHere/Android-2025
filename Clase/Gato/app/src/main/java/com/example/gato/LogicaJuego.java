package com.example.gato;

class LogicaJuego {
    private char[] tablero;
    private char jugadorActual;

    public LogicaJuego() {
        tablero = new char[9];
        reiniciar();
    }

    public boolean realizarMovimiento(int indice) {
        if (tablero[indice] == '-') {
            tablero[indice] = jugadorActual;
            return true;
        }
        return false;
    }

    public boolean verificarVictoria() {
        int[][] condicionesVictoria = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condicion : condicionesVictoria) {
            if (tablero[condicion[0]] != '-' && tablero[condicion[0]] == tablero[condicion[1]] && tablero[condicion[1]] == tablero[condicion[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean estaTableroLleno() {
        for (char celda : tablero) {
            if (celda == '-') return false;
        }
        return true;
    }

    public void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    public char obtenerJugadorActual() {
        return jugadorActual;
    }

    public void reiniciar() {
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = '-';
        }
        jugadorActual = 'X';
    }
}
