create database demo;
CREATE TABLE `t_bad_word` (
  `BAD_WORD_ID` int(11) NOT NULL auto_increment,
  `BAD_WORD` varchar(64) default NULL,
  `REPLACE_WORD` varchar(64) default NULL,
  PRIMARY KEY  (`BAD_WORD_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8