# PaperCut Coding Challenge

### Problem Descriptions
 - To reduce printing waste, a school is implementing PaperCut and will
charge for printing as follows:
 - Paper size A4, job type single-sided:
    -  • 15 cents per black and white page
    - • 25 cents per colour page
 - Paper size A4, job type double-sided:
    - • 10 cents per black and white page
    - • 20 cents per colour page
 - Write a program in Java (or if we have discussed it during our phone conversation - another programming language you feel more
comfortable with) that helps the system administrator calculate the print costs.

### The application should:
 -  Read print job details - total number pages, number colour pages, and whether job is double-sided - from a file (see attached file for
an example)
 - Output the details of each print job and calculated cost to the
console
 - Output the total cost of all jobs to the console
 - Show how you have tested your application
 - Support for other paper sizes will be added in the future.

### Addition requirements
 - In addition to reviewing the way your application solves the problem, we
will be looking at the structure and maintainability of your software.

### How do your run the program
 - This application is developed under IDEA
 - You can import to IDEA and run PrintServiceExecutor main function.
 - or you can extract a jor file and run from command line.

### Solution walk through
 - The csv files is the input, each line contains print configuration, and print paper size, but its mixed with colored and no colored print jobs
 - Separate each line into two different print jobs both for colored and non-colored, in this way, it will give flexibility down the track
 - One csv consists of a list of print jobs
 - Separate code into different modules under domains package and services package.
 - Added thorough tests
 - Coded entire solution under 90 mins.
 
### Improvements down the line
 - give a input to read csv file location from console.
 - better price configuration using reflection and read from property files
 - given a simple GUI

### Author
- Seabook Chen
- seabook1024@gmail.com
- 12 years + coding experiences
- java, reactjs, nodejs, golang, blockchain

