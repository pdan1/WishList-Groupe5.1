/* This script creates the wishlish database */

-------------------------------------------------------------------------------
-- Cleanup tables
-------------------------------------------------------------------------------

PRAGMA foreign_keys = OFF;

-- Drop each tables if one exists
DROP TABLE IF EXISTS Friends;
DROP TABLE IF EXISTS Accesses;
DROP TABLE IF EXISTS Wishes;
DROP TABLE IF EXISTS Wishlists;
DROP TABLE IF EXISTS Users;

-------------------------------------------------------------------------------
-- Create tables
-------------------------------------------------------------------------------

-- Create Users table
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

-- Create Wishlists table
CREATE TABLE Wishlists (
    listid STRING NOT NULL UNIQUE PRIMARY KEY,
    name    STRING NOT NULL,
    userid  STRING NOT NULL REFERENCES Users (userid),
    desc    STRING,
    UNIQUE (name, userid)
);

-- Create Wishes table
CREATE TABLE Wishes (
    wishid    STRING NOT NULL UNIQUE PRIMARY KEY,
    name      STRING NOT NULL,
    listid   INT    NOT NULL REFERENCES Wishlists (listid),
    amount    INT    NOT NULL,
    link      STRING,
    wishrate  INT,
    price     INT,
    pict      STRING,
    desc      TEXT,
    UNIQUE (name, listid)
);

-- Create Accesses table
CREATE TABLE Accesses (
    userid  STRING NOT NULL REFERENCES Users (userid),
    listid STRING NOT NULL REFERENCES Wishlists (listid),
    perm    STRING NOT NULL,
    PRIMARY KEY (userid, listid),
    UNIQUE (userid, listid, perm)
);

-- Create Friends table
CREATE TABLE Friends (
    userid1 STRING NOT NULL REFERENCES Users (userid),
    userid2 STRING NOT NULL REFERENCES Users (userid),
    status  STRING NOT NULL,
    PRIMARY KEY (userid1, userid2)
);

PRAGMA foreign_keys = ON;

-------------------------------------------------------------------------------
-- Populate tables
-------------------------------------------------------------------------------

-- Add users
INSERT INTO Users VALUES
--   userid               email                      name               password       color    size  pict                             address                                                        interest1      interest2 interest3
    ('Austry',            'morgane.14@caramail.com', 'Morgane Leclerc', 'vlctuxf',     'mauve', 'XS', 'file:///assets/id_austry.jpg',  '12, Rue de Constantinople, 1348, Ottignies-Louvain-la-Neuve', 'linux',       'diving',       'jewels'),
    ('Frenchton',         'anton.levrai@yahoo.com',  'Anton Le Preu',   'abalanglai',  'bleu',  'M',  'file:///assets/id_lepreu.jpg',  '564, Avenue du Débarquement, 4862, Tataouine-les-Bains',      'french',      'crochet',      'swedish'),
    ('Juli1',             'juju.1@hotmail.com',      'Juju',            'chaussettes', 'red',   'XL', 'file:///assets/id_juju.jpg',    '8, Rue Alfred Houel, 14830, Langrunes sur Mer',               'videogames',  'tumblr',       'yu-gi-oh'),
    ('4lisse',            'alice.bridge@skynet.be',  'WitchyMess',      'sphoria',     'black', 'L',  'file:///assets/id_abridge.jpg', '42, Boulevard Matignon, 54808, Marne-la-Vallée',              'piercings',   'makeup',       'beers');

-- Add wishlists
INSERT INTO Wishlists VALUES
--   listid name                         userid      desc
    ('1',    'Xmas 2021',                 'Austry',   'What I whish to receive for christmas !'),
    ('2',    'Video Games',               'Juli1',    'Video Games I want to play.'),
    ('3',    '2Watch',                    'Frenchton', 'Episodes, Series & Movies I want to watch soon.'),
    ('4',    'Bridge Ink Tattoo Designs', '4lisse',   'Some tattos designs I can do in my shop, visit www.bridge-inks.be to book an appointment !');

-- Add wishes
INSERT INTO Wishes VALUES
--   wishid  name                 listid amount link                                        wishrate price  pict                                                    desc
    ('1',    'cute whale',        '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 3,       4000,  'file:///assets/bridge-ink/cute_whale.jpg',            'Dimension (mm): 50x36'),
    ('2',    'infernal skull',    '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 5,       12000, 'file:///assets/bridge-ink/infernal_skull.jpg',        'Dimension (mm): 265x74'),
    ('3',    'demonic succub',    '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 4,       9000,  'file:///assets/bridge-ink/demon_succub.jpg',          'Dimension (mm): 186x131'),
    ('4',    'slytherin emblem',  '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 3,       3000,  'file:///assets/bridge-ink/slytherin_emblem.jpg',      'Dimension (mm): 40x40'),
    ('5',    'gryffindor emblem', '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 3,       3000,  'file:///assets/bridge-ink/gryffindor_emblem.jpg',     'Dimension (mm): 40x40'),
    ('6',    'hufflepuff emblem', '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 2,       3000,  'file:///assets/bridge-ink/hufflepuff_emblem.jpg',     'Dimension (mm): 40x40'),
    ('7',    'ravenclaw emblem',  '4',    1,     'www.bridge-ink.be/designs/cute_whale.html', 2,       3000,  'file:///assets/bridge-ink/ravenclaw_emblem.jpg',      'Dimension (mm): 40x40'),
    ('8',    'Resident Evil',     '2',    1,     'www.sega.com',                              4,       4500,  'file:///assets/games/resident-evil.jpg',               NULL),
    ('9',    'Rayman 2',          '2',    1,     'www.ubisoft.com',                           5,       1500,  'file:///assets/games/rayman.jpg',                      NULL),
    ('10',   'Assassins Creed',   '2',    1,     'www.ubisoft.com',                           2,       6500,  'file:///assets/games/assassins-creed.jpg',             NULL),
    ('11',   'Peaky Blinders',    '3',    1,     'www.netflix.org',                           4,       NULL,  'file:///assets/netflix/thumbnails/peaky-blinders.jpg', NULL),
    ('12',   'Game Of Throne',    '3',    1,     'www.hbo.com',                               2,       NULL,  'file:///assets/hbo/thumbnails/got.jpg',                NULL),
    ('13',   'Casa del Papel',    '3',    1,     'www.netflix.com',                           3,       NULL,  'file:///assets/netflix/thumbnails/casa-del-papel.jpg', NULL);

INSERT INTO Accesses VALUES
--   userid       listid perm
    ('Austry',    '4',    'read'),
    ('Frenchton', '4',    'read'),
    ('Juli1',     '4',    'read'),
    ('4lisse',    '4',    'read'),
    ('Austry',    '3',    'edit'),
    ('Frenchton', '1',    'read'),
    ('4lisse',    '1',    'read');

INSERT INTO Friends VALUES
--  userid1    userid2 status
    ('Austry', 'Frenchton', 'approved'),
    ('Austry', '4lisse',    'approved'),
    ('Juli1',  'Frenchton', 'pending'),
    ('Juli1',  'Austry',    'pending'),
    ('4lisse', 'Juli1',     'approved'),
    ('4lisse', 'Frenchton', 'approved');
