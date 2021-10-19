
DROP TABLE IF EXISTS event_member;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS member;

CREATE TABLE member (
        member_id serial,
        last_name varchar(50),
        first_name varchar(50),
        email_address varchar(100),
        phone numeric NULL,
        birthday date NULL,
        reminder_emails boolean,
        
        CONSTRAINT pk_member PRIMARY KEY (member_id)
        );
        
CREATE TABLE groups (
        group_id serial,
        group_name varchar(100) NOT NULL,
        member_id int NOT NULL,
        
        CONSTRAINT pk_groups PRIMARY KEY (group_id),
        CONSTRAINT fk_groups_member FOREIGN KEY (member_id) REFERENCES member (member_id)
        
      );
      
      CREATE TABLE group_member (
        member_id int NOT NULL,
        group_id int NOT NULL,
        
        CONSTRAINT pk_group_member PRIMARY KEY ( member_id, group_id),
        CONSTRAINT fk_group_member_member FOREIGN KEY (member_id) REFERENCES member (member_id),
        CONSTRAINT fk_group_member_groups FOREIGN KEY (group_id) REFERENCES groups (group_id)
        );
      
CREATE TABLE event (
        event_id serial,
        event_name varchar(100) NOT NULL,
        description varchar(1000),
        start_date date NOT NULL,
        group_id int NOT NULL,
        member_id int NOT NULL,
        
        CONSTRAINT pk_event PRIMARY KEY (event_id),
        CONSTRAINT fk_event_groups FOREIGN KEY (group_id) REFERENCES groups (group_id),
        CONSTRAINT fk_event_member FOREIGN KEY (member_id) REFERENCES member (member_id)
        
        );
        
CREATE TABLE event_member (
        member_id int NOT NULL,
        event_id int NOT NULL,
        
        CONSTRAINT pk_event_member PRIMARY KEY ( member_id, event_id),
        CONSTRAINT fk_event_member_member FOREIGN KEY (member_id) REFERENCES member (member_id),
        CONSTRAINT fk_event_member_event FOREIGN KEY (event_id) REFERENCES event (event_id)
        );
        
        
        
        


