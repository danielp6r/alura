let titulo = document.querySelector('h1');
titulo.innerHTML = 'Hora do Desafio';

function verificarClick(){
    console.log('O botão foi clicado.');
}

function alertar(){
    alert('Eu amo JS.');
}

function cidade(){
    let nomeCidade = prompt('Digite o nome de uma cidade:');
    alert(`Estive em ${nomeCidade} e lembrei de você.`); 
}

function soma(){
    let num1 = parseInt(prompt('Digite o primeiro Número inteiro:'));
    let num2 = parseInt(prompt('Digite o segundo Número inteiro:'));
    let soma = num1 + num2;
    alert(`A soma de ${num1} e ${num2} é igual a ${soma}`)
}