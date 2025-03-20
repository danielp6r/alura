//Crie uma função que determine se um ano é bissexto
function ehBissexto(ano) {
    // Verifica se o ano é divisível por 4 e (não divisível por 100 ou divisível por 400)
    return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
}

console.log(ehBissexto(2024)); 
console.log(ehBissexto(2025)); 