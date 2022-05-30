
class Car:
    'This class represent a Car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    # Accelerate method
    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

        # Stop method
    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

# Creating 3 objects of the Car class
car1 = Car("Maruti", "Zen", "2008", "manual", "Silver")
car2 = Car("Hyundai", "i20", "2020", "automatic", "Red")
car3 = Car("Honda", "Civic", "2018", "automatic", "Black")

# Calling the class methods
car1.accelerate()
car1.stop()


