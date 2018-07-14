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
INSERT INTO `poslovna`.`individual` (`email`, `address`, `jmbg`,`name`, `surname`, `phonenumber`) VALUES ('peca@gmail.com','Kralja Aleksandra','0103995800765','Damjan','Nicic','067889654');
INSERT INTO `poslovna`.`individual` (`email`, `address`, `jmbg`,`name`, `surname`, `phonenumber`) VALUES ('saska@gmail.com','Safarikova 43','2002995600777','Aleksandra','Grujic','061572365');


INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`, `fax`, `mbr`, `delivery_address`, `location`,`activity_id`) VALUES ('firmaA@gmail.com','Kacki put 56','13041995200876','Afirma','af','065867465','11','432522','deliveryA@gmail.com','Novi Sad','1');
INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`, `fax`, `mbr`, `delivery_address`, `location`,`activity_id`) VALUES ('firmaB@gmail.com','Partizanska 43','24041995200876','Bfirma','bf','066789065','22','652743','deliveryB@gmail.com','Beograd','2');
INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`, `fax`, `mbr`, `delivery_address`, `location`,`activity_id`) VALUES ('firmaC@gmail.com','Njegoseva 44','2341995200876','Cfirma','cf','0636543465','33','782134','deliveryC@gmail.com','Nis','3');
INSERT INTO `poslovna`.`legal_entity` (`email`, `address`, `jmbg`,`name`, `short_name`, `phonenumber`, `fax`, `mbr`, `delivery_address`, `location`,`activity_id`) VALUES ('firmaD@gmail.com','Partizanska 43','24041995200876','Dfirma','df','061323165','44','653852','deliveryD@gmail.com','Subotica','1');


INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('1','2');
INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('2','2');
INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('3','2');
INSERT INTO `poslovna`.`individual_bank` (`individual_id`, `bank_id`) VALUES ('4','2');

INSERT INTO `poslovna`.`legal_entity_bank` (`legal_entity_id`, `bank_id`) VALUES ('1','2');
INSERT INTO `poslovna`.`legal_entity_bank` (`legal_entity_id`, `bank_id`) VALUES ('2','2');
INSERT INTO `poslovna`.`legal_entity_bank` (`legal_entity_id`, `bank_id`) VALUES ('3','2');
INSERT INTO `poslovna`.`legal_entity_bank` (`legal_entity_id`, `bank_id`) VALUES ('4','2');

INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('DIN','Dinar',1,'1');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('EUR','Euro',0,'2');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('KVM','Marka',1,'3');
INSERT INTO `poslovna`.`currency` (`password`, `name`,`domicile`, `country_id`) VALUES ('RUB','Rublja',1,'4');


INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `individual_id`) VALUES ('778-1111111111111-92',1,'2018-02-20','2','1','1');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `individual_id`) VALUES ('778-2222222222222-92',1,'2018-03-01','2','2','2');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `individual_id`) VALUES ('778-3333333333333-92',1,'2018-06-30','2','3','3');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `legal_entity_id`) VALUES ('778-4444444444444-92',1,'2018-01-10','2','1','1');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `legal_entity_id`) VALUES ('778-5555555555555-92',1,'2018-01-21','2','2','2');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `legal_entity_id`) VALUES ('778-6666666666666-92',0,'2018-07-02','2','3','3');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `legal_entity_id`) VALUES ('778-8888888888888-92',0,'2018-01-21','2','2','2');
INSERT INTO `poslovna`.`account` (`accountnum`, `is_valid`,`openingdate`, `bank_id`, `currency_id`, `legal_entity_id`) VALUES ('778-9999999999999-92',1,'2018-07-02','2','3','3');

INSERT INTO `poslovna`.`daily_account_balance` (`date`, `new_state`,`payment_from`, `payment_to`, `previous_state`, `bankaccount_id`) VALUES ('2018-01-01', 50000.0, 0.0, 0.0, 50000.00, '2');


INSERT INTO `poslovna`.`activity` (`code`, `name`) VALUES ('1A3','Uzgoj zitarica');
INSERT INTO `poslovna`.`activity` (`code`, `name`) VALUES ('U56','Proizvodnja papira');
INSERT INTO `poslovna`.`activity` (`code`, `name`) VALUES ('9IO','Proizvodnja vina');

