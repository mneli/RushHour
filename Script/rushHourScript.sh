#!/bin/bash

#Create/clean RushHourProject directory
if mkdir ~/RushHourProject 2> /dev/null 
then 
	printf "\nRushHourProject folder doesn't exist at home. \nA folder with the name RushHourProject was created.\n\n"
elif rm -r -f ~/RushHourProject/* 
then
	printf "\nRushHourProject folder already exist at home. \nContent was successfully deleted.\n\n"
fi

#change directory to clone
cd ~/RushHourProject/

#clone project
if git clone https://g42861:tempPassScript@gitlab.com/cathleruste/p-g42861.git 
then 
	
	#create sub-directory RushHourProject to save .class files
	if mkdir ~/RushHourProject/RushHourProject ; then

		#src files compilation
		if	javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/Orientation.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/Direction.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/Position.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/Car.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/Board.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/RushHourException.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/view/Color.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/view/Display.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/view/Keyboard.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/model/RushHourGame.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/view/RushHourView.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/src/g42861/rushhour/RushHour.java 2> /dev/null 
		then
			printf "\nAll class compiled correctly at ~/RushHourProject/RushHourProject\n"
		else
			echo "Compile error. Please check CLASSPATH and add ~/RushHourProject/RushHourProject if needed"
		fi

		#search names of src and save them in srcNameForDoc.txt
		if find ~/RushHourProject/p-g42861/src/ -name "*.java" > srcNameForDoc.txt
		then
			#create javadoc
			if javadoc -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/p-g42861/doc -charset utf-8 @srcNameForDoc.txt > /dev/null ; then
				echo "Javadoc created at ~/RushHourProject/p-g42861/doc"
			fi
			#remove srcNameForDoc.txt
			rm srcNameForDoc.txt
		fi
		
		#test files compilation
		if	javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/test/g42861/rushhour/model/PositionTest.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/test/g42861/rushhour/model/CarTest.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/test/g42861/rushhour/model/BoardTest.java 2> /dev/null &&
			javac -J-XX:-UseCompressedClassPointers -d ~/RushHourProject/RushHourProject ~/RushHourProject/p-g42861/test/g42861/rushhour/model/RushHourGameTest.java 2> /dev/null
		then
			
			echo "All test class compiled correctly at ~/RushHourProject/RushHourProject"
			
			#save test class names and test results to rushHourTestResults.txt
			if	printf "\nPositionTest\n" >> ~/RushHourProject/rushHourTestResults.txt &&
				java org.junit.runner.JUnitCore g42861.rushhour.model.PositionTest >> ~/RushHourProject/rushHourTestResults.txt &&
				printf "\nCarTest\n" >> ~/RushHourProject/rushHourTestResults.txt &&
				java org.junit.runner.JUnitCore g42861.rushhour.model.CarTest >> ~/RushHourProject/rushHourTestResults.txt &&
				printf "\nBoardTest\n" >> ~/RushHourProject/rushHourTestResults.txt &&
				java org.junit.runner.JUnitCore g42861.rushhour.model.BoardTest >> ~/RushHourProject/rushHourTestResults.txt &&
				printf "\nRushHourGameTest\n" >> ~/RushHourProject/rushHourTestResults.txt &&
				java org.junit.runner.JUnitCore g42861.rushhour.model.RushHourGameTest >> ~/RushHourProject/rushHourTestResults.txt
			then
				echo "All test results were saved to rushHourTestResults.txt at ~/RushHourProject/"
				
				#create a folder to copy xml files if game launched via main class
				mkdir -p ~/src/g42861/rushhour/view 2> /dev/null
				cp ~/RushHourProject/p-g42861/src/g42861/rushhour/view/*.xml ~/src/g42861/rushhour/view/
				#create a folder to copy xml files if game launched via jar file
				mkdir -p ~/RushHourProject/RushHourProject/src/g42861/rushhour/view 2> /dev/null &&
				cp ~/RushHourProject/p-g42861/src/g42861/rushhour/view/*.xml ~/RushHourProject/RushHourProject/src/g42861/rushhour/view
				cd ~/RushHourProject/RushHourProject
				#create manifest text
				printf "Main-Class: g42861.rushhour.RushHour \n" > manifest.txt
				
				#create jar
				jar -J-XX:UseCompressedClassPointers cfm rushhour.jar manifest.txt g42861/rushhour/RushHour.class g42861/rushhour/model/*.class g42861/rushhour/view/*.class
				java -XX:-UseCompressedClassPointers -jar rushhour.jar
				rm manifest.txt
			fi
		else
			echo "Compile error. Please check existance of jUnit and add it to the CLASSPATH"
		fi
	fi
else
	echo "Project couldn't be cloned. Please check git credentials and relaunch the script."
fi
