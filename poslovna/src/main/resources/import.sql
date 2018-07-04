INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('232','Srbija');
INSERT INTO `poslovna`.`country` (`code`, `name`) VALUES ('257','Grcka');
INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('144','Novi Sad', '21000', '1');
INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('482','Beograd', '22300', '1');
INSERT INTO `poslovna`.`city` (`code`, `name`, `post_num`, `country_id`) VALUES ('738','Atina', '13800', '2');

INSERT INTO `poslovna`.`bank` (`address`, `bank`,`code`, `email`, `fax`,`name`, `phonenumber`, `pib`, `web`) VALUES ('Bulevar Evrope 32',1,'998','erste@gmail.com','089-212','ErsteBank','089-212','889','aaa');
INSERT INTO `poslovna`.`bank` (`address`, `bank`,`code`, `email`, `fax`,`name`, `phonenumber`, `pib`, `web`) VALUES ('Mise Dimitrijevic 40',1,'778','intesa@gmail.com','119-522','IntesaBank','119-522','778','bbbb');
INSERT INTO `poslovna`.`user` (`email`, `password`, `bank_id`) VALUES ('peca@gmail.com','peca123','1');
INSERT INTO `poslovna`.`user` (`email`, `password`, `bank_id`) VALUES ('saska@gmail.com','saska123','2');