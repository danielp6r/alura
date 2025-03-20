//Adicione os números 1,2,3 em uma variável chamada minhaLista e armazene os números 4, 5 e 6 separadamente em outra variável. Use o método concat() para combinar as sequências de valores em uma nova lista chamadanovaLista. Imprima novaLista no console.

let minhaLista = [1, 2, 3];
let outraLista = [4, 4, 5, 6];

let novaLista = minhaLista.concat(outraLista);
console.log(`Lista concatenada: ${novaLista}`);

//Remova o último elemento de novaLista. Imprima novaLista após a remoção.
novaLista.pop();
console.log(`Último item removido: ${novaLista}`);

//Utilize o algoritmo de Fisher-Yates (também conhecido como Knuth Shuffle) para embaralhar os elementos em novaLista. 
function embaralha(lista) {

    for (let indice = lista.length; indice; indice--) {

        const indiceAleatorio = Math.floor(Math.random() * indice);

        // atribuição via destructuring
        [lista[indice - 1], lista[indiceAleatorio]] = 
            [lista[indiceAleatorio], lista[indice - 1]];
    }
}

embaralha(novaLista);
console.log(`Lista embaralhada: ${novaLista}`);

// Crie uma função chamada removerDuplicatas que aceita um array como parâmetro e retorna um novo array sem elementos duplicados.
function removerDuplicatas(array) {
    let listaSemDuplicatas = [];
    for (let i = 0; i < array.length; i++) {
        if (!listaSemDuplicatas.includes(array[i])) {
            listaSemDuplicatas.push(array[i]);
        }
    }
    return listaSemDuplicatas;
}

// Teste a função com novaLista
let listaSemDuplicatas = removerDuplicatas(novaLista);
console.log(`Lista sem duplicatas: ${listaSemDuplicatas}`);