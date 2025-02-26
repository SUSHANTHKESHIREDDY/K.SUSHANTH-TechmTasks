class Animal{
    name:string;
    specie:string;
    constructor(name:string,specie:string){
        this.name=name;
        this.specie=specie;
    }
    displayanimal():void{
        console.log(`Name: ${this.name}, Species: ${this.specie}`);
    }
}
class tiger extends Animal{
    constructor(name:string){
        super(name,"Tiger");
    }
    roar(): void {
        console.log(`${this.name} the tiger is roaring!`);
      }
}
const tiger1 = new tiger("Rajah");
tiger1.displayanimal(); 
tiger1.roar();