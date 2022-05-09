import constant.DriverQualification;
import constant.VehicleType;
import dao.*;
import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Update company
        Company company = CompanyDAO.getCompany(1);
        Company company3 = new Company(1, "Company3");
        CompanyDAO.saveCompany(company3);
//        company.setName("Euroway");
//        CompanyDAO.saveOrUpdateCompany(company);
//        System.out.println(company);


        System.out.println("---------------------------Company's clients---------------------------");

//        company.getClients().stream().forEach(System.out::println);

        CompanyDAO.getCompanyClients(1).stream().forEach(System.out::println); //prints also company.toString()

//        CompanyDAO.getCompanyClientsDTO(1).stream().forEach(System.out::println); //doesn't print company details


        System.out.println("---------------------------------- Delete company with employees ----------------------------------");
        //Company company2 = CompanyDAO.getCompany(2);
        //CompanyDAO.deleteCompany(company2);

        System.out.println("------------------------------------Create clients------------------------------------");
//        Client client6 = new Client(1, "Simon", "Williams", true, company);
//        ClientDAO.saveClient(client6);
//        Client client = ClientDAO.getClient(15);
//        System.out.println(client);


        System.out.println("------------------------------------Delete clients------------------------------------");
//        ClientDAO.deleteClient(client);
//        System.out.println(client);


        System.out.println("------------------------------------Get vehicles------------------------------------");
        CompanyDAO.getCompanyVehicles(1).stream().forEach(System.out::println);

        System.out.println("------------------------------------Delete vehicles------------------------------------");
//        List<Vehicle> vehicleList = CompanyDAO.getCompanyVehicles(1);
//        VehicleDAO.deleteVehicle(vehicleList.get(1));



        System.out.println("------------------------------------Get drivers------------------------------------");
        CompanyDAO.getCompanyDrivers(1).stream().forEach(System.out::println);


        System.out.println("------------------------------------Edit/Update drivers------------------------------------");
//        Driver driver = CompanyDAO.getCompanyDrivers(1).get(1);
//        driver.setSalary(3000);
//        DriverDAO.saveOrUpdateDriver(driver);
//        System.out.println(driver);


        System.out.println("------------------------------------Save trip data------------------------------------");
//        Trip trip = new Trip();
//        trip.setId(1);
//        trip.setOriginPoint("Los Angeles");
//        trip.setDestinationPoint("Atlantic City");
//        trip.setDepartureDate(LocalDate.of(2021, 12, 01));
//        trip.setArrivalDate(LocalDate.of(2021,12,15));
//        trip.setPrice(7688);
//        TripDAO.saveTrip(trip);


        System.out.println("------------------------------------Sort companies by name------------------------------------");
//        List<Company> sortedCompany = CompanyDAO.companiesByNameAsc();
//        sortedCompany.stream().forEach(System.out::println);

        System.out.println("------------------------------------Sort drivers by salary------------------------------------");
//        List<Driver> sortedDrivers = DriverDAO.driversBySalaryAsc();
//        sortedDrivers.stream().forEach(System.out::println);

        System.out.println("------------------------------------Sort trips by destination------------------------------------");
//        List<Trip> sortedTrips = TripDAO.tripsWithDestinationEqualTo("Place B");
//        sortedTrips.stream().forEach(System.out::println);


        //DATA INITIALIZE

//        //Create companies
//        Company company1 = new Company(1, "Company1");
//        Company company2 = new Company(1,"Company2");
//        CompanyDAO.saveCompany(company1);
//        CompanyDAO.saveCompany(company2);
//
//        //Create clients
//        Client client1 = new Client(1, "Aleks", "Aleksiev", true, company1);
//        Client client2 = new Client(1, "Boris", "Bonev", true, company2);
//        Client client3 = new Client(1, "Chuck", "Christopher", false, company1);
//        Client client4 = new Client(1, "Daryl", "Denvers", false, company2);
//        ClientDAO.saveClient(client1);
//        ClientDAO.saveClient(client2);
//        ClientDAO.saveClient(client3);
//        ClientDAO.saveClient(client4);

//        //Set clientLists
//        List<Client> clientList1 = Arrays.asList(client1, client3);
//        List<Client> clientList2 = Arrays.asList(client2, client4);

//        company1.setClients(clientList1);
//        company2.setClients(clientList2);

//        System.out.println("----------------------------------Print clients----------------------------------");
//        company1.getClients().stream().forEach(System.out::println);

//        ClientDAO.saveClients(clientList1);  //All the clients in the list will save a second time into the DB
//        ClientDAO.saveClients(clientList2);
//
//        //Create drivers
//        Driver driver1 = new Driver(1, "Andrey", "Angelov", DriverQualification.MANY_PEOPLE, 2899, company1);
//        Driver driver2 = new Driver(1, "Boris", "Borislavov", DriverQualification.DANGEROUS_LOADS, 3899, company1);
//        Driver driver3 = new Driver(1, "Ceco", "Cezarov", DriverQualification.MANY_PEOPLE, 3099, company2);
//        Driver driver4 = new Driver(1, "Denis", "Denislavov", DriverQualification.DANGEROUS_LOADS, 3999, company2);
//        DriverDAO.saveDriver(driver1);
//        DriverDAO.saveDriver(driver2);
//        DriverDAO.saveDriver(driver3);
//        DriverDAO.saveDriver(driver4);
//
//        //Create driverLists
//        List<Driver> driverList1 = Arrays.asList(driver1, driver2);
//        List<Driver> driverList2 = Arrays.asList(driver3, driver4);
//        company1.setDrivers(driverList1);
//
//        System.out.println("---------------------------------------------Drivers---------------------------------------------");
//        System.out.println(company1.getDrivers().get(1));

//        DriverDAO.saveDrivers (driverList1);
//        DriverDAO.saveDrivers (driverList2);

//        //Create vehicles
//        Vehicle vehicle1 = new Vehicle(1,"CB1234AB", VehicleType.BUS, company1);
//        Vehicle vehicle2 = new Vehicle(1,"CB1234AC", VehicleType.CISTERN, company1);
//        Vehicle vehicle3 = new Vehicle(1,"CB1234AH", VehicleType.TRUCK, company1);
//        Vehicle vehicle4 = new Vehicle(1,"CB4321AB", VehicleType.BUS, company2);
//        Vehicle vehicle5 = new Vehicle(1,"CB4321AC", VehicleType.CISTERN, company2);
//        Vehicle vehicle6 = new Vehicle(1,"CB4321AH", VehicleType.TRUCK, company2);
//        VehicleDAO.saveVehicle(vehicle1);
//        VehicleDAO.saveVehicle(vehicle2);
//        VehicleDAO.saveVehicle(vehicle3);
//        VehicleDAO.saveVehicle(vehicle4);
//        VehicleDAO.saveVehicle(vehicle5);
//        VehicleDAO.saveVehicle(vehicle6);
//
//        //Create vehicleLists
//        List<Vehicle> vehicleList1 = Arrays.asList(vehicle1, vehicle2, vehicle3);
//        List<Vehicle> vehicleList2 = Arrays.asList(vehicle4, vehicle5, vehicle6);
//        VehicleDAO.saveVehicles(vehicleList1);
//        VehicleDAO.saveVehicles(vehicleList2);
//
//        //Create Lists
//        List<Cargo> cargoList1 = new ArrayList<>(); //normal load
//        List<Cargo> cargoList2 = new ArrayList<>(); //normal load
//        List<Cargo> cargoList3 = new ArrayList<>(); //special load
//        List<Cargo> cargoList4 = new ArrayList<>(); //special load
//
//        //Create passengerLists
//        List<Passenger> passengerList1 = new ArrayList<>();
//        List<Passenger> passengerList2 = new ArrayList<>();
//
//        //Create trips
//        Trip trip1 = new Trip(1, "Place A", "Place B",
//                LocalDate.of(2021, 9, 20), LocalDate.of(2021, 9, 23),
//                passengerList1, 6700);
//        Trip trip2 = new Trip(1, "Place C", "Place D",
//                LocalDate.of(2021, 10, 20), LocalDate.of(2021, 10, 23),
//                passengerList2, 2600);
//        Trip trip3 = new Trip(1, "Place E", "Place F",
//                LocalDate.of(2021, 7, 20), LocalDate.of(2021, 7, 27),
//                cargoList1, 15000, 7000);
//        Trip trip4 = new Trip(1, "Place G", "Place H",
//                LocalDate.of(2021, 9, 20), LocalDate.of(2021, 9, 27),
//                cargoList2, 16000, 8000);
//        Trip trip5 = new Trip(1, "Place I", "Place J",
//                LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 27),
//                cargoList1, 17000, 9000);
//        Trip trip6 = new Trip(1, "Place K", "Place L",
//                LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 27),
//                cargoList2, 18000, 10000);
//        TripDAO.saveTrip(trip1);
//        TripDAO.saveTrip(trip2);
//        TripDAO.saveTrip(trip3);
//        TripDAO.saveTrip(trip4);
//        TripDAO.saveTrip(trip5);
//        TripDAO.saveTrip(trip6);

//        //Create tripLists
//        List<Trip> tripList1 = Arrays.asList(trip1, trip3, trip5);
//        List<Trip> tripList2 = Arrays.asList(trip2, trip4, trip6);
//        TripDAO.saveTrips(tripList1);
//        TripDAO.saveTrips(tripList2);

//        //Create cargo
//        Cargo merch1 = new Cargo(1, "Carrots", trip3);
//        Cargo merch5 = new Cargo(1, "Onions", trip3);
//        Cargo merch2 = new Cargo(1, "Watermelons", trip4);
//        Cargo merch6 = new Cargo(1, "Oranges", trip4);
//        Cargo merch3 = new Cargo(1, "Uranium", trip5);
//        Cargo merch4 = new Cargo(1, "Liquid Nitrogen", trip6);
//        CargoDAO.saveCargo(merch1);
//        CargoDAO.saveCargo(merch5);
//        CargoDAO.saveCargo(merch2);
//        CargoDAO.saveCargo(merch6);
//        CargoDAO.saveCargo(merch3);
//        CargoDAO.saveCargo(merch4);

//        //Create passengers
//        Passenger passenger1 = new Passenger(1, "A", trip1);
//        PassengerDAO.savePassenger(passenger1);
//        passengerList1.add(passenger1);
//        Passenger passenger2 = new Passenger(1, "B", trip1);
//        PassengerDAO.savePassenger(passenger2);
//        passengerList1.add(passenger2);
//        Passenger passenger3 = new Passenger(1, "C", trip1);
//        PassengerDAO.savePassenger(passenger3);
//        passengerList1.add(passenger3);
//        Passenger passenger4 = new Passenger(1, "D", trip1);
//        PassengerDAO.savePassenger(passenger4);
//        passengerList1.add(passenger4);
//        Passenger passenger5 = new Passenger(1, "E", trip1);
//        PassengerDAO.savePassenger(passenger5);
//        passengerList1.add(passenger5);
//        Passenger passenger6 = new Passenger(1, "F", trip1);
//        PassengerDAO.savePassenger(passenger6);
//        passengerList1.add(passenger6);
//        Passenger passenger7 = new Passenger(1, "G", trip1);
//        PassengerDAO.savePassenger(passenger7);
//        passengerList1.add(passenger7);
//        Passenger passenger8 = new Passenger(1, "H", trip1);
//        PassengerDAO.savePassenger(passenger8);
//        passengerList1.add(passenger8);
//        Passenger passenger9 = new Passenger(1, "I", trip1);
//        PassengerDAO.savePassenger(passenger9);
//        passengerList1.add(passenger9);
//        Passenger passenger10 = new Passenger(1, "J", trip1);
//        PassengerDAO.savePassenger(passenger10);
//        passengerList1.add(passenger10);
//        Passenger passenger11 = new Passenger(1, "K", trip1);
//        PassengerDAO.savePassenger(passenger11);
//        passengerList1.add(passenger11);
//        Passenger passenger12 = new Passenger(1, "L", trip1);
//        PassengerDAO.savePassenger(passenger12);
//        passengerList1.add(passenger12);
//        Passenger passenger13 = new Passenger(1, "M", trip1);
//        PassengerDAO.savePassenger(passenger13);
//        passengerList1.add(passenger13);
//        Passenger passenger14 = new Passenger(1, "N", trip2);
//        PassengerDAO.savePassenger(passenger14);
//        passengerList1.add(passenger14);
//        Passenger passenger15 = new Passenger(1, "O", trip2);
//        PassengerDAO.savePassenger(passenger15);
//        passengerList1.add(passenger15);
//        Passenger passenger16 = new Passenger(1, "P", trip2);
//        PassengerDAO.savePassenger(passenger16);
//        passengerList1.add(passenger16);
//
//        //Set passengerLists
//        passengerList1 = Arrays.asList(passenger1, passenger2, passenger3, passenger4, passenger5, passenger6,
//                passenger7, passenger8, passenger9, passenger10, passenger11, passenger12, passenger13);
//        passengerList2 = Arrays.asList(passenger14, passenger15, passenger16);
//        PassengerDAO.savePassengers(passengerList1);
//        PassengerDAO.savePassengers(passengerList2);
//
//        //Set merchandiseLists
//        cargoList1 = Arrays.asList(merch1, merch5);
//        CargoDAO.saveCargoList(cargoList1);
//        cargoList2 = Arrays.asList(merch2, merch6);
//        CargoDAO.saveCargoList(cargoList2);
//        cargoList3 = Arrays.asList(merch3);
//        CargoDAO.saveCargoList(cargoList3);
//        cargoList4 = Arrays.asList(merch4);
//        CargoDAO.saveCargoList(cargoList4);
//
//        //Set companies
//        company1.setVehicles(vehicleList1);
//        company1.setDrivers(driverList1);
//        company1.setTrips(tripList1);
//
//        company2.setVehicles(vehicleList2);
//        company2.setDrivers(driverList2);
//        company2.setTrips(tripList2);
    }

}
