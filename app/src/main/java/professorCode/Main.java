package professorCode;

import javafx.application.Application;
import javafx.stage.Stage;
import studentCode.GhostSkeleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main  extends Application {

    private String dictionaryFilePath, sharedFilePath;
    private int minWordLength;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parameters params = getParameters();
        List<String> list = params.getRaw();

        if(list.isEmpty()){
            throw new IllegalArgumentException(getTeamName()+".jar could not start because a shared file path was not specified as a runtime argument.");
        }

        if(list.size() < 2){
            throw new IllegalArgumentException(getTeamName()+".jar could not start because there are not enough runtime arguments specified. Excepted > 1 but received "+list.size()+".");
        }

        if(!new File(list.get(0)).exists()){
            throw new FileNotFoundException(getTeamName()+".jar could not start because a shared file path specified points to a file that does not exist.");
        }

        sharedFilePath = list.get(0);

        dictionaryFilePath = getRunningDirectory()+File.separator+"ARBITER_DICTIONARY.txt";

        if(!new File(dictionaryFilePath).exists()){
            throw new FileNotFoundException(getTeamName()+".jar could not start because the dictionary could not be found.");
        }

        minWordLength = Integer.parseInt(list.get(1));

        GhostSkeleton skeleton = new GhostSkeleton(primaryStage, getTeamName(), sharedFilePath, dictionaryFilePath, minWordLength);

        Thread thread = new Thread(skeleton);

        thread.start();
    }

    /**
     * Returns a file object representing your jar file.
     * @return A file object
     */
    private static File getJarFile(){
        return new java.io.File(GhostSkeleton.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath());
    }

    /**
     * This will figure out your team name by using the name of your jar file.
     * @return A string representing your team name. The string is equal to the name of your jar file.
     */
    public static String getTeamName(){
        return getJarFile().getName().replaceAll(".jar", "");
    }

    /**
     * This will return the directory that your jar file is located in. This is useful when you want to reference
     * your dictionary text file when it is located in the same directory as your jar file.
     * @return The current directory of your jar file.
     */
    public static String getRunningDirectory(){
        return getJarFile().getParent();
    }


}
