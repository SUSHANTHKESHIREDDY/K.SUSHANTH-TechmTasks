var Bus = /** @class */ (function () {
    function Bus(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    Bus.prototype.displaybusinfo = function () {
        console.log("Make: ".concat(this.make, ", Model: ").concat(this.model, ", Year: ").concat(this.year));
    };
    return Bus;
}());
var mybus = new Bus("Volvo", "B9r", 2022);
mybus.displaybusinfo();
