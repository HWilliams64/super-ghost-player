package studentCode;

import java.util.Objects;
import javafx.stage.Stage;
import professorCode.IOManager;
import professorCode.TurnParserV2;
import professorCode.TurnParser;
import sharedCode.AddLocation;
import sharedCode.SharedGameData;

public class GhostSkeleton implements Runnable{

	private String sharedFilePath;
	private String myTeamName;
	private int minWordLength;
	private String fragment;

	private FileManager fileManager;
	private IOManager<SharedGameData> ioManager;
	private Dictionary dictionary;
	private TurnParserV2 turnParser;
	private GameManager gameManager;
	private Stage primaryStage;

	public GhostSkeleton(Stage primaryStage, String myTeamName, String sharedFilePath, String dictionaryFilePath, int minWordLength) throws Exception {
		//Use this code to get the name of the containing jar file
		this.myTeamName = myTeamName;

		//The path to the shared game file, passed to my program by the arbiter program
		this.sharedFilePath = sharedFilePath;

		//The minimum winning word length
		this.minWordLength = minWordLength;

		//The primary java fx stage
		this.primaryStage = primaryStage;

		this.turnParser = new TurnParser();


		/*
		 * Add you custom code for initialization of your classes below
		 */
		this.fileManager = null;//Add your FileManager from the last project here

		this.dictionary = null; //Add your Dictionary from the last project here

		this.ioManager = null; //Add your IoManager here
		this.ioManager.setPath(this.sharedFilePath);

		this.gameManager = new GameManager(this.primaryStage, this.ioManager, this.myTeamName, this.minWordLength, this.dictionary);
	}


	@Override
	public void run() {
		try {

			System.out.println(myTeamName + " STARTED");

			SharedGameData currentGameData;

			while (true) {
				fileManager.update();

				if (fileManager.hasChanged()) {

					//We want to get the most recent version of the file
					currentGameData = ioManager.read();

					if (Objects.isNull(currentGameData)) return;

					if (turnParser.isGameOver(currentGameData)) {
						System.out.println(myTeamName + " TERMINATED");
						System.exit(0);
					} else if (turnParser.isMyTurn(myTeamName, currentGameData)) {
						//Update the current word fragment this is useful for when deciding the next letter to play
						updateWordFragment(currentGameData);

						gameManager.makeTurn(currentGameData, fragment);
					}
				}
			}
		}catch (Throwable e){
			System.err.println("_______["+this.myTeamName+"] Error GhostSkeleton Main Loop_______");
			e.printStackTrace();
		}
	}

	public void updateWordFragment(SharedGameData shareGameData) {

		fragment = "";

		shareGameData.gameActions().forEach(action -> {
			boolean isFront = action.getAddLocation().equals(AddLocation.Front);

			String letter = String.valueOf(action.getLetter());

			fragment = isFront ? letter+fragment : fragment+letter;
		});
	}
}
