function palindromo(texto) {
    let lista = [];
    
    //Salva o texto em ordem invertida em uma lista.
    for (let i = 0; i < texto.length; i++){
        lista.push(texto[texto.length - i - 1]);
    }

    let textoInvertido = '';

    for (let i = 0; i < texto.length; i++){
        textoInvertido += lista[i];
    }

    console.log(texto === textoInvertido);
}

palindromo('teste');
palindromo('osso')