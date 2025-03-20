function ordenar(n1,n2,n3){
    let lista = [n1,n2,n3];

    for (let i = 0; i < 3; i++){
        for (let j = i + 1; j < 3; j++){
            if (lista[i] > lista[j]){
                let troca = lista[i];
                lista[i] = lista[j];
                lista[j] = troca;
            }
        }
    }

    return lista;
}

console.log(ordenar(9,1,5));