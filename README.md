# YT Lessons
A bunch of utils class and demonstration of Java code with JavaFX.

#### ![ACTF - Auto Complete Text Field](https://github.com/rponciano/YTLessons/tree/master/src/main/java/rponciano/ACTF)
Class created to look up user suggestions when entering text into a TextField. These suggestions are based on a list that must be passed in the constructor, in addition to the maximum number of suggestions that will be displayed.

#### ![AHTV - Auto Header Table View](https://github.com/rponciano/YTLessons/tree/master/src/main/java/rponciano/AHTV)
Class created to make it easy to create the JavaFX TableView header. With this class, just instantiate and call a method for the header to be created based on the data class of the table.

#### ![DCRG - Dynamic CheckBox/RadioButton Group](https://github.com/rponciano/YTLessons/tree/master/src/main/java/rponciano/DCRG)
Class to generate list of checkboxes or radios, dynamically. The class generates the group from an Object list.

#### ![DD - Drag & Drop demonstration](https://github.com/rponciano/YTLessons/tree/master/src/main/java/rponciano/DD)

#### ![LWC - List With Control](https://github.com/rponciano/YTLessons/tree/master/src/main/java/rponciano/LWC)
Class created to manage a layout containing a list, a field for the user to add data (combobox or textfield) and two buttons to control: add or remove item from the list.

## How to run

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
1. JDK 8 161 (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
```
java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)
```

2. Apache Maven 3.5.0 (https://maven.apache.org/docs/3.5.0/release-notes.html)

### Getting started

1. Download or clone this repo.

2. Inside root folder, execute 
```
mvn clean install
```

3. Run the jar file
```
java -jar target/...*.jar
```

You should see the result and done! 

## License

The code is under the [Common Creative License BY-NonCommercial](https://creativecommons.org/licenses/by-nc/4.0/legalcode)
