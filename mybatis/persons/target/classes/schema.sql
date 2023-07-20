create table person(
   personId INT NOT NULL,
   name VARCHAR(50)
);

create table address
(
    addressId INT NOT NULL,
    streetAddress VARCHAR(50),
    personId INT NOT NULL
);