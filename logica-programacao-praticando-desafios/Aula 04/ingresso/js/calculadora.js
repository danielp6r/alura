function calcular(operacao, a, b) {
    let resultado;

    if (operacao === 'somar') {
        resultado = somar(a, b);
    } else if (operacao === 'subtrair') {
        resultado = subtrair(a, b);
    } else if (operacao === 'multiplicar') {
        resultado = multiplicar(a, b);
    } else if (operacao === 'dividir') {
        resultado = dividir(a, b);
    } else {
        return "Operação inválida!";
    }

    return resultado;
}

function somar(a, b) {
    return a + b;
}

function subtrair(a, b) {
    return a - b;
}

function multiplicar(a, b) {
    return a * b;
}

function dividir(a, b) {
    if (b == 0) {
        return 'Erro: Impossível dividir por 0.'
    } else {
        return a / b;
    }
}

console.log(calcular('somar', 1, 1));
console.log(calcular('subtrair', 10, 1));
console.log(calcular('multiplicar', 5, 5));
console.log(calcular('dividir', 16, 4))
console.log(calcular('dividir', 1, 0));