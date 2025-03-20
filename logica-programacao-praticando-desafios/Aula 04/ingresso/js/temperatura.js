//Usar C para célsius e F para Fahrenheit
function conversorTemperatura(temperatura, escalaAtual) {
    let resultado;

    if (escalaAtual === 'C' || escalaAtual === 'c') {
        // Converte de Celsius para Fahrenheit
        resultado = (temperatura * 9/5) + 32;
        return `${temperatura}°C é igual a ${resultado}°F`;
    } else if (escalaAtual === 'F' || escalaAtual === 'f') {
        // Converte de Fahrenheit para Celsius
        resultado = (temperatura - 32) * 5/9;
        return `${temperatura}°F é igual a ${resultado}°C`;
    } else {
        return "Escala inválida. Use 'C' para Celsius ou 'F' para Fahrenheit.";
    }
}

console.log(conversorTemperatura(25, 'C'));
console.log(conversorTemperatura(77, 'f'));