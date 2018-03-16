# Airport-Security-System
Java application to identify the risk at the airport based on the factors such as number of passengers, hazardous items detected from passengers, airplane traffic, etc. 


Note :
<input_file> must be kept at path : Airport_Security_System/airportSecurityState

Assuming you are in the directory Airport_Security_System/airportSecurityState:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
 
ant -buildfile src/build.xml run -Darg0=(input_file_name) -Darg1=(output_file_name) -Darg2=(debug level)

-----------------------------------------------------------------------
Data Structures used:

ArrayList is used to store the prohibited items. 
Time complexity for finding prohibited items : O(n)

String is used to store the output
Time complexity for inserting the string in String array : O(n)

-----------------------------------------------------------------------

