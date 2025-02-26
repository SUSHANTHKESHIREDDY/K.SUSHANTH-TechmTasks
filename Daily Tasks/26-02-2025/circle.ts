class Shape{
    color:string;
    constructor(color:string){
        this.color=color;
    }
    displaycolor():void{
        console.log(`Shape color:${this.color}`);
    }
}
class Circle extends Shape{
    radius:number;
    constructor(radius:number,color:string){
        super(color);
        this.radius=radius;
    }
    CalculateArea():number{
        return Math.PI*this.radius*this.radius;
    }
    displaycircledetails():void{
        console.log(`radius:${this.radius}`);
        console.log(`area:${this.CalculateArea()}`);
    }
}
const my=new Circle(5,"red");
my.displaycircledetails();
