package game.view;

/**
 * Implementation interface of the Observer pattern. {@code ViewListener}
 * act as the type of the subject. In this manner, this type is asign to
 * the classes of the model package or more generally to the {@code ModelManager}
 * class.
 * 
 * @author  Guillaume Schneider
 * @version 1.0
 * @since   2021-04-12
 * @see     <a href="https://en.wikipedia.org/wiki/Observer_pattern">
 * Observer Pattern<a>
 */
public interface ViewListener {

    public void update();
    
}
