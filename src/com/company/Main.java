package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

public class Main {

//    private static void showCar(Car car) {
//        System.out.println("Car Mark:" + car.getMark());
//        for (int i = 0; i < car.getCount(); i++) {
//            System.out.println("model:" + car.getArrayModelsNames()[i] + " price:" + car.getArrayModelsPrice()[i]);
//        }
//    }
//    private static void showMoto(Moto moto) {
//        System.out.println("Moto Mark:" + moto.getMark() + " lastModified=" + moto.getLastModified());
//        for (int i = 0; i < moto.getCount(); i++) {
//            System.out.println("model:" + moto.getArrayModelsNames()[i] + " price:" + moto.getArrayModelsPrice()[i]);
//        }
//    }
//    private static void showTransport(ITransport transport) {
//        String c = "";
//        if (transport instanceof Car) {
//            c = "Car";
//        } else if (transport instanceof Moto) {
//            c = "Moto";
//        }
//        System.out.println(c + " Mark:" + transport.getMark());
//        for (int i = 0; i < transport.getCount(); i++) {
//            System.out.println("model:" + transport.getArrayModelsNames()[i] + " price:" + transport.getArrayModelsPrice()[i]);
//        }
//    }
//    private static void showTablo(ITransport transport) {
//        System.out.println("****" + transport.getMark() + "****");
//        System.out.println("===getAvgPrice");
//        System.out.println(Tablo.getAvgPrice(transport));
//        System.out.println("===showModels");
//        Tablo.showModels(transport);
//        System.out.println("===showPrices");
//        Tablo.showPrices(transport);
//        System.out.println("===showModelsAndPrices");
//        Tablo.showModelsAndPrices(transport);
//    }

    public static void main(String[] args) throws ModelPriceOutOfBoundsException, NoSuchModelNameException, DuplicateModelNameException {
        try {
//            System.out.println("====Add mark avto:====");
//            Car car1 = new Car("Lad", 5);
//            Car car2 = new Car("Subar", 2);
//            Car car3 = new Car("Lexu", 3);
//
//            System.out.println(car1.getMark());
//            System.out.println(car2.getMark());
//            System.out.println(car3.getMark());
//
//            System.out.println("====Change mark name avto:====");
//
//            car1.setMark("Lada");
//            car2.setMark("Subary");
//            car3.setMark("Lexus");
//
//            System.out.println(car1.getMark());
//            System.out.println(car2.getMark());
//            System.out.println(car3.getMark());
//
//            System.out.println("====Array Model names and array Model prices====");
//            showCar(car1);
//            showCar(car2);
//            showCar(car3);
//
//            System.out.println("====Change Model names====");
//            car1.setModelName("model1", "Vesta");
//            car1.setModelName("model2", "Priora");
//            car1.setModelName("model3", "Granta");
//            car1.setModelName("model4", "Niva");
//            car1.setModelName("model5", "Kalina");
//            car2.setModelName("model1", "Impreza");
//            car2.setModelName("model2", "Forester");
//            car3.setModelName("model1", "Is200");
//            car3.setModelName("model2", "RX250");
//            car3.setModelName("model3", "RX350");
//            //car1.setModelName("model7", "model77"); //Exception
//            //car1.setModelName("Vesta", "Vesta"); //Exception
//            showCar(car1);
//            showCar(car2);
//            showCar(car3);
//
//            System.out.println("====Get and Change Model price====");
//            System.out.println(car1.getPriceByName("Priora"));
//
//            car1.setPriceByName("Vesta", 1000000.0);
//            car1.setPriceByName("Priora", 550000.0);
//            car1.setPriceByName("Granta", 700000.0);
//            car1.setPriceByName("Niva", 800000.0);
//            car1.setPriceByName("Kalina", 600000.0);
//            car2.setPriceByName("Impreza", 850000.0);
//            car2.setPriceByName("Forester", 1500000.0);
//            car3.setPriceByName("Is200", 1000000.0);
//            car3.setPriceByName("RX250", 2000000.0);
//            car3.setPriceByName("RX350", 2500000.0);
//            //car1.setPriceByName("Vesta", -33333.0); //Exception
//            //car1.setPriceByName("model7", 33333.0); //Exception
//            showCar(car1);
//            showCar(car2);
//            showCar(car3);
//
//            System.out.println("====add Model Name And Model Price====");
//            car1.addModelNameAndModelPrice("XRAY", 1500000.0);
//            //car1.addModelNameAndModelPrice("XRAY", -5555.0); //Exception
//            //car1.addModelNameAndModelPrice("XRAY", 5555.0); //Exception
//            showCar(car1);
//
//            System.out.println("====Delete Model ====");
//            car1.delModelsByName("XRAY");
//            //car1.delModelsByName("model7"); //Exception
//            showCar(car1);
//
//            System.out.println("Array length: " + car1.getCount());
//
//
//            System.out.println("========Car test end========");
//
//
//            Moto moto1 = new Moto("Ura", 5);
//            Moto moto2 = new Moto("Hond", 2);
//
//            System.out.println("====Array Model names and array Model prices====");
//            showMoto(moto1);
//            showMoto(moto2);
//
//            System.out.println(moto1.getMark());
//            System.out.println(moto2.getMark());
//
//            System.out.println("====Change mark name moto:====");
//
//            moto1.setMark("Ural");
//            moto2.setMark("Honda");
//
//            System.out.println(moto1.getMark());
//            System.out.println(moto2.getMark());
//
//            System.out.println("====Change Model names====");
//            moto1.setModelName("moto_model1", "Type1");
//            moto1.setModelName("moto_model2", "Type2");
//            moto1.setModelName("moto_model3", "Type3");
//            moto1.setModelName("moto_model4", "Type4");
//            moto1.setModelName("moto_model5", "Type5");
//            moto2.setModelName("moto_model1", "R1");
//            moto2.setModelName("moto_model2", "RS1000");
//            //moto2.setModelName("RS1000", "RS1000"); //Exception
//            //moto2.setModelName("Model", " x x"); //Exception
//            moto2.setPriceByName("R1", 1000000.0);
//
//            System.out.println("====Get and Change Model price====");
//            System.out.println("R1 price is " + moto2.getPriceByName("R1"));
//
//            moto1.setPriceByName("Type1", 300000.0);
//            moto1.setPriceByName("Type2", 400000.0);
//            moto1.setPriceByName("Type3", 500000.0);
//            moto1.setPriceByName("Type4", 600000.0);
//            moto1.setPriceByName("Type5", 700000.0);
//            moto2.setPriceByName("R1", 850000.0);
//            moto2.setPriceByName("RS1000", 1500000.0);
//            //moto1.setPriceByName("Type1", -33333.0); //Exception
//            //moto1.setPriceByName("model7", 33333.0); //Exception
//            showMoto(moto1);
//            showMoto(moto2);
//
//            System.out.println("====add Model Name And Model Price====");
//            moto1.addModelNameAndModelPrice("Type6", 1500000.0);
//            //moto1.addModelNameAndModelPrice("Type6", -5555.0); //Exception
//            //moto1.addModelNameAndModelPrice("Type6", 5555.0); //Exception
//            showMoto(moto1);
//
//            System.out.println("====Delete Model ====");
//            moto1.delModelsByName("Type6");
//            //moto1.delModelsByName("model7"); //Exception
//            showMoto(moto1);
//
//            System.out.println("Array length: " + moto1.getCount());
//
//            System.out.println("========Moto test end========");
//
//            System.out.println("=======Show Transport========");
//            showTransport(car1);
//            showTransport(moto1);
//
//            System.out.println("=======Show Tablo========");
//            showTablo(car1);
//            showTablo(car2);
//            showTablo(car3);
//            showTablo(moto1);
//            showTablo(moto2);

//======================================================================================================================

//            ITransport Car3 = new Car("Skoda",5);
//            showCar((com.company.Car) Car3);

//            System.out.println("=======Byte - write=======");
//            FileOutputStream fos = new FileOutputStream("data.dat");
//            Tablo.outputVehicle(Car3, fos);
//            fos.close();
//
//            System.out.println("=======Byte - read=======");
//            FileInputStream fis = new FileInputStream("data.dat");
//            ITransport vehicleresult = Tablo.inputVehicle(fis);
//            System.out.println(vehicleresult.getMark());
//            System.out.println(vehicleresult.getSizeModelArray());
//            System.out.println("Models:");
//            Tablo.printModels(vehicleresult);
//            System.out.println("Price:");
//            Tablo.printPrices(vehicleresult);

//            System.out.println("Save models in file");
//            File file = new File("data.byte");
//            long timestamp = file.lastModified();
//            System.out.println("data.byte last mod = " + new Date(timestamp));
//            System.out.println("=======symbols - write=======");
//            FileWriter fileWriter = new FileWriter("data.txt");
//            Tablo.writeVehicle(Car3, fileWriter);
//            fileWriter.flush();
//
//            System.out.println("=======symbols - read=======");
//            FileReader fileReader = new FileReader("data.txt");
//            ITransport vehicleresult2 = Tablo.readVehicle(fileReader);
//            System.out.println(vehicleresult2.getMark());
//            System.out.println(vehicleresult2.getSizeModelArray());
//            System.out.println("Models:");
//            Tablo.printModels(vehicleresult2);
//            System.out.println("Price:");
//            Tablo.printPrices(vehicleresult2);

//            System.out.println("=======serializations - write=======");
//            FileOutputStream fos2 = new FileOutputStream("vehicle.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos2);
//            oos.writeObject(Car3);
//            oos.close();
//            System.out.println("File saved");
//
//            System.out.println("=======serializations - read=======");
//            FileInputStream fis2 = new FileInputStream("vehicle.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis2);
//            ITransport motor = (ITransport) ois.readObject();
//            System.out.println("Output info:");
//            System.out.println(motor);
//            ois.close();

//            System.out.println("=====in console write: Class, Mark, Len, Models, Price=====");
//            ITransport transportConsole =  Tablo.readVehicle(new InputStreamReader(System.in));
//            System.out.println("=====You add:=====");
//            Tablo.writeVehicle((ITransport) transportConsole, new OutputStreamWriter(System.out));
//            System.out.println("=====Check add:=====");
//            showTransport(transportConsole);
//======================================================================================================================

//        Car Car1 = new Car("Skoda", 1);
//        Car Car2 = new Car("Skoda", 1);
//        Car1.setPriceByName("model1", 1000000.0);
//        Car2.setPriceByName("model1", 1000000.0);
//        System.out.println("Chek:" + Car1.equals(Car2));
//
//        System.out.println(Car1.hashCode() == Car2.hashCode());
//        System.out.println(Car1.hashCode());
//        System.out.println(Car2.hashCode());
//
//        Car cloned = Car1.clone();
//        System.out.println(Car1.equals(cloned));
//        Car1.setModelName("model1","modelNew");
//        System.out.println(Car1);
//        System.out.println(cloned);
//
//        System.out.println(Car2.hashCode() == cloned.hashCode());
//        System.out.println(Car2.equals(cloned));


        Moto Moto1 = new Moto("Suzuki", 2);
//        Moto Moto2 = new Moto("Suzuki", 2);
//        Moto1.setPriceByName("1", 1000000.0);
//        Moto2.setPriceByName("1", 1000000.0);
//        System.out.println("Chek:" + Moto1.equals(Moto2));
//
//        System.out.println(Moto1.hashCode() == Moto2.hashCode());
//        System.out.println(Moto1.hashCode());
//        System.out.println(Moto2.hashCode());

        Moto clonedMoto = Moto1.clone();
        System.out.println(Moto1.equals(clonedMoto));
        Moto1.setModelName("1","1New");
        System.out.println(Moto1.equals(clonedMoto));

        System.out.println(Moto1);
        System.out.println(clonedMoto);
//
//        System.out.println(Moto2.hashCode() == clonedMoto.hashCode());
//        System.out.println(Moto2.equals(clonedMoto));

        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }
}
