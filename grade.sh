# Clear current student dir and add files from github
rm -rf student-submission
mkdir -p /Users/danielrousseau/Documents/CSE15L/list-examples-grader/student-submission
git clone $1 student-submission

# Copy tests into student folder
cp TestListExamples.java student-submission

# Check if student submission compiiles
javac student-submission/ListExamples.java 
if [[ $? -ne 0 ]]
then 
    echo "##########################################" 
    echo ""
    echo "Compilation Error, fix your mistake."
    echo "Your grade is 0/100"
    exit 1
fi


# Compile and run tests
cd student-submission
javac -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar *.java
java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > ../output.txt
cd ../

grep -E "Failures|OK" output.txt


