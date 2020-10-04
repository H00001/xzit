const add = (x,y) => x + y + this.k;
add.prototype.bind0 = (v) => {
    this = v
}
let dt = {k:5};
console.log(add.bind0(dt).add(1,2))