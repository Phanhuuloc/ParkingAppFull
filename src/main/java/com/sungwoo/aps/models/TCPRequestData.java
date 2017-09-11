package com.sungwoo.aps.models;

public class TCPRequestData {
    private byte msgID;
    private byte source;
    private byte des;
    private byte[] data;

    public TCPRequestData(byte msgID, byte source, byte des, byte[] data) {
        this.msgID = msgID;
        this.source = source;
        this.des = des;
        this.data = data;
    }
}
