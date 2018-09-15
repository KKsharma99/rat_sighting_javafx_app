package com.lynden.example.latlong;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Vraka on 12/5/2017.
 */

public class User {

    private String _id;
    public SimpleStringProperty _name;
    private String _contact;
    private boolean _isAdmin;
    private boolean _isLocked;
    public SimpleStringProperty _lockStatus;
    public SimpleStringProperty _delete;

    public User(String _id, String _name, String _contact, boolean _isAdmin, boolean _isLocked) {
        this._id = _id;
        this._name = new SimpleStringProperty(_name);
        this._contact = _contact;
        this._isAdmin = _isAdmin;
        this._isLocked =_isLocked;
        this._delete = new SimpleStringProperty("delete");
        if(_isLocked) {
        	_lockStatus = new SimpleStringProperty("unlock");
        } else {
        	_lockStatus = new SimpleStringProperty("lock");
        }
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name.get();
    }

    public void set_name(String _name) {
        this._name = new SimpleStringProperty(_name);
    }

    public String get_contact() {
        return _contact;
    }
    
    public String get_delete() {
        return _delete.get();
    }

    public void set_contact(String _contact) {
        this._contact = _contact;
    }

    public boolean is_isAdmin() {
        return _isAdmin;
    }

    public void set_isAdmin(boolean _isAdmin) {
        this._isAdmin = _isAdmin;
    }

    public boolean is_isLocked() {
        return _isLocked;
    }

    public void set_isLocked(boolean _isLocked) {
    	
    	if(_isLocked) {
    		HTTPPostReq.lockUser(this._id);
    	} else {
    		HTTPPostReq.unlockUser(this._id);

    	}
    	
        this._isLocked = _isLocked;
    }
    
    public String get_lockStatus() {
    	if(_isLocked) {
        	_lockStatus = new SimpleStringProperty("unlock");
        } else {
        	_lockStatus = new SimpleStringProperty("lock");
        }
    	
    	return _lockStatus.get();
    }
}
