DROP TABLE requests CASCADE CONSTRAINTS PURGE;
DROP TABLE goods CASCADE CONSTRAINTS PURGE;
DROP TABLE trips CASCADE CONSTRAINTS PURGE;
DROP TABLE snetworks CASCADE CONSTRAINTS PURGE;
DROP TABLE friendships CASCADE CONSTRAINTS PURGE;
DROP TABLE users CASCADE CONSTRAINTS PURGE;
DROP TABLE userconnection CASCADE CONSTRAINTS PURGE;

CREATE TABLE users
(
	id		  INTEGER  NOT NULL ,
	name		  VARCHAR2(50)  NULL ,
	state		  INTEGER  NULL ,
	nickname	  VARCHAR2(50)  NULL ,
	email		  VARCHAR2(50)  NULL, 
  picture VARCHAR2(255)  NULL
);

CREATE UNIQUE INDEX XPKUsers ON users
(id  ASC);

ALTER TABLE users
	ADD CONSTRAINT  XPKUsers PRIMARY KEY (id);



CREATE TABLE friendships
(
	user1		  INTEGER  NOT NULL ,
	user2		  INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKfriendships ON friendships
(user1  ASC,user2  ASC);

ALTER TABLE friendships
	ADD CONSTRAINT  XPKfriendships PRIMARY KEY (user1,user2);



CREATE TABLE goods
(
	name		  VARCHAR2(50)  NULL ,
	id		  INTEGER  NOT NULL ,
	description	  VARCHAR2(50)  NULL ,
	location	  VARCHAR2(50)  NULL
);

CREATE UNIQUE INDEX XPKgoods ON goods
(id  ASC);

ALTER TABLE goods
	ADD CONSTRAINT  XPKgoods PRIMARY KEY (id);



CREATE TABLE trips
(
	dest		  VARCHAR2(50)  NULL ,
	departure_date	  DATE  NULL ,
	arrival_date	  DATE  NULL ,
	id		  INTEGER  NOT NULL ,
	traveller	  INTEGER  NOT NULL ,
	capacity	  INTEGER  NULL 
);

CREATE UNIQUE INDEX XPKTrips ON trips
(id  ASC);

ALTER TABLE trips
	ADD CONSTRAINT  XPKTrips PRIMARY KEY (id);



CREATE TABLE requests
(
	trip		  INTEGER  NOT NULL ,
	goods		  INTEGER  NOT NULL ,
	customer	  INTEGER  NOT NULL ,
	count		  INTEGER  NULL ,
        max_cost          INTEGER  NULL ,
	currency	  VARCHAR2(10)  NULL ,
	status            VARCHAR2(20)  NULL
);

CREATE UNIQUE INDEX XPKrequests ON requests
(trip  ASC,goods  ASC,customer  ASC);

ALTER TABLE requests
	ADD CONSTRAINT  XPKrequests PRIMARY KEY (trip,goods,customer);



CREATE TABLE snetworks
(
	user_id		  INTEGER  NOT NULL ,
	page		  VARCHAR2(255)  NULL ,
  provider_user_id varchar2(255) NOT NULL,
	network_type INTEGER  NOT NULL 
);

CREATE UNIQUE INDEX XPKsnetworks ON snetworks
(user_id  ASC,network_type  ASC);

ALTER TABLE snetworks
	ADD CONSTRAINT  XPKsnetworks PRIMARY KEY (user_id,network_type);

CREATE TABLE UserConnection
(
    userId varchar(255) NOT NULL,
    providerId varchar(255) NOT NULL,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) NOT NULL,					
    secret varchar(255),
    refreshToken varchar(255),
    expireTime long,
    primary key (userId, providerId, providerUserId)
);

CREATE UNIQUE INDEX UserConnectionRank ON UserConnection
(userId, providerId, rank);

ALTER TABLE friendships
	ADD (CONSTRAINT  R_8 FOREIGN KEY (user1) REFERENCES users(id));

ALTER TABLE friendships
	ADD (CONSTRAINT  R_9 FOREIGN KEY (user2) REFERENCES users(id));

ALTER TABLE requests
	ADD (CONSTRAINT  R_2 FOREIGN KEY (trip) REFERENCES trips(id));

ALTER TABLE requests
	ADD (CONSTRAINT  R_3 FOREIGN KEY (goods) REFERENCES goods(id));

ALTER TABLE requests
	ADD (CONSTRAINT  R_5 FOREIGN KEY (customer) REFERENCES users(id));

ALTER TABLE snetworks
	ADD (CONSTRAINT  R_7 FOREIGN KEY (user_id) REFERENCES users(id));

ALTER TABLE trips
	ADD (CONSTRAINT  R_6 FOREIGN KEY (traveller) REFERENCES users(id));
