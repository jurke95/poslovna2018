INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('232','Srbija');
INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('257','Grcka');
INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('233','Bosna');
INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('252','Rusija');

INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('144','Novi Sad', '21000', '1');
INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('482','Beograd', '22300', '1');
INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('738','Atina', '13800', '2');

INSERT INTO `poslovna`.`bank` (`address`, `bank`,`code`, `email`, `fax`,`name`, `phonenumber`, `pib`, `web`) VALUES ('Bulevar Evrope 32',1,'998','erste@gmail.com','089-212','ErsteBank','089-212','889','aaa');
INSERT INTO `poslovna`.`bank` (`address`, `bank`,`code`, `email`, `fax`,`name`, `phonenumber`, `pib`, `web`) VALUES ('Mise Dimitrijevic 40',1,'778','intesa@gmail.com','119-522','IntesaBank','119-522','778','bbbb');
INSERT INTO `poslovna`.`user` (`email`, `password`, `bank_id`) VALUES ('peca@gmail.com','peca123','1');
INSERT INTO `poslovna`.`user` (`email`, `password`, `bank_id`) VALUES ('saska@gmail.com','saska123','2');


INSERT INTO `poslovna`.`individual` (`email`, `address`, `jmbg`,`name`, `surname`, `phonenumber`) VALUES ('jurke@gmail.com','Mileve Maric bb','22071995800690','Marko','Juric','069234152');
INSERT INTO `poslovna`.`individual` (`email`, `address`, `jmbg`,`name`, `surname`, `phonenumber`) VALUES ('dulke@gmail.com','Bulevar Evrope 32','03041995800876','Dragan','Dulic','065867465');

INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`) VALUES ('firmaA@gmail.com','Kacki put 56','13041995200876','Afirma','af','065867465');
INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`) VALUES ('firmaB@gmail.com','Partizanska 43','24041995200876','Bfirma','bf','066789065');


INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('1','2');
INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('2','2');


INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('DIN','Dinar',1,'1');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('EUR','Euro',0,'2');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('KVM','Marka',1,'3');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('RUB','Rublja',1,'4');