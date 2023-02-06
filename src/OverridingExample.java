public class OverridingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.print();
        Car car = new Car();
        car.print();
    }
}

/*
 this class should have been abstract!!
 but we need to instantiate it here so didn't make it abstract
 */
class Vehicle {
    protected void print(){
        System.out.println("this is a vehicle");
    }
}
class Car extends Vehicle{
    @Override
    public void print() {
        System.out.println("this is a car");
    }
}
