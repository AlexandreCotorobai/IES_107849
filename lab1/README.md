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

# Lab1_3

touch Dockerfile 

docker build -t <directory_name> .

docker run -dp 127.0.0.1:3000:3000 getting-started  ## OR SIMILAR

docker ps
docker stop <the-container-id>
docker rm <the-container-id>

docker rm -f <the-container-id> stops and removes at in one command

### Share App
docker tag getting-started YOUR-USER-NAME/getting-started
docker push YOUR-USER-NAME/getting-started

### Containers
docker run -d ubuntu bash -c "shuf -i 1-10000 -n 1 -o /data.txt && tail -f /dev/null"
docker exec <container-id> cat /data.txt
docker run -it ubuntu ls /

### Volumes
docker volume create todo-db
docker run -dp 127.0.0.1:3000:3000 --mount type=volume,src=todo-db,target=/etc/todos getting-started

docker volume inspect todo-db