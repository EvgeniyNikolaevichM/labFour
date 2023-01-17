package com.company;
import java.io.Serializable;

public interface ITransport extends Serializable, Cloneable {
    String getMark();

    void setMark(String newMark);

    String[] getArrayModelsNames();

    Double[] getArrayModelsPrice();

    void setModelName(String oldModelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException;

    Double getPriceByName(String modelName) throws NoSuchModelNameException;

    void setPriceByName(String modelName, Double newModelPriceByName) throws NoSuchModelNameException;

    void addModelNameAndModelPrice(String modelName, Double modelPrice) throws DuplicateModelNameException;

    void delModelsByName(String modelName) throws NoSuchModelNameException;

    int getCount();

    int getSizeModelArray();
}
