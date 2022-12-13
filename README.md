# M320
Joel Sow Mischa Strauss 

### Aggregation / hat-beziehung:
In Java, aggregation refers to the act of combining multiple objects into one object. 
This can be thought of as creating a "has-a" relationship between the objects. 
For example, if you have a Car class and an Engine class, the Car class could have an instance of the Engine class as one of its attributes. 
This would mean that a Car "has-an" Engine, and the relationship between the two classes is an example of aggregation.

```java
public class Car {
  private String name;
  private Engine engine;
  public Car(String name, Engine engine){
      this.name = name;
      this.engine = engine;
  }
}

public class Engine {
  private String name;
}
```
***

### Composition
Composition refers to the act of creating objects that are made up of other objects. 
This is similar to aggregation, but with one key difference: 
in composition, the composed objects have a strong ownership relationship, meaning that they cannot exist independently of the object that contains them. 
For example:
A Car object would have an Engine object as one of its attributes. 
However, in this case, the Engine object would be created and destroyed along with the Car object. 
This means that the Car "is-made-up-of" Engine, and the relationship between the two classes is an example of composition.

```java
public class Car {
  private String name;
  private Engine engine;

  public Car() {
    engine = new Engine();
  }
}

public class Engine {
  private String name;
}
```