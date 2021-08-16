**SprintFit**


This app lets you upload and add your fitness activities and view fitness statistics to aid you in better understanding your own health and fitness habits.

**Description and Features**

SpringFit lets you add, edit, and delete fitness activities. Each activity is comprised of activity name, duration, date, calories burned, and distance.
You may add activities manually or upload a JSON of the appropriate format to upload many activities simultaneously.
Activities can currently be sorted by calories burned.
Four graphs are generated based on the data and can be navigate to via the navigation bar on the UI. The graphs update automatically when any activity is added, deleted, or edited.

**Getting Started**

**Dependencies**

Note that you will not beed to install or download any of the following for installation, as they are packaged with the program; see installation section for installation.

	•	Spring Boot with Maven framework
	•	JDBC mysql connector jar to connect to database.
	•	Org.json library for parsing JSONs
	•	Thyme leaf template for front-end
	•	Chart.js (this will NOT require a download, as the library is currently implemented via cloud).
	•	Highcharts.js


**Installing**	

	•	Simply clone from Github and open with IntelliJ.
	•	Under the Maven tab, the user may need to click Reload All Maven Projects, Generate Sources and Update Folders For All Projects, as well as Download Sources and/or Documentation. The user should then restart IntelliJ.


**Executing program**

	•	You must first create a MySql table to contain the data. It is recommended that the table be named “activities.” The table will need the following columns: id, activity_name, duration, calories, distance, date. Please ensure that the table is constructed exactly as depicted on the MYSQL.png image.
	•	Navigate to the storylineParser package and open the DAOJDBC class. Under URL, add your MySql Schema, not the name of the table itself. Add user (default root) and password.
	•	To run the program, right click MyFitnessAppwithMvcApplication class and press run.
	•	To manually fill the table with a JSON, run Main under the storylineParser package. This will load the storyline.json in the resources package.
	•	Note that the app only supports the exact JSON format of the included storyline.json.


**Known Issues**

The calories burned per year bar graph will not load unless there are at least five years of data. Uploading the json by navigating to upload within the application UI or running the storylineParser Main should suffice.

**Authors**

•Zachary Sylvane

•Donghyeon Kim (Sam)

•Pradeepti Reddy Tandra

