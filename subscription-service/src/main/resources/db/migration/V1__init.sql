DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
       INCREMENT BY 1
       MINVALUE 1
       CACHE 1
       NO CYCLE;

COMMIT;


CREATE TABLE subscribers
(
   id             integer        NOT NULL,
   date_of_birth  timestamp,
   email          varchar(255)   NOT NULL,
   first_name     varchar(255),
   gender         varchar(255),
   subscribed	  boolean DEFAULT true,
   newsletter_id        integer NOT NULL,
   UNIQUE(email)
);

ALTER TABLE subscribers
   ADD CONSTRAINT subscribers_pkey
   PRIMARY KEY (id);

CREATE TABLE email_errors
(
   id     integer        NOT NULL,
   date   timestamp		 NOT NULL,
   email  varchar(255)   NOT NULL,
   error  varchar(1000)  NOT NULL
);

ALTER TABLE email_errors
   ADD CONSTRAINT email_errors_pkey
   PRIMARY KEY (id);

COMMIT;
