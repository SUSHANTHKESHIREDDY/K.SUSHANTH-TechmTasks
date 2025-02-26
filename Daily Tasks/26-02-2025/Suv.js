var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var car = /** @class */ (function () {
    function car(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    car.prototype.start = function () {
        console.log("The ".concat(this.year, " ").concat(this.make, " ").concat(this.model, " is starting."));
    };
    return car;
}());
var Suv = /** @class */ (function (_super) {
    __extends(Suv, _super);
    function Suv(make, model, year, offroad) {
        var _this = _super.call(this, make, model, year) || this;
        _this.offroad = _this.offroad;
        return _this;
    }
    Suv.prototype.toggleoffroad = function () {
        this.offroad = !this.offroad;
        if (this.offroad) {
            console.log("The ".concat(this.make, " ").concat(this.model, " is now off-road capable."));
        }
        else {
            console.log("The ".concat(this.make, " ").concat(this.model, " is no longer off-road capable."));
        }
    };
    Suv.prototype.display = function () {
        console.log("Off-road capable: ".concat(this.offroad));
    };
    return Suv;
}(car));
var mySUV = new Suv("Jeep", "Wrangler", 2023, true);
mySUV.display();
mySUV.toggleoffroad();
