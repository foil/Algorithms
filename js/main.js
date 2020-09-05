function countTriplets(arr, r) {
    if (arr.length < 3)
        return 0;
    const m = new Map();
    const l = new Array(arr.length);
    m.set(arr[arr.length - 1], 1);
    for (let i = arr.length - 2; i > 0; i --) {
        const n = arr[i];
        const t = n * r;
        if (m.has(t))   l[i] = m.get(t);
        if (m.has(n))   m.set(n, m.get(n) + 1);
        else    m.set(n, 1);
    }
    console.log(l);
    m.clear();
    m.set(arr[0], 1);
    for (let i = 1; i < arr.length - 1; i ++) {
        const n = arr[i];
        const t = n / r;
        if (m.has(t) && l[i])   l[i] *= m.get(t);
        if (m.has(n))   m.set(n, m.get(n) + 1);
        else    m.set(n, 1);
    }

    console.log(l);
    return l.reduce((cur, acc) => cur + acc, 0);
}

function main() {
    // const arr = new Array(100);
    // arr.fill(1);
    const arr = [1, 100, 10000, 100000, 1000000, 1000000000, 1000000000,
        10000000, 100000, 100000000, 1000, 100000000, 1000, 1000, 10000000, 10000, 100, 1000, 1]
    console.log(countTriplets(arr, 1));
}

main();