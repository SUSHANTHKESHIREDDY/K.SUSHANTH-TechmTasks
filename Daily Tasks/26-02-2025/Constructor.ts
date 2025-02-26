class Student{
    name:string;
    roolnu:number |undefined;
    constructor(name:string,roolnu:number);
    constructor(name:string);
    constructor(name:string,roolnu ?:number){
        this.name=name;
        this.roolnu=roolnu;
    }
   
}
const st=new Student("k.s.r",27);
const st1=new Student("k.a.r");
console.log(st);
console.log(st1);