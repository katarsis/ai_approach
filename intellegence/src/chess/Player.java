package chess;

import java.io.Serializable;

public class Player implements Serializable{

	String name;
	
	enum Colors {
		black,white;
	}
	
	public enum PlayerTypes{
		computer,human;
	}
	
	Colors color;
	PlayerTypes playerType;
	
	public Player(Colors color, PlayerTypes type){
		this.color = color;
		this.playerType = playerType;
	}
	
	public void setPlayer(PlayerTypes type){
		this.playerType = type;
	}
}
