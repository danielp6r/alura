let totalGeral;
// Modificando o placeholder do input para 0
document.getElementById('quantidade').setAttribute('placeholder', '0');
// Desafio 3: Modificando o título do h1 com textContent
document.querySelector('.titulo').textContent = 'Carrinho de compras atualizado';

limpar();

function adicionar() {
    //recuperar valores: nome do produto, quantidade e valor
    let produto = document.getElementById('produto').value;
    let nomeProduto = produto.split('-')[0];
    let valorUnitario = produto.split('R$')[1];
    let quantidade = document.getElementById('quantidade').value;
    // Desafio 1: Validar se a quantidade é um número válido e maior que 0
    if (isNaN(quantidade) || quantidade <= 0) {
        alert("Digite uma quantidade válida maior que 0.");
        return;
    }
    //calcular o preço subtotal
    let preco = quantidade * valorUnitario;
    //adicionar ao carrinho
    let carrinho = document.getElementById('lista-produtos');
    carrinho.innerHTML += `<section class="carrinho__produtos" id="lista-produtos"><section class="carrinho__produtos__produto">
    <span class="texto-azul">${quantidade}x</span> ${nomeProduto} <span class="texto-azul">R$${preco}</span></
    section></section>`;
    //atualizar o valor total
    totalGeral += preco;
    let campoTotal = document.getElementById('valor-total');
    campoTotal.textContent = `R$ ${totalGeral}`;

    // Desafio 2: Exibir no console
    console.log(`Produto: ${nomeProduto}`);
    console.log(`Quantidade: ${quantidade}`);
    console.log(`Valor Unitário: R$ ${valorUnitario}`);
    console.log(`Preço Subtotal: R$ ${preco.toFixed(2)}`);

    document.getElementById('quantidade').value = 0;
    
}

function limpar() {
    totalGeral = 0;
    document.getElementById('lista-produtos').innerHTML = '';
    document.getElementById('valor-total').textContent = 'R$ 0'
}