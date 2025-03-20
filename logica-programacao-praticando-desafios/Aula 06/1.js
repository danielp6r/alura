//Crie uma função que valide se um número é positivo, negativo ou zero.
function numero(x){
    if (x == 0) {
        return 'Zero';
    } else if (x > 0) {
        return 'Positivo';
    } else {
        return 'Negativo';
    }
}

console.log(numero(-1));
console.log(numero(0));
console.log(numero(1));