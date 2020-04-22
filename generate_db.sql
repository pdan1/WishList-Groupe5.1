--
-- File generated with SQLiteStudio v3.2.1 on mer. avr. 22 15:15:11 2020
--
-- Text encoding used: System
-- 

PRAGMA foreign_keys = off;
DROP TABLE Accesses;
DROP TABLE Friends;
DROP TABLE Wishes;
DROP TABLE Wishlists;
DROP TABLE Users;

BEGIN TRANSACTION;

-- Table: Accesses
CREATE TABLE Accesses (
    userid  STRING NOT NULL REFERENCES Users (userid),
    list    STRING NOT NULL REFERENCES Wishlists (name),
    ownerid STRING NOT NULL REFERENCES Wishlists (userid),
    perm    STRING NOT NULL,
    PRIMARY KEY (userid, list, ownerid)
);

-- Table: Friends
CREATE TABLE Friends (
    userid1 STRING NOT NULL REFERENCES Users (userid),
    userid2 STRING NOT NULL REFERENCES Users (userid),
    status  STRING NOT NULL,
    PRIMARY KEY (userid1, userid2)
);

-- Table: Users
CREATE TABLE Users (
    userid    STRING NOT NULL PRIMARY KEY,
    email     STRING NOT NULL,
    name      STRING NOT NULL,
    password  STRING NOT NULL,
    color     STRING NOT NULL DEFAULT 'black',
    size      STRING NOT NULL DEFAULT 'M',
    pict      STRING,
    address   TEXT,
    interest1 STRING,
    interest2 STRING,
    interest3 STRING
);

-- Table: Wishes
CREATE TABLE Wishes (
    name      STRING NOT NULL,
    list      STRING NOT NULL REFERENCES Wishlists (name),
    userid    STRING NOT NULL REFERENCES Wishlists (userid),
    amount    INT    NOT NULL,
    link      STRING,
    wishrate  INT,
    price     INT,
    pict      STRING,
    desc      TEXT,
    PRIMARY KEY (name, list, userid)
);

-- Table: Wishlists
CREATE TABLE Wishlists (
    name    STRING NOT NULL,
    userid  STRING NOT NULL REFERENCES Users (userid),
    desc    STRING,
    PRIMARY KEY (name, userid)
);

INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('Austry', 'Bridge Ink Tattoo Designs', '4lisse', 'read');
INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('Frenchton', 'Bridge Ink Tattoo Designs', '4lisse', 'read');
INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('Juli1', 'Bridge Ink Tattoo Designs', '4lisse', 'read');
INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('4lisse', 'Xmas 2021', 'Austry', 'read');
INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('Austry', '2Watch', 'Frenchton', 'edit');
INSERT INTO Accesses (userid, list, ownerid, perm) VALUES ('Frenchton', 'Xmas 2021', 'Austry', 'read');


INSERT INTO Friends (userid1, userid2, status) VALUES ('Austry', 'Frenchton', 'approved');
INSERT INTO Friends (userid1, userid2, status) VALUES ('Austry', '4lisse', 'approved');
INSERT INTO Friends (userid1, userid2, status) VALUES ('Juli1', 'Frenchton', 'pending');
INSERT INTO Friends (userid1, userid2, status) VALUES ('Juli1', 'Austry', 'pending');
INSERT INTO Friends (userid1, userid2, status) VALUES ('4lisse', 'Juli1', 'approved');
INSERT INTO Friends (userid1, userid2, status) VALUES ('4lisse', 'Frenchton', 'approved');



INSERT INTO Users (userid, email, name, password, color, size, pict, address, interest1, interest2, interest3) VALUES ('Austry', 'morgane.14@caramail.com', 'Morgane Leclerc', 'vlctuxf', 'mauve', 'XS', 'file:///assets/id_austry.jpg', '12, Rue de Constantinople, 1348, Ottignies-Louvain-la-Neuve', 'linux', 'diving', 'jewels');
INSERT INTO Users (userid, email, name, password, color, size, pict, address, interest1, interest2, interest3) VALUES ('Frenchton', 'anton.levrai@yahoo.com', 'Anton Le Preu', 'abalanglai', 'bleu', 'M', 'file:///assets/id_lepreu.jpg', '564, Avenue du Débarquement, 4862, Tataouine-les-Bains', 'french', 'crochet', 'swedish');
INSERT INTO Users (userid, email, name, password, color, size, pict, address, interest1, interest2, interest3) VALUES ('Juli1', 'juju.1@hotmail.com', 'Juju', 'chaussettes', 'red', 'XL', 'file:///assets/id_juju.jpg', '8, Rue Alfred Houel, 14830, Langrunes sur Mer', 'videogames', 'tumblr', 'yu-gi-oh');
INSERT INTO Users (userid, email, name, password, color, size, pict, address, interest1, interest2, interest3) VALUES ('4lisse', 'alice.bridge@skynet.be', 'WitchyMess', 'sphoria', 'black', 'L', 'file:///assets/id_abridge.jpg', '42, Boulevard Matignon, 54808, Marne-la-Vallée', 'piercings', 'makeup', 'beers');


INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('cute whale', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 3, 4000, 'file:///assets/bridge-ink/cute_whale.jpg', 'Dimension (mm): 50x36');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('infernal skull', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 5, 12000, 'file:///assets/bridge-ink/infernal_skull.jpg', 'Dimension (mm): 265x74');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('demonic succub', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 4, 9000, 'file:///assets/bridge-ink/demon_succub.jpg', 'Dimension (mm): 186x131');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('slytherin emblem', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 3, 3000, 'file:///assets/bridge-ink/slytherin_emblem.jpg', 'Dimension (mm): 40x40');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('gryffindor emblem', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 3, 3000, 'file:///assets/bridge-ink/gryffindor_emblem.jpg', 'Dimension (mm): 40x40');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('hufflepuff emblem', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 2, 3000, 'file:///assets/bridge-ink/hufflepuff_emblem.jpg', 'Dimension (mm): 40x40');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('ravenclaw emblem', 'Bridge Ink Tattoo Designs', '4lisse', 1, 'www.bridge-ink.be/designs/cute_whale.html', 2, 3000, 'file:///assets/bridge-ink/ravenclaw_emblem.jpg', 'Dimension (mm): 40x40');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Lexin Swedish Dictionary', 'Books', 'Frenchton', 1, 'www.kth.com', 3, 2700, 'file:///assets/kth/lexin.jpg', 'A swedish dictionary with IPA transcription');
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Resident Evil', 'Video Games', 'Juli1', 1, 'www.sega.com', 4, 4500, 'file:///assets/games/resident-evil.jpg', NULL);
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Rayman 2', 'Video Games', 'Juli1', 1, 'www.ubisoft.com', 5, 1500, 'file:///assets/games/rayman.jpg', NULL);
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Assassins Creed', 'Video Games', 'Juli1', 1, 'www.ubisoft.com', 2, 6500, 'file:///assets/games/assassins-creed.jpg', NULL);
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Peaky Blinders', '2Watch', 'Frenchton', 1, 'www.netflix.org', 4, NULL, 'file:///assets/netflix/thumbnails/peaky-blinders.jpg', NULL);
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Game Of Throne', '2Watch', 'Frenchton', 1, 'www.hbo.com', 2, NULL, 'file:///assets/hbo/thumbnails/got.jpg', NULL);
INSERT INTO Wishes (name, list, userid, amount, link, wishrate, price, pict, "desc") VALUES ('Casa del Papel', '2Watch', 'Frenchton', 1, 'www.netflix.org', 3, NULL, 'file:///assets/netflix/thumbnails/casa-del-papel.jpg', NULL);



INSERT INTO Wishlists (name, userid, "desc") VALUES ('Xmas 2021', 'Austry', 'What I whish to receive for christmas !');
INSERT INTO Wishlists (name, userid, "desc") VALUES ('Video Games', 'Juli1', 'Video Games I want to play.');
INSERT INTO Wishlists (name, userid, "desc") VALUES ('2Watch', 'Frenchton', 'Episodes, Series & Movies I want to watch soon.');
INSERT INTO Wishlists (name, userid, "desc") VALUES ('Bridge Ink Tattoo Designs', '4lisse', 'Some tattos designs I can do in my shop, visit www.bridge-inks.be to book an appointment !');
INSERT INTO Wishlists (name, userid, "desc") VALUES ('Books', 'Frenchton', 'Books I want to read.');


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
