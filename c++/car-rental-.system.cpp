#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <limits>

using namespace std;

class Car {
private:
    string carName;
    string carModel;
    bool booked;  // New attribute to indicate if the car is booked

public:
    // Constructor
    Car(string name, string model, bool isBooked = false) 
        : carName(name), carModel(model), booked(isBooked) {}

    // Getters
    string getCarName() const {
        return carName;
    }

    string getCarModel() const {
        return carModel;
    }

    bool isBooked() const {
        return booked;
    }

    // Mark car as booked
    void markAsBooked() {
        booked = true;
    }

    // Overload the << operator for file output
    friend ostream& operator<<(ostream& os, const Car& car) {
        os << car.carName << "," << car.carModel << "," << car.booked;
        return os;
    }

    // Overload the >> operator for file input
    friend istream& operator>>(istream& is, Car& car) {
        string bookedStr;
        getline(is, car.carName, ',');
        getline(is, car.carModel, ',');
        getline(is, bookedStr);
        car.booked = (bookedStr == "1");
        return is;
    }
};

#ifdef _WIN32
    #include <conio.h>
    #define CLEAR_SCREEN "cls"
#else
    #include <cstdio>
    #include <cstdlib>
    #define CLEAR_SCREEN "clear"
#endif

void clearScreen() {
#ifdef _WIN32
    system(CLEAR_SCREEN);
#else
    cout << "\033[2J\033[1;1H";
#endif
}

void waitForEnter() {
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    clearScreen();
}

class CarRentalSystem {
private:
    vector<Car> cars;
    string filename;

    void saveToFile() const {
        ofstream outFile(filename);
        for (const auto& car : cars) {
            outFile << car << endl;
        }
        outFile.close();
    }

    void loadFromFile() {
        ifstream inFile(filename);
        if (inFile) {
            Car car("", "");
            while (inFile >> car) {
                cars.push_back(car);
            }
            inFile.close();
        }
    }

public:
    CarRentalSystem(const string& file) : filename(file) {
        loadFromFile();
    }

    ~CarRentalSystem() {
        saveToFile();
    }

    void addCar(const Car& car) {
        cars.push_back(car);
        saveToFile();
    }

    void displayAvailableCars() const {
        cout << "Available Cars:" << endl;
        for (const auto& car : cars) {
            cout << "Name: " << car.getCarName() 
                 << ", Model: " << car.getCarModel()
                 << (car.isBooked() ? " (BOOKED)" : "") << endl;
        }
        cout<<"Enter to clear screen:";
        cin.ignore();
        cin.ignore();
        system("cls");    }

    void removeCar(const Car& car) {
        for (size_t i = 0; i < cars.size(); ++i) {
            if (cars[i].getCarName() == car.getCarName() && cars[i].getCarModel() == car.getCarModel()) {
                cars.erase(cars.begin() + i);
                saveToFile();
                break;
            }
        }
    }

    void bookCar(const Car& car) {
        bool carFound = false;
        for (size_t i = 0; i < cars.size(); ++i) {
            if (cars[i].getCarName() == car.getCarName() && cars[i].getCarModel() == car.getCarModel()) {
                carFound = true;
                if (!cars[i].isBooked()) {
                    cars[i].markAsBooked();
                    saveToFile();
                    cout << "Car booked successfully!\n\n\n\n" << endl;
                } else {
                    cout << "Car is already booked.\n\n\n\n" << endl;
                }
                break;
            }
        }
        if (!carFound) {
            cout << "Car not found.\n\n\n\n" << endl;
        }
    }
};

void displayMenu() {
    cout << "Menu:" << endl;
    cout << "1. Display available cars" << endl;
    cout << "2. Add a car" << endl;
    cout << "3. Remove a car" << endl;
    cout << "4. Book a car" << endl;
    cout << "5. Exit" << endl;
    cout << "Enter your choice: ";
}

int main() {
    CarRentalSystem rentalSystem("cars.txt");

    // Sample cars with realistic names
    Car car1("Toyota Camry", "2020");
    Car car2("Honda Civic", "2019");

    rentalSystem.addCar(car1);
    rentalSystem.addCar(car2);

    int choice;
    do {
        displayMenu();
        cin >> choice;

        switch (choice) {
            case 1:
                rentalSystem.displayAvailableCars();
                cout << "\n\n\n\n";
                break;
            case 2: {
                string name, model;
                cout << "Enter car name: ";
                cin >> name;
                cout << "Enter car model: ";
                cin >> model;
                Car newCar(name, model);
                rentalSystem.addCar(newCar);
                cout << "Car added successfully!\n\n\n\n" << endl;
                break;
            }
            case 3: {
                string name, model;
                cout << "Enter car name: ";
                cin >> name;
                cout << "Enter car model: ";
                cin >> model;
                Car carToRemove(name, model);
                rentalSystem.removeCar(carToRemove);
                cout << "Car removed successfully!\n\n\n\n" << endl;
                break;
            }
            case 4: {
                string name, model;
                cout << "Enter car name: ";
                cin >> name;
                cout << "Enter car model: ";
                cin >> model;
                Car carToBook(name, model);
                rentalSystem.bookCar(carToBook);
                break;
            }
            case 5:
                cout << "Exiting..." << endl;
                cout << "Press Enter to clear the screen...";
                cin.ignore();
                waitForEnter();
                break;
            default:
                cout << "Invalid choice. Try again." << endl;
        }

    } while (choice != 5);

    return 0;
}
