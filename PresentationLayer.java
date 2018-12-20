import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Window;
/**
* Presentation Layer
* @author Brandon Mok
* @version 12/18/18
*/
public class PresentationLayer extends Application implements EventHandler<ActionEvent>{
      /**
      * Gui - JavaFx
      * Problem: JavaFx does not allow same elements to be used in more than 1 scene.
      * Solution: If scenes share same element, will need to create multiple versions
      */
      // GUI
      private Stage stage;
      private Scene scene; // Login
      private Scene scene2; // Select
      private Scene scene3; // Insert
      private Scene scene4; // Update
      private Scene scene5; // Delete
      private Scene scene6; // select users
      
      // Layouts
      private VBox layout1 = new VBox(8);
      private VBox layout2 = new VBox(8);
      private VBox layout3 = new VBox(8);
      private VBox layout4 = new VBox(8);
      private VBox layout5 = new VBox(8);
      private VBox layout6 = new VBox(8);
      
      // MenuBar - Several Bars for each window (can't use same bar for every scene)
      private MenuBar mbBar = new MenuBar();
      private MenuBar mbBar2 = new MenuBar();
      private MenuBar mbBar3 = new MenuBar();
      private MenuBar mbBar4 = new MenuBar();
      private MenuBar mbBar5 = new MenuBar();
      
      // Menu
      private Menu mnProcess = new Menu("Process");
      private Menu mnLogOut = new Menu("LogOut");
      
      // Menu Items
      private MenuItem miSelect = new MenuItem("Select");
      private MenuItem miSelectUsers = new MenuItem("Select Users");
      private MenuItem miInsert = new MenuItem("Insert");
      private MenuItem miUpdate = new MenuItem("Update");
      private MenuItem miDelete = new MenuItem("Delete");
      private MenuItem miLogOut = new MenuItem("LogOut");
      
      // Labels
      private Label lblUser = new Label("Username: ");
      private Label lblPass = new Label("Password:  ");
      private Label lblSearch = new Label("  Search: ");
      private Label lblSearchBy = new Label("  Search By: ");
      private Label lblSearchBy2 = new Label("  Search By: ");
      private Label lblSpace = new Label("                 ");
      private Label lblInsert = new Label("  Insert ");
      private Label lblProjName = new Label("  Project Name ");         // Insert
      private Label lblProjDes = new Label("  Project Description ");   // Insert
      private Label lblUpdate = new Label(" Update:  ");
      private Label lblUpdateOn = new Label(" Update On: ");
      private Label lblSetNewVal = new Label(" Set new value: ");
      private Label lblSetNewValOn = new Label(" Set new value on: ");
      private Label lblDelete = new Label(" Delete Project: ");
      private Label lblDeleteOn = new Label(" Delete On: ");
      private Label lblSearchUsers = new Label("Search Users: ");
      
      // Textfields
      private TextField tfUser = new TextField();     // login
      private TextField tfPass = new TextField();     // login
      private TextField tfSearch = new TextField();   // Select
      private TextField tfInsert = new TextField();   // Insert
      private TextField tfProjName = new TextField(); // Update
      private TextField tfProjDes = new TextField();  // Update
      private TextField tfProjName2 = new TextField();// Update
      private TextField tfProjDes2 = new TextField(); // Update
      private TextField tfDelete = new TextField();   // Delete
      private TextField tfSearchUsers = new TextField();
      
      // Buttons
      private Button btnLogin = new Button("Login");
      private Button btnSearch = new Button("Search");
      private Button btnSearchUsers = new Button("Search Users");
      private Button btnInsert = new Button("Insert");
      private Button btnUpdate = new Button("Update");
      private Button btnDelete = new Button("Delete");
      
      // TextArea
      private TextArea taLog = new TextArea(); // select
      private TextArea taLog2 = new TextArea(); // insert
      private TextArea taLog3 = new TextArea(); // update 
      private TextArea taLog4 = new TextArea(); // Delete
      private TextArea taLog5 = new TextArea(); // Select Users
      
      // RadioButtons (*Can't use same elements in different scenes*)
      private RadioButton rb1, rb2, rb3, rb4;
      private RadioButton rb5, rb6, rb7, rb8, rb13, rb14;
      private RadioButton rb9, rb10, rb11, rb12;
      private RadioButton rb15, rb16, rb17, rb18, rb19; 
      
      // User role - Determines which processes are available
      private String role = "";
      
      // RadioButton Selection strings
      private String selected = ""; 
      private String selectProcess = "userID";// initially set, after clicks of rbtns
      
      // Users object
      private Users user;
      
      // Project object
      private Projects project = new Projects();
      
      // 2D Arraylist of userData for processes
      private ArrayList<ArrayList<String>> userData;
      
      // Dropdown
      private ComboBox box = new ComboBox();

 
      /**
      * Main
      */
      public static void main(String[] args){
         launch(args);
      }
      
      /**
      * Start
      */
      public void start(Stage _stage){
         stage = _stage;
        
         // LOGIN 
         btnLogin.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                  doLogin();
            }
         });


         /**
         * Layout1 - Login
         */
         // FlowPane - Username
         FlowPane fpUser = new FlowPane();
            fpUser.getChildren().addAll(lblUser,tfUser);
            
         // FlowPane - Password
         FlowPane fpPass = new FlowPane();
            fpPass.getChildren().addAll(lblPass,tfPass);
            
         // FlowPane - Login button
         FlowPane fpLogin = new FlowPane();
            fpLogin.getChildren().add(btnLogin);
            
         // Adding elements to layout
         layout1.getChildren().add(fpUser);
         layout1.getChildren().add(fpPass);
         layout1.getChildren().add(fpLogin);
         scene = new Scene(layout1, 350, 100);
         
         

         /**
         * Layout2 - Select
         */
         // Menu Bar w/ Processes
         mnProcess.getItems().addAll(miSelect,new SeparatorMenuItem(),miSelectUsers, new SeparatorMenuItem(), miInsert,new SeparatorMenuItem(),miUpdate,new SeparatorMenuItem(),miDelete);
         mnLogOut.getItems().add(miLogOut);
         mbBar = new MenuBar();
         mbBar.getMenus().addAll(mnProcess,mnLogOut);
         layout2.getChildren().add(mbBar);   // adding menubar to gui
         
         // FlowPane with search elements
         FlowPane fpSearch = new FlowPane();
            fpSearch.getChildren().addAll(lblSearch,tfSearch, lblSpace, btnSearch);
         layout2.getChildren().add(fpSearch);     
         
         // Toggle Buttons
         rb1 = new RadioButton("userID");
         rb2 = new RadioButton("projectName");
         rb3 = new RadioButton("projectID");
         rb4 = new RadioButton("description");
         rb13 = new RadioButton("ALL");
         rb14 = new RadioButton("Name");
         
         // ToggleGroup for radio buttons
         ToggleGroup group = new ToggleGroup();
         rb1.setToggleGroup(group);
         rb2.setToggleGroup(group);
         rb3.setToggleGroup(group);
         rb4.setToggleGroup(group);
         rb13.setToggleGroup(group);
         rb14.setToggleGroup(group);
         
         rb1.setTranslateX(10);
         rb14.setTranslateX(20);
         rb2.setTranslateX(30); // move radio buttons for more spacing
         rb3.setTranslateX(40);
         rb4.setTranslateX(50);
         
         rb13.setSelected(true); // set a radiobutton selected initially
         
         selectProcess = "ALL";
         
         // Search Button Clicked
         btnSearch.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                  doSearch();
            }
         });
         
         // Pane with radio buttons
         FlowPane fpRadio = new FlowPane();
            fpRadio.getChildren().addAll(lblSearchBy,rb13,rb1,rb14,rb2,rb3,rb4);

         // When Radio button is changed/clicked
         group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
             public void changed(ObservableValue<? extends Toggle> ov,
                 Toggle old_toggle, Toggle new_toggle) {
                     if (group.getSelectedToggle() != null) {
                    
                        if(rb1.isSelected()){
                           selectProcess = "projects.userID";
                        }
                        if(rb2.isSelected()){
                              selectProcess = "projects.name";
                        }
                        if(rb3.isSelected()){
                              selectProcess = "projects.projectID";
                        }
                        if(rb4.isSelected()){
                              selectProcess = "projects.description";
                        }
                        if(rb13.isSelected()){
                              selectProcess = "ALL";
                        }
                        if(rb14.isSelected()){
                              selectProcess = "users.name";
                        }
                     }                
                 }
         });     
         Font newFont = Font.font("MONOSPACED", FontWeight.NORMAL, 12);
         taLog.setFont(newFont);
         layout2.getChildren().addAll(fpRadio,taLog); 
         scene2 = new Scene(layout2, 700, 300); // sets the scene
         
         
         
         /**
         * Layout 3 - Insert
         */
         mbBar2.getMenus().addAll(mnProcess,mnLogOut);
         layout3.getChildren().add(mbBar2); // adding the menubar from previous scene
         
         // Insert fields
         FlowPane fpInsert = new FlowPane();
            fpInsert.getChildren().addAll(lblProjName, tfProjName, lblSpace,btnInsert); 
         
         FlowPane fpDescription = new FlowPane();
            fpDescription.getChildren().addAll(lblProjDes, tfProjDes);
         
         // TextArea in a flowpane
         FlowPane fpArea = new FlowPane();
            fpArea.getChildren().add(taLog2);
            
         // Insert button clicked  
         btnInsert.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                  doInsert();
            }
         });
            
         layout3.getChildren().addAll(fpInsert,fpDescription,fpArea);
         scene3 = new Scene(layout3, 700, 300);
         
         
         
         /**
         * Layout 4 - UPDATE
         */
         mbBar3.getMenus().addAll(mnProcess,mnLogOut);
         layout4.getChildren().add(mbBar3); // adding the menubar from previous scene
   
         // Toggle Buttons
         rb5 = new RadioButton("userID");
         rb6 = new RadioButton("projectName");
         rb7 = new RadioButton("projectID");
         rb8 = new RadioButton("description");
         
         // ToggleGroup for radio buttons
         ToggleGroup group2 = new ToggleGroup();
         rb5.setToggleGroup(group2);
         rb6.setToggleGroup(group2);
         rb7.setToggleGroup(group2);
         rb8.setToggleGroup(group2);
         
         rb6.setTranslateX(10); // move radio buttons for more spacing
         rb7.setTranslateX(20);
         rb8.setTranslateX(30);
         
         rb5.setSelected(true); // set a radiobutton selected initially
          
         // Update button clicked
         btnUpdate.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
               doUpdate();
            }
         });
         
         // When Radio button is changed/clicked
         group2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
             public void changed(ObservableValue<? extends Toggle> ov,
                 Toggle old_toggle, Toggle new_toggle) {
                     if (group2.getSelectedToggle() != null) {
                     
                        if(rb5.isSelected()){
                           selectProcess = "projects.userID";
                        }
                        if(rb6.isSelected()){
                              selectProcess = "projects.name";
                        }
                        if(rb7.isSelected()){
                             selectProcess = "projects.projectID";
                        }
                        if(rb8.isSelected()){
                              selectProcess = "projects.description";
                        }
                     }                
                 }
         });
         
         
         box.getItems().addAll(
            "name",
            "description"
         );
         
         box.setValue("name");
         
         
         // FlowPane - Fields
         FlowPane fpUpdate = new FlowPane();
            fpUpdate.getChildren().addAll(lblUpdate, tfProjName2, lblSpace, btnUpdate);
            
         // FlowPane - Fields
         FlowPane fpDes = new FlowPane();
            fpDes.getChildren().addAll(lblSetNewVal, tfProjDes2);
         
         // FlowPane - Radio Buttons
         FlowPane fpRadioBtn = new FlowPane();
            fpRadioBtn.getChildren().addAll(lblUpdateOn, rb5, rb6, rb7, rb8);
          
         // FlowPane - DropDown 
         FlowPane fpDrop = new FlowPane();
            fpDrop.getChildren().addAll(lblSetNewValOn,box);

         // Adding all elements to layout4 
         layout4.getChildren().addAll(fpUpdate,fpRadioBtn,fpDes,fpDrop,taLog3);
         scene4 = new Scene(layout4, 700, 300);
         
         
         
         /**
         * Layout 5 - Delete
         */
         mbBar4.getMenus().addAll(mnProcess,mnLogOut);
         layout5.getChildren().add(mbBar4);      
            
         // Radio Buttons
         rb9 = new RadioButton("userID");
         rb10 = new RadioButton("projectName");
         rb11 = new RadioButton("projectID");
         rb12 = new RadioButton("description");
         
         // ToggleGroup for radio buttons
         ToggleGroup group4 = new ToggleGroup();
         rb9.setToggleGroup(group4);
         rb10.setToggleGroup(group4);
         rb11.setToggleGroup(group4);
         rb12.setToggleGroup(group4);
         
         rb10.setTranslateX(10); // move radio buttons for more spacing
         rb11.setTranslateX(20);
         rb12.setTranslateX(30);
         
         rb9.setSelected(true); // set a radiobutton selected initially
         
         // Delete button clicked
         btnDelete.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                  doDelete();
            }
         });
         
         // When Radio button is changed/clicked
         group4.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
             public void changed(ObservableValue<? extends Toggle> ov,
                 Toggle old_toggle, Toggle new_toggle) {
                     if (group4.getSelectedToggle() != null) {
                        if(rb9.isSelected()){
                           selectProcess = "projects.userID";
                        }
                        if(rb10.isSelected()){
                              selectProcess = "projects.name";
                        }
                        if(rb11.isSelected()){
                              selectProcess = "projects.projectID";
                        }
                        if(rb12.isSelected()){
                              selectProcess = "projects.description";
                        }
                     }                
                 }
         });
         
         // FlowPane - Delete Elements
         FlowPane fpDelete = new FlowPane();
            fpDelete.getChildren().addAll(lblDelete, tfDelete, btnDelete);
         
         // FlowPane - Radio Buttons
         FlowPane fpRadioButton = new FlowPane();
            fpRadioButton.getChildren().addAll(lblDeleteOn, rb9, rb10, rb11, rb12);
            
         // Adding all elements to layout5
         layout5.getChildren().addAll(fpDelete,fpRadioButton,taLog4);
         scene5 = new Scene(layout5, 700, 300);
         
         
         
         
         
       /**
       * Layout 6 - Select Users
       * Last implementation 
       */
       mbBar5.getMenus().addAll(mnProcess,mnLogOut);
         layout6.getChildren().add(mbBar5);      
            
         // Radio Buttons
         rb15 = new RadioButton("All");
         rb16 = new RadioButton("userID");
         rb17 = new RadioButton("name");
         rb18 = new RadioButton("email");
         rb19 = new RadioButton("role");
         
         // ToggleGroup for radio buttons
         ToggleGroup group5 = new ToggleGroup();
         rb15.setToggleGroup(group5);
         rb16.setToggleGroup(group5);
         rb17.setToggleGroup(group5);
         rb18.setToggleGroup(group5);
         rb19.setToggleGroup(group5);
         
         rb16.setTranslateX(10); // move radio buttons for more spacing
         rb17.setTranslateX(20);
         rb18.setTranslateX(30);
         rb19.setTranslateX(40);
         
         rb15.setSelected(true); // set a radiobutton selected initially
         
         // Delete button clicked
         btnSearchUsers.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
                  doSearchUsers();
            }
         });
         
         selectProcess = "ALL";
         
         // When Radio button is changed/clicked
         group5.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
             public void changed(ObservableValue<? extends Toggle> ov,
                 Toggle old_toggle, Toggle new_toggle) {
                     if (group5.getSelectedToggle() != null) {
                        if(rb15.isSelected()){
                              selectProcess = "ALL";
                        }
                        if(rb16.isSelected()){
                              selectProcess = "users.userID";
                        }
                        if(rb17.isSelected()){
                              selectProcess = "users.name";
                        }
                        if(rb18.isSelected()){
                              selectProcess = "users.email";
                        }
                        if(rb19.isSelected()){
                              selectProcess = "users.role";
                        }
                     }                
                 }
         });
         
         // FlowPane - Delete Elements
         FlowPane fpSearchUsers = new FlowPane();
            fpSearchUsers.getChildren().addAll(lblSearchUsers, tfSearchUsers, btnSearchUsers);
         
         // FlowPane - Radio Buttons
         FlowPane fprbtns = new FlowPane();
            fprbtns.getChildren().addAll(lblSearchBy2,rb15,rb16,rb17,rb18,rb19);
            
         Font newFonts = Font.font("MONOSPACED", FontWeight.NORMAL, 12);
         taLog5.setFont(newFonts);
            
         // Adding all elements to layout5
         layout6.getChildren().addAll(fpSearchUsers,fprbtns,taLog5);
         scene6 = new Scene(layout6, 700, 300);

  
       
         // TextArea size change
         taLog.setPrefColumnCount(200);
         taLog.setPrefRowCount(200);
         taLog.setWrapText(true); // allow text to wrap
         
         taLog2.setPrefColumnCount(200);
         taLog2.setPrefRowCount(200);
         taLog2.setWrapText(true);
         
         taLog3.setPrefColumnCount(200);
         taLog3.setPrefRowCount(200);
         taLog3.setWrapText(true);
         
         taLog4.setPrefColumnCount(200);
         taLog4.setPrefRowCount(200);
         taLog4.setWrapText(true);     
         
         taLog5.setPrefColumnCount(200);
         taLog5.setPrefRowCount(200);
         taLog5.setWrapText(true);    
         
         // set widths of textfields
         tfUser.setPrefWidth(150);
         tfPass.setPrefWidth(150);
         fpUser.setAlignment(Pos.CENTER);
         fpPass.setAlignment(Pos.CENTER);
         fpLogin.setAlignment(Pos.CENTER);         
         
         // Setting menuitems to have listeners
         miSelect.setOnAction(this);
         miSelectUsers.setOnAction(this);
         miInsert.setOnAction(this);
         miUpdate.setOnAction(this);
         miDelete.setOnAction(this);
         miLogOut.setOnAction(this);
      
      
         stage.setScene(scene); // set Scene
         stage.setTitle("Login");
         stage.show();
      }// end of start
      
      
      
      /**
      * Handle
      * MenuItem clicks action handler
      * @return void
      */
      public void handle(ActionEvent evt){
         MenuItem mi = (MenuItem)evt.getSource();
         
         // Switch with each menuitem case
         switch(mi.getText()){
            case "Select":
               selectProcess = "userID";
               stage.setScene(scene2);
               stage.setTitle(role + " Select");
               break;
            case "Select Users":
               selectProcess = "ALL";
               stage.setScene(scene6);
               stage.setTitle(role + " Select Users");
               break;
            case "Insert":
               stage.setScene(scene3);
               stage.setTitle(role +  " Insert");
               break;
            case "Update":
               selectProcess = "userID";
               stage.setScene(scene4);
               stage.setTitle(role + " Update");
               break;
            case "Delete":
               selectProcess = "userID";
               stage.setScene(scene5);
               stage.setTitle(role + " Delete");
               break;
            case "LogOut":
               stage.setScene(scene);
               stage.setTitle("Login");
               role = "";
               miSelect.setDisable(false); // logging out resets the priveleges
               miInsert.setDisable(false);
               miUpdate.setDisable(false);
               miDelete.setDisable(false);
               tfUser.setText("");
               tfPass.setText("");
               break;
         }// end of switch
      }// end of handle
     
      
      
      /**
      * doLogin
      * Button click will handle the login
      * Checks for users' login credentials and the user's role 
      * Disables functions based on user's role
      * @return void
      */
      public void doLogin(){
            // Get textfield contents
            String userID = tfUser.getText();
            String password = tfPass.getText();
            
            // Check if fields are empty
            if(userID.equals("") || password.equals("")){
               fieldError();
            }else{
            
                // Users object
                user = new Users(userID);
                 
                try{    
                   // Login in w/username & password
                   if(user.login(userID,password)){
                        stage.setScene(scene2); // if login is successful, show next scene
                   }
                   else{
                        Alert alert = new Alert(AlertType.ERROR, "Incorrect Login");
                        alert.showAndWait();
                   }
                }
                catch(Exception e){
                      Alert alert = new Alert(AlertType.ERROR, "Incorrect Login");
                        alert.showAndWait();
                }
                  
                // User's role
                role = user.getRole();
                
                // Checking the user's role
                // Students and public can only use select
                // Disables all other functions based on user
                if(role.equals("student") || role.equals("public")){
                     miInsert.setDisable(true);
                     miUpdate.setDisable(true);
                     miDelete.setDisable(true);
                }
            }
      }// end of login
      
     
      /**
      * doSearch
      * In the SELECT screen ( Search button )
      */
      public void doSearch(){
             // Get search input
            String searchInput = tfSearch.getText();
            
            // Clear textarea
            taLog.setText("");

            /**
            * Check for the ALL function first
            * Check first as to bypass the empty textfield check
            */
            if(selectProcess.equals("ALL")){
               userData = project.selectAll();
               searchHelper(userData);
            }
            else if(searchInput.equals(" ")){ // Empty textfield check
               fieldError();
            }
            else{
                  try{
                     // perform search
                     userData = project.select(searchInput,selectProcess);
                     
                     // If there's nothing in the first spot, then there's nothing in the list
                     if(userData.get(0).get(1) == null){
                        noResults();
                        taLog.appendText("Error: no results returned. Check the selected field is correct with that of the search. \n");
                     }else{
                        searchHelper(userData);
                     }
                  }
                  catch(IndexOutOfBoundsException iobe){
                        noResults();
                        taLog.appendText("Error: no results returned. Check the selected field is correct with that of the search. \n");
                  }
               }    
      }// end of doSearch()


      /**
      * searchHelper
      * Performs search for the doSearch method
      * Both the ALL process and regular processes search using same code
      */
      public void searchHelper(ArrayList<ArrayList<String>> userdata){
            // String formatter
            String formatter = String.format("%-1s %12s %17s %18s %20s\n","ProjectID","Name","Description","Creator", "CreatorName\n");
            taLog.appendText(formatter);
                        
                        String projectID = "";
                        String projectName = "";
                        String description = "";
                        String creator = "";
                        String creatorName = "";

                     
                        for(ArrayList<String> list : userData){
                           int i = 0;
                           String result = "";
                           for(String s : list){
                              
                              if(i == 0){
                                 projectID = s;
                              }
                              else if (i == 1){
                                 projectName = s;
                              }
                              else if(i == 2){
                                 description = s;
                              }
                              else if(i == 3){
                                 creator = s;
                              }
                              else if(i == 4){ 
                                 creatorName = s;
                                 break;
                              }
                              i++; // increment the counter
                           }  
                           
                           // Print information
                           formatter = String.format("%-1s %20s %18s %18s %20s\n",projectID,projectName,description,creator,creatorName);
                           taLog.appendText(formatter);       
                        }
      }


      /**
      * doInsert
      * Performs insert of a project 
      * Displays whether insert was successful in textarea
      * @return void
      */
      public void doInsert(){
            // Get project information from user
            String projName = tfProjName.getText();
            String projDes = tfProjDes.getText();
            
            // Check for user info
            if(projName.equals("") || projDes.equals("")){
                  fieldError();
            }
            else{
               
               // Insert information
               // Uses a project object to insert 
               int results = project.insert(user, projName, projDes);
               
               // If insert failed
               if(results == -1){
                  taLog2.appendText("[Insert Failed] Fields : " + projName + ", " + projDes);
               }
               else{
                  taLog2.appendText("[Insert Successful] Project was successfully inserted!");
               }  
                    
            
            }
      }// end of insert
      
      
      /**
      * doUpdate()
      * @return void
      */
      public void doUpdate(){
            // Get project information from user
            String projName2 = tfProjName2.getText();
            String projDes2 = tfProjDes2.getText();
            String updateDropDwn = box.getValue().toString();            
            
            // Check if there's input from user
            if(projName2.equals("") || projDes2.equals("")){
                  fieldError();
            }else{
               // Perform update
               int result = project.update(user,projDes2, updateDropDwn, projName2, selectProcess);
               
               // if update failed
               if(result == -1 || result == 0){
                  taLog3.appendText("[Update Failed] Fields : " + projName2 + ", " + selectProcess + ", " + projDes2 + ", " + updateDropDwn + "\n");
               }
               else{
                  taLog3.appendText("[Update Successful] Update was successfully performed!\n");
               }
            }
      }// end of update
      
      
      /**
      * doDelete
      * @return void
      */
      public void doDelete(){
         // Get user input
         String toDelete = tfDelete.getText();
         
         // Check for input
         if(toDelete.equals("")){
            fieldError();
         }
         else{
         
            // delete
            int result = project.delete(user,toDelete,selectProcess);
            
            System.out.println("DELETE # " + result);
            
            // checks for if the delete was successful or not
            if(result == -1 || result == 0){
               taLog4.appendText("[Delete Failed] Fields : " + toDelete + ", " + selectProcess + "\n");
            }
            else{
               taLog4.appendText("[Delete Successful] Delete was successfully performed!\n");
            }
            
         }
      }// end of delete
      
      
      /**
      * doSearchUsers
      * Separate method for search users tab
      */
      public void doSearchUsers(){
            // Get search input
            String input = tfSearchUsers.getText();
            
            // Clear textarea
            taLog5.setText("");

            /**
            * Check for the ALL function first
            * Check first as to bypass the empty textfield check
            */
            if(selectProcess.equals("ALL")){
               userData = project.selectAllUsers();
               doSearchHelper(userData);
            }
            else if(input.equals(" ")){ // Empty textfield check
               fieldError();
            }
            else{
                  try{
                     // perform search for users
                     userData = project.selectUsers(input,selectProcess);
                     
                     // If there's nothing in the first spot, then there's nothing in the list
                     if(userData.get(0).get(1) == null){
                        noResults();
                        taLog5.appendText("Error: no results returned. Check the selected field is correct with that of the search. \n");
                     }else{
                        doSearchHelper(userData);
                     }
                  }
                  catch(IndexOutOfBoundsException iobe){
                        noResults();
                        taLog5.appendText("Error: no results returned. Check the selected field is correct with that of the search. \n");
                  }
               }    

      }// end of doSearchUsers  
      
      
      /**
      * SearchUsers helper
      */
      public void doSearchHelper(ArrayList<ArrayList<String>> userdata){
            // String formatter
            String formatter2 = String.format("%-1s %20s %30s %25s\n","UserID","Name","Email","Role\n");
            taLog5.appendText(formatter2);
                        
            String userID = "";
            String name = "";
            String email = "";
            String role = "";
                     
            for(ArrayList<String> list : userData){
                  int i = 0;
                  String result = "";
                   for(String s : list){
                        if(i == 0){
                           userID = s;
                        }
                        else if (i == 1){
                           name = s;
                        }
                        else if(i == 2){
                           email = s;
                        }
                        else if(i == 3){
                           role = s;
                        }
                        else if(i == 4){ 
                           break;
                         }
                         i++; // increment the counter
                    }  
                           
                    // Print information
                    formatter2 = String.format("%-1s %25s %30s %18s\n",userID,name,email,role);
                    taLog5.appendText(formatter2);   
                        
             }// end of for loop
      }// end of doSearchHelper
    
      
      
      
      
      /**
      * Field Error
      * Alert message used for each process with required input fields
      */
      public void fieldError(){
            Alert alert = new Alert(AlertType.ERROR, "Missing input in fields");
               alert.showAndWait();
      }// end of field Error
           
           
      /**
      * noResults
      * When no results are returned in select
      */   
      public void noResults(){
            Alert alert = new Alert(AlertType.ERROR, "No results returned. Is the field selected correct with the search?");
               alert.showAndWait();
      }
}// end of class