class car{
    make:string;
    model:string;
    year:number
    constructor(make :string,model:string,year:number){
        this.make=make;
        this.model=model;
        this.year=year;
    }
    start() :void{
        console.log(`The ${this.year} ${this.make} ${this.model} is starting.`);
    }
}
    class Suv extends car{
        offroad:boolean;
        constructor(make:string,model:string,year:number,offroad:boolean){
            super(make,model,year);
            this.offroad=this.offroad;
        }
        toggleoffroad():void{
            this.offroad=!this.offroad;
            if(this.offroad){
                console.log(`The ${this.make} ${this.model} is now off-road capable.`);
            }
            else {
                console.log(`The ${this.make} ${this.model} is no longer off-road capable.`);
              }
        }
        display():void{
            console.log(`Off-road capable: ${this.offroad}`);
        }
    }
    const mySUV = new Suv("Jeep", "Wrangler", 2023, true);
    mySUV.display();
mySUV.toggleoffroad();

