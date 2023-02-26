@REM Build the project, see README
@REM Copy the fatjar and this bat file at the root of the folder where files will be extracted
@REM Modify the path to the installation if needed
@REM Then run the bat file
set installpath="C:\Program Files (x86)\Games\Funcom\Secret World Legends"
java -jar tswrdb-0.0.1.jar export rdbtype 1020002 --tsw %installpath%
java -jar tswrdb-0.0.1.jar export rdbtype 1020003 --tsw %installpath%
java -jar tswrdb-0.0.1.jar export rdbtype 1020005 --tsw %installpath%
