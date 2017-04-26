package com.slu.se_project.backend;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public abstract class BackendlessObject implements Parcelable,Serializable {

    protected String objectId;
    protected String ownerId;
    protected Date created;
    protected Date updated;

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getObjectId() {
            return objectId;
    }

    public void setObjectId(String objectId) {
            this.objectId = objectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(objectId);
        parcel.writeString(ownerId);
        parcel.writeString(created.toString());
        parcel.writeString(updated.toString());
    }

}
