function fatorial(x){
    resultado = 1;
    while (x > 0) {
        resultado = resultado * x;
        x--;
    }
    return resultado;
}

alert(fatorial(5));