create table PUBLIC.ARTIST
(
    ID       BIGINT auto_increment,
    ADDRESS  VARCHAR(255),
    ALIAS    VARCHAR(255),
    EMAIL    VARCHAR(255) not null,
    PHOTO    VARCHAR(255),
    USERNAME VARCHAR(255) not null
);

alter table PUBLIC.ARTIST
    add constraint CONSTRAINT_7
        primary key (ID);

create table PUBLIC.FOLLOWER
(
    ID       BIGINT auto_increment,
    ADDRESS  VARCHAR(255),
    EMAIL    VARCHAR(255) not null,
    USERNAME VARCHAR(255) not null
);

create table PUBLIC.ACCOUNT
(
    ID          BIGINT auto_increment,
    ACTIVE      INTEGER,
    PASSWORD    VARCHAR(255) not null,
    PERMISSION  VARCHAR(255),
    ROLE        VARCHAR(255),
    STATUS      BOOLEAN,
    USERNAME    VARCHAR(255) not null,
    ARTIST_ID   BIGINT,
    FOLLOWER_ID BIGINT,
    constraint FK92WUNYC59R2JN37X7M9S60NPT
        foreign key (FOLLOWER_ID) references PUBLIC.FOLLOWER (ID),
    constraint FKNK04KDW87MTO016TE24JGUD2S
        foreign key (ARTIST_ID) references PUBLIC.ARTIST (ID)
);

alter table PUBLIC.ACCOUNT
    add constraint CONSTRAINT_E
        primary key (ID);

alter table PUBLIC.FOLLOWER
    add constraint CONSTRAINT_4
        primary key (ID);

create table PUBLIC.PLAYLIST
(
    ID            BIGINT auto_increment,
    PLAYLIST_NAME VARCHAR(255) not null,
    ARTIST_ID     BIGINT,
    FOLLOWER_ID   BIGINT,
    constraint FKGJ68WLCK6HP3JXWY1X295G23R
        foreign key (FOLLOWER_ID) references PUBLIC.FOLLOWER (ID),
    constraint FKP3W4THSG0RJBRLMXJ8U01AGRP
        foreign key (ARTIST_ID) references PUBLIC.ARTIST (ID)
);

alter table PUBLIC.PLAYLIST
    add constraint CONSTRAINT_9
        primary key (ID);

create table PUBLIC.SONG
(
    ID          BIGINT auto_increment,
    PHOTO       VARCHAR(255),
    SONG_NAME   VARCHAR(255) not null,
    PLAYLIST_ID BIGINT,
    constraint FKI9VDF6WC669CLIYN1B4NA9VTN
        foreign key (PLAYLIST_ID) references PUBLIC.PLAYLIST (ID)
);

alter table PUBLIC.SONG
    add constraint CONSTRAINT_2
        primary key (ID);

create table PUBLIC.SONG_ARTIST
(
    ARTIST_ID BIGINT not null,
    SONG_ID   BIGINT not null,
    constraint FK9TEVOJS24WNWIN3DI24WLAO1M
        foreign key (ARTIST_ID) references PUBLIC.ARTIST (ID),
    constraint FKA29CRE1DFPDJ3GEK88UKV43CC
        foreign key (SONG_ID) references PUBLIC.SONG (ID)
);

