
const forEach = (l, fn) => {
    for (const key in l) {
        fn(key, l[key])
    }
}
const map = (m, fn) => {
    for (const key in m) {
        m[key] = fn(key, m[key])
    }
    return m
}

const filter = (m, fn) => {
    let r = []
    for (const key in m) {
        if (fn(key, m[key])) {
            r.push(m[key])
        }
    }
    return r
}

const reduce = (m,fn) => {
    // please complement it!
}

forEach([1, 2, 3, 4, 5], v => {
    console.log(v)
})
console.log(map([1, 2, 3, 4, 5], (_v, e) => e + 1))
console.log(filter([1, 2, 3, 4, 5], (_v, e) => e - 1 == 0))