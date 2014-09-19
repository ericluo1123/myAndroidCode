package com.teamsourcing.LoongyeeApp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Environment;
import android.util.Log;
import com.teamsourcing.LoongyeeApp.main.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import android.content.SharedPreferences;
import java.net.URL;
import java.util.*;
import java.io.*;

public class Device implements Parcelable {
    String keyId;
    String groupName;
    String name;
    String loopCode;
    String rssi;
    String status;
    String No;

    public static final String testData = "device.0.KeyName=測試一\n"+
            "device.0.LoopCode=010000\n"+
            "device.1.KeyID=01\n"+
            "device.1.KeyName=測試二\n"+
            "device.1.LoopCode=010101\n"+
            "device.1.RSSI=-57\n"+
            "device.1.Status=01\n"+
            "device.0.KeyID=08\n"+
            "device.0.RSSI=-67\n"+
            "device.0.Status=04\n"+
            "device.2.KeyName=測試三\n"+
            "device.2.KeyID=02\n"+
            "device.2.LoopCode=010111\n"+
            "device.2.RSSI=-77\n"+
            "device.2.Status=01\n"+
            "device.3.KeyName=測試四\n"+
            "device.3.KeyID=06\n"+
            "device.3.LoopCode=000111\n"+
            "device.3.RSSI=-68\n"+
            "device.3.Status=01\n";

    public static final String testData1 = "device.0.KeyName=n1,n2,n3\n" +
            "device.0.KeyID=08\n" +
            "device.0.GroupName=Room\n" +
            "device.0.LoopCode=010000\n" +
            "device.0.RSSI=-67\n"+
            "device.0.Status=04\n"+
            "device.1.KeyName=s1,s2,s3\n" +
            "device.1.KeyID=01\n" +
            "device.1.GroupName=Room2\n" +
            "device.1.LoopCode=101011\n" +
            "device.1.RSSI=-57\n"+
            "device.1.Status=02\n"+
            "device.2.KeyName=\n" +
            "device.2.KeyID=09\n" +
            "device.2.GroupName=Room3\n" +
            "device.2.LoopCode=101022\n" +
            "device.2.RSSI=-59\n"+
            "device.2.Status=02\n";


    public Device() {
    }

    private static TreeMap<String, HashMap<String, String>> getDeviceMap(String values) {

        String [] lines = values.split("\n");
        TreeMap <String, HashMap<String, String>> deviceList = new TreeMap<String, HashMap<String, String>>();
        HashMap <String, String> device;

        String line;
        for (String line1 : lines) {
            line = line1;
            String[] pairs = line.split("=");
            String keyPart = pairs[0];
            String valuePart = "";
            if (pairs.length == 2) {
                valuePart = pairs[1];
            }

            String[] triplet = keyPart.split("\\.");
            String deviceNo = triplet[1];
            device = deviceList.get(deviceNo);
            if (device == null) {
                device = new HashMap<String, String>();
            }
            device.put("No", deviceNo);
            device.put(triplet[2], valuePart);
            deviceList.put(deviceNo, device);
        }
        return deviceList;
    }

    public static ArrayList<Device> getDeviceList(String value) {
        TreeMap <String, HashMap<String, String>> resultMap = getDeviceMap(value);
        ArrayList<Device> result = new ArrayList<Device>();
        Object [] values = resultMap.values().toArray();
        for (Object value1 : values) {
            result.add(new Device((HashMap<String, String>) value1));
        }
        Collections.sort(result, new Comparator<Device>(){
            @Override
            public int compare(Device b1,Device b2){
                return  b2.getKeyId().compareTo(b1.getKeyId());
            }
        });
        return result;
    }
    public Device( HashMap<String, String> map) {
        this.setKeyId(map.get("KeyID"));
        this.setName(map.get("KeyName"));
        this.setLoopCode(map.get("LoopCode"));
        this.setRssi(map.get("RSSI"));
        this.setStatus(map.get("Status"));
        this.setGoupName(map.get("GroupName"));
        this.setNo(map.get("No"));
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoopCode() {
        return loopCode;
    }

    public void setLoopCode(String loopCode) {
        this.loopCode = loopCode;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public void setGoupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGoupName() {
        return groupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.keyId);
        dest.writeString(this.name);
        dest.writeString(this.loopCode);
        dest.writeString(this.rssi);
        dest.writeString(this.status);
    }

    private Device(Parcel in) {
        this.keyId = in.readString();
        this.name = in.readString();
        this.loopCode = in.readString();
        this.rssi = in.readString();
        this.status = in.readString();
    }

    public static Parcelable.Creator<Device> CREATOR = new Parcelable.Creator<Device>() {
        public Device createFromParcel(Parcel source) {
            return new Device(source);
        }

        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    public ArrayList<Device> TestGetData()
    {
        ArrayList<Device> result;
        result = getDeviceList(testData1);
        return result;

    }

    public ArrayList<Device> GetData()
    {
        String url = Constants.IP +"cgi-bin/uci_show?data=device";
        HttpURLConnection httpConn = null;
        String ws_respond = "";
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {
                ws_respond += lines;
                ws_respond += "\n";
            }
            reader.close();
            httpConn.disconnect();
        }
        catch (Exception e)
        {
            Log.e("Device", "exception", e);
        }
        ArrayList<Device> result;
        if(!ws_respond.equals(""))
        {
            result = getDeviceList(ws_respond);
        }
        else
        {
            result = new ArrayList<Device>();
        }
//        for(int i=0; i<result.size();i++)
//        {
//
//        }
        return result;
    }
   public ArrayList<Device> test()
   {

        ArrayList<Device> result = getDeviceList(testData);
        File vSDCard = null;
        try{
            if( Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED) )
                return null;
            else
            {
                vSDCard = Environment.getExternalStorageDirectory();
            }
            File vPath = new File( vSDCard.getParent() + "/" + vSDCard.getName() + "/Device" );
            if( !vPath.exists() )
                vPath.mkdirs();
            File vFile = new File(vSDCard.getParent() + "/" + vSDCard.getName() + "/Device/DeviceNote.txt");
            if(!vFile.exists())
            {
                vFile.createNewFile();
                FileWriter fw = new FileWriter(vFile);
                for(int i=0; i<result.size();i++)
                {
                    fw.write(result.get(i).getRssi());
                    fw.write("\r\n");
                }
                fw.close();
            }
            return result;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main (String []args){

       String s= ",,,";
       String ss[] = s.split(",",-1);

        /*
        String url = "http://192.168.103.1/cgi-bin/uci_show?data=device";
        HttpURLConnection httpConn = null;
        String ws_respond = "";
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {
                ws_respond += lines;
                ws_respond += "\n";
            }
            reader.close();
            httpConn.disconnect();
        }
        catch (Exception e)
        {

        }
        */
        ArrayList<Device> result = getDeviceList(testData1);
//        if(result.get(0).getName() != "")
//        {
//            String str[] = result.get(0).getName().split("\\,");
//        }
        System.out.println("Done");
//        getStuff();
    }

    public static void getStuff() {
        String url ="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,86,AE,5C,02,00,00,00,00,01,0D";
        HttpURLConnection httpConn = null;
        String ws_respond = "";

        try {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {
                ws_respond += lines;
            }
            reader.close();
            httpConn.disconnect();

        }
        catch (Exception e) {

        }
    }
}
