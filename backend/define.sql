
    create table camicia (
        id integer not null auto_increment,
        id_lunghezza_manica integer,
        id_taglia integer,
        id_tipo_colletto integer,
        id_vestibilita integer,
        primary key (id)
    ) engine=InnoDB;

    create table chiusura (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table colore (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table fantasia (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table lunghezza (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table lunghezza_manica (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table maglietta (
        id integer not null auto_increment,
        id_lunghezza_manica integer,
        id_taglia integer,
        id_tipo_colletto integer,
        id_vestibilita integer,
        primary key (id)
    ) engine=InnoDB;

    create table marca (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table materiale (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table messaggi (
        codice varchar(255) not null,
        messaggio varchar(255),
        primary key (codice)
    ) engine=InnoDB;

    create table ordine (
        id integer not null auto_increment,
        id_utente integer,
        prezzo_totale integer not null,
        stato tinyint not null check (stato between 0 and 3),
        data varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table pantalone (
        id integer not null auto_increment,
        id_lunghezza integer,
        id_taglia integer,
        id_vestibilita integer,
        primary key (id)
    ) engine=InnoDB;

    create table prodotti_ordini (
        id integer not null auto_increment,
        id_ordine integer,
        id_prodotto integer,
        qty integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table prodotto (
        id integer not null auto_increment,
        id_camicia integer,
        id_colore integer,
        id_fantasia integer,
        id_maglietta integer,
        id_marca integer,
        id_materiale integer,
        id_pantalone integer,
        id_scarpa integer,
        id_vestito integer,
        prezzo integer not null,
        qty integer not null,
        sesso tinyint not null check (sesso between 0 and 2),
        primary key (id)
    ) engine=InnoDB;

    create table scarpa (
        id integer not null auto_increment,
        id_chiusura integer,
        id_tipo_scarpa integer,
        taglia_scarpe integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table taglia (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tipo_colletto (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table tipo_scarpa (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table utente (
        cap integer,
        id integer not null auto_increment,
        ruolo tinyint not null check (ruolo between 0 and 1),
        civico varchar(255),
        cognome varchar(255) not null,
        mail varchar(255) not null,
        nome varchar(255) not null,
        paese varchar(255),
        password varchar(255) not null,
        strada varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table vestibilita (
        id integer not null auto_increment,
        descrizione varchar(45) not null,
        primary key (id)
    ) engine=InnoDB;

    create table vestito (
        id integer not null auto_increment,
        id_lunghezza integer,
        id_lunghezza_manica integer,
        id_taglia integer,
        id_vestibilita integer,
        primary key (id)
    ) engine=InnoDB;

    alter table utente 
       add constraint UK_p72xb2utk1ksr1ymf57y37w04 unique (mail);

    alter table camicia 
       add constraint FKp9yyo4ecr31xd79hiycxts3g2 
       foreign key (id_lunghezza_manica) 
       references lunghezza_manica (id);

    alter table camicia 
       add constraint FKnoaliami3f0oo3o60eix7qmxi 
       foreign key (id_taglia) 
       references taglia (id);

    alter table camicia 
       add constraint FK4nokon7cv660t2pmxq82n085q 
       foreign key (id_tipo_colletto) 
       references tipo_colletto (id);

    alter table camicia 
       add constraint FKgeh2fbgol42pco61i5jpoc82f 
       foreign key (id_vestibilita) 
       references vestibilita (id);

    alter table maglietta 
       add constraint FK9ub6ddwr3xjcvk4wtreimfuk3 
       foreign key (id_lunghezza_manica) 
       references lunghezza_manica (id);

    alter table maglietta 
       add constraint FK84ts4i4q2vrl7mbfw9eocvuk2 
       foreign key (id_taglia) 
       references taglia (id);

    alter table maglietta 
       add constraint FK51obvk32ly3j9xrvmuxth6v0v 
       foreign key (id_tipo_colletto) 
       references tipo_colletto (id);

    alter table maglietta 
       add constraint FK1kqbeyj5j9u1ibudfqrqeiu9e 
       foreign key (id_vestibilita) 
       references vestibilita (id);

    alter table ordine 
       add constraint FKgsxxfj3dm1kfppteavqrvkwcr 
       foreign key (id_utente) 
       references utente (id);

    alter table pantalone 
       add constraint FKk0u5eck12eeftsvq181oe93ot 
       foreign key (id_lunghezza) 
       references lunghezza (id);

    alter table pantalone 
       add constraint FKny36hnmhmjk9v2x6cwht2rgoi 
       foreign key (id_taglia) 
       references taglia (id);

    alter table pantalone 
       add constraint FKhw64r0etybfujkr1k7c0ld2g 
       foreign key (id_vestibilita) 
       references vestibilita (id);

    alter table prodotti_ordini 
       add constraint FKi2mbnw4n2cb3fefi51etj2mud 
       foreign key (id_ordine) 
       references ordine (id);

    alter table prodotti_ordini 
       add constraint FKnvgotj0nphoul71tcbyb6icij 
       foreign key (id_prodotto) 
       references prodotto (id);

    alter table prodotto 
       add constraint FKnylcw9cgwgyu4n8h1u06031tn 
       foreign key (id_camicia) 
       references camicia (id);

    alter table prodotto 
       add constraint FK6ia54rtygaey4syubw578mxs4 
       foreign key (id_colore) 
       references colore (id);

    alter table prodotto 
       add constraint FKd6br6vgm6sca3djassgq4wgh6 
       foreign key (id_fantasia) 
       references fantasia (id);

    alter table prodotto 
       add constraint FKp9or9ilge0qnwtq7g5p4vwnue 
       foreign key (id_maglietta) 
       references maglietta (id);

    alter table prodotto 
       add constraint FK6d9dw86iywursj1h1e7l59jvi 
       foreign key (id_marca) 
       references marca (id);

    alter table prodotto 
       add constraint FK7j9xeo0vijpsiwmqvj0tkccgj 
       foreign key (id_materiale) 
       references materiale (id);

    alter table prodotto 
       add constraint FK7yfnrrtc7ac3ihfc1geckx4bf 
       foreign key (id_pantalone) 
       references pantalone (id);

    alter table prodotto 
       add constraint FKggnjgyshhsx2jvayfofjos8rn 
       foreign key (id_scarpa) 
       references scarpa (id);

    alter table prodotto 
       add constraint FKdvnhbpn91qum2cr3jblywns9v 
       foreign key (id_vestito) 
       references vestito (id);

    alter table scarpa 
       add constraint FK9halp1d4og2p9fahutsugclg2 
       foreign key (id_chiusura) 
       references chiusura (id);

    alter table scarpa 
       add constraint FK22na7mkgqvptcnsjpqjqcp1oe 
       foreign key (id_tipo_scarpa) 
       references tipo_scarpa (id);

    alter table vestito 
       add constraint FKqtwawxx5lq2hc1y0ovwkp9lei 
       foreign key (id_lunghezza) 
       references lunghezza (id);

    alter table vestito 
       add constraint FK86f2db9kqrogp4f7nfyxmen6q 
       foreign key (id_lunghezza_manica) 
       references lunghezza_manica (id);

    alter table vestito 
       add constraint FKrx54cqy1uqlngjq6jnwhdvtrn 
       foreign key (id_taglia) 
       references taglia (id);

    alter table vestito 
       add constraint FKemt2twvdo5e3thnf39oix4sbv 
       foreign key (id_vestibilita) 
       references vestibilita (id);
