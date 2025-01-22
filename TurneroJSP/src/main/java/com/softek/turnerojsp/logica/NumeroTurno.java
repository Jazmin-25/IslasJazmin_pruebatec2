
package com.softek.turnerojsp.logica;


class NumeroTurno {
    private static long contador = 1; // Contador incremental de  turnos
    private long valor;
    
    //constructor vacio

    public NumeroTurno() {
    }

    public NumeroTurno(long valor) {
        this.valor = valor;
    }

    public static long getContador() {
        return contador;
    }

    public static void setContador(long contador) {
        NumeroTurno.contador = contador;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
    
    // Método para crear un nuevo turno incrementando el contador
    public static NumeroTurno nuevoTurno() {
        return new NumeroTurno(contador++);
    }
    
    //tostring

    @Override
    public String toString() {
        //return "NumeroTurno{" + "valor=" + valor + '}';
        return "Turno_" + valor;
    }//NumeroTurno 
    
    
}
