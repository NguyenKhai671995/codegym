// happy coding 👻

function fiabonacci(num: number):number {
    if (num == 0){
        return 0;
    }
    if (num == 1){
        return 1;
    }
    return fiabonacci(num - 1)+ fiabonacci(num -2);
}

let count:number = 0;
let i:number = 0;
let sum:number = 0

while (count <= 5){
    console.log(fiabonacci(i) + "");
    sum += fiabonacci(i);
    i++;
    count++
}
console.log(sum);
