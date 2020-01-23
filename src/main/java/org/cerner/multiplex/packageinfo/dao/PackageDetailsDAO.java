package org.cerner.multiplex.packageinfo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PackageDetailsDAO<Integer, Package> {
    private final Map<Integer,Package> map = new HashMap<>();


    /**
     * Adds a new value to the map. If the map already contains a value
     * at the given key, an exception is raised. If your intent
     * is to update the value regardless of whether it is present or not,
     * consider using the {@link #addOrUpdate(Object, Object)} method instead.
     *
     * @param key the lookup key
     * @param value the value to store
     * @throws IllegalStateException if the map already contains a value at the given key
     */
    public synchronized void add(Integer key, Package value) {
        if (map.containsKey(key)) {
            throw new IllegalStateException("A value for '"+key+"' is already present.");
        }

        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }

        map.put(key, value);
    }

    /**
     * Updates an existing value in the map. The previous value is returned.
     * If no value was present, then an exception is raised. If your intent
     * is to store the value regardless of whether it is present or not,
     * consider using the {@link #addOrUpdate(Object, Object)} method instead.
     *
     * @param key the lookup key
     * @param value the value to store
     * @return the previous value
     * @throws IllegalStateException if there was no previous value
     */
    public synchronized Package update(Integer key, Package value) {
        if (!map.containsKey(key)) {
            throw new IllegalStateException("There is no value to update for key '"+key+"'.");
        }

        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }

        return map.put(key, value);
    }

    /**
     * Adds a new value, or updates an existing value in the map. The previous
     * value is returned. If no value was present, then {@code null} will be
     * the returned value.
     *
     * @param key the lookup key
     * @param value the value to store
     * @return the previous value or {@code null}
     */
    public synchronized Package addOrUpdate(Integer key, Package value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }

        return map.put(key, value);
    }

    /**
     * Removes a value from the map. Returns true if a value was removed, or
     * false if the operation had no effect.
     *
     * @param key the lookup key
     * @return true if a value was removed, false otherwise
     */
    public synchronized boolean remove(Integer key) {
        return map.remove(key) != null;
    }

    /**
     * Returns true if the map contains the given key.
     *
     * @param key the lookup key
     * @return true if the map contains the key, false otherwise
     */
    public synchronized boolean contains(Integer key) {
        return map.containsKey(key);
    }

    /**
     * Retrieve an element from the map. Because {@code null} values are not allowed,
     * a returned value of {@code null} will always mean that the map did not contain
     * the value. Therefore, a call to {@link #contains(Object)} which returns true
     * will guarantee that a call to get(key) will always return a non-null value.
     *
     * @param key the lookup key
     * @return the value stored under the given key, or null
     */
    public synchronized List<org.cerner.multiplex.packageinfo.model.Package> get(int key) {

        List<org.cerner.multiplex.packageinfo.model.Package> packages = new ArrayList<>();
        for (Map.Entry<Integer, Package> entry : map.entrySet())
        {
            org.cerner.multiplex.packageinfo.model.Package packageItem = (org.cerner.multiplex.packageinfo.model.Package)entry.getValue();
            if (packageItem.getHospitalId() ==  key) {
                packages.add(packageItem);
            }
        }
        return packages;
    }
}

