package com.company;

import java.io.*;


public class Tablo {

    public static Double getAvgPrice(ITransport transport) {
        Double[] prices = transport.getArrayModelsPrice();

        if (prices.length != 0) {
            int count = 0;
            Double sum = 0.0d;
            for (int i = 0; i < prices.length; i++) {
                sum += prices[i];
                count++;
            }
            return sum / count;
        } else {
            return 0.0d;
        }
    }

    public static void showModels(ITransport transport) {
        System.out.println("models for " + transport.getMark());
        String[] modelsNames = transport.getArrayModelsNames();

        for (int i = 0; i < modelsNames.length; i++) {
            System.out.println("  " + modelsNames[i]);
        }
    }

    public static void showPrices(ITransport transport) {
        System.out.println("prices for " + transport.getMark());
        Double[] prices = transport.getArrayModelsPrice();

        for (int i = 0; i < prices.length; i++) {
            System.out.println("  " + prices[i]);
        }
    }

    public static void showModelsAndPrices(ITransport transport) {
        System.out.println("prices for " + transport.getMark());
        String[] modelsNames = transport.getArrayModelsNames();
        Double[] prices = transport.getArrayModelsPrice();

        for (int i = 0; i < modelsNames.length; i++) {
            System.out.println("  " + modelsNames[i] + " = " + prices[i]);
        }
    }


    public static void printModels(ITransport ITransport) {
        for (String str : ITransport.getArrayModelsNames()) {
            System.out.println(str);
        }
    }

    public static void printPrices(ITransport ITransport) {
        for (double AllPrices : ITransport.getArrayModelsPrice()) {
            System.out.println(AllPrices);
        }
    }

    public static void outputVehicle(ITransport v, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(v.getClass().getName());
        dos.writeUTF(v.getMark());
        int len = v.getSizeModelArray();
        dos.writeInt(len);
        try {
            for (int i = 0; i < len; i++) {
                dos.writeUTF(v.getArrayModelsNames()[i]);
                dos.writeDouble(v.getArrayModelsPrice()[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File saved Ok. Len = " + len);
    }

    public static ITransport inputVehicle(InputStream in) throws IOException, DuplicateModelNameException {
        DataInputStream dis = new DataInputStream(in);
        ITransport res = null;
        String cl = dis.readUTF();
        String mark = dis.readUTF();
        int len = dis.readInt();
        if (cl.equals("Moto"))
            res = new Moto(mark, 0);
        else res = new Car(mark, 0);
        for (int i = 0; i < len; i++) {
            res.addModelNameAndModelPrice(dis.readUTF(), dis.readDouble());
        }
        return res;
    }

    public static void writeVehicle(ITransport v, Writer out) {
        try {
            PrintWriter printWriter = new PrintWriter(out);
            if (v instanceof Car) printWriter.println("Car");
            else printWriter.println("Moto");
            printWriter.println(v.getMark());
            printWriter.println(v.getSizeModelArray());
            for (int i = 0; i < v.getSizeModelArray(); i++) {
                printWriter.println(v.getArrayModelsNames()[i]);
                printWriter.println(v.getArrayModelsPrice()[i]);
            }
            printWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ITransport readVehicle(Reader in) {
        ITransport vehicle;
        try {
            BufferedReader bufferedReader = new BufferedReader(in);
            String cl = bufferedReader.readLine();
            String mark = bufferedReader.readLine();
            int count = Integer.parseInt(bufferedReader.readLine());
            String[] models = new String[count];
            double[] prices = new double[count];
            if (cl.equals("Moto"))
                vehicle = new Moto(mark, 0);
            else vehicle = new Car(mark, 0);
            for (int i = 0; i < count; i++) {
                models[i] = bufferedReader.readLine();
                prices[i] = Double.parseDouble(bufferedReader.readLine());
                vehicle.addModelNameAndModelPrice(models[i], prices[i]);
            }
        } catch (IOException | DuplicateModelNameException ex) {
            throw new RuntimeException(ex);
        }
        return vehicle;
    }
}
