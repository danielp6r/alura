//Implemente uma função que receba um array e um elemento, e retorne se o elemento está presente no array.

function estaPresente(lista, elemento) {
    return lista.includes(elemento);
}

let minhaLista = [1, 2, 3];

console.log(estaPresente(minhaLista, 1));
console.log(estaPresente(minhaLista, 0));