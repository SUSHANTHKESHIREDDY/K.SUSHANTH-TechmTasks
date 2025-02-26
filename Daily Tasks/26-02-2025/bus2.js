var Bus = /** @class */ (function () {
    function Bus(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    Bus.prototype.start = function () {
        console.log("The ".concat(this.year, " ").concat(this.make, " ").concat(this.model, " bus is starting."));
    };
    return Bus;
}());
var myBus = new Bus("Volvo", "B9R", 2022);
myBus.start();
