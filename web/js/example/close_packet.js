// 1.
const Once = (fn) => {
    var h = false;
    return (...param) => {
        if (!h) {
            h = true
            return fn(...param)
        }
    }
}
const f = (x, y) => x + y;
const on = Once(f);

console.log(on(1, 3));
console.log(on(1, 3));
// 2.
const tran_param = (fn, ...p) => () => fn(...p)
const fun0 = tran_param(console.log, 1);
setTimeout(fun0, 1000);