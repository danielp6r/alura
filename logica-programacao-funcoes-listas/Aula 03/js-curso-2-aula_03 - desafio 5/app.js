function areaEPerimetroCircular(raio) {
    let pi = 3.14;
    let area = pi * raio ** 2;
    let perimetro = 2 * raio * pi;

    alert(`Área = ${area} m²`);
    alert(`Perímetro = ${perimetro.toFixed(1)} m`);
}

areaEPerimetroCircular(10);