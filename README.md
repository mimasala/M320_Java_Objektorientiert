# M320
Joel Sow Mischa Strauss 

---
## Introduction
### Encapsulation:
Encapsulation protects an object from unauthorized acces by clients.
You access these objects through methods. 
This is done by making the instance variables private and providing public methods to access them.

<b>example:</b>
```java
public class entity{
    private int x;
    private int y;
    public entity(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
```
<b>Usages:</b>
- User.java
- Beatmap.java


### Information Hiding:
Information hiding is a way to hide the implementation details of a class from the user.
This is done by making the instance variables private and providing public methods to access them.

<b>example:</b>
```java
public class entity{
    private int x;
    private int y;
    public entity(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
```
<b>Usages:</b>
- User.java
- Beatmap.java

### Getter, Setter:
Getter and Setter are methods that are used to access and modify the value of a private variable.
Getter is used to access the value of a private variable.
Setter is used to modify the value of a private variable.

<b>example:</b>
```java
public class entity{
    private int x;
    private int y;
    public entity(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
```
<b>Usages:</b>
- User.java
- Beatmap.java

### Delegate:
Delegate is a method that is used to delegate a task to another method.
This is done by calling the method that is delegated to.
    
<b>example:</b>
```java
public class entity{
    private int x;
    private int y;
    public entity(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void move(int x, int y){
        setX(x);
        setY(y);
    }
}
class runner{
    public static void main(String[] args){
        entity e = new entity(0,0);
        e.move(1,1);
    }
}
```

<b>Usages:</b>

>`Menu.java:`
>```java
>String userSelection = InputService.getString("Enter your selection: ");
>```

>`InputService.java:`
> ```java
>  public static String getString(String message) {
>      System.out.print(message);
>      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
>      try {
>          return reader.readLine();
>      } catch (IOException e) {
>          e.printStackTrace();
>      }
>      return "";
>  }
> ```

---

## Project/implementation

the classes User.java and Beatmap.java are Objects, which are used to store data.
The class Menu.java is a class that is used to display the menu and get the user input.
The class InputService.java is a class that is used to get the user input.
The class Main.java is the main class that is used to run the program.

Service classes are used to delegate tasks to other classes.

I implemented some helper classes, which dont directly serve an object, but are used to delegate code to other classes.
These classes are:

the OsuLog.java class is used to log certain texts to the console with colors.


