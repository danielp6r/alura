function imc(altura, peso) {
    return peso / (altura ** 2);
}

alert(`Índice IMC = ${imc(1.78, 73)} `);