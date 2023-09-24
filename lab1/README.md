Notes about lab1
# Lab1_2

## Run WeatherApp

mvn package

mvn exec:java -Dexec.mainClass="com.mk.app.WeatherStarter" -Dexec.cleanupDaemonThreads=false -Dexec.args="1010500" 

## INFO

Aveiro ID: 1010500


# Lab1_3
## Usefull git commands
| Comand | What it does |
| ------ | ------------ |
|
| git init	                               | #Initialize a local Git repository|
| git clone repo_url	                   | #Clone public repository|
| git status	                           | #Check status|
| git add [file-name]	                   | #Add a file to the staging area|
| git add -A	                           | #Add all new and changed files to the staging area|
| git commit -m "[commit message]"	       | #Commit changes|
| git rm -r [file-name.txt]     	       | #Remove a file (or folder)|
| git branch	                           | #List of branches (the asterisk denotes the current branch)|
| git branch -a	                           | #List all branches (local and remote)|
| git branch [branch name]	               | #Create a new branch|
| git branch -d [branch name]	           | #Delete a branch|
| git branch -D [branch name]	           | #Delete a branch forcefully|
| git push origin --delete [branch name]   | #Delete a remote branch|
| git checkout -b [branch name]	           | #Create a new branch and switch to it|