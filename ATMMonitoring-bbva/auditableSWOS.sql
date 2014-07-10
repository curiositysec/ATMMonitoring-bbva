CREATE SEQUENCE auditable_operating_systems_id_seq START 1
CREATE SEQUENCE auditable_software_id_seq START 1

CREATE TABLE auditable_operating_systems (
    id          integer NOT NULL,
    date_created   timestamp,
    start_date    timestamp,
    end_date     timestamp,
    os_id       integer NOT NULL
);

CREATE TABLE auditable_software (
    id          integer NOT NULL,
    date_created   timestamp,
    start_date    timestamp,
    end_date     timestamp,
    software_id      integer NOT NULL
);


CREATE TABLE terminal_config_auditable_sw (
 
    terminal_config_id         integer NOT NULL,
    auditable_software_id      integer NOT NULL
);

CREATE TABLE terminal_config_auditable_os (
 
    terminal_config_id         integer NOT NULL,
    auditable_os_id      integer NOT NULL
);


ALTER TABLE auditable_operating_systems add PRIMARY KEY (id);
ALTER TABLE auditable_software add PRIMARY KEY (id);


ALTER TABLE auditable_operating_systems add FOREIGN KEY (os_id) REFERENCES operating_systems(id);
ALTER TABLE auditable_software add FOREIGN KEY (software_id) REFERENCES software(id);

ALTER TABLE terminal_config_auditable_sw add FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);
ALTER TABLE terminal_config_auditable_sw add FOREIGN KEY ( auditable_software_id) REFERENCES auditable_software(id);

ALTER TABLE terminal_config_auditable_os add FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);
ALTER TABLE terminal_config_auditable_os add FOREIGN KEY (auditable_os_id) REFERENCES auditable_operating_systems(id

