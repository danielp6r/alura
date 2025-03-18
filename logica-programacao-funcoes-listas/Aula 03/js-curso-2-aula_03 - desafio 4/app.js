function areaMaisPerimetro (altura, largura){
    let area = altura * largura;
    let perimetro = 2 * (altura + largura)

    alert(`Área da sala: ${area} m²`);
    alert(`Perímetro da sala: ${perimetro} m`);
}

areaMaisPerimetro(5, 8);