package utils;

import java.util.ArrayList;
import java.util.List;

import utils.Boolean;

/**
 * {@code BooleanEvent} is a boolean object wrapper with some tools
 * to manipulate them. This class was coded in intention to benefit
 * from the features of the boolean primitives but with the caracteristics
 * of an object. In this case this class is a derivate from {@link utils.Boolean Boolean}.
 * <p>
 * Beyond these advantages, this class provides all the tools needed
 * to ordering series of events.
 * <p>
 * <b>note:</b> the project of this class has not been successful due to lack of
 * specification of Java about object creation (see <s>verifyInstance()</s> documentation). 
 * Some part of the code are not usefull because of that but this class remains functional.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 * @see     {@link utils.Boolean Boolean}
 * @see     {@link #verifyBooleanInstance()}
 */
public final class BooleanEvent {

    private Boolean boolItem;
    // Object declaration to verify the correct instantiation of the class

    private static List<BooleanEvent> booleanEventList = new ArrayList<BooleanEvent>();
    // BooleanEvent List needed to order the series of events

    /**
     * Construct BooleanEvent object and add this object on the 
     * List of BooleanEvent.
     */
    public BooleanEvent() { 
        boolItem = new Boolean();
        booleanEventList.add(this);
    }

    /**
     * Construct BooleanEvent object and add this object on the 
     * List of BooleanEvent.
     * 
     * @param bool  boolean value assigned to the object
     */
    public BooleanEvent(boolean bool) { 
        boolItem = new Boolean(bool); 
        booleanEventList.add(this);
    }

    /**
     * Get the boolean value of the object wrapper
     */
    public boolean get() {
        //verifyInstance();
        return boolItem.get();
    }
 
    /**
     * Set the boolean value of the object wrapper
     * @param bool  the boolean value
     */
    public void set(boolean bool) {
       // verifyInstance();
        boolItem.set(bool);
    }

    /**
     * Pathway all the {@code BooleanEvent} object created and set 
     * as true this object.
     * 
     * @param booleanEvent  {@code BooleanEvent} object set as true
     */
    public static void setOnlyTrue(BooleanEvent... booleanEvent) {
        for(BooleanEvent item : booleanEventList) {
            for(BooleanEvent bool : booleanEvent)
                if(item != bool) {
                    item.set(false);
                }
            else item.set(true);
        }
    }

    /**
     * Instantiate the object class if the object is null, otherwise
     * does nothing but return true.
     * @deprecated In order to make this class instantiate by herself
     * this function was setted up to create an instance at the call of a
     * method. As the Singleton pattern does. But Java does not have the 
     * needed spefication to do that.
     * 
     * @return <b>true</b> if instance of the class exist and <b>false</b> if instance
     * does not exist.
     */
    @Deprecated
    private boolean verifyInstance() {
        if(boolItem == null) {
            boolItem = new Boolean();
            return false;
        }
        return true;
    }
}
