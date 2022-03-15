DROP DATABASE IF EXISTS `tour_agency` ;

-- -----------------------------------------------------
-- Database tourist_agency
-- -----------------------------------------------------
CREATE DATABASE  IF NOT EXISTS `tour_agency` DEFAULT CHARACTER SET utf8;
USE `tour_agency`;

-- -----------------------------------------------------
-- Creating table `tour_agency`.`hotel_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel_type` ;

CREATE TABLE IF NOT EXISTS `hotel_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ідентифікатор готелю. Автоінкрементується по мірі додавання нових готелей',
  `type` VARCHAR(45) NOT NULL COMMENT 'тип готелю: звичайний мережевий готель, мотель, резорт, корчма',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE = InnoDB;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel_type` WRITE;
INSERT INTO `hotel_type` VALUES (1,'Chain hotel'),(2,'Motel'),(3,'Resort'), (4,'Inns');
UNLOCK TABLES;

-- -----------------------------------------------------
-- Creating table `tour_agency`.`tour_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tour_type`;
CREATE TABLE `tour_type` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ідентифікатор типу турів. Автоінкрементується по мірі додавання нових типів',
	`type` VARCHAR(45) NOT NULL COMMENT 'тип туру: відпочинок, екскурсія, шопінг',
	PRIMARY KEY (`id`),
	UNIQUE KEY `id_UNIQUE` (`id`),
	UNIQUE KEY `type_UNIQUE` (`type`)
) Engine = InnoDB;

--
-- Dumping data for table `tour_type`
--

LOCK TABLES `tour_type` WRITE;
INSERT INTO `tour_type` VALUES (1,'Vacation'),(2,'Excursion'),(3,'Shopping');
UNLOCK TABLES;

-- -----------------------------------------------------
-- Creating table `tour_agency`.`tour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tour`;
CREATE TABLE `tour`(
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Ідентифікатор туру. Автоінкрементується по мірі додавання нових турів',
	`name` VARCHAR(45) NOT NULL COMMENT 'Назва туру',
	`description` VARCHAR(255) NOT NULL COMMENT 'Опис туру',
	`price` INT NOT NULL COMMENT 'Ціна за тур',
	`is_burning` TINYINT NOT NULL COMMENT 'Змінна, що зберігає 0, якщо тур не є палаючим, і, відповідно, 1 у протилежному випадку. По замовч. рівна 0.',
	`people_amount` INT NOT NULL COMMENT 'Кількість людей, для яких призначений тур',
	`is_deleted` TINYINT NOT NULL COMMENT 'Змінна, що зберігає 0, якщо тур не є видаленим, і, відповідно, 1 у протилежному випадку. По замовч. рівна 0.',
	`hotel_id` BIGINT NOT NULL COMMENT 'Ідентифікатор типу готелів, які запропоновані у даному турі. Для одного туру може бути запропоновано лише 1 тип готелів.',
	`tour_type_id` BIGINT NOT NULL COMMENT 'Ідентифікатор типу туру: відпочинок, екскурсія чи шопінг',
    PRIMARY KEY (`id`),
	UNIQUE KEY `id_UNIQUE` (`id`),
	UNIQUE KEY `name_UNIQUE` (`name`),
	CONSTRAINT `fk_tour_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel_type` (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
    CONSTRAINT `fk_tour_type` FOREIGN KEY (`tour_type_id`) REFERENCES `tour_type` (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE
) engine = InnoDB;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
INSERT INTO `tour` VALUES 
(1,'Kenya Safari', 'If you like to go big on excursion, this is the package for you. Six National Parks – Lake Naivasha, Lake Nakuru, Serengeti, Ngorongoro Crater, Lake Manyara, and Tarangire. One National Game Reserve – Masai Mara.', 3150, 0, 1, 0, 4, 2),
(2,'Margaritaville Island Reserve Cap', 'If great food, drinks, and entertainment is what you seek, look no further than the newly opened Margaritaville Island Cap. Located on the world-famous Juanillo Beach in the Dominican Republic.', 4300, 0, 2, 0, 3, 1),
(3,'Vacation on Bahamas', 'A vacation in The Bahamas can be either fun-filled and action-packed or as exclusive and restful as desired (or a perfect balance of both). From island-hopping, diving, and swimming with dolphins to fine dining.', 1920, 0, 1, 0, 3, 1);
UNLOCK TABLES;

-- -----------------------------------------------------
-- Creating table `tour_agency`.`order_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_status` ;

CREATE TABLE IF NOT EXISTS `order_status` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Ідентифікатор статусу замовлення. Автоінкрементується.',
  `status` VARCHAR(45) NOT NULL COMMENT 'Статус замовлення: зареєстроване, сплачене, скасоване.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
 ) 
ENGINE = InnoDB;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
INSERT INTO `order_status` VALUES (1, 'Registered'), (2, 'Paided'), (3, 'Canceled'); 
UNLOCK TABLES;

-- -----------------------------------------------------
-- Сreating table `tour_agency`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `id` BIGINT NOT NULL COMMENT 'Ідентифікатор ролі користувачів.',
  `role_name` VARCHAR(45) NOT NULL COMMENT 'Назва ролі: юзер, менеджер чи адмін.',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name`)
  )
ENGINE = InnoDB;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES 
(1, 'user'), 
(2, 'manager'), 
(3, 'admin'); 
UNLOCK TABLES;

-- ---------------------------------------------------
-- Creating table `tour_agency`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Ідентифікатор користувача. Автоінкрементується по мірі додавання нових користувачів.',
  `login` VARCHAR(45) NOT NULL COMMENT 'Логін користувача. Унікальне імя для авторизації.',
  `password` VARCHAR(45) NOT NULL COMMENT 'Пароль користувача. Необхідний для авторизації.',
  `role_id` BIGINT NOT NULL COMMENT 'Ідентифікатор ролі акаунта.',
  `email` VARCHAR(45) NOT NULL COMMENT 'Поштова скринька користувача',
  `first_name` VARCHAR(45) NOT NULL COMMENT 'Імя користувача',
  `last_name` VARCHAR(45) NOT NULL COMMENT 'Прізвище користувача',
  `is_blocked` TINYINT NOT NULL DEFAULT '0' COMMENT 'Змінна, що зберігає 0, якщо користувач не є заблокованим і, відповідно, 1 у протилежному випадку. За замовч. зберігає 0',
  `discount` INT NOT NULL DEFAULT '0' COMMENT 'Відсоткова знижка користувача. За кожне зроблене замовлення значення збільшується на {discont.step}. По замовч. рівне 0.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  CONSTRAINT `fk_account_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
  )
ENGINE = InnoDB;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1, 'admin','admin',1,'email1@gmail.com', 'Maksym', 'Buchatskyi', 0, 0);

UNLOCK TABLES;

-- -----------------------------------------------------
-- Creating table `order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Ідентифікатор замовлення',
	`total_price` INT NOT NULL COMMENT 'Загальна сума замовлення.',
	`date_of_order` DATETIME NOT NULL COMMENT 'Дата замовлення',
	`order_status_id` BIGINT NOT NULL COMMENT 'Ідентифікатор статусу замовлення.',
	`tour_id` BIGINT NOT NULL COMMENT 'Ідентифікатор туру, по якому було зроблення замовлення.',
	`user_id` BIGINT NOT NULL COMMENT 'Ідентифікатор юзера, що здійснив замовлення',
  PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_order_status1`
    FOREIGN KEY (`order_status_id`)
    REFERENCES `order_status` (`id`)
	ON DELETE CASCADE 
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_tour1`
    FOREIGN KEY (`tour_id`)
    REFERENCES `tour` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Creating table `discount`
-- -----------------------------------------------------
DROP TABLE IF exists `discount`;
CREATE TABLE `discount` (
	`step` INT NOT NULL COMMENT 'Крок, з яким буде збільшуватись відсоток знижки для постійних покупців',
    `max` INT NOT NULL COMMENT 'Максимальне значення, якого може набути відсоток знижки'
) ENGINE = InnoDB;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
INSERT INTO `discount` VALUES 
(5, 20); 
UNLOCK TABLES;

















