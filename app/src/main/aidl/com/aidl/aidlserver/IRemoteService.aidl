// IRemoteService.aidl
package com.aidl.aidlserver;

// Declare any non-default types here with import statements
import com.aidl.aidlclient.Person;

interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    Person getPerson(int position);
    List<Person> getPersonList();
}
