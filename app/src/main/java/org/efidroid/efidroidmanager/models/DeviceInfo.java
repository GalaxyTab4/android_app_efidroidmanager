package org.efidroid.efidroidmanager.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.efidroid.efidroidmanager.AppConstants;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DeviceInfo implements Parcelable {

    // data
    private String mDeviceName = null;
    private FSTab mFSTab = null;

    // state
    public LoadingState mLoadingState = LoadingState.STATE_LOAD_DEVICEINFO;

    public enum LoadingState {
        STATE_LOAD_DEVICEINFO,
        STATE_LOAD_FSTAB,
    }

    public DeviceInfo() {
    }

    protected DeviceInfo(Parcel in) {
        mDeviceName = in.readString();
        mFSTab = in.readParcelable(FSTab.class.getClassLoader());
    }

    public static final Creator<DeviceInfo> CREATOR = new Creator<DeviceInfo>() {
        @Override
        public DeviceInfo createFromParcel(Parcel in) {
            return new DeviceInfo(in);
        }

        @Override
        public DeviceInfo[] newArray(int size) {
            return new DeviceInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDeviceName);
        dest.writeParcelable(mFSTab, flags);
    }

    public void parseDeviceList(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        mDeviceName = jsonObject.getString(AppConstants.DEVICE_NAME);
    }

    public void parseFSTab(String data) throws IOException {
        mFSTab = new FSTab(data);
    }

    public String getDeviceName() {
        return mDeviceName;
    }

    public FSTab getFSTab() {
        return mFSTab;
    }
}
