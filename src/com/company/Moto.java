package com.company;

import java.lang.System;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Moto implements ITransport {
    private class Model implements Serializable, Cloneable {
        private String name = null;
        private double price = Double.NaN;
        Model prev = null;
        Model next = null;

        Model(Model next, Model prev, String name, double price) {
            this.name = name;
            this.price = price;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return "model: " + name + " price: " + price;
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        double getPrice() {
            return this.price;
        }

        void setPrice(double price) {
            if (price <= 0)
                throw new ModelPriceOutOfBoundsException("Model price must be greater than zero!");
            else
                this.price = price;
        }

        public String getName() {
            return this.name;
        }

        void setName(String name) {
            this.name = name;
        }

        public int hashCode() {
            int result = name == null ? 0 : name.hashCode();
            result = (int) (result + price);
            return result;
        }

        public Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }
    }

    private String brand;
    private int size = 0;

    private Model head = new Model("0", 0);
    {
        size = 1;
        head.prev = head;
        head.next = head;
    }

    private transient long lastModified;

    {
        this.lastModified = System.currentTimeMillis();
    }

    public Moto(String brand) {
        this.brand = brand;
    }

//    public Moto(String brand, int modelsCount) {
//        this.brand = brand;
//        for (int i = 0; i < modelsCount; i++) {
//            String modelName = "moto_model" + (i + 1);
//            Double modelPrice = Math.round(Math.random() * 1000000) / 100.0;
//            try {
//                addModelNameAndModelPrice(modelName, modelPrice);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public Moto(String brand, int modelsSize) {
        this.brand = brand;
        for (int i = 1; i < modelsSize; i++) {
            try {
                addModelNameAndModelPrice(Integer.toString(i), 1d);
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
        }
    }


    public void setMark(String brand) {
        this.brand = brand;
    }

    public String getMark() {
        return this.brand;
    }

    public void setModelName(String modelName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        if (isModelExists(newName))
            throw new DuplicateModelNameException(newName);
        Model model = findModelByName(modelName);
        model.setName(newName);
    }


    public String[] getArrayModelsNames() {
        String[] names = new String[size];
        if (!isEmpty()) {
            Model node = this.head;
            for (int i = 0; i < size; node = node.next, i++)
                names[i] = node.name;
        }
        return names;
    }


    public Double getPriceByName(String modelName) throws NoSuchModelNameException {
        Model model = findModelByName(modelName);
        return model.getPrice();
    }


    public void setPriceByName(String modelName, Double price) throws NoSuchModelNameException {
        if (price <= 0)
            throw new ModelPriceOutOfBoundsException("Model price must be greater than zero!");
        Model model = findModelByName(modelName);
        model.setPrice(price);
    }


    public Double[] getArrayModelsPrice() {
        Double[] prices = new Double[size];
        Model node = this.head;
        for (int i = 0; i < size; node = node.next, i++)
            prices[i] = node.price;
        return prices;
    }

    private Model findModelByName(String modelName) throws NoSuchModelNameException {
        Model result = getModelByName(modelName);
        if (result == null)
            throw new NoSuchModelNameException(modelName);
        return result;
    }

    private Model getModelByName(String modelName){
        Model result = null;
        if (this.head.name.equals(modelName)) {
            result = this.head;
        } else {
            for (Model node = this.head.next; node != this.head; node = node.next)
                if (node.name.equals(modelName)) {
                    result = node;
                    break;
                }
        }
        return result;
    }

    private boolean isModelExists(String modelName){
        return getModelByName(modelName) != null;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public Model getModelByIndex(int index) {
        Model m;
        m = head;
        int i = 1;
        while (i <= index) {
            m = m.next;
            ++i;
        }
        return m;
    }


    public void addModelNameAndModelPrice(String modelName, Double modelPrice) throws DuplicateModelNameException {
        if (modelPrice <= 0.0d) {
            throw new ModelPriceOutOfBoundsException("invalid price " + modelPrice);
        }
        if (getModelByName(modelName) == null) {
            Model model = new Model(modelName, modelPrice);
            model.next = head;
            model.prev = head.prev;
            model.prev.next = model;
            head.prev = model;
            size++;
        } else {
            throw new DuplicateModelNameException(modelName);
        }
        this.lastModified = System.currentTimeMillis();
    }

    public void delModelsByName(String modelName) throws NoSuchModelNameException {
        if (head == null)
            return;
        Model modelToDelete = findModelByName(modelName);

        if (modelToDelete.next == modelToDelete.prev)
            head = null;
        else {
            modelToDelete.prev.next = modelToDelete.next;
            modelToDelete.next.prev = modelToDelete.prev;
        }
        size--;
        this.lastModified = System.currentTimeMillis();
    }

    public int getSizeModelArray() {
        return size;
    }

    public int getCount() {
        return size;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mark ").append(getMark()).append("\n");
        for (int i = 0; i < getArrayModelsNames().length; i++) {
            stringBuffer.append("Model: ").append(getArrayModelsNames()[i]).append("\n");
        }
        for (int j = 0; j < getArrayModelsPrice().length; j++) {
            stringBuffer.append("Price: ").append(getArrayModelsPrice()[j]).append("\n");
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Moto)) return false;
        if (Objects.equals(this.brand, ((Moto) o).brand)) {
            return Arrays.equals(getArrayModelsPrice(), ((Moto) o).getArrayModelsPrice())
                    && Arrays.equals(getArrayModelsNames(), ((Moto) o).getArrayModelsNames());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(head, size, brand);
    }


    public Moto clone() throws CloneNotSupportedException {
        Moto clone = (Moto) super.clone();
        clone.size = 0;
        Double[] prices = getArrayModelsPrice();
        String[] names = getArrayModelsNames();
        clone.head = new Model(names[0], prices[0]);
        clone.head.prev = clone.head;
        clone.head.next = clone.head;
        for (int i = 1; i < size; i++) {
            Model node = new Model(names[i], prices[i]);
            node.prev = clone.head.prev;
            node.next = clone.head;
            clone.head.prev.next = node;
            clone.head.prev = node;
        }
        clone.size = this.size;
        return clone;
    }
}
