/**
 * For use in Compsci 201, P0, Duke University
 * @author rfd10, Rodrigo de Albuquerque
 * To be modified by students in 201, when you make
 * a modification, add yourself as an author in these
 * comments.
 *
 */
public class Person201 {

    private String myName;      // name of person
    private double myLatitude;  // latitude  (N is +, S is -)
    private double myLongitude; // longitude (W is -, E is +)
    private String myPhrase;    // phrase associated with person

    /**
     * Default constructor for Owen@Duke
     */
    public Person201(){
        this ("Owen", 35.9312, -79.0058, "woto");
    }

    /**
     * Construct Person201 object with information
     * @param name typically first name of person
     * @param lat latitude, negative for southern hemisphere
     * @param lon longitude, negative for western hemisphere
     * @param phrase for person
     */
    public Person201(String name,
                     double lat, double lon,
                     String phrase) {
        myName = name;
        myLatitude = lat;
        myLongitude = lon;
        myPhrase = phrase;
    }

    /**
     * Returns the latitude as double, negative for below equator
     * @return this person's latitude
     */
    public double getLatitude(){
        return myLatitude;
    }

    /**
     * Returns the longitude as double, negative for west of prime meridian
     * @return this person's longitude
     */
    public double getLongitude(){
        return myLongitude;
    }

    /**
     * Returns phrase for this person.
     * @return phrase for this person.
     */
    public String getPhrase(){
        // TODO change here
        return this.myPhrase;
    }

    /**
     * Returns name of this person.
     * @return name of this person
     */
    public String getName(){
        // TODO change here
        return this.myName;
    }


    /**
     * Returns String using E/W for longitude, N/S for latitude
     */
    @Override
    public String toString(){
        String lats = "" + Math.abs(myLatitude);
        if (myLatitude < 0) {
            lats += "S";
        }
        else {
            lats += "N";
        }
        String lons = ""+Math.abs(myLongitude);
        if (myLongitude < 0) {
            lons += "W";
        }
        else {
            lons += "E";
        }
        return String.format("%s %s @ %s %s",myName,myPhrase,lats,lons);
    }
    
    @Override
    public boolean equals(Object o) {
    	//protection code
    	if(this == o) return true;
    	if(! (o instanceof Person201)) return false;
    	if(o == null) return false;
    	
    	Person201 person = (Person201) o; //casting an Object pointer to a Person201 pointer 
    	
    	if(!this.myName.equals(person.myName)) {
    		return false;
    	}
    	
    	else if(this.myLatitude != person.myLatitude) {
    		return false;
    	}
    	
    	else if(this.myLongitude != person.myLongitude) {
    		return false;
    	}
    	
    	else if(!this.myPhrase.equals(person.myPhrase)){
    		return false;
    	}
    	
    	return true;
    }
    
}
