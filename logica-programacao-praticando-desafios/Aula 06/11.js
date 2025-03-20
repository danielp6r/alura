//Crie uma função que receba um array de números e retorne a soma dos elementos pares e o produto dos elementos ímpares.
function somaProduto(lista) {
    let soma = 0;
    let produto = 1;
    for (let i = 0; i < lista.length; i++) {
        if (lista[i] % 2 == 0) {
            soma += lista[i];
        } else {
            produto *= lista[i];
        }
    }
    return console.log(`Soma dos pares = ${soma} \n Produto dos ímpares = ${produto}`);
}

minhaLista = [1, 2, 3, 4, 5, 6];
somaProduto(minhaLista);