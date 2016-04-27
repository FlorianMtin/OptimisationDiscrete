/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrien
 */
public abstract class Lieu {
    protected float longitude;
    protected float latitude;
    protected int codepostale;
    protected String name;
    protected String id;
    
    public Lieu (String id, String name, int codepostale, int longitude, int latitude)
    {
        this.id = id;
        this.name = name;
        this.codepostale = codepostale;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public int distance (Lieu autreLieu)
    {
        double R = 6371; //Rayon de la Terre moyen
        double a = Math.toRadians(this.latitude);
        double b = Math.toRadians(autreLieu.latitude);
        double c = Math.toRadians(autreLieu.longitude - this.longitude);
        double d = Math.toRadians(autreLieu.latitude - this.latitude);

        double dist = Math.sin(d/2)*Math.sin(d)/2+Math.cos(a)*Math.cos(b)*Math.sin(c/2)*Math.sin(c/2);
        return (int) ((int) R * (2 * Math.atan2(Math.sqrt(dist), Math.sqrt(1 - dist))));
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public int getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
