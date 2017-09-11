//package com.sungwoo.aps.models;
//
//import org.json.JSONObject;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * @author phloc
// */
//@Entity
//@Table(name = "PARKING")
//public class Parking implements SungWooModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID", length = 16)
////    @JsonIgnore
//    private int uid;
//
//    private String name;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parking")
//    private Set<Lot> lots;
//
//    public Parking() {
//    }
//
//    public Parking(String name) {
//        this.name = name;
//    }
//
//    public int getUid() {
//        return uid;
//    }
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public Set<Lot> getLots() {
//        return lots;
//    }
//
//    public void setLots(Set<Lot> lots) {
//        this.lots = lots;
//    }
//
//    @Override
//    public JSONObject toJSON() {
//        return null;
//    }
//}
