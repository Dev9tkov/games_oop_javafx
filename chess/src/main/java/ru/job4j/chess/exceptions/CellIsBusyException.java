package ru.job4j.chess.exceptions;


public class CellIsBusyException extends RuntimeException{
    private CellIsBusyException() {
    }

    public CellIsBusyException(String cie) {
        super(cie);
    }
}
