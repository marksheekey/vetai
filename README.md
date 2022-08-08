# VetAI Technical

We prepared an app for you. It's quite simple, composed of just 2 screens.
The first screen displays a list of Pokemon from this API: https://pokeapi.co/api/v2/pokemon/
The second screen displays the details of the pokemon selected.

The app is purposely buggy and could use some improvements.

You are to improve the app in any way you see fit and will need to explain the choices you make in the 2nd stage interview.

Feel free to choose any libraries you want to create your solution.

We suggest you spend a few hours on it. When you are satisfied with the result you can share the repo with us on Github to `GiacomoDB` or Gitlab to `giacomo.debacco`.
Any issue or question drop us an email at giacomo.de.bacco@vet-ai.com.

Please fork or download this repo and work on it on your own space. You can send it as instructed above.
Thank you.


Mark Sheekey's contribution...

Issues Found.

1. I dont see a list of pokemon - just one.
2. Clicking "Show Only Favourites" adds another same item to the list.
3. Clicking on an item, you see the name, no images or details.
4. Clicking on the check box on a list item has the same effect as the bug in 2.
5. Going back from detail shows only the one item. Itself may bnot be abug, rather you see the bug in 1. manifest again.
6. In general, although not strictly "bugs" the app has no stryling or standard buttons (eg back button)
- it just doesnt look lkike a good Android app
7. I'd update dependencies too.
8. In "real" world i'd be tempted to apolit app into modules, a module for ROOM, a module for the API, maybe have a separate one for the repos.
9. 

Steps taken to Improve.
1. Get full list
   -- I see we are using RxJava - I have never used this - In the real world I'd learn what I need to so that I can
   make the necessary changes. But, in this case I'll change everything so it's more "standard" Android.
   This app isn't complicated, so feel justified in getting rid of something that adds complexity. At least, complex for me.
2. I've reorganised some of the folder srtructure.
3. I've made it so, we will eventually have paging on the loading of pokemon
4. I put in an app bar, makes it look nicer.

**** Things not done yet.
1. Build list with recycler view, so can get last scroll prosition and then load new page of pokemon
2. Need mechanism to update db with favourite flag
3. I think what i have in place will successfully toggle between favourited / not favourite
4. Will use GLide to get image for pokemon
5. THe spec asked me to submit when satisfied - I'm not satisfied it as it's not working and i havent finished.
