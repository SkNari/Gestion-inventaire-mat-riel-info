SRC_DIR := src/
BIN_DIR := bin/
JAVADOC_DIR := javadoc/


#packages src
MODEL_DIR := $(SRC_DIR)model/
CONTROLEUR_DIR := $(SRC_DIR)controleur/
VIEW_DIR := $(SRC_DIR)vue/

#packages bin
MODEL_DIR_BIN := $(BIN_DIR)model/
CONTROLEUR_DIR_BIN := $(BIN_DIR)controleur/
VIEW_DIR_BIN := $(BIN_DIR)vue/

#data
DATA_DIR := data/

FLAGS := -d $(BIN_DIR) -sourcepath $(SRC_DIR) -classpath $(BIN_DIR)
JC := javac
JEXE := java -classpath "$(BIN_DIR)"
JDOC := javadoc
RM := rm -rf 
MKDIR := mkdir

all: $(BIN_DIR) $(BIN_DIR)Main.class

$(BIN_DIR):
	$(MKDIR) $(BIN_DIR)

$(DATA_DIR): 
	$(MKDIR) $(DATA_DIR)

#application
$(BIN_DIR)Main.class: $(SRC_DIR)Main.java $(BIN_DIR)app/App.class $(DATA_DIR)
	$(JC) $(FLAGS) $(SRC_DIR)Main.java

$(BIN_DIR)app/App.class: $(SRC_DIR)app/App.java $(CONTROLEUR_DIR_BIN)Controleur.class $(CONTROLEUR_DIR_BIN)ConnexionControleur.class $(MODEL_DIR_BIN)Serialisation.class
	$(JC) $(FLAGS) $(SRC_DIR)app/App.java

#models

$(MODEL_DIR_BIN)Materiel.class: $(MODEL_DIR)Materiel.java
	$(JC) $(FLAGS) $(MODEL_DIR)Materiel.java

$(MODEL_DIR_BIN)CapteursDeProfondeur.class: $(MODEL_DIR)CapteursDeProfondeur.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)CapteursDeProfondeur.java

$(MODEL_DIR_BIN)CasqueAudio.class: $(MODEL_DIR)CasqueAudio.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)CasqueAudio.java

$(MODEL_DIR_BIN)CasqueVR.class: $(MODEL_DIR)CasqueVR.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)CasqueVR.java

$(MODEL_DIR_BIN)ManetteJeu.class: $(MODEL_DIR)ManetteJeu.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)ManetteJeu.java

$(MODEL_DIR_BIN)ManetteVR.class: $(MODEL_DIR)ManetteVR.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)ManetteVR.java

$(MODEL_DIR_BIN)Souris.class: $(MODEL_DIR)Souris.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)Souris.java

$(MODEL_DIR_BIN)Tablette.class: $(MODEL_DIR)Tablette.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)Tablette.java

$(MODEL_DIR_BIN)Telephone.class: $(MODEL_DIR)Telephone.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)Telephone.java

$(MODEL_DIR_BIN)Webcam.class: $(MODEL_DIR)Webcam.java $(MODEL_DIR_BIN)Materiel.class 
	$(JC) $(FLAGS) $(MODEL_DIR)Webcam.java


$(MODEL_DIR_BIN)Emprunteur.class: $(MODEL_DIR)Emprunteur.java  
	$(JC) $(FLAGS) $(MODEL_DIR)Emprunteur.java

$(MODEL_DIR_BIN)Emprunt.class: $(MODEL_DIR)Emprunt.java $(MODEL_DIR_BIN)Emprunteur.class $(MODEL_DIR_BIN)CapteursDeProfondeur.class $(MODEL_DIR_BIN)CasqueAudio.class $(MODEL_DIR_BIN)CasqueVR.class $(MODEL_DIR_BIN)ManetteJeu.class $(MODEL_DIR_BIN)ManetteVR.class $(MODEL_DIR_BIN)Souris.class $(MODEL_DIR_BIN)Telephone.class $(MODEL_DIR_BIN)Tablette.class $(MODEL_DIR_BIN)Webcam.class
	$(JC) $(FLAGS) $(MODEL_DIR)Emprunt.java

$(MODEL_DIR_BIN)Stockage.class: $(MODEL_DIR)Stockage.java $(MODEL_DIR_BIN)CapteursDeProfondeur.class $(MODEL_DIR_BIN)CasqueAudio.class $(MODEL_DIR_BIN)CasqueVR.class $(MODEL_DIR_BIN)ManetteJeu.class $(MODEL_DIR_BIN)ManetteVR.class $(MODEL_DIR_BIN)Souris.class $(MODEL_DIR_BIN)Telephone.class $(MODEL_DIR_BIN)Tablette.class $(MODEL_DIR_BIN)Webcam.class
	$(JC) $(FLAGS) $(MODEL_DIR)Stockage.java

$(MODEL_DIR_BIN)Serialisation.class: $(MODEL_DIR)Serialisation.java $(MODEL_DIR_BIN)Stockage.class $(MODEL_DIR_BIN)Emprunt.class $(MODEL_DIR_BIN)Data.class
	$(JC) $(FLAGS) $(MODEL_DIR)Serialisation.java

$(MODEL_DIR_BIN)Data.class: $(MODEL_DIR)Data.java
	$(JC) $(FLAGS) $(MODEL_DIR)Data.java


#controllers

$(CONTROLEUR_DIR_BIN)Controleur.class: $(CONTROLEUR_DIR)Controleur.java $(MODEL_DIR_BIN)Stockage.class $(VIEW_DIR_BIN)Vue.class
	$(JC) $(FLAGS) $(CONTROLEUR_DIR)Controleur.java

$(CONTROLEUR_DIR_BIN)ConnexionControleur.class: $(CONTROLEUR_DIR)ConnexionControleur.java $(VIEW_DIR_BIN)Vue.class
	$(JC) $(FLAGS) $(CONTROLEUR_DIR)ConnexionControleur.java

#ui (views)

$(VIEW_DIR_BIN)Vue.class: $(VIEW_DIR)Vue.java  $(MODEL_DIR_BIN)Stockage.class 
	$(JC) $(FLAGS) $(VIEW_DIR)Vue.java

#launch program
run:
	$(JEXE) Main

#clean bin dir
clean:
	$(RM) $(BIN_DIR)*

#clean data dir
cleandata:
	$(RM) $(DATA_DIR)*

#generate javadoc
doc:
	$(JDOC) -d $(JAVADOC_DIR) $(MODEL_DIR)* $(HELPER_DIR)* $(ENUM_DIR)* $(UI_DIR)*.java $(CONTROLLER_DIR)*.java $(ACTIONS_DIR)* $(UNDO_REDO_DIR)* $(CONTAINER_UI_DIR)* $(CONTAINER_CONTROLLER_DIR)* $(POPUP_UI_DIR)* $(POPUP_CONTROLLER_DIR)*
	#$(JDOC) -d $(JAVADOC_DIR) $(UI_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(CONTROLLER_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(API_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(SRC_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(HELPER_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(UNDO_REDO_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(CONTAINER_UI_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(POPUP_UI_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(POPUP_CONTROLLER_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(CONTAINER_CONTROLLER_DIR)*.java
	#$(JDOC) -d $(JAVADOC_DIR) $(ACTIONS_DIR)*.java

#clean javadoc
docclean:
	$(RM) $(JAVADOC_DIR)*

#dev utility
dev: clean $(BIN_DIR)Application.class

.PHONY: clean test doc