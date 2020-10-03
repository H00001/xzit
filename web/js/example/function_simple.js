// function 1
// we have a function like this
function add(x, y) {
    return x + y;
}
// function 2
// now let us simple it
const add1 = function(x, y) {
    return x + y
};

// function 3
const add2 = (x, y) => {
    return x + y
};

// function 4
// The process of 3 to 4 is that if we have
// one experssion and the experssion is res
// -ult.
const add3 = (x, y) => x + y

function fun0() {
    return function(x) {
        return function(y) {
            return x + y;
        }
    }
}
// simplify it
const fun1 = () => x => y => x + y;
// call it
console.log(fun1()(1)(10))