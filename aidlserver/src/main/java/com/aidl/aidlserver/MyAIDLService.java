package com.aidl.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class MyAIDLService extends Service {

    List<Person> personList = new ArrayList<>();
    DataSource dataSource;

    public MyAIDLService() {
        dataSource = DataSource.getInstance();
        dataSource.initPersonList();
        personList.addAll(dataSource.getPersonList());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IRemoteService.Stub binder = new IRemoteService.Stub() {
        @Override
        public Person getPerson(int position) throws RemoteException {

            int personListSize = dataSource.getPersonList().size();
            if (position > 0 && position < personListSize) {
                return personList.get(position);
            } else {
                return personList.get(0);
            }
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return dataSource.getPersonList();
        }
    };

}
