package com.company;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Objects;


public class Car implements ITransport {
    private String mark;
    private Model[] models;

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String newMark) {
        mark = newMark;
    }


    private class Model implements Serializable, Cloneable {
        private String modelName;
        private Double modelPrice;

        public Model(String modelName, Double modelPrice) {
            this.modelName = modelName;
            this.modelPrice = modelPrice;
        }

        private String getModelName() {
            return modelName;
        }

        private void setModelName(String newModelName) {
            modelName = newModelName;
        }

        private Double getModelPrice() {
            return modelPrice;
        }

        private void setModelPrice(Double newModelPrice) {
            modelPrice = newModelPrice;
        }

        public int hashCode() {
            int result = modelName == null ? 0 : modelName.hashCode();
            result = (int) (result + modelPrice);
            return result;
        }

        public String toString() {
            return modelName + "" + modelPrice;
        }

        public Model clone() throws CloneNotSupportedException {
            Model clone = (Model) super.clone();
            return new Model(modelName, modelPrice);
        }
    }

    @Override
    public String[] getArrayModelsNames() {
        String[] modelsNames = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            modelsNames[i] = model.getModelName();
        }
        return modelsNames;
    }

    @Override
    public Double[] getArrayModelsPrice() {
        Double[] modelsPrice = new Double[models.length];
        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            modelsPrice[i] = model.getModelPrice();
        }
        return modelsPrice;
    }

    @Override
    public void setModelName(String oldModelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException {
        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            if (model.getModelName().equals(newModelName)) {
                throw new DuplicateModelNameException("model " + newModelName + " already exists");
            }
        }

        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            if (model.getModelName().equals(oldModelName)) {
                model.setModelName(newModelName);
                return;
            }
        }
        throw new NoSuchModelNameException("model " + oldModelName + " not found");
    }

    @Override
    public Double getPriceByName(String modelName) throws NoSuchModelNameException {
        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            if (model.getModelName().equals(modelName)) {
                return model.getModelPrice();
            }
        }
        throw new NoSuchModelNameException("model " + modelName + " not found");
    }

    @Override
    public void setPriceByName(String modelName, Double newModelPriceByName) throws
            NoSuchModelNameException {
        if (newModelPriceByName <= 0.0d) {
            throw new ModelPriceOutOfBoundsException("invalid price " + newModelPriceByName);
        }

        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            if (model.getModelName().equals(modelName)) {
                model.setModelPrice(newModelPriceByName);
                return;
            }
        }
        throw new NoSuchModelNameException("model " + modelName + " not found");
    }

    @Override
    public void addModelNameAndModelPrice(String modelName, Double modelPrice) throws DuplicateModelNameException {
        if (modelPrice <= 0.0d) {
            throw new ModelPriceOutOfBoundsException("invalid price " + modelPrice);
        }

        for (int i = 0; i < models.length; i++) {
            Model model = models[i];
            if (model.getModelName().equals(modelName)) {
                throw new DuplicateModelNameException("model " + modelName + " already exists");
            }
        }

        models = Arrays.copyOf(models, models.length + 1);
        Model newModel = new Model(modelName, modelPrice);
        models[models.length - 1] = newModel;
    }

    @Override
    public void delModelsByName(String modelName) throws NoSuchModelNameException {
        boolean flug = true;
        for (int i = 0; i < models.length; i++)
            if (Objects.equals(models[i].getModelName(), modelName)) {
                flug = false;
                System.arraycopy(models, i + 1, models, i, models.length - i - 1);
                models = Arrays.copyOf(models, models.length - 1);
            }
        if (flug) throw new NoSuchModelNameException(modelName);
    }

    @Override
    public int getCount() {
        return models.length;
    }

    public Car(String mark, int modelsCount) {
        this.mark = mark;
        models = new Model[0];
        for (int i = 0; i < modelsCount; i++) {
            String modelName = "model" + (i + 1);
            Double modelPrice = Math.round(Math.random() * 1000000) / 100.0;
            try {
                addModelNameAndModelPrice(modelName, modelPrice);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getSizeModelArray() {
        return models.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mark ").append(getMark()).append("\n");
        for (int i = 0; i < getArrayModelsNames().length; i++) {
            stringBuffer.append("Model: ").append(getArrayModelsNames()[i]).append("\n");
        }
        for (int i = 0; i < getArrayModelsPrice().length; i++) {
            stringBuffer.append("Price: ").append(getArrayModelsPrice()[i]).append("\n");
        }
        return stringBuffer.toString();
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Car)) return false;
        if (Objects.equals(this.mark, ((Car) o).mark)) {
            return Arrays.equals(getArrayModelsPrice(), ((Car) o).getArrayModelsPrice())
                    && Arrays.equals(getArrayModelsNames(), ((Car) o).getArrayModelsNames());
        }
        return false;
    }

    public int hashCode() {
        int result = Objects.hash(mark);
        result = 31 * result + Arrays.hashCode(models);
        return result;
    }

    public Car clone() throws CloneNotSupportedException {
        Car clone = (Car) super.clone();
        clone.models = this.models.clone();
        for (int i = 0; i < models.length; i++) {
            clone.models[i] = this.models[i].clone();
        }
        return clone;
    }
}