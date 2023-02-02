https://www.sqlite.org/download.html
CRUD
UNF
//game_characters.db
//data.db
//data2.db
//dump.sql
drop table character;
create table character (id integer not null primary key autoincrement, name text not null UNIQUE);
ALTER TABLE character DROP COLUMN name;
ALTER TABLE character add COLUMN name text not null;
.tables
.schema character
.mod box   ->
select * from character
select * from character order by name
select count(*) from character; == select count(id) from character;
UPDATE character SET name = 'Vulrend2' WHERE name='Vulrend';
UPDATE character SET id = 36 WHERE id = 1;
.shell cls

insert into character(name) values('Vulrend');
insert into character(name) values('Werunth');
insert into character(name) values('Harelath');
insert into character(name) values('Zuroth');
insert into character(name) values('Dorath');
insert into character(name) values('Sharian');
insert into character(name) values('Maiel');
insert into character(name) values('Melron');
insert into character(name) values('Melkorn');
insert into character(name) values('Meralia');
insert into character(name) values('Galeron');
insert into character(name) values('Dalior');
insert into character(name) values('Oristor');
insert into character(name) values('Yverath');
insert into character(name) values('Deraldorion');
insert into character(name) values('Doriolin');
insert into character(name) values('Melion');
insert into character(name) values('Turimbar');
insert into character(name) values('Turin');
insert into character(name) values('Reolath');
insert into character(name) values('Theolas');
insert into character(name) values('Eoner');
insert into character(name) values('Eoren');
insert into character(name) values('Alwund');
insert into character(name) values('Tarathiel');
insert into character(name) values('Throk');
insert into character(name) values('Eldron');
insert into character(name) values('Eltharien');
insert into character(name) values('Elthar');
insert into character(name) values('Relath');
insert into character(name) values('Garndal');
insert into character(name) values('Vuldred');
insert into character(name) values('Njorn');
insert into character(name) values('Perulian');
insert into character(name) values('Loruthan');

create table race (id integer not null primary key autoincrement, name text not null UNIQUE);
insert into race(name) values('Dwarves');
insert into race(name) values('Elves');
insert into race(name) values('Humans');
insert into race(name) values('Goblins');
insert into race(name) values('Orcs');

ALTER TABLE character add COLUMN race_id integer;
UPDATE character SET race_id = 1 WHERE id>=1 and id<10;
UPDATE character SET race_id = 1 WHERE id%5=0;
UPDATE character SET race_id = 2 WHERE id%5=1;
UPDATE character SET race_id = 3 WHERE id%5=2;
UPDATE character SET race_id = 4 WHERE id%5=3;
UPDATE character SET race_id = 5 WHERE id%5=4;

create table class (id integer not null primary key autoincrement, name text not null UNIQUE);
insert into class(name) values('Warrior');
insert into class(name) values('Gunslinger');
insert into class(name) values('Archer');
insert into class(name) values('Assassin');
insert into class(name) values('Tank');

ALTER TABLE character add COLUMN class_id integer;

UPDATE character SET class_id = 1 WHERE id%5=4;
UPDATE character SET class_id = 2 WHERE id%5=3;
UPDATE character SET class_id = 3 WHERE id%5=2;
UPDATE character SET class_id = 4 WHERE id%5=1;
UPDATE character SET class_id = 5 WHERE id%5=0;


//цена, вес, редкость, макс. в инвентаре

create table item (id integer not null primary key autoincrement, name text not null UNIQUE, price integer default 0, weight REAL, rarity integer CHECK(rarity between 1 and 5) default 1, maximum integer default 1);
insert into item(name) values('');
//price, weight, rarity, maximum

insert into item(name) values('Adobe');
insert into item(name) values('Aluminum Ingot');
insert into item(name) values('Animal Bone');
insert into item(name) values('Animal Fat');
insert into item(name) values('Animal Hide');
insert into item(name) values('Bamboo Stick');
insert into item(name) values('Beeswax');
insert into item(name) values('Black Dye');
insert into item(name) values('Blue Alloy');
insert into item(name) values('Blue Coral Powder');
insert into item(name) values('Blue Dye');
insert into item(name) values('Blue Metal');
insert into item(name) values('Bolts');
insert into item(name) values('Brick');
insert into item(name) values('Bronze Ingot');
insert into item(name) values('Carved Wood');
insert into item(name) values('Cattail');
insert into item(name) values('Cement');
insert into item(name) values('Charcoal');
insert into item(name) values('Clay');
insert into item(name) values('Cloth');
insert into item(name) values('Coal');
insert into item(name) values('Copper Ingot');
insert into item(name) values('Copper Ore');
insert into item(name) values('Crafted Leather');
insert into item(name) values('Cursed Wood');
insert into item(name) values('Duct Tape');
insert into item(name) values('Electronic Components');
insert into item(name) values('Empty Can');
insert into item(name) values('Feather');
insert into item(name) values('Fertile Soil');
insert into item(name) values('Firewood');
insert into item(name) values('Flint');
insert into item(name) values('Gas');
insert into item(name) values('Glass');
insert into item(name) values('Glue');
insert into item(name) values('Gold Ingot');
insert into item(name) values('Gold Nugget');
insert into item(name) values('Gravel');
insert into item(name) values('Green Dye');
insert into item(name) values('Hard Skin');
insert into item(name) values('Hardwood');
insert into item(name) values('Iron Ingot');
insert into item(name) values('Iron Ore');
insert into item(name) values('Jade');
insert into item(name) values('Large Stone');
insert into item(name) values('Leather');
insert into item(name) values('Leather Straps');
insert into item(name) values('Marble');
insert into item(name) values('Metal Scraps');
insert into item(name) values('Metal Shard');
insert into item(name) values('Metal Wire');
insert into item(name) values('Monster Scales');
insert into item(name) values('Nails');
insert into item(name) values('Orange Dye');
insert into item(name) values('Paper');
insert into item(name) values('Plant Fiber');
insert into item(name) values('Plastic');
insert into item(name) values('Purple Coral Powder');
insert into item(name) values('Purple Dye');
insert into item(name) values('Quartz');
insert into item(name) values('Red Coral Powder');
insert into item(name) values('Red Dye');
insert into item(name) values('Rooftiles');
insert into item(name) values('Rope');
insert into item(name) values('Rubber');
insert into item(name) values('Sand');
insert into item(name) values('Sharp Stone');
insert into item(name) values('Silicon');
insert into item(name) values('Silver Ingot');
insert into item(name) values('Silver Ore');
insert into item(name) values('Slate');
insert into item(name) values('Small Stone');
insert into item(name) values('Steel Ingot');
insert into item(name) values('Steel Plates');
insert into item(name) values('Stick');
insert into item(name) values('Straws');
insert into item(name) values('Thread');
insert into item(name) values('Timber');
insert into item(name) values('Tin');
insert into item(name) values('Titanium Dust');
insert into item(name) values('Titanium Ingot');
insert into item(name) values('Turquoise');
insert into item(name) values('Varnish');
insert into item(name) values('Whetstone');
insert into item(name) values('White Coral Powder');
insert into item(name) values('White Dye');
insert into item(name) values('Wood Log');
insert into item(name) values('Wood Planks');
insert into item(name) values('Wool');
insert into item(name) values('Yellow Coral Powder');
insert into item(name) values('Yellow Dye');

select count(*) from item;
SELECT random();
UPDATE item SET price = random()%1000+1000;
UPDATE item SET weight = (random()%100+100)/10;
UPDATE item SET rarity = abs(random()%5)+1;
UPDATE item SET maximum = abs(random()%25)+1;

create table inventory (id integer not null primary key autoincrement, character_id integer, item_id integer);
.schema

//Файл со всеми insert-ами
.output dump.sql
.dump
.quit == .exit

.open game_characters.db
.open 'files name'
select * item;

insert into inventory(character_id, item_id) value(2,1);

Вывести имена персонажей и список предметов в инвентаре
select c.id, c.name, i.name
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (c.id=2);

select count(*)
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (c.id=2);

select count(*) from inventory where character_id=2;

select inv.item_id, c.name, i.name
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (c.id=2)
order by inv.item_id;

select item_id from inventory
where character_id=2
order by item_id;

//Удалить предмет
DELETE FROM item WHERE id=50;

Вывести всех пресонажей, у которых в инвентаре содержатся предметы с редкостью 5
select c.name, i.name, i.rarity
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (i.rarity=5);

Вывести персонажей, у которых в инвенторе есть "Glass"
select c.name, i.name
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (i.name='Glass')
group by c.name
order by c.name;

Вывести вес инвентаря у персонажа с id = 2
select c.name, sum(i.weight)
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (i.id=2);

Вес всех инвентарей
select sum(i.weight)
from item as i, inventory as inv
where (i.id=inv.item_id);

У каких персонажей количество вещей = 20..25 ???
select c.name, count(i.id) as cc
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (cc = 25);

Количество вещей у каждого персонажа
select c.name, count(i.id)
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id)
group by c.id;

Предмет, который реже всего встречается в инвентарях
select i.name, count(inv.item_id) as cc
from item as i, inventory as inv
where (i.id=inv.item_id)
group by inv.item_id
order by cc
limit 10;

Предмет, который чаще всего встречается в инвентарях
select i.name, count(inv.item_id) as cc
from item as i, inventory as inv
where (i.id=inv.item_id)
group by inv.item_id
order by cc desc
limit 10;

Сколько вещей у персонажа с id=2
select c.name, count(i.id)
from character as c, item as i, inventory as inv
where (c.id=inv.character_id) and (i.id=inv.item_id) and (c.id=2);

//Если пропал исходный файл
.open game character.db
.read dump.sql
.tables