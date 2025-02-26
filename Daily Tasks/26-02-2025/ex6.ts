let unknownValue: any = "123";
let numericValue: number = (unknownValue as string).length;
console.log(numericValue);

let stringnum:string ="456"
let nm:number =parseInt(stringnum);
console.log("parseInt() Result:", nm);
let numberToString: number = 1234;
let convertedString: string = numberToString.toString();
console.log("toString() Result:", convertedString);

let booleanToString: boolean = true;
let convertedBooleanString: string = booleanToString.toString();
console.log("boolean to string:", convertedBooleanString);