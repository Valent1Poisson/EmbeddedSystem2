# Assignements
Cours Embedded system BJTU

### Valentin POISSON 18929045 & VENUTI Leo 18929053

## Assignements 1

Simple interface to log in and sign up, just an introctuction to layout and managing activities. We didn't use Fragment for the Menu of our App because of software issue that didn't allow us to use this feature (Gradle version could'nt be update). On Coach avtivity, There is a CardView with a recycler View to display Trainer. This list update dynamically. If you click on one trainer you will go on his personnal information. From this activity is possible to send a message to the trainer. On the other feature for the training there is a list View where you can find different Online Video. The last feature for student are the choice of courses depending of your preferencies. You can add Coach filter, time filter and sport filter to find the best course you want. There is a last features only for coach which allow the user to offer courses with different filter.

## Assignements 2 : 

For the database we decided to use a local one because of the difficulty to implement a standard one and communicate with http request. So we chose the most use : SQLite, which is highly like standard SQL request. furthermore we offer the possibility to add two types of account, student one and a teacher one. 
We linked de data base to the login user authentification and to the form for signup.
When you are connected you have a button to get a card view with the list of the personal trainers, when you click on one,appear all the information about the trainer.

## Assignement 3 :

On your user space we add a button to get a list of advising sport videos and we implemented a video player that get videos from internet and allow to remote the playing.
About the messenger we only implemented a little UI that seems to a messenger service. Implemented a full messenger servir will be very hard and long to do. Thats why we added on click on a textView an alertDialog that launch AlertDialog with positive and negative Button for calling or sending message.

## Assignement 5 :

We chose to implement a Facebook connection possibility. Unfortunately we succeed to add the feature but we had some issues to make it work properly because of our android gradle version. We succeed to make it work on an other computer with update, but to allow us to work on our own computer we put in comment all facebook code.
