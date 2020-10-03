// This is a function named `f` with 1 parameter. 
// `x` is the independent variable. The function `
// f` calculates the power of a number.
const f = x => x * x;
console.log("result of power of 2 :" + f(2));
// This is a function named `g` with 2 parameters.
//  `x` and `z` is the independent variables. The 
// function `g` calculates the sum of two numbers.
const g = (x, z) => x + z;
console.log(g(1, 2));
// what is curring?
// The function of `curry` can make a new function
// . The new function takes one fewer argument tha
// -n the old one, but you need to pass this param
// -eter in advance.
/**
 * we can use function `g` like this:
 * ```console.log(g(1,2))```
 * to print the result of function `g`.
 *  This statement prints out 1+2.
 * At this point, we can use the curry function to
 * keep the first argument to 1.
**/
const curry = (fn, p1) => (...p) => fn(p1, ...p);
const add1 = curry(g, 1);
console.log(add1(3));
/**
 * add1 is a `curried function`. we can use it to 
 * add another value. 
**/

// higher example:
// calcluator distance
const l = (x, y, z, x1, y1, z1) =>
    Math.sqrt(
        Math.pow((x - x1), 2) +
        Math.pow((y - y1), 2) +
        Math.pow((z - z1), 2)
    );
console.log(l(0, 0, 0, 1, 1, 1));
// use currying.
const l_center = curry(curry(curry(l, 0), 0), 0);
console.log(l_center(1, 1, 1));
// However, this is a very complex way to use
// it. We can write a function that curry
// multiple variables.
const curry_0 = (fn, ...p1) => 
	(...p) => fn(...p1, ...p);
// Let us give it a try.
const l_center_1 = curry_0(l, 0, 0, 0);
console.log(l_center_1(1, 1, 1));
// The higher currily function logic is to return 
// a function. This function makes a judgment when
// called, if the call parameter is greater than 
// or equal to the required parameter, then it cal
// -ls fn and returns. If not all of these argumen
// -ts are passed in, they need to be cached in th
// -e function
const curry_1 = (fn, len) => (...rest) =>
    rest.length >= len ? fn(...rest) : 
    curry_1((...a) => fn(...rest, ...a), 
    len - rest.length);


const curry_high = fn => curry_1(fn, fn.length);

// call function `curry_hight` to curry function
console.log(curry_high(l)(0, 1, 2, 4, 5, 6))
console.log(curry_high(l)(0, 1)(2, 4, 5, 6))
console.log(curry_high(l)(0, 1, 2)(4, 5, 6))



const _ = {}

// curry by mask
// This is a curry function that input unset variables by maskcode `_`.
const curry_mask = (fn, ...p) => curry_1((...nv) =>
    fn(...p.map(v => v === _ ? nv.shift() : v)), p.filter(e => e !== _).length);

console.log(curry_mask(l, _, 1, 2, _, _, 5)(2)(3, 4))
