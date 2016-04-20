/*
SQLyog Community Edition- MySQL GUI v8.2 
MySQL - 5.1.42-community : Database - webrecdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`webrecdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `webrecdb`;

/*Table structure for table `ratings` */

DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
  `website_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`website_id`,`user_id`),
  KEY `FK_ratings` (`user_id`),
  KEY `FK_ratings_web` (`website_id`),
  CONSTRAINT `FK_ratings` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `FK_ratings_web` FOREIGN KEY (`website_id`) REFERENCES `websites` (`website_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ratings` */

insert  into `ratings`(`website_id`,`user_id`,`rating`) values (1,1,5),(1,2,3),(1,3,4),(2,1,3),(2,2,4),(2,3,5),(4,3,3),(4,7,4),(5,3,3),(6,3,3),(6,7,5),(7,3,3),(8,3,4),(8,7,2),(11,3,5),(11,7,1),(12,3,5),(12,7,3),(13,3,5),(14,7,5);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `isAdmin` tinyint(4) NOT NULL DEFAULT '0',
  `lockedAccount` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`username`,`password`,`isAdmin`,`lockedAccount`) values (1,'adam','password',0,1),(2,'bill','bill',0,0),(3,'jorge','password',1,0),(4,'bob','bob',0,0),(5,'dora','password',1,0),(6,'corey','password',0,0),(7,'john','john',0,1),(8,'aaa','aaa',0,0);

/*Table structure for table `websites` */

DROP TABLE IF EXISTS `websites`;

CREATE TABLE `websites` (
  `website_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL,
  `creator` int(11) NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`website_id`),
  KEY `FK_websites` (`creator`),
  CONSTRAINT `FK_websites` FOREIGN KEY (`creator`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `websites` */

insert  into `websites`(`website_id`,`url`,`creator`,`description`) values (1,'http://failblog.org/',1,'Great site that demonstrates the stupidity of people.'),(2,'http://www.reddit.com/',2,'Use to be a programmer only site, now used for the posting of anything.'),(4,'www.pointlesssites.com',3,'This site contains amazing things'),(5,'www.lfg.com',3,'Use to be good...'),(6,'www.google.com',3,'Single greatest sear'),(7,'www.cad-online.com',3,'Interesting until...'),(8,'http://www.explosm.net/comics/2003/',3,'Awesome. Just awesome.'),(11,'www.theGreatShort',3,'Awesome. Just awesome'),(12,'www.newSiteTest.com',5,'This is a test'),(13,'www.theloon.net',3,'Hello All'),(14,'thejohn.com',7,'the not bestest but pretty good site');

/* Procedure structure for procedure `addRating` */

/*!50003 DROP PROCEDURE IF EXISTS  `addRating` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addRating`(IN website_id_in INT, IN user_id_in INT, IN rating_in INT, OUT result BOOLEAN)
BEGIN
	DECLARE numRows INT;
	
	SELECT COUNT(*) 
		INTO numRows 
		FROM ratings 
		WHERE website_id=website_id_in
		AND user_id=user_id_in;
	
	IF numRows=0 THEN
		INSERT INTO ratings SET website_id=website_id_in, user_id=user_id_in, rating=rating_in;
		SET result=TRUE;
	ELSE
		SET result=FALSE;
	END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `addUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `addUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(IN newUsername VARCHAR(20), IN password1 VARCHAR(20), IN password2 VARCHAR(20), OUT result BOOLEAN)
BEGIN
	DECLARE numRows INT;
	
	SELECT COUNT(*) 
		INTO numRows 
		FROM users 
		WHERE username=newUsername;
	
	IF numRows=0 THEN
		IF password1 != password2 THEN
			SET result=FALSE;
		ELSE
			INSERT INTO users SET username=newUsername, PASSWORD=password1;
			SET result=TRUE;
		END IF;
	ELSE
		SET result=FALSE;
	END IF;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getUserId` */

/*!50003 DROP PROCEDURE IF EXISTS  `getUserId` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserId`(IN checkUsername VARCHAR(20), OUT result INT)
BEGIN
	SELECT user_id
		INTO result 
		FROM users 
		WHERE username=checkUsername;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `isAdmin` */

/*!50003 DROP PROCEDURE IF EXISTS  `isAdmin` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `isAdmin`(IN checkUsername VARCHAR(20), OUT result BOOLEAN)
BEGIN
	SELECT isAdmin
		INTO result 
		FROM users 
		WHERE username=checkUsername;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `saveSite` */

/*!50003 DROP PROCEDURE IF EXISTS  `saveSite` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `saveSite`(IN website INT, IN newURL VARCHAR(20), IN creator1 INT, IN newDescription VARCHAR(20), OUT result BOOLEAN)
BEGIN
	DECLARE numRows INT;
	
	if website = -1 THEN
		SELECT COUNT(*) 
			INTO numRows 
			FROM websites 
			WHERE url=newURL;
		IF numRows=0 THEN
			INSERT INTO websites SET url=newURL, description=newDescription, creator=creator1;
			SET result=TRUE;
		ELSE
			SET result=FALSE;
		END IF;
	ELSE
		SELECT COUNT(*) 
			INTO numRows 
			FROM websites 
			WHERE website_id=website;
		IF numRows=1 THEN
			UPDATE websites SET url=newURL, description=newDescription WHERE website_id=website;
			SET result=TRUE;
		ELSE
			SET result=FALSE;
		END IF;
	END if;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `validateLogin` */

/*!50003 DROP PROCEDURE IF EXISTS  `validateLogin` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `validateLogin`(IN theUsername VARCHAR(20), IN thePassword VARCHAR(20), OUT result BOOLEAN)
BEGIN
	DECLARE numRows INT;
	SELECT COUNT(*) 
		INTO numRows 
		FROM users 
		WHERE username=theUsername 
		AND PASSWORD=thePassword;
	
	IF numRows=0 THEN
		SET result=FALSE;
	ELSE
		SET result=TRUE;
	END IF;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
