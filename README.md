# Super Ghost Player

This is an empty ghost project you may use to develop your super ghost
application.

## Getting started
It is assumed you are running your code in the courses pre-configured Grader
Than Workspace

1. (Optional) Open your terminal and change the directory to a location you would like to
   save this project. Use the `cd` command to change the directory. Below is an
   example:

    ```shell
    cd file/path/to/directory/ 
    ```

2. Clone this repository by running the following command:

    ```shell
    git clone https://github.com/HWilliams64/super-ghost-player.git
    ```

    You will now see a directory by the name of super-ghost-player in the
    current directory. This is your ghost project.

3. Change your IDE Workspace to the projects root directory. **File** > **Open
   Folder** > *Select the folder named super-ghost-player* 
   
4. Now that your IDE is open in super-ghost-player workspace add your homework
   files. Add your the files you created from the *Object Serialization and
   Deserialization* and *Ghost Primer* homework assignments to the folder
   [app/src/main/java/studentCode](app/src/main/java/studentCode). These files
   include FileManager.java, MyIOManager.java, and Dictionary.java.

5. Update lines 41, 43, and 45 in the
   [GhostSkeleton.java](app/src/main/java/studentCode/GhostSkeleton.java) file.

## Adding Game Logic and a GUI

### Game Logic 

Open the [GameManager.java](app/src/main/java/studentCode/GameManager.java) file
and add your game logic to the `onTurn()` method on line 84. This method is
called every time it is your turn. You are given the current word fragment of
the game. In this method you will figure out the next letter and the location of
the letter to be played.

### GUI

Open the [GameManager.java](app/src/main/java/studentCode/GameManager.java) file
and add your GUI setup code to the `GameManager()` constructor on line 45. This
constructor is called once at the start of the game you are given The java fx
stage, your IO Manager object you initialized in the Game Manager class, your
team name (The file name of you jar file), the minimum word length of the game
(This will not change during the game), and the dictionary you created in the
Game Manager class. Use this function to setup all your GUI widgets and draw
them on the stage. Additionally initialize any classes or variables needed so
that your application may effectively play the ghost game. Its recommended that
assign the primaryStage, minWordLength, and dictionary to local class variables
so you may access them in the onTurn function which will be called during the
game.

To update the GUI write your code in the `updateGUI()` method on line 96. This
method is invoked immediately after your `onTurn()` method has successfully
completed. This is where you should update your GUI with the necessary graphical
changes.

Don't forget, you must recreate your jar file each time you change your code.
Recreate your jar file by running `gradle :shadowJar`. Then run SGhostapp.jar
file to test your changes.

By completing this you have effectively completed the entire project.

Feel free to add as many other classes and files as needed to achieve a winning
solution.

## Create and run a .jar file
1. Create a jar file by running the following command:
   
    ```shell
    gradle :shadowJar
    ```

    You will notice a file by the name of your_team_name.jar in your project
    directory. This is your ghost application.

    To change the name of the jar file open the build.gradle file and modify
    line 41. After changing the name in the build.gradle file, run the
    `shadowJar` command from above again.

2. Start the ghost game by running the SGhostApp.jar file with your jar file.
   Run the following command:

    ```shell
    java -jar SGhostApp.jar your_team_name.jar
    ```
    
    On your desktop you will see a window popup where you can begin to play the
    ghost game. You are done!

    **WARNING**: You will not be able to fully play the game until you add the
    game logic.
    
## View the application GUI
The easiest way to view the GUI is to use Grader Than Desktop from within the
Grader Than IDE.

1. Copy your workspace's URL.
   
2. press ctrl-shift-p to open the command palette. A text field will appear in
   the top middle of the screen. [Read more on how to open the command
   Palette](https://code.visualstudio.com/docs/getstarted/userinterface#_command-palette).
   
3. Type Simple Browser: Show in the command palette text field.
   
4. Paste the URL you copied from step 1. Before pressing ENTER, replace the word
   'ide' in the URL with 'desktop'. (The word 'ide' can be found before
   /?folder=)

5. In the window that appears you will see the running Ghost applications.

## Submitting

Submit your jar file. Make sure your jar file is named something other than
"your_team_name.jar".