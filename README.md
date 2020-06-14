# IBM-project

## drools-hello-world
This project consists of Drools rule file and supporting classes which categorizes a student based on his/her **CGPA**.
Additional details are also added to match the Excel Data. 

**More rules can be added according to the need.**

>> Run the code (DroolsStudent.java) as 'Java Application' in eclipse IDE.

In case of any error while executing the **DroolsStudent** class :
>> Go to 'Project' -> 'Clean', in the menu bar, to clean the build path

### Output 
![output of Drools Flow](https://github.com/garima2910/IBM-project/blob/master/output.PNG)

## ReadExcel
This project consists of apache.poi modules and related class which reads the data in 'student_data2.xlsx' based on **Student Type**.

Student types defined in it are :-

**1. Excellent :** CGPA>=9.0 and CGPA<=10.0

**2. Good      :** CGPA>=8.0 and CGPA<9.0

**3. Average   :** CGPA>=5.0 and CGPA<8.0

**4. Bad       :** CGPA<5.0
