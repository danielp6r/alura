function tabuada(x){
    let y = 1;
    while (y <= 10){
        console.log(`${y} x ${x} = ${y * x}`);
        alert((`${y} x ${x} = ${y * x}`));
        y++;
    }
}

tabuada(5);