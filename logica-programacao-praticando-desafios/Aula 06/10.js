//Desenvolva uma função que receba um array de objetos representando estudantes de um curso e um objeto que representa um estudante procurado. Depois retorne se o objeto está presente no array.

function estaPresente(estudantes, estudanteProcurado) {
    
    var nomes = [];

    for (var i = 0; i < estudantes.length; i++) {
        nomes.push(estudantes[i].nome);
    }

    return nomes.includes(estudanteProcurado.nome);
}

let estudantes = [{ nome: "Daniel" }, { nome: "Karine" }];

console.log(estaPresente(estudantes, { nome: "Daniel" })); 
console.log(estaPresente(estudantes, { nome: "Karine" }));
console.log(estaPresente(estudantes, { nome: "asodkoaskd" }));