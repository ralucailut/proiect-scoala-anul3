/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.util.Objects;

/**
 *
 * @author yo5bdm
 */
public class User {
    private int id;
    private int clasa;
    private String username;
    private String password;
    /**
     * Constructor folosit pentru citirea userului din baza de date
     * @param id
     * @param clasa
     * @param username
     * @param password 
     */
    public User(int id, int clasa, String username, String password) {
        this.id = id;
        this.clasa = clasa;
        this.username = username;
        this.password = password;
    }
    /**
     * Constructor folosit pentru citirea userului din fereastra de login
     * @param username
     * @param password 
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.clasa;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
