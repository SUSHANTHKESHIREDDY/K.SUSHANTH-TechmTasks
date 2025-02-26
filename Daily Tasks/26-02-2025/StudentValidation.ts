class Student{
    name:string;
    age:number;
    constructor(name:string,age:number){
        this.name=name;
        if(age>0){
            this.age=age;
        }
        else{
            this.age=0;

        }
    }
    displayStudentInfo(): void {
        console.log(`Name: ${this.name}, Age: ${this.age}`);
      }
}
const student1 = new Student("Alice", 20);
student1.displayStudentInfo();