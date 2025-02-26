var Engine = /** @class */ (function () {
    function Engine(horsepower, fueltype) {
        this.horsepower = horsepower;
        this.fueltype = fueltype;
    }
    Engine.prototype.displayEnginedetails = function () {
        console.log("Engine: ".concat(this.horsepower, " HP, ").concat(this.fueltype));
    };
    return Engine;
}());
var car = /** @class */ (function () {
    function car(make, model, year, engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }
    car.prototype.start = function () {
        console.log("The ".concat(this.year, " ").concat(this.make, " ").concat(this.model, " is starting."));
    };
    car.prototype.printcar = function () {
        console.log("Car: ".concat(this.year, " ").concat(this.make, " ").concat(this.model));
        this.engine.displayEnginedetails();
    };
    return car;
}());
var myEngine = new Engine(250, "Gasoline");
var myCar = new car("Toyota", "Camry", 2022, myEngine);
myCar.start();
myCar.printcar();
