create table 'user'(
    'id' int(11) NOT NULL auto_increment,
    'name' varchar(255) default NULL,
    'age' int(11) default NULL,
    'sex' varchar(255) default NULL,
    PRIMARY KEY ('id')
)ENGINE=InnoBD DEFAULT CHARSET=uft8;