class Bus{
    make:string;
    model:string;
    year:number;
    constructor(make:string,model:string,year:number){
        this.make=make;
        this.model=model;
        this.year=year;
    }
    displaybusinfo():void{
        console.log(`Make: ${this.make}, Model: ${this.model}, Year: ${this.year}`);
    }
}
    const mybus=new Bus("Volvo","B9r",2022);
    mybus.displaybusinfo();

