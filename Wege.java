import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.List;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Border;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;

/**
 * Game implementation of board game Wege Landlock
 * @author Erica Lee
 */
public class Wege extends Application{
    // Field for rows and columns of the board being created setting default board size to 6 x 6
    private int numberRows;
    private int numberColumns;
    private int numberSquares;
    private int numberCards;
    private Board board;

    private BorderPane layout;
    private int turnNumber = 0;

    /** Create the game
     * @param numberRows and numberColumns
     */
    public void start (Stage primaryStage) {

        /** makes the board with the args from the main method
         * @param defines numberRows and numberColumns
         */
        List <String> args = getParameters().getRaw();
        if (args.size() == 2) {
            numberRows = Integer.parseInt(args.get(0));
            numberColumns = Integer.parseInt(args.get(1));
            numberSquares = numberRows * numberColumns;
        }

        else if (args.size() == 3) {
            numberRows = Integer.parseInt(args.get(0));
            numberColumns = Integer.parseInt(args.get(1));
            numberCards = Integer.parseInt(args.get(2));
        }


        /** makes the board with the args from the main method
         * no param needed
         * the default value is used which is 6 rows and 6 columns
         */
        else{
            numberRows = 6;
            numberColumns = 6;
            numberSquares = 36;
            numberCards = 0;
        }

        Board board = new Board(numberRows, numberColumns);
        //creates a layout for the gridpane of the board and the buttons with label at bottom
        layout = new BorderPane();

        /** creates a button and a new created and shuffled deck will be represented in this button
         */
        FlowPane flowPane = new FlowPane();
        Label labels = new Label();
        labels.setText("Player 1's Turn" + '\n' + "Click to draw");

        //("Player" + (turnNumber%2 + 1) + "'s Turn" + '\n' + "Click to draw & rotate" + '\n');
        layout.setTop(board.getGridPane());
        WegeButton deck = new WegeButton(75, 75);
        Deck drawingDeck;
        if (numberCards == 0) {
            drawingDeck = new Deck();
        }
        else {
            drawingDeck = new Deck(numberCards);
        }
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(deck, labels);
        flowPane.setAlignment(Pos.CENTER);
        layout.setBottom(flowPane);


        primaryStage.setTitle("Erica's Wege LandLock Game!");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();


        /** Event handler for if the player clicks on the deck
         */
        deck.setOnAction(new EventHandler <ActionEvent> (){
            public void handle (ActionEvent e) {
                if (deck.getCard()== null){
                    deck.setCard(drawingDeck.getDeck().get(0));
                    //if (turnNumber %2== 0) {
                    //   labels.setText("Player 1's Turn" + '\n' + "Click to rotate");
                    // }



                    // else {
                    //  labels.setText("Player 2's Turn" + '\n' + "Click to rotate");
                    //}
                }
                else{
                    deck.rotate();
                }
            }
        });

        /** Event handler for placing the first card down
         */
        if(turnNumber == 0) {
            for (int index = 0; index < numberSquares; index++) {
                board.getIndexButton(index).setOnAction(new EventHandler <ActionEvent> (){
                    public void handle (ActionEvent e) {
                        WegeButton b = (WegeButton) e.getSource();
                        b.setCard(deck.getCard());
                        drawingDeck.getDeck().remove(0);
                        deck.setCard(null);
                        turnNumber = turnNumber + 1;
                    }
                });
            }
        }


        /** Event handler for if the player clicks on a button in the grid to place the card from the deck there
         */
        if (turnNumber != 0) {
            for (int index = 0; index < numberSquares; index++) {
                // first checks if there are adjacent cards to where it is being placed
                board.getIndexButton(index).setOnAction(new EventHandler <ActionEvent> (){
                    public void handle (ActionEvent e) {
                        WegeButton b = (WegeButton) e.getSource();
                        if(deck.getCard() != null ) {//&& board.checkAdjacent(board.getIndex(b))==true) {
                            b.setCard(deck.getCard());
                            drawingDeck.getDeck().remove(0);
                            deck.setCard(null);
                            turnNumber = turnNumber + 1;

                            if (turnNumber %2== 0) {
                                labels.setText("Player 1's Turn" + '\n' + "Click to draw");
                            }
                            else {
                                labels.setText("Player 2's Turn" + '\n' + "Click to draw");
                            }
                        }
                        else {
                            System.out.println("akhfe");
                        }

                    }
                });
            }

        }


    }


    /**
     * Launch the game
     * @param args the command line argument is the number of rows and columns
     */
    public static void main(String[] args) {

        Application.launch(args);
    }
}
