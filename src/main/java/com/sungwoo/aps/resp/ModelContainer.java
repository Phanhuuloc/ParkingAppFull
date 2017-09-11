package com.sungwoo.aps.resp;

import java.util.List;

public class ModelContainer<T, E> {

    List<T> datas;
    E model;

    public ModelContainer() {
    }

    public ModelContainer(List<T> datas) {
        this.datas = datas;
    }

    public ModelContainer(List<T> datas, E model) {
        this.datas = datas;
        this.model = model;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public E getModel() {
        return model;
    }

    public void setModel(E model) {
        this.model = model;
    }
}
