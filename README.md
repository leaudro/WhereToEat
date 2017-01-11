# WhereToEat

Project made using Kotlin language and MVP architecture. 

Web-service made in Python in a few hours (terrible! haha)
- https://github.com/leaudro/wheretoeat-python

Available in Heroku: 
- https://wheretoeat-python.herokuapp.com/
Data is being saved in Firebase

## Running the app:
- When you run the app for the first time, you see a screen where you should type a username. It will be saved internally and will be used to compute your votes.
- This "login" screen appears until you confirm a username. After that, you will always be redirected to the places' list (main screen)
- On the main screen you will see a list of places available to lunch. You can see if a place was already voted on the same week, or if you vote on any place on the same day.
- In case you already voted on that day, you can't vote again.
- After noon, votes are blocked, and you can see the name of the Place chosen on that day (the one with the most votes)

## Highlights
- MVP(Model/View/Presenter) Architecture: Organized and well defined code
- Dependency Injection using Dagger
- Painless Thread-safe thanks to Rx
- Very little coupling: well defined layers, easy to change/maintain

##Improvements needed
- A better web-service to provide data to the app
- Move some business logic from the app to the server (i.e.: place of the day / blocking votes)
- Real sign-in (email/password)
- Take advantage of Firebase
- Use location
