# Dynamic CheckBox/RadioButton Group
Class to generate list of checkboxes or radios, dynamically. The class generates the group from an Object list.

This code<br>
![code](https://user-images.githubusercontent.com/6250218/54032810-690c7c00-4191-11e9-9972-9c926b9aaf87.png)

Generate this result<br>
![result](https://user-images.githubusercontent.com/6250218/54032811-69a51280-4191-11e9-9664-ecc8c3f78d6e.png)


<br>
<b>VERY IMPORTANT: To work, the toString() method of Object Class must be @Override to return the String that wants to be displayed next to the CheckBox/RadioButton.</b> 
<br>
See [ModelExample.java](https://github.com/rponciano/DCRG/blob/master/src/main/java/rponciano/DCRG/ModelExample.java)

[Go to class!](https://github.com/rponciano/DCRG/blob/master/src/main/java/rponciano/DCRG/DynamicCRGroup.java)

1. [How to run](#1-How-to-run)
2. [Methods](#2-Methods)
3. [License](#3-License)

## 1. How to run

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
mvn clean package install
```

3. Run the jar file
```
java -jar path/jar/file/...*.jar
```

You should see an interface and done! 

## 2. Methods
public Boolean isSelectedAtPosition(int position);
```
Method used to tell if a CheckBox/RadioButton is checked.
@param position - position of the element. Start at 0.
@return True if the component is checked; False otherwise;
null if something is wrong.
```

public String getTextAtPosition(int position)
```
Method used to get the text of the component at position.
@param position - position of the element. Start at 0.
@return String of the component in position.
```

public Object getObjectAtPosition(int position)
```
Method to get the object at position.
@param position - position of the element. Start at 0.
@return Object at position.
```

## 3. License

The code is under the [Common Creative License BY-NonCommercial](https://creativecommons.org/licenses/by-nc/4.0/legalcode)
