//package com.sungwoo.aps.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import org.json.JSONObject;
//
//import javax.annotation.Generated;
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * @author phloc
// */
//@Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-25T04:31:55.163Z")
//@Entity
//@Table(name = "LOT")
//public class Lot implements SungWooModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID", length = 16)
////    @JsonIgnore
//    private int uid;
//
//    @Column(length = 1024)
//    private String name;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lot")
//    private Set<Area> areas;
//
//    @ManyToOne
//    @JoinColumn(name = "parking_uid")
//    @JsonBackReference
//    private Parking parking;
//
//    public Lot() {
//    }
//
//    public Lot(String name) {
//        this.name = name;
//    }
//
//    public Lot(int uid, String name) {
//        this.uid = uid;
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
//    public Set<Area> getAreas() {
//        return areas;
//    }
//
//    public void setAreas(Set<Area> areas) {
//        this.areas = areas;
//    }
//
//    public Parking getParking() {
//        return parking;
//    }
//
//    public void setParking(Parking parking) {
//        this.parking = parking;
//    }
//
//    @Override
//    public String toString() {
//        return "Lot{" +
//                "uid=" + uid +
//                ", name='" + name + '\'' +
//                ", areas=" + areas +
//                ", parking=" + parking +
//                '}';
//    }
//
//    @Override
//    public JSONObject toJSON() {
//        return null;
//    }
//}
