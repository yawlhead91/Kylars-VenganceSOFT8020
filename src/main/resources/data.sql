INSERT INTO Users (fname, lname) VALUES 
('Alex', 'Kirwan'), 
('Amy', 'Hyland'), 
('John', 'Cena');

INSERT INTO Weapons VALUES 
(NULL, 'Long Sword', 'melee', 31, 12, 5, 1, 150), 
(NULL, 'Long Sword', 'melee', 41, 18, 5, 2, 320),
(NULL, 'Long Sword', 'melee', 51, 23, 5, 3, 556),
(NULL, 'Dwarvin bow', 'ranged', 12, 2, 26, 1, 200),
(NULL, 'Dwarvin bow', 'ranged', 24, 4, 32, 2, 390),
(NULL, 'Dwarvin bow', 'ranged', 32, 6, 40, 3, 800),
(NULL, 'Ice Staff', 'magical', 25, 2, 12, 1, 80), 
(NULL, 'Ice Staff', 'magical', 31, 2, 14, 2, 160),
(NULL, 'Ice Staff', 'magical', 45, 2, 18, 3, 320),
(NULL, 'Elfish Bronze Shield', 'melee', 10, 24, 2, 1, 200),
(NULL, 'Elfish Bronze Shield', 'melee', 15, 41, 2, 2, 300),
(NULL, 'Elfish Bronze Shield', 'melee', 20, 60, 2, 3, 600);


INSERT INTO Enchantments VALUES 
(NULL, 'Blessing of fire', 'melee', 5, 0, 50),
(NULL, 'Posion of giant spider', 'ranged', 9, 0, 60),
(NULL, 'Elixir of power', 'magical', 16, 0, 120),
(NULL, 'Vale of protection', 'melee', 0, 20, 55);


INSERT INTO Inventory (uId, weapon)
SELECT Users.id, Weapons.id 
FROM Users
LEFT JOIN Weapons
ON Weapons.level = 1; 


