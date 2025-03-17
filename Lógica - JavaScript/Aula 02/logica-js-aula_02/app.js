alert('Boas vindas ao jogo do número secreto');
let numeroSecreto = 2;
console.log('Número secreto: ' + numeroSecreto);
let chute = prompt('Escolha um número entre 1 e 10');
console.log('chute: ' + chute)
console.log('Resultado da comparação:', chute == numeroSecreto);

//Se chute for igual ao número secreto
if (chute == numeroSecreto) {
    alert(`Correto! Você descobriu o número secreto ${numeroSecreto}`);
} else {
    alert('Errou!' + ' Você escolheu ' + chute + '. O número secreto era ' + numeroSecreto)
}