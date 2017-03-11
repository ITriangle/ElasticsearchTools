package com.wangl.domain;

/**
 * Created by wangl on 2016/11/9.
 */
public class MacLog {

    /**
     * id : 3846151
     * equipment_code : 743218887888860A240A6
     * service_code : 12010525011945
     * factory_code : 743218887
     * area_code : 120105
     * mac : 3C-A3-48-B5-0F-7C
     * terminal_company :
     * ssid :
     * signal : -80
     * access_ap_mac : 3C-A3-48-B5-0F-7C
     * create_time : 2020-01-01T18:03:48
     * x_coordinate :
     * y_coordinate :
     * equipment_longitude : 117.21853
     * equipment_latitude : 39.143717
     * identitication_type : 100000
     * identitication_account :
     * access_ap_ssid : 54+N5ZOB5YWs5Y+4fFRQLUxJTktfRTdFMnxKSFNLSU5LX0U3RTJ8d2lmaV8gRl9FN0UyfE1FUkNV
     UllfREI2NnxGQVNUXzA0QjJCNjZ8WGlhb21pX1BDLTIwfOa1t+m4peaVsOeggS1B
     * access_ap_channel :
     * access_ap_encryption_type :
     * end_time : 2020-01-01T18:03:48
     * connect_num : 1
     */

    private String id;
    private String equipment_code;
    private String service_code;
    private String factory_code;
    private String area_code;
    private String mac;
    private String terminal_company;
    private String ssid;
    private String signal;
    private String access_ap_mac;
    private String create_time;
    private String x_coordinate;
    private String y_coordinate;
    private String equipment_longitude;
    private String equipment_latitude;
    private String identitication_type;
    private String identitication_account;
    private String access_ap_ssid;
    private String access_ap_channel;
    private String access_ap_encryption_type;
    private String end_time;
    private String connect_num;


    @Override
    public String toString() {
        return "MacLog{" +
                "id='" + id + '\'' +
                ", equipment_code='" + equipment_code + '\'' +
                ", service_code='" + service_code + '\'' +
                ", factory_code='" + factory_code + '\'' +
                ", area_code='" + area_code + '\'' +
                ", mac='" + mac + '\'' +
                ", terminal_company='" + terminal_company + '\'' +
                ", ssid='" + ssid + '\'' +
                ", signal='" + signal + '\'' +
                ", access_ap_mac='" + access_ap_mac + '\'' +
                ", create_time='" + create_time + '\'' +
                ", x_coordinate='" + x_coordinate + '\'' +
                ", y_coordinate='" + y_coordinate + '\'' +
                ", equipment_longitude='" + equipment_longitude + '\'' +
                ", equipment_latitude='" + equipment_latitude + '\'' +
                ", identitication_type='" + identitication_type + '\'' +
                ", identitication_account='" + identitication_account + '\'' +
                ", access_ap_ssid='" + access_ap_ssid + '\'' +
                ", access_ap_channel='" + access_ap_channel + '\'' +
                ", access_ap_encryption_type='" + access_ap_encryption_type + '\'' +
                ", end_time='" + end_time + '\'' +
                ", connect_num='" + connect_num + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipment_code() {
        return equipment_code;
    }

    public void setEquipment_code(String equipment_code) {
        this.equipment_code = equipment_code;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getFactory_code() {
        return factory_code;
    }

    public void setFactory_code(String factory_code) {
        this.factory_code = factory_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTerminal_company() {
        return terminal_company;
    }

    public void setTerminal_company(String terminal_company) {
        this.terminal_company = terminal_company;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public String getAccess_ap_mac() {
        return access_ap_mac;
    }

    public void setAccess_ap_mac(String access_ap_mac) {
        this.access_ap_mac = access_ap_mac;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(String x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public String getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(String y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public String getEquipment_longitude() {
        return equipment_longitude;
    }

    public void setEquipment_longitude(String equipment_longitude) {
        this.equipment_longitude = equipment_longitude;
    }

    public String getEquipment_latitude() {
        return equipment_latitude;
    }

    public void setEquipment_latitude(String equipment_latitude) {
        this.equipment_latitude = equipment_latitude;
    }

    public String getIdentitication_type() {
        return identitication_type;
    }

    public void setIdentitication_type(String identitication_type) {
        this.identitication_type = identitication_type;
    }

    public String getIdentitication_account() {
        return identitication_account;
    }

    public void setIdentitication_account(String identitication_account) {
        this.identitication_account = identitication_account;
    }

    public String getAccess_ap_ssid() {
        return access_ap_ssid;
    }

    public void setAccess_ap_ssid(String access_ap_ssid) {
        this.access_ap_ssid = access_ap_ssid;
    }

    public String getAccess_ap_channel() {
        return access_ap_channel;
    }

    public void setAccess_ap_channel(String access_ap_channel) {
        this.access_ap_channel = access_ap_channel;
    }

    public String getAccess_ap_encryption_type() {
        return access_ap_encryption_type;
    }

    public void setAccess_ap_encryption_type(String access_ap_encryption_type) {
        this.access_ap_encryption_type = access_ap_encryption_type;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getConnect_num() {
        return connect_num;
    }

    public void setConnect_num(String connect_num) {
        this.connect_num = connect_num;
    }
}
