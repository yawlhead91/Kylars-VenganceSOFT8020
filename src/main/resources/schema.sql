CREATE TABLE Users ( 
	id int(11) NOT NULL AUTO_INCREMENT, 
	fname varchar(50) NOT NULL, 
	lname varchar(50) NOT NULL,
	kubit int DEFAULT 1000,
	level int(11) DEFAULT 1,
		check(level <= 25),
	PRIMARY KEY (id) 
);

CREATE TABLE Weapons (
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	wtype ENUM('ranged', 'melee', 'magical') NOT NULL,
	damage int(100) NOT NULL,
	protection int(100) NOT NULL,
	ranged int(100) NOT NULL,
	level int(11) NOT NULL,
		check(level <= 5),
	cost int(100) NOT NULL
);


CREATE TABLE Enchantments (
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	etype ENUM('ranged', 'melee', 'magical') NOT NULL,
	bonusdmg int(100) NOT NULL,
	bonusprt int(100) NOT NULL,
	cost int(100) NOT NULL
);

CREATE TABLE Inventory (
	id int(11) NOT NULL AUTO_INCREMENT,
	uId int(11) NOT NULL,
	weapon int(11) NOT NULL,
	enchantment int(11) DEFAULT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (uId) REFERENCES Users(id),
	FOREIGN KEY (weapon) REFERENCES Weapons(id),
	FOREIGN KEY (enchantment) REFERENCES Enchantments(id)
);


