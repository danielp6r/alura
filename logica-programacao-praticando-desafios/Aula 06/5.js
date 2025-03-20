//Implemente uma função que calcule a média de dois números, interrompendo a execução se algum dos números não for válido.
function calcularMedia(num1, num2) {
    
    if (isNaN(num1) || isNaN(num2)) {
        console.log('Erro: Ambos os valores devem ser números!');
        return; 
    }

    let media = (num1 + num2) / 2;
    console.log(`A média é: ${media}`);
}


calcularMedia(10, 40);  
calcularMedia(20, -10);
let x;
calcularMedia(10, x);